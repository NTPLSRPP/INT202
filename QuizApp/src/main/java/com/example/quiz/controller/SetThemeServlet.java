package com.example.quiz.controller;

import com.example.quiz.model.Color;
import com.example.quiz.model.Theme;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SetThemeServlet", value = "/set-theme")
public class SetThemeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("theme") == null) {
            Theme theme = new Theme(); // create theme
            theme.fetchColors(); // fetch colors from Color.csv
            session.setAttribute("theme", theme); // save theme in session name "theme"
        }
        Theme theme = (Theme) session.getAttribute("theme");
        request.setAttribute("theme", theme);
        request.getRequestDispatcher("/setTheme.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (request.getParameter("selectedColor") != null) {
            int selectedColor = Integer.parseInt(request.getParameter("selectedColor"));
            Theme theme = (Theme) session.getAttribute("theme");
            Cookie bgColor = new Cookie("bgColor", theme.getColors().get(selectedColor).getBgColor());
            Cookie txtColor = new Cookie("txtColor", theme.getColors().get(selectedColor).getTxtColor());
            bgColor.setMaxAge(60*60*24*7);
            txtColor.setMaxAge(60*60*24*7);
            response.addCookie(bgColor);
            response.addCookie(txtColor);
        }
        response.sendRedirect("index.jsp");
    }
}
