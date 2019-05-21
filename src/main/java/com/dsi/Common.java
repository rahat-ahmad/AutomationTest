package com.dsi;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Common {

//	WebElement healthcare, higherEducation, eDiscovery, banking, offDockManagement, projects, clients, ourPeople,
//			joinUs;

	public List<WebElement> topBarButtons(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@id='right-menu']/ul/li/a"));
	}
	
	public List<WebElement> projectList(WebDriver driver){
		return driver.findElements(By.xpath("//li[@class='is-active orbit-slide']"));
	}

	public WebElement getHealthcare(WebDriver driver) {
		if(projectList(driver).size()==5) return projectList(driver).get(0);
		return projectList(driver).get(1);
	}

	public WebElement getHigherEducation(WebDriver driver) {
		if(projectList(driver).size()==5) return projectList(driver).get(1);
		return projectList(driver).get(2);
	}

	public WebElement geteDiscovery(WebDriver driver) {
		if(projectList(driver).size()==5) return projectList(driver).get(2);
		return projectList(driver).get(3);
	}

	public WebElement getBanking(WebDriver driver) {
		if(projectList(driver).size()==5) return projectList(driver).get(3);
		return projectList(driver).get(4);
	}

	public WebElement getOffDockManagement(WebDriver driver) {
		if(projectList(driver).size()==5) return projectList(driver).get(4);
		return projectList(driver).get(5);
	}

	public WebElement getProjects(WebDriver driver) {
		return topBarButtons(driver).get(0);
	}

	public WebElement getClients(WebDriver driver) {
		return topBarButtons(driver).get(1);
	}

	public WebElement getOurPeople(WebDriver driver) {
		return topBarButtons(driver).get(2);
	}

	public WebElement getJoinUs(WebDriver driver) {
		return topBarButtons(driver).get(3);
	}
	
	public WebElement getActiveSlideOfClient(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='orbit-wrapper']/ul/li[@class='orbit-slide is-active']")).get(0);
	}
	
	public List<WebElement> getEmployeeList(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='row']/div[@class='large-3 medium-6 small-6 columns']"));
	}
}
