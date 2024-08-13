package stepDefinitions;

import Utils.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class stepDefi {

    private WebDriver driver;
    Utils utils = new Utils();

    @Given("Click on category and verify if product displayed")
    public void click_on_category_and_verify_if_product_displayed() {
        driver = utils.getUrl(driver,"https://www.demoblaze.com/index.html");
        utils.getElementByXpath(driver,"//a[@id='itemc' and text()='Phones']").click();
        Assert.assertTrue("Element is not visible", utils.isDisplayed(driver, "//h4[@class='card-title']//a[text()='Samsung galaxy s6']"));
        utils.getElementByXpath(driver,"//a[@id='itemc' and text()='Laptops']").click();
        Assert.assertTrue("Element is not visible", utils.isDisplayed(driver,"//h4[@class='card-title']//a[text()='Sony vaio i5']"));
        utils.getElementByXpath(driver,"//a[@id='itemc' and text()='Monitors']").click();
        Assert.assertTrue("Element is not visible", utils.isDisplayed(driver,"//h4[@class='card-title']//a[text()='Apple monitor 24']"));
        driver.close();
    }

    @Given("Click on product")
    public void click_on_product() {
        driver = utils.getUrl(driver,"https://www.demoblaze.com/index.html");
        utils.getElementByXpath(driver,"//a[@class='hrefch' and text()='Samsung galaxy s6']").click();
        Assert.assertTrue("Element is not visible", utils.isDisplayed(driver,"//a[@class='btn btn-success btn-lg']"));
    }
    @Then("Click on Add to cart")
    public void click_on_add_to_cart() {
        utils.getElementByXpath(driver,"//a[@class='btn btn-success btn-lg']").click();
    }
    @Then("Click on cart from navbar")
    public void click_on_cart_from_navbar() {
        utils.getElementByXpath(driver,"//a[@id='cartur']").click();
        Assert.assertTrue("Element is not visible", utils.isDisplayed(driver,"//button[text()='Place Order']"));
    }
    @Then("Verify if item displayed in the cart")
    public void verify_if_item_displayed_in_the_cart() {
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//tr[@class='success']//td[text()='Samsung galaxy s6']")));
        utils.getElementByXpath(driver,"//button[text()='Place Order']").click();
    }
    @Then("click on Place Order button")
    public void click_on_place_order_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = driver.findElement((By.xpath("//h5[@id='orderModalLabel']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[@id='orderModalLabel']")));
        utils.getElementByXpath(driver,"//input[@id='name']").sendKeys("Atul");
        utils.getElementByXpath(driver,"//input[@id='country']").sendKeys("xyz");
        utils.getElementByXpath(driver,"//input[@id='city']").sendKeys("xyz");
        utils.getElementByXpath(driver,"//input[@id='card']").sendKeys("xyz");
        utils.getElementByXpath(driver,"//button[text()='Purchase']").click();
        Assert.assertTrue("Element is not visible", utils.isDisplayed(driver,"//h2[contains(text(),'Thank you for your purchase')]"));
        driver.close();
    }
}
