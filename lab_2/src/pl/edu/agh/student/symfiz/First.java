package pl.edu.agh.student.symfiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test_of_mature_female")
public class First extends HttpServlet {
    public First() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int age = Integer.parseInt(request.getParameter("age"));
        String name = request.getParameter("name");

        PrintWriter out = response.getWriter();

        if (age >= 18 && name.charAt(name.length() - 1) == 'a') {
            out.println("Mature female.");
        } else {
            out.println("Not mature female.");
        }

        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
