package pages;

import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

@Getter
@Setter
public class LoginPage {
    private AppiumDriver driver;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]/android.view.ViewGroup")
    private WebElement loginButton;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"input-email\"]")
    private WebElement emailField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"input-password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"button-login-container\"]/android.view.ViewGroup/android.widget.TextView")
    private WebElement loginTab;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Login\"]/android.widget.TextView[1]")
    private WebElement loginFromBarButton;

    @FindBy(id = "android:id/alertTitle")
    private WebElement successMessageText;


    @FindBy(id = "android:id/message")
    private WebElement loginSuccessMessage;


    WebDriverWait wait;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 300);

    }

    public void clickOnLoginButton() {
        //click on login button
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(getLoginButton()));
        loginButton.click();
    }

    public void clickOnLoginWidgetFromBar() {
        //click on widget login from below bar items
        WebElement loginWidgetButton = wait.until(ExpectedConditions.elementToBeClickable(getLoginFromBarButton()));
        loginWidgetButton.click();
    }

    public void clickOnLoginTab() {
        //click on login tab pages switching
        WebElement loginTab = wait.until(ExpectedConditions.elementToBeClickable(getLoginTab()));
        loginTab.click();
    }

    public void login(String email, String password) {
       //input email text in the email field
        WebElement emailField = wait.until(ExpectedConditions.visibilityOf(getEmailField()));
        emailField.sendKeys(email);

       //input password text in the password field
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOf(getPasswordField()));
        passwordField.sendKeys(password);


    }

    public boolean verifyDisplayingSuccessMessageText() {
        //verify that the success message Text 'Success' from popup is displayed correctly

        wait = new WebDriverWait(driver, 100);
        WebElement successMessageText = wait.until(ExpectedConditions.visibilityOf(getSuccessMessageText()));
        return successMessageText.isDisplayed();
    }


    public boolean isLoginSuccessful() {
        //verify that login success from popup is displayed correctly

        WebElement loginSuccessMessage = wait.until(ExpectedConditions.visibilityOf(getLoginSuccessMessage()));
        return loginSuccessMessage.isDisplayed();
    }
}
