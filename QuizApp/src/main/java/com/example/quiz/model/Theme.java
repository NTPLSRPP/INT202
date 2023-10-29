package com.example.quiz.model;

import com.example.quiz.utils.CSVLoader;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class Theme {
    private List<Color> colors;
    private int currentThemeIndex;

    public void fetchColors() {
        CSVLoader loader = new CSVLoader();
        loader.loadColors();
        colors = loader.getColors();
    }
}
