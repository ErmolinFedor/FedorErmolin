
package hw8.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataSet {

    @SerializedName("data_1")
    @Expose
    private Data data1;
    @SerializedName("data_2")
    @Expose
    private Data data2;
    @SerializedName("data_3")
    @Expose
    private Data data3;
    @SerializedName("data_4")
    @Expose
    private Data data4;
    @SerializedName("data_5")
    @Expose
    private Data data5;

    public Data getData1() {
        return data1;
    }

    public Data getData2() {
        return data2;
    }

    public Data getData3() {
        return data3;
    }

    public Data getData4() {
        return data4;
    }

    public Data getData5() {
        return data5;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DataSet.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("data1");
        sb.append('=');
        sb.append(((this.data1 == null)?"<null>":this.data1));
        sb.append(',');
        sb.append("data2");
        sb.append('=');
        sb.append(((this.data2 == null)?"<null>":this.data2));
        sb.append(',');
        sb.append("data3");
        sb.append('=');
        sb.append(((this.data3 == null)?"<null>":this.data3));
        sb.append(',');
        sb.append("data4");
        sb.append('=');
        sb.append(((this.data4 == null)?"<null>":this.data4));
        sb.append(',');
        sb.append("data5");
        sb.append('=');
        sb.append(((this.data5 == null)?"<null>":this.data5));
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
        result = ((result* 31)+((this.data1 == null)? 0 :this.data1 .hashCode()));
        result = ((result* 31)+((this.data5 == null)? 0 :this.data5 .hashCode()));
        result = ((result* 31)+((this.data4 == null)? 0 :this.data4 .hashCode()));
        result = ((result* 31)+((this.data3 == null)? 0 :this.data3 .hashCode()));
        result = ((result* 31)+((this.data2 == null)? 0 :this.data2 .hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DataSet) == false) {
            return false;
        }
        DataSet rhs = ((DataSet) other);
        return ((((((this.data1 == rhs.data1)||((this.data1 != null)&&this.data1 .equals(rhs.data1)))&&((this.data5 == rhs.data5)||((this.data5 != null)&&this.data5 .equals(rhs.data5))))&&((this.data4 == rhs.data4)||((this.data4 != null)&&this.data4 .equals(rhs.data4))))&&((this.data3 == rhs.data3)||((this.data3 != null)&&this.data3 .equals(rhs.data3))))&&((this.data2 == rhs.data2)||((this.data2 != null)&&this.data2 .equals(rhs.data2))));
    }

}
