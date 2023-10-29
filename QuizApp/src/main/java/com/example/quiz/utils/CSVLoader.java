package com.example.quiz.utils;

import com.example.quiz.model.Color;
import com.example.quiz.model.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@NoArgsConstructor

public class CSVLoader {
    List<Question> questions = new ArrayList<>();
    List<Color> colors = new ArrayList<>();
    public void loadQuestions() {
        InputStream inputStream = CSVLoader.class.getClassLoader().getResourceAsStream("Data.csv");
        if (inputStream == null) {
            System.out.println("Couldn't find CSV file");
            return;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            String csvSplitBy = "\\|";
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                String questionText = data[0];
                System.out.println(questionText);
                List<String> options = Arrays.asList(data[1].split(","));
                System.out.println(options);
                int correctAnswerIndex = Integer.parseInt(data[2]);
                System.out.println(correctAnswerIndex);
                Question question = new Question(questionText, options, correctAnswerIndex);
                questions.add(question);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadColors() {
        InputStream inputStream = CSVLoader.class.getClassLoader().getResourceAsStream("Color.csv");
        if (inputStream == null) {
            System.out.println("Couldn't find CSV file");
            return;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            String csvSplitBy = "\\|";
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                String title = data[0];
                System.out.println(title);
                String bgColor = data[1];
                System.out.println(bgColor);
                String txtColor = data[2];
                System.out.println(txtColor);
                Color color = new Color(title, bgColor, txtColor);
                colors.add(color);
                System.out.println("--------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}