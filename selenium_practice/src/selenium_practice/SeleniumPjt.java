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
        // WebDriver start
        WebDriver driver = new ChromeDriver();
        
        // access accuweather.com
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
        
        // JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", placeBtn);
        
        // data read
        String dateSelector = "div.date > p:nth-child(2)";
        List<WebElement> items1 = driver.findElements(By.cssSelector(dateSelector));
        
        String statusSelector = "div.phrase > p";
        List<WebElement> items2 = driver.findElements(By.cssSelector(statusSelector));
        
        String rainChanceSelector = "div.precip:last-child";
        List<WebElement> items3 = driver.findElements(By.cssSelector(rainChanceSelector));
        
        // data print
		
		for (int i = 0;i < items1.size();i++) {
			String rainChanceText = items3.get(i).getText();
			String emoji;
			int rainChance = Integer.parseInt(rainChanceText.replace("%", ""));
			if (rainChance < 40) {
				emoji = "그냥 가";
			} else if (rainChance < 70) {
				emoji = "우산...챙겨야 할지도?";
			} else {
				emoji = "우산 챙겨";
			}
			System.out.printf("%s|%-20s|%s %s\n", items1.get(i).getText(), items2.get(i).getText(), items3.get(i).getText(), emoji);
		}
    }
}
