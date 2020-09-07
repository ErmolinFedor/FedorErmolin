package hw5.pages;

import hw5.pages.components.RightSideBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class UserTable extends BaseElements {
    private RightSideBar rightSideBar;

    @FindBy(id = "ivan")
    private WebElement ivanCheckbox;

    @FindBy(css = "table#user-table select")
    private List<WebElement> dropdowns;

    @FindBy(css = "table#user-table a")
    private List<WebElement> usernames;

    @FindBy(css = "table#user-table div.user-descr span")
    private List<WebElement> descriptions;

    @FindBy(css = "table#user-table div.user-descr input")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//tr[2]//option")
    private List<WebElement> optionsTypeForUserRoman;

    @FindBy(xpath = "//td[1]")
    private List<WebElement> numberColumn;

    public UserTable(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        rightSideBar = new RightSideBar(driver);
    }

    public void clickIvanCheckbox() {
        ivanCheckbox.click();
    }

    public RightSideBar getRightSideBar() {
        return rightSideBar;
    }

    public int getDropdownCount() {
        return dropdowns.size();
    }

    public int getUsernameCount() {
        return usernames.size();
    }

    public int getDescriptionsCount() {
        return descriptions.size();
    }

    public int getCheckboxesCount() {
        return checkboxes.size();
    }

    public List<WebElement> getOptionsTypeForUserRoman() {
        return optionsTypeForUserRoman;
    }

    public List<String> getUsernamesList() {
        List<String> usernameList = new ArrayList<>();
        for (WebElement username : usernames) {
            usernameList.add(username.getText());
        }
        return usernameList;
    }

    public List<String> getNumberColumnList() {
        List<String> numberColumnList = new ArrayList<>();
        for (WebElement number : numberColumn) {
            numberColumnList.add(number.getText());
        }
        return numberColumnList;
    }

    public List<String> getDescriptionsList() {
        List<String> descriptionStrings = new ArrayList<>();
        for (WebElement description : descriptions) {
            descriptionStrings.add(description.getText());
        }
        return descriptionStrings;
    }

    public List<String> getOptionsStringForRoman() {
        List<String> optionList = new ArrayList<>();
        for (WebElement option : optionsTypeForUserRoman) {
            optionList.add(option.getText());
        }
        return optionList;
    }
}
