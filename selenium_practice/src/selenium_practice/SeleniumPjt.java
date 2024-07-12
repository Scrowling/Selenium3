package selenium_practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumPjt {
    public static void main(String[] args) {
        // WebDriver 珥덇린�솕
        WebDriver driver = new ChromeDriver();
        
        // �븘�걧�썾�뜑 �쎒�럹�씠吏� �뿴湲�
        driver.get("https://www.accuweather.com/ko/kr/south-korea-weather");
        
        WebElement searchInput = driver.findElement(By.cssSelector("div.featured-search-bar.featured-search > div.searchbar-content > form > input"));
        Scanner sc = new Scanner(System.in);
        System.out.printf("Please Enter Location Name: ");
        String word = sc.nextLine();
        searchInput.sendKeys(word);
        searchInput.sendKeys(Keys.ENTER);
        sc.close();
        
        // Explicit wait to ensure the page is fully loaded and the element is present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement placeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > div.two-column-page-content > div.page-column-1 > div.page-content.content-module > div.locations-list.content-module > a:nth-child(1)")));
        
        // JavaScriptExecutor瑜� �궗�슜�븯�뿬 �슂�냼 �겢由�
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", placeBtn);
        
        // �뜲�씠�꽣 �씫�뼱�삤湲�
        String dateSelector = "div.date > p:nth-child(2)";
        List<WebElement> items1 = driver.findElements(By.cssSelector(dateSelector));
        
        String statusSelector = "div.phrase > p";
        List<WebElement> items2 = driver.findElements(By.cssSelector(statusSelector));
        
        String rainChanceSelector = "div.precip:last-child";
        List<WebElement> items3 = driver.findElements(By.cssSelector(rainChanceSelector));
        List<String> rainChances = new ArrayList();
        
        // �뜲�씠�꽣 異쒕젰
        for (WebElement item : items3) {
            rainChances.add(item.getText());
        }
        
		for (WebElement item : items1) {
			System.out.println(item.getText());
		}
		
		for (WebElement item : items2) {
			System.out.println(item.getText());
		}
		
		for (WebElement item : items3) {
			System.out.println(item.getText());
		}
    }
}
