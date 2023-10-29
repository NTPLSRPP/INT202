package com.example.quiz.model;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor

public class Question {
    private String title;
    private List<String> options;
    private int correctAnswerIndex;

    public boolean checkAnswer(int selectedIndex) {
        return correctAnswerIndex == selectedIndex;
    }
}
