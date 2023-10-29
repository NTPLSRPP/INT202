package servlets.multiplication;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "MultiplicationServlet", value = "/multiplication_table")
public class MultiplicationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numberStr = request.getParameter("number");
        if (numberStr == null || numberStr.length() == 0 || ! isNumber(numberStr)) {
            request.setAttribute("error", "Invalid number or parameter !!!");
        }
        request.getRequestDispatcher("/multiplication_table.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private static boolean isNumber(String numberStr) {
        for (int i = 0; i < numberStr.length(); i++) {
            if (! Character.isDigit(numberStr.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}