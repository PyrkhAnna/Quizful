package by.htp.quizful;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.quizful.steps.Steps;

public class QuizfulAutomationTest {
	private Steps steps;
	private final String USERNAME = "Anna_Pyrkh27";
	private final String PASSWORD = "Klopik_123456";
	
	@BeforeMethod(description = "Init browser")
	public void setUp()	{
		steps = new Steps();
		steps.initBrowser();
	}

	
	@Test(description = "Login to Quizful")
	public void oneCanLoginQuizful()	{
		steps.loginQuizful(USERNAME, PASSWORD);
		Assert.assertTrue(steps.isLoggedIn(USERNAME));
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
	
}
