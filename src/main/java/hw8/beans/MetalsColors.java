
package hw8.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MetalsColors {
    @SerializedName("summary")
    @Expose
    private List<Integer> summary = new ArrayList<Integer>();
    @SerializedName("elements")
    @Expose
    private List<String> elements = new ArrayList<String>();
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("metals")
    @Expose
    private String metals;
    @SerializedName("vegetables")
    @Expose
    private List<String> vegetables = new ArrayList<String>();
    public List<Integer> getSummary() {
        return summary;
    }
    public void setSummary(List<Integer> summary) {
        this.summary = summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMetals() {
        return metals;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public void setVegetables(List<String> vegetables) {
        this.vegetables = vegetables;
    }

}
