package pl.edu.agh.student.symfiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/car")
public class CarChoiceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/carForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String carType = request.getParameter("type");
        String priceRange = request.getParameter("price_range");
        String[] prices = priceRange.split("-");
        int priceFrom = Integer.parseInt(prices[0]);
        int priceTo = Integer.parseInt(prices[1]);
        CarChoiceHelper helper = new CarChoiceHelper();

        CarChoiceHelper.carType type = CarChoiceHelper.carType.SPORT;
        switch (carType) {
            case "sport":
                type = CarChoiceHelper.carType.SPORT;
                break;
            case "urban":
                type = CarChoiceHelper.carType.URBAN;
                break;
            case "luxury":
                type = CarChoiceHelper.carType.LUXURY;
        }
        String[] carsToOffer = helper.getCars(type, priceFrom, priceTo);

        PrintWriter out = response.getWriter();
        out.print(String.join(", ", carsToOffer));
        out.close();
    }
}