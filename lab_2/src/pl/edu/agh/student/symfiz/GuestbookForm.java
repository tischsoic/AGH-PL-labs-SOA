package pl.edu.agh.student.symfiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/gbf")
public class GuestbookForm extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comments = (String) request.getServletContext().getAttribute("comments");
        if (comments == null) {
            comments = "";
        }
        request.setAttribute("comments", comments);
        request.getRequestDispatcher("/WEB-INF/guestbookForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("name");
        String comment = request.getParameter("name");

        String oldComments = (String) request.getServletContext().getAttribute("comments");
        if (oldComments == null) {
            oldComments = "";
        }
        String newComments = oldComments + "<br /><br /><b>" + name + "</ b> (" + email + ")<br />" + comment;
        request.getServletContext().setAttribute("comments", newComments);

        doGet(request, response);
    }
}
