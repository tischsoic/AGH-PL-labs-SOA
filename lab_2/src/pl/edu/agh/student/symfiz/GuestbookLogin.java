package pl.edu.agh.student.symfiz;

import com.sun.deploy.net.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpRetryException;
import java.net.URI;
import java.util.Objects;
import java.util.Vector;

@WebServlet("/gbl")
public class GuestbookLogin extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();

        users = new Vector<>();
        users.add(new UserData("a", "ap"));
        users.add(new UserData("b", "bp"));
    }

    private boolean manageLoggedUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("login") != null) {
            URI contextUrl = URI.create(request.getRequestURL().toString()).resolve(request.getContextPath());
            response.sendRedirect(contextUrl + "/gbf");
            return true;
        }
        return false;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean userAlreadyLogged = manageLoggedUser(request, response);
        if (userAlreadyLogged) {
            return;
        }
        request.getRequestDispatcher("/WEB-INF/guestbookLogin.jsp").forward(request, response);
    }

    class UserData {
        UserData(String l, String p) {
            login = l;
            password = p;
        }

        String login;
        String password;
    }

    private Vector<UserData> users;

    private boolean userDataValid(String l, String p) {
        return users.stream().anyMatch(ud -> ud.login.equals(l) && ud.password.equals(p));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean userAlreadyLogged = manageLoggedUser(request, response);
        if (userAlreadyLogged) {
            return;
        }

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        URI contextUrl = URI.create(request.getRequestURL().toString()).resolve(request.getContextPath());
        boolean logginCorrect = true;
        String message = "";

        if (Objects.equals(login, "")) {
            logginCorrect = false;
            message += "Enter login. ";
        }

        if (Objects.equals(login, "")) {
            logginCorrect = false;
            message += "Enter password. ";
        }

        if (logginCorrect && userDataValid(login, password)) {
            request.getSession().setAttribute("login", login);
            response.sendRedirect(contextUrl + "/gbf");
        } else {
            message += "Login or password incorrect!";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/WEB-INF/guestbookLogin.jsp").forward(request, response);
        }
    }
}
