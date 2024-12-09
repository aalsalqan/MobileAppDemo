package pages;

import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.Random;


@Getter
public class FormsPage {
    private AppiumDriver driver;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Forms\"]")
    private WebElement formsWidgetButton;


    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"text-input\"]")
    private WebElement inputField;


    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"input-text-result\"]")
    private WebElement typeTextField;


    @FindBy(xpath = "//android.widget.Switch[@content-desc=\"switch\"]")
    private WebElement switchToggleButton;


    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
    private WebElement dropDownListOptions;


    WebDriverWait wait;

    // Add locators for the 4 sections and interactions
    public FormsPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 500);
    }

    public void FillFormsPage(String text) {
        Random random = new Random();
        text = text + random.nextInt(100);

        clickOnFormTabButton();
        fillInputField(text);
        Assert.assertTrue(verifyTypeTextField(), " input field text display successfully");

        clickOnSwitchButton();
        clickOnDropDownListButton();
        clickOnDropDownListOptions();
    }

    public void clickOnFormTabButton() {
        //click on forms widget from bar
        WebElement formsWidgetButton = wait.until(ExpectedConditions.elementToBeClickable(getFormsWidgetButton()));
        formsWidgetButton.click();
    }

    public void fillInputField(String text) {
        //fill the input field

        WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(getInputField()));
        inputField.sendKeys(text);
    }


    public boolean verifyTypeTextField() {
        //verify the field type text displayed successfully
        WebElement inputFieldText = wait.until(ExpectedConditions.elementToBeClickable(getTypeTextField()));
        return inputFieldText.isDisplayed();
    }


    public void clickOnSwitchButton() {
        //click on switch button

        WebElement switchToggleButton = wait.until(ExpectedConditions.elementToBeClickable(getSwitchToggleButton()));
        switchToggleButton.click();
    }

    public void clickOnDropDownListButton() {
        //click on drop down list

        WebElement dropDownListButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Dropdown\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")));
        dropDownListButton.click();
    }

    public void clickOnDropDownListOptions() {
        //choose web driver element from list option & you can take it randomly via the list web element
        WebElement dropDownListOptions = wait.until(ExpectedConditions.elementToBeClickable(getDropDownListOptions()));
        dropDownListOptions.click();
    }


}
