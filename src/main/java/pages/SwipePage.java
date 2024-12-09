package pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Map.*;

@Getter
public class SwipePage {
    private AppiumDriver driver;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Swipe\"]/android.widget.TextView[1]")
    private WebElement swipeWidgetFromBar;


    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"slideTextContainer\"])[2]/android.widget.TextView[1]")
    private WebElement supportVideoCardText;


    WebDriverWait wait;

    public SwipePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 300);

    }

    public void goToSwipeScreen() {
        //click on the swip widget bar

        WebElement swipScreenTab = wait.until(ExpectedConditions.elementToBeClickable(getSwipeWidgetFromBar()));
        getSwipeWidgetFromBar().click();
    }

    public void swipeUntilSupportVideosCardDisplay() throws InterruptedException {
        // this to keep swiping tell it gets the support video card

        WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement swapCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.view.ViewGroup[@content-desc=\"card\"])[1]")));

            //keep looping until gets the specified card
            // 4 its the number for the cards
            //2 the first current card that on it

            for(int i=2;i<=4;i++){
                String currentFocusedCard = swapCard.getAttribute("focusable");
                Assert.assertEquals("true", currentFocusedCard);
                WebElement dotsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Carousel\"]/android.view.ViewGroup/android.view.ViewGroup["+i+"]")));
                swipeAction(dotsElement, "left");
            }
            System.out.println("support videos card found ");
            Thread.sleep(100);
    }

    public void swipeAction(WebElement ele, String swipeDirection) {
        // this swpping function cards
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "direction", swipeDirection,
                "percent", 0.75
        ));
    }

}

