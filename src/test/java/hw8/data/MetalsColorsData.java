package hw8.data;

import com.google.gson.Gson;
import hw8.beans.Data;
import hw8.beans.DataSet;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static java.lang.String.join;

public class MetalsColorsData {
    private static final String JSON_Path = "src\\test\\resources\\hw8\\JDI_ex8_metalsColorsDataSet.json";
    @DataProvider(name = "MetalsColorsToDo")
    public Object[][] getData() {
        DataSet dataSet = readJson();
        return new Object[][]{
                {dataSet.getData1(), expectedList(dataSet.getData1())},
                {dataSet.getData2(), expectedList(dataSet.getData2())},
                {dataSet.getData3(), expectedList(dataSet.getData3())},
                {dataSet.getData4(), expectedList(dataSet.getData4())},
                {dataSet.getData5(), expectedList(dataSet.getData5())}
        };
    }

    private List<String> expectedList(Data data) {
        List<String> expectedList = new ArrayList<>();
        if (data.getSummary()!= null) {
            int sum= data.getSummary().stream().mapToInt(Integer::intValue).sum();
            expectedList.add(format("Summary: %d", sum));
        }
        if (data.getElements()!= null) {
            String elementsList = join(", ", data.getElements());
            expectedList.add(join(" ", "Elements:", elementsList));
        }
        if (data.getColor()!= null) {
            expectedList.add(format("Color: %s", data.getColor()));
        }
        if (data.getMetals()!= null) {
            expectedList.add(format("Metal: %s", data.getMetals()));
        }
        if (data.getVegetables()!= null) {
            String vegetablesList = join(", ", data.getVegetables());
            expectedList.add(join(" ", "Vegetables:", vegetablesList));
        }
        return expectedList;
    }

    private DataSet readJson() {
        DataSet dataSet = null;
        try {
            dataSet = new Gson().fromJson(
                    new FileReader(JSON_Path),
                    DataSet.class
            );
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dataSet;
    }
}
