package pages;

import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

@Getter
@Setter
public class SignupPage {
    private AppiumDriver driver;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"button-sign-up-container\"]/android.view.ViewGroup/android.widget.TextView")
    private WebElement signupTab;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"input-email\"]")
    private WebElement emailField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"input-password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"input-repeat-password\"]")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"button-SIGN UP\"]/android.view.ViewGroup")
    private WebElement signupButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]")
    private WebElement signupMessage;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/message\"]")
    private WebElement signupSuccessfullyMessage;

    @FindBy(id = "android:id/button1")
    private WebElement okButton;

 WebDriverWait wait;
    public SignupPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver,300);

    }

    public void goToSignupTab() {
        WebElement signUpTab = wait.until(ExpectedConditions.elementToBeClickable(getSignupTab()));
        signUpTab.click();
    }

    public void fillSignupForm(String email, String password) {
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getConfirmPasswordField().sendKeys(password);
        getSignupButton().click();
    }
    public static String generateRandomEmailAddress() {
        final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        final String DOMAIN = "@gmail.com"; // Change this to your desired domain

        Random random = new Random();
        StringBuilder emailAddress = new StringBuilder();

        // Generate a random username
        int usernameLength = 5 + random.nextInt(6); // Username length between 5 and 10
        for (int i = 0; i < usernameLength; i++) {
            int index = random.nextInt(ALPHABET.length());
            emailAddress.append(ALPHABET.charAt(index));
        }

        // Append a random number to ensure uniqueness
        emailAddress.append(random.nextInt(1000)); // Append a number between 0 and 999

        // Append the domain
        emailAddress.append(DOMAIN);

        return emailAddress.toString();
    }


    public boolean verifySignupMessage() {
        WebElement signUpMessage = wait.until(ExpectedConditions.visibilityOf(getSignupMessage()));
        return signUpMessage.isDisplayed();

    }

    public boolean verifySignupSuccessMessage() {
        WebElement signUpMessageSuccess = wait.until(ExpectedConditions.visibilityOf(getSignupSuccessfullyMessage()));
        return signUpMessageSuccess.isDisplayed();

    }


    public void clickOkButton() {
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(getOkButton()));
        okButton.click();

    }

    public String commonMethodForLoginPage(String email , String password) {
        goToSignupTab();
        fillSignupForm(email,password);
        clickOkButton();
        return email;

    }

}




