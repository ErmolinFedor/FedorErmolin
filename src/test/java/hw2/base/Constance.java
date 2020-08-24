package hw2.base;

import java.util.ArrayList;
import java.util.List;

public class Constance {
    public static final String titleExpected = "Home Page";
    public static final String login = "Roman";
    public static final String password = "Jdi1234";
    public static final String userName = "ROMAN IOVLEV";
    public static final String mainText = "EPAM FRAMEWORK WISHES…\n"
            + "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, "
            + "SED DO EIUSMOD TEMPOR INCIDIDUNT UT "
            + "LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, "
            + "QUIS NOSTRUD EXERCITATION ULLAMCO "
            + "LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT "
            + "DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN "
            + "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
    public static final String subHeaderTxt = "JDI GITHUB";
    public static final String link = "https://github.com/epam/JDI";
    public static final String menuButtons = "HOME\n"
            + "CONTACT FORM\n"
            + "SERVICE\n"
            + "METALS & COLORS";

    public static final List<String> serviceElementsLeft = new ArrayList<>();

    public static final List<String> serviceElementsHeader = new ArrayList<>();

    public static final int imgCount = 4;

    public static final int checkboxes = 4;
    public static final int radios = 4;
    public static final int dropdown = 1;
    public static final int buttons = 2;

    static {
        serviceElementsHeader.add("SUPPORT");
        serviceElementsHeader.add("DATES");
        serviceElementsHeader.add("SEARCH");
        serviceElementsHeader.add("COMPLEX TABLE");
        serviceElementsHeader.add("SIMPLE TABLE");
        serviceElementsHeader.add("USER TABLE");
        serviceElementsHeader.add("TABLE WITH PAGES");
        serviceElementsHeader.add("DIFFERENT ELEMENTS");
        serviceElementsHeader.add("PERFORMANCE");
    }


    static {
        serviceElementsLeft.add("Support");
        serviceElementsLeft.add("Dates");
        serviceElementsLeft.add("Complex Table");
        serviceElementsLeft.add("Simple Table");
        serviceElementsLeft.add("Search");
        serviceElementsLeft.add("User Table");
        serviceElementsLeft.add("Table with pages");
        serviceElementsLeft.add("Different elements");
        serviceElementsLeft.add("Performance");
    }




}
