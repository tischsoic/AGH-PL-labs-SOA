package pl.edu.agh.student.symfiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/mean")
public class Third extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] params = request.getParameterValues("a");
        PrintWriter out = response.getWriter();

        if (params == null || params.length != 5) {
            out.print("bad params");
            out.close();
            return;
        }

        double mean = 0;
        for (int i = 0; i < 5; ++i) {
            mean += Integer.parseInt(params[i]);
        }
        mean /= 5;

        out.print("mean: " + mean);
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> paramsNames = request.getParameterNames();
        PrintWriter out = response.getWriter();
        ArrayList<Integer> numbers = new ArrayList<>();

        try {
            while (paramsNames.hasMoreElements()) {
                String s = paramsNames.nextElement();
                numbers.add(Integer.parseInt(request.getParameter(s)));
            }
        } catch (Exception e) {
            out.print("error");
            out.close();
            return;
        }

        Collections.sort(numbers);
        StringBuilder sb = new StringBuilder();
        for (Integer i : numbers)
        {
            sb.append(i);
            sb.append("\t");
        }
        out.print("numbers: ");
        out.print(sb.toString());
        out.close();
    }
}
