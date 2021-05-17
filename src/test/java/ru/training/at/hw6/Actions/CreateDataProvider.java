package ru.training.at.hw6.Actions;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.testng.annotations.DataProvider;
import ru.training.at.hw6.entities.TestValues;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class CreateDataProvider {

    private static Object[][] dataObject;
    public static HashMap<String, TestValues> testData;
    private static final String jsonPath = "src/test/resources/JDI_ex8_metalsColorsDataSet.json";

    @DataProvider
    public static Object[][] dataFromFile() {

        Type testDataType = new TypeToken<HashMap<String, TestValues>>() {
        }.getType();

        try (JsonReader reader = new JsonReader(new FileReader(jsonPath))) {
            testData = new Gson().fromJson(reader, testDataType);

            int i = 0;
            dataObject = new Object[testData.size()][1];
            for (Map.Entry<String, TestValues> entry : testData.entrySet()) {
                dataObject[i][0] = entry.getValue();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataObject;
    }
}
