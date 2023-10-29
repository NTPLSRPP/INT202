package com.example.quiz.controller;

import com.example.quiz.model.Color;
import com.example.quiz.model.Question;
import com.example.quiz.model.QuizSession;
import com.example.quiz.model.Theme;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "QuizController", value = "/quiz-controller")
public class QuizController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(); // create session to store a session in request
        if (session == null || session.getAttribute("quizSession") == null) { // check session
            QuizSession quizSession = new QuizSession(); // create form of question [questions, currentQuestion, score]
            quizSession.fetchQuestion(); // fetch data from Data.csv
            session.setAttribute("quizSession", quizSession); // save quizSession in session name "quizSession"
        }
        QuizSession quizSession = (QuizSession) session.getAttribute("quizSession"); // create QuizSession to store a "quizSession" in session
        Question currentQuestion = quizSession.getQuestions().get(quizSession.getCurrentQuestionIndex()); // create currentQuestion to store a currentQuestion from quizSession
        request.setAttribute("currentQuestion", currentQuestion); // save currentQuestion in request name "currentQuestion"
        request.setAttribute("isAnswer", quizSession.isAnswer()); // save isAnswer in request name "isAnswer"
        request.getRequestDispatcher("/quiz.jsp").forward(request, response); // forward request to quiz.jsp
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        QuizSession quizSession = (QuizSession) session.getAttribute("quizSession");
        if (request.getParameter("option") != null) {
            int answer = Integer.parseInt(request.getParameter("option")); // store answer in answer variable
            quizSession.checkCorrectQuestion(answer); // check answer
            quizSession.moveToNextQuestion(); // move index of currentQuestion in quizSession
            quizSession.answer();
        }else {
            quizSession.notAnswer();
        }
        if (quizSession.isQuizEnded()) { // check isQuizEnded
            int score = quizSession.getCorrectAnswerCount(); // store score from quizSession
            request.setAttribute("score", score); // save score in request name "score"
            request.getRequestDispatcher("/result.jsp").forward(request, response); // forward request to result.jsp
        }else {
            doGet(request, response); // if quiz not end forward to doGet method
        }
    }
}
