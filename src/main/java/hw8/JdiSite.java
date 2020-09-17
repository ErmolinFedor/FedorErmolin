package hw8;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw8.pages.JdiHomePage;
import hw8.pages.JdiMetalsColorsPage;

@JSite("http://jdi-testing.github.io/jdi-light/")
public class JdiSite {
    @Url("/index.html")
    public static JdiHomePage jdiHomePage;

    @Url("/metals-colors.html")
    public static JdiMetalsColorsPage jdiMetalsColorsPage;

    public static void open() {
        jdiHomePage.open();
    }
}
