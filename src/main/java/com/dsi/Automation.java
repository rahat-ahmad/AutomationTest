package com.dsi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Automation {
	WebDriver driver;
	WebDriverWait wait;
	Common common;

	public Automation() {
		ChromeDriverInitializer chromeDriverInitializer = new ChromeDriverInitializer();
		driver = chromeDriverInitializer.getChromeDriver();
		wait = new WebDriverWait(driver, 10);
		common = new Common();
	}

	public void test() throws InterruptedException, IOException {
		List<Map<String, String>> allResult = new ArrayList<Map<String, String>>();
		try {
			driver.get("http://www.dsinnovators.com/");
			
			allResult.add(result(null, "1.1", "", ""));
			
			allResult.add(result(common.getProjects(driver), "2.1", "Projects", ""));
			
			allResult.add(result(common.getClients(driver), "2.2", "Clients", ""));
			
			allResult.add(result(common.getOurPeople(driver), "2.3", "Our People", ""));
			
			allResult.add(result(common.getJoinUs(driver), "2.4", "Join Us", ""));
			
			allResult.add(result(driver.findElement(By.xpath("//a[@class='button splash']")), "2.5", "More About Dsi", ""));
			
			allResult.add(result(common.getHealthcare(driver), "2.6", "Healthcare", ""));
			
			allResult.add(result(common.getHigherEducation(driver), "2.7", "Higher Education", ""));
			
			allResult.add(result(common.geteDiscovery(driver), "2.8", "eDiscovery", ""));
			
			allResult.add(result(common.getBanking(driver), "2.9", "Banking", ""));
			
			allResult.add(result(common.getOffDockManagement(driver), "2.10", "Off-Dock Management", ""));
			
			allResult.add(result(
					driver.findElement(By
							.xpath("//a[@class='button medium margin-top-1 margin-bottom-2 secondary-color capitalize']")),
					"2.11", "Know More", ""));
			
			allResult.add(result(
					driver.findElement(By.xpath(
							"//a[@class='button medium medium margin-top-1 margin-bottom-2 secondary-color capitalize']")),
					"2.12", "Contact Us", ""));
			
			try {
				common.getProjects(driver).click();
				allResult.add(resultAfterClick("3.1", true));
				Thread.sleep(2000);
			} catch (WebDriverException e) {
				System.out.println(e);
				allResult.add(resultAfterClick("3.1", false));
			}

			try {
				common.getHealthcare(driver).findElement(By.tagName("a")).click();
				allResult.add(resultAfterClick("3.2", true));
				allResult.add(result(null, "3.3", "http://www.dsinnovators.com/olwel.html", driver.getCurrentUrl()));
				driver.navigate().back();
				Thread.sleep(3000);
			} catch (WebDriverException e) {
				System.out.println(e);
				allResult.add(resultAfterClick("3.2", false));
				allResult.add(resultAfterClick("3.3", false));
			}

			try {
				common.getHigherEducation(driver).findElement(By.tagName("a")).click();
				allResult.add(resultAfterClick("3.4", true));
				allResult.add(result(null, "3.5", "http://www.dsinnovators.com/jenzabar.html", driver.getCurrentUrl()));
				driver.navigate().back();
				Thread.sleep(3000);
			} catch (WebDriverException e) {
				System.out.println(e);
				allResult.add(resultAfterClick("3.4", false));
				allResult.add(resultAfterClick("3.5", false));
			}

			try {
				common.geteDiscovery(driver).findElement(By.tagName("a")).click();
				allResult.add(resultAfterClick("3.6", true));
				allResult.add(result(null, "3.7", "http://www.dsinnovators.com/iControl.html", driver.getCurrentUrl()));
				driver.navigate().back();
				Thread.sleep(3000);
			} catch (WebDriverException e) {
				System.out.println(e);
				allResult.add(resultAfterClick("3.6", false));
				allResult.add(resultAfterClick("3.7", false));
			}

			try {
				common.getBanking(driver).findElement(By.tagName("a")).click();
				allResult.add(resultAfterClick("3.8", true));
				allResult.add(result(null, "3.9", "http://www.dsinnovators.com/infoImage.html", driver.getCurrentUrl()));
				driver.navigate().back();
				Thread.sleep(3000);
			} catch (WebDriverException e) {
				System.out.println(e);
				allResult.add(resultAfterClick("3.8", false));
				allResult.add(resultAfterClick("3.9", false));
			}

			try {
				common.getOffDockManagement(driver).findElement(By.tagName("a")).click();
				allResult.add(resultAfterClick("3.10", true));
				allResult.add(result(null, "3.11", "http://www.dsinnovators.com/odms.html", driver.getCurrentUrl()));
				driver.navigate().back();
				Thread.sleep(3000);
			} catch (WebDriverException e) {
				System.out.println(e);
				allResult.add(resultAfterClick("3.10", false));
				allResult.add(resultAfterClick("3.11", false));
			}
			
			try {
				common.getClients(driver).click();
				allResult.add(resultAfterClick("3.12", true));
				Thread.sleep(2000);
			} catch (WebDriverException e) {
				System.out.println(e);
				allResult.add(resultAfterClick("3.12", false));
			}
			String currentSlide = common.getActiveSlideOfClient(driver).getText();
			Thread.sleep(5000);
			if(!currentSlide.equals(common.getActiveSlideOfClient(driver).getText())) allResult.add(resultAfterClick("3.13", true));
			else {allResult.add(resultAfterClick("3.13", false));}
			
			
			currentSlide = common.getActiveSlideOfClient(driver).getText();
			driver.findElement(By.xpath("//div[@class='orbit primary-background']/div/div/button[@class='orbit-next']")).click();
			if(!currentSlide.equals(common.getActiveSlideOfClient(driver).getText())) allResult.add(resultAfterClick("3.14", true));
			else {allResult.add(resultAfterClick("3.14", false));}
			
			currentSlide = common.getActiveSlideOfClient(driver).getText();
			driver.findElement(By.xpath("//div[@class='orbit primary-background']/div/div/button[@class='orbit-previous']")).click();
			if(!currentSlide.equals(common.getActiveSlideOfClient(driver).getText())) allResult.add(resultAfterClick("3.15", true));
			else {allResult.add(resultAfterClick("3.15", false));}
			
			try {
				common.getOurPeople(driver).click();
				if(common.getEmployeeList(driver).size()==4) allResult.add(resultAfterClick("3.16", true));
				else allResult.add(resultAfterClick("3.16", false));
				
			} catch (WebDriverException e) {
				System.out.println(e);
				allResult.add(resultAfterClick("3.16", false));
			}
			
			try {
				driver.findElement(By.xpath("//div[@class='text-center']/a[@class='button medium margin-top-1 margin-bottom-2 secondary-color capitalize']")).click();
				Thread.sleep(5000);
				if(common.getEmployeeList(driver).size()==12) allResult.add(resultAfterClick("3.17", true));
				else allResult.add(resultAfterClick("3.17", false));
			} catch (WebDriverException e) {
				System.out.println(e);
				allResult.add(resultAfterClick("3.17", false));
			}
			
			try {
				driver.findElement(By.xpath("//div[@id='partner-with-us-button text-center']/div/a")).click();
				allResult.add(resultAfterClick("3.18", true));
				Thread.sleep(2000);
				allResult.add(result(null, "3.19", "http://www.dsinnovators.com/contact.html", driver.getCurrentUrl()));
			} catch (WebDriverException e) {
				System.out.println(e);
				allResult.add(resultAfterClick("3.18", false));
				allResult.add(resultAfterClick("3.19", false));
			}
		} catch (NoSuchElementException e1) {
			System.out.println(e1);
		} catch (TimeoutException e2) {
			System.out.println(e2);
		}
		
		CsvResult csvResult = new CsvResult();
		csvResult.resultInFile(allResult);
		driver.quit();
	}

	public Map<String, String> result(WebElement webElement, String id, String value, String URL) {
		Map<String, String> map = new HashMap<String, String>();
		if (webElement == null && URL.isEmpty()) {
			map.put("id", id);
			map.put("result", "Passed");
			return map;
		}
		if (URL.isEmpty() && webElement.getText().trim().equalsIgnoreCase(value)) {
			map.put("id", id);
			map.put("result", "Passed");
			return map;
		}

		if (!URL.isEmpty() && value.equals(URL)) {
			map.put("id", id);
			map.put("result", "Passed");
			return map;
		}
		map.put("id", id);
		map.put("result", "Failed");
		return map;
	}

	public Map<String, String> resultAfterClick(String id, boolean isClicked) {
		Map<String, String> map = new HashMap<String, String>();
		if (isClicked) {
			System.out.println(id + " " + isClicked);
			map.put("id", id);
			map.put("result", "Passed");
			return map;
		}
		map.put("id", id);
		map.put("result", "Failed");
		return map;

	}
}
