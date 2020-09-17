package hw8.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import hw8.beans.MetalsColors;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;
import static java.lang.String.join;

public class MetalsColorsData {
    private static final String JSON_Path = "src\\test\\resources\\hw8\\JDI_ex8_metalsColorsDataSet.json";
    @DataProvider(name = "MetalsColorsToDo")
    public Object[][] getData() {
        Map<String, MetalsColors> dataSetFromJson = readJson();
        Object[][] testDataSet = new Object[dataSetFromJson.size()][2];
        int i = 0;
        for (String key : dataSetFromJson.keySet()) {
            testDataSet[i][0] = dataSetFromJson.get(key);
            testDataSet[i][1] = expectedList(dataSetFromJson.get(key));
            i++;
        }
        return testDataSet;
    }

    private List<String> expectedList(MetalsColors metalsColors) {
        List<String> expectedList = new ArrayList<>();
        if (metalsColors.getSummary()!= null) {
            int sum= metalsColors.getSummary().stream().mapToInt(Integer::intValue).sum();
            expectedList.add(format("Summary: %d", sum));
        }
        if (metalsColors.getElements()!= null) {
            String elementsList = join(", ", metalsColors.getElements());
            expectedList.add(join(" ", "Elements:", elementsList));
        }
        if (metalsColors.getColor()!= null) {
            expectedList.add(format("Color: %s", metalsColors.getColor()));
        }
        if (metalsColors.getMetals()!= null) {
            expectedList.add(format("Metal: %s", metalsColors.getMetals()));
        }
        if (metalsColors.getVegetables()!= null) {
            String vegetablesList = join(", ", metalsColors.getVegetables());
            expectedList.add(join(" ", "Vegetables:", vegetablesList));
        }
        return expectedList;
    }

    private Map<String, MetalsColors> readJson() {
        JsonReader jsonReader = null;
        try {
            jsonReader = new JsonReader(new FileReader(JSON_Path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Type jsonType = new TypeToken<Map<String, MetalsColors>>() {
        }.getType();
        Map<String, MetalsColors> dataSetFromJson = new Gson().fromJson(jsonReader, jsonType);
        return dataSetFromJson;
    }

}
