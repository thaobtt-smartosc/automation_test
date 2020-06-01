package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	  String ID_INPUT_EMAIL = "email";
	    String ID_INPUT_PASSWORD = "pass";
	    String ID_BUTTON_SIGN_IN = "send2";
	    String ERROR_EMAIL="//div[@id='email-error']";
	    String ERROR_PASS="//div[@id='pass-error']";
		String ERROR_PASS1="//div[@data-bind='html: message.text']";
	    public LoginPage(WebDriver driver) {
	        super(driver);
	    }

	    public void inputEmail(String email){
	        actionUtility.sendKeys(By.id(ID_INPUT_EMAIL), email);
	    }

	    public void inputPassword(String password){
	        actionUtility.sendKeys(By.id(ID_INPUT_PASSWORD), password);
	    }

	    public void clickOnSignIn(){
	        waitUtility.sleep(3);
	        actionUtility.click(By.id(ID_BUTTON_SIGN_IN));
	    }

	    public void login(String email, String pass) {
	        actionUtility.sendKeys(By.id(ID_INPUT_EMAIL), email);
	        actionUtility.sendKeys(By.id(ID_INPUT_PASSWORD), pass);
	        waitUtility.sleep(3);
	        actionUtility.click(By.id(ID_BUTTON_SIGN_IN));
	    }
	    public String checkEmail()
		{
			 actionUtility.checkElementDisplay(By.xpath(ERROR_EMAIL));	
			 return driver.findElement(By.xpath(ERROR_EMAIL)).getText();
		}
	    public String checkPassword(String pass)
		{
			if(pass=="")
			{
				actionUtility.checkElementDisplay(By.xpath(ERROR_PASS));
				return driver.findElement(By.xpath(ERROR_PASS)).getText();
			}
			else {
				actionUtility.checkElementDisplay(By.xpath(ERROR_PASS1));
				return driver.findElement(By.xpath(ERROR_PASS1)).getText();
			}
			
		}

}
