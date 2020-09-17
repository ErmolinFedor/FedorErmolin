package hw8.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hw8.beans.MetalsColors;
import hw8.forms.MetalsColorsForm;
import io.qameta.allure.Step;

import java.util.List;
import java.util.stream.Collectors;

public class JdiMetalsColorsPage extends WebPage {
    @Css("#submit-button")
    private Button submitButton;

    @XPath("//*[@class='form']")
    private MetalsColorsForm metalsColorsForm;

    @Css(".results li")
    private WebList results;

    @Step("Submit form Metals & Colors")
    public void clickSubmit() {
        submitButton.click();
    }

    @Step("Fill form Metals & Colors by data below: {data}")
    public void fillMetalsColorsForm(MetalsColors metalsColors) {
        metalsColorsForm.fill(metalsColors);
        submitButton.click();
    }

    public List<String> getLogListResults() {
        return results.stream()
                .map(UIElement::getText)
                .collect(Collectors.toList());
    }

}
