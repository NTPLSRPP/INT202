package Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdditionServlet", value = "/addition_table")
public class AdditionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String numberStr1 = request.getParameter("number1");
        String numberStr2 = request.getParameter("number2");
//
        if (numberStr1 == null || numberStr1.length() == 0 || !isNumber(numberStr1)) {
            request.setAttribute("error", "invalid or missing number1");
        } else if (numberStr2 == null || numberStr2.length() == 0 || !isNumber(numberStr2)) {
            request.setAttribute("error", "invalid or missing number2");
        }
        else {
            int number1 = Integer.parseInt(numberStr1);
            int number2 = Integer.parseInt(numberStr2);
            int sum = number1 + number2;
            String result = String.valueOf(sum);
            request.setAttribute("result", result);
        }
        request.getRequestDispatcher("/addition_table.jsp").forward(request, response);

    }

    private static boolean isNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numberStr1 = request.getParameter("number1");
        String numberStr2 = request.getParameter("number2");

        if (numberStr1 == null || numberStr1.length() == 0 || isNumber(numberStr1)) {
            request.setAttribute("error", "invalid or missing number1");
        } else if (numberStr2 == null || numberStr2.length() == 0 || isNumber(numberStr2)) {
            request.setAttribute("error", "invalid or missing number2");
        } else {
            int number1 = Integer.parseInt(numberStr1);
            int number2 = Integer.parseInt(numberStr2);
            int sum = number1 + number2;
            String result = String.valueOf(sum);
            request.setAttribute("result", sum);
        }
        request.getRequestDispatcher("/addition_table.jsp").forward(request, response);
    }
}