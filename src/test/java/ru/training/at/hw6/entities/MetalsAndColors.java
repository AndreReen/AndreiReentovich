package ru.training.at.hw6.entities;

import lombok.Data;
import java.util.Arrays;
import java.util.List;

@Data
public class MetalsAndColors {
    String[] summary;
    String[] elements;
    String color;
    String metals;
    String[] vegetables;

    public static List<String> resultsList(MetalsAndColors data) {
        String sumExp = "Summary: "
                + (Integer.parseInt(data.getSummary()[0]) + Integer.parseInt(data.getSummary()[1]));
        String elemBuild = Arrays.toString(data.getElements());
        String elemExp = "Elements: " + elemBuild.substring(1, elemBuild.length() - 1);
        String colorExp = "Color: " + data.getColor();
        String metalExp = "Metal: " + data.getMetals();
        String vegBuild = Arrays.toString(data.getVegetables());
        String vegExp = "Vegetables: " + vegBuild.substring(1, vegBuild.length() - 1);
        return Arrays.asList(sumExp, elemExp, colorExp, metalExp, vegExp);
    }
}
