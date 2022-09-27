package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class LoginSteps extends BaseClass {
    @Given("user navigates to the login page of the website")
    public void user_navigates_to_the_login_page_of_the_website() throws IOException {
        setup();
    }

    @When("user enter valid username and password and clicks on the login button")
    public void user_enter_valid_username_and_password_and_clicks_on_the_login_button() throws IOException {
        pageFactory.getLoginPage().login();
    }

    @And("user is on the PIM page")
    public void user_is_on_the_pim_page() {
        pageFactory.getLoginPage().landingPageVerifyAfterLogin();
    }

    @Then("browser closes")
    public void browser_closes()
    {
        close_browser();
    }
}