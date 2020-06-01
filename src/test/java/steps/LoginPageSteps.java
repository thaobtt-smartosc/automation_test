package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import utility.InitDriver;

public class LoginPageSteps {

    public LoginPage loginPage;
    public HomePage homePage;

    public LoginPageSteps(){
        loginPage = new LoginPage(InitDriver.getDriver());
        homePage = new HomePage(InitDriver.getDriver());
    }

    @Given("go to Login page")
    public void goToLoginPage() {
        homePage.open().clickOnSignIn();
    }

    @And("^input Email as (.+?)$")
    public void inputEmailAs(String email) {
    	System.out.println("ahihi");
        loginPage.inputEmail(email);
    }

    @And("^input Password as (.+?)$")
    public void inputPassAs(String pass) {
        loginPage.inputPassword(pass);
    }

    @And("click on SignIn button")
    public void clickOnSignInButton() {
        loginPage.clickOnSignIn();
    }

    @Then("verify user is logged in successfully")
    public void verifyUserIsLoggedInSuccessfully() {
        // check user log in successfully
        Assert.assertTrue("Log in unsuccessfully.Plz check!", homePage.checkUserLoggedIn());
    }
    @Then("verify login with invalid email")
    public void verifyLoginWithInvalidEmail()
    {
    	Assert.assertEquals("Please enter a valid email address (Ex: johndoe@domain.com).", loginPage.checkEmail());
    }
    @Then("verify login with invalid password")
    public void verifyLoginWithInvalidPassword()
    {
    	//Assert.assertEquals("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.",loginPage.checkPassword(password));
    }


}
