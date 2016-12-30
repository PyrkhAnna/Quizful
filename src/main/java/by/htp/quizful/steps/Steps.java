package by.htp.quizful.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import by.htp.quizful.driver.DriverSingleton;
import by.htp.quizful.pages.LoginPage;

public class Steps {
	private WebDriver driver;
	private final Logger logger = LogManager.getRootLogger();
	
	
	public void initBrowser(){
		driver = DriverSingleton.getDriver();
		logger.info("initBrowser");
	}

	public void closeDriver() {
		driver.quit();
		logger.info("closeDriver");
	}

	public void loginQuizful(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.fillForm(username, password);
	}

	public boolean isLoggedIn(String username)
	{
		LoginPage loginPage = new LoginPage(driver);
		return (loginPage.getLoggedInUserName().trim().toLowerCase().equals(username.toLowerCase()));
	}
}
