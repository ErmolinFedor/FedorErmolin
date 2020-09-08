
package hw8.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data {

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Data.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("summary");
        sb.append('=');
        sb.append(((this.summary == null)?"<null>":this.summary));
        sb.append(',');
        sb.append("elements");
        sb.append('=');
        sb.append(((this.elements == null)?"<null>":this.elements));
        sb.append(',');
        sb.append("color");
        sb.append('=');
        sb.append(((this.color == null)?"<null>":this.color));
        sb.append(',');
        sb.append("metals");
        sb.append('=');
        sb.append(((this.metals == null)?"<null>":this.metals));
        sb.append(',');
        sb.append("vegetables");
        sb.append('=');
        sb.append(((this.vegetables == null)?"<null>":this.vegetables));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.summary == null)? 0 :this.summary.hashCode()));
        result = ((result* 31)+((this.metals == null)? 0 :this.metals.hashCode()));
        result = ((result* 31)+((this.color == null)? 0 :this.color.hashCode()));
        result = ((result* 31)+((this.vegetables == null)? 0 :this.vegetables.hashCode()));
        result = ((result* 31)+((this.elements == null)? 0 :this.elements.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Data) == false) {
            return false;
        }
        Data rhs = ((Data) other);
        return ((((((this.summary == rhs.summary)||((this.summary!= null)&&this.summary.equals(rhs.summary)))&&((this.metals == rhs.metals)||((this.metals!= null)&&this.metals.equals(rhs.metals))))&&((this.color == rhs.color)||((this.color!= null)&&this.color.equals(rhs.color))))&&((this.vegetables == rhs.vegetables)||((this.vegetables!= null)&&this.vegetables.equals(rhs.vegetables))))&&((this.elements == rhs.elements)||((this.elements!= null)&&this.elements.equals(rhs.elements))));
    }

}
