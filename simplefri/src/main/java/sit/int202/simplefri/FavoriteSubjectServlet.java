package sit.int202.simplefri;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "FavoriteSubjectServlet", value = "/FavoriteSubjectServlet")
public class FavoriteSubjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doSomething(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doSomething(request, response);
    }

    private void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] favoriteSubjects = request.getParameterValues("favoriteSubject");
        if (favoriteSubjects != null) {
            for (String favoriteSubject : favoriteSubjects) {
                System.out.println("favoriteSubject = " + favoriteSubject);
            }
        }

    }
}
