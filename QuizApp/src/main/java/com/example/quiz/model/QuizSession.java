package com.example.quiz.model;

import com.example.quiz.utils.CSVLoader;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class QuizSession {

    private List<Question> questions;
    private int currentQuestionIndex;
    private int correctAnswerCount;
    private boolean isAnswer = true;

    public void fetchQuestion() {
        CSVLoader loader = new CSVLoader();
        loader.loadQuestions();
        questions = loader.getQuestions();
    }

    public void moveToNextQuestion() {
        currentQuestionIndex++;
    }

    public void answer() {
        isAnswer = true;
    }

    public void notAnswer() {
        isAnswer = false;
    }

    public boolean isQuizEnded() {
        return currentQuestionIndex == questions.size();
    }

    public void checkCorrectQuestion(int selectedIndex) {
        if (questions.get(currentQuestionIndex).checkAnswer(selectedIndex)) {
            correctAnswerCount++;
        }
    }

    public void resetQuiz() {
        currentQuestionIndex = 0;
        correctAnswerCount = 0;
    }
}
