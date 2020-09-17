package hw8.forms;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.DropdownExpand;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hw8.beans.MetalsColors;

public class MetalsColorsForm extends Form<MetalsColors> {
    @XPath("//*[@id='summary-block']//label")
    private WebList summaryRadiobuttons;

    @XPath("//*[@id='elements-block']//label")
    private WebList elementsCheckboxes;

    @XPath("//div[@id='colors']//button")
    private Button colorDropdownExpander;

    @UI("div[ui=dropdown]")
    private DropdownExpand color;

    @XPath("//div[@id='metals']//button")
    private Button metalsDropdownExpander;

    @UI("div[ui=combobox]")
    private DropdownExpand metals;

    @XPath("//div[@id='vegetables']//button")
    private Button vegetablesDropdownExpander;

    @XPath("//div[@id='vegetables']//label")
    private WebList vegetablesDropdown;

    @Override
    public void fill(final MetalsColors metalsColors) {
        metalsColors.getSummary().forEach(summary -> summaryRadiobuttons.select(Integer.toString(summary)));
        metalsColors.getElements().forEach(elementsCheckboxes::select);
        super.fill(metalsColors);
        vegetablesDropdownExpander.click();
        vegetablesDropdown.select("Vegetables");
        metalsColors.getVegetables().forEach(vegetablesDropdown::select);
    }

}
