package by.htp.quizful.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage{
	
	private static final Logger logger = LogManager.getRootLogger();
	

    private static final String URL = "http://www.quizful.net/LoginAction.loginForm";
    
    @FindBy(id = "login")
	private WebElement login;
    @FindBy(name = "loginForm.password")
   	private WebElement password;
    @FindBy(css = "p.buttons input.btn.btn-primary")
   	private WebElement submitButton;
    @FindBy(xpath = "//ul[@id='user-panel']//a[starts-with(@href,'/user/')] ")
   	private WebElement linkLoggedInUserName;
    
    public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
    
    public void openPage(){
    	driver.navigate().to(URL);
		logger.info("Login page opened");
    }
        
    public void fillForm(String loginValue, String passwordValue){
    	login.sendKeys(loginValue);
    	password.sendKeys(passwordValue);
    	submitButton.click();
    	logger.info("Login form passed");
    }
    public String getLoggedInUserName() {
		return linkLoggedInUserName.getText();
	}
}
