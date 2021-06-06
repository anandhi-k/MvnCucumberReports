package stepdefs;

import java.io.File;


import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;

//import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GooglePageStepDef {
	WebDriver driver;
	
			
	@Given("User is on google home page")
	public void user_is_on_google_home_page() {
		WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
	  driver.get("https://www.google.co.in/");
	  }

	@When("User search selenium")
	public void user_search_selenium() {
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("Selenium Tutorial");
		searchbox.submit();
	}

	@Then("Should display selenium search result page")
	public void should_display_selenium_search_result_page() {
	  Assert.assertEquals("Selenium Tutorial - Google Search", driver.getTitle());
	}

	@When("User search Java")
	public void user_search_Java() {
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("Java Tutorial");
		searchbox.submit();
	}

	@Then("Should display Java search result page")
	public void should_display_Java_search_result_page() {
		//Making this verification to fail
		 Assert.assertEquals("Java Tutorial - Google Search", driver.getTitle());
	}
	
	@Then("Close the browser")
	public void close_the_browser() {
	  driver.close();
	}

	@After
	public void includeScreenshot(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
			scenario.attach(fileContent, "image/png", "image1");
		
//			scenario.embed(fileContent, "image/png", "image1");
//			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
//			File destinationPath = new File(System.getProperty("user.dir") + "/target/test-report/extent-report/screenshots/" + sourcePath + ".png"); 
//			FileUtils.copyFile(sourcePath, destinationPath); 
//			Reporter.addScreenCaptureFromPath("./screenshots/"+screenshotName+".png");
//	
		}
		
	}

}
