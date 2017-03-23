package pl.edu.agh.student.symfiz;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Scanner;

@WebServlet("/p_s_s")
public class SecondController extends HttpServlet {
    public SecondController() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String choice = SecondModel.getGameResponse();
        ServletContext context = getServletContext();
        String path = context.getRealPath("/WEB-INF/" + choice + ".html");
        String responseContent = new Scanner(new File(path)).useDelimiter("\\Z").next();

        PrintWriter out = response.getWriter();
        out.print(responseContent);

        out.close();
    }
}
