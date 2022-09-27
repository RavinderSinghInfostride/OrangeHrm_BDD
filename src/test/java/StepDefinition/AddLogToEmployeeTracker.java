package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class AddLogToEmployeeTracker extends BaseClass {
    @Given("user logins with valid credentials")
    public void user_logins_with_valid_credentials() throws IOException {
        setup();
        pageFactory.getLoginPage().login();
    }

    @When("user navigates to the performance page and navigates to the employee tracker page")
    public void user_navigates_to_the_performance_page_and_navigates_to_the_employee_tracker_page() {
        pageFactory.getEmployeeTrackerPage().navigateToEmployeeTracker();
    }

    @And("user searches the employee tracker report and clicks the view report button")
    public void user_searches_the_employee_tracker_report_and_clicks_the_view_report_button() throws IOException, InterruptedException {
        pageFactory.getEmployeeTrackerPage().searchEmployeeTrackerReport();
    }

    @Then("user clicks the add log button and fill the log details")
    public void user_clicks_the_add_log_button_and_fill_the_log_details() {
        pageFactory.getEmployeeTrackerPage().addLogToEmployeeTrackReport();
    }

    @And("the log is added and the user logs out")
    public void the_log_is_added_and_the_user_logs_out() {
        pageFactory.getEmployeeTrackerPage().verifyLogIsAdded();
        pageFactory.getEmployeeTrackerPage().logout();
    }

    @Then("the browser closes")
    public void the_browser_closes() {
        close_browser();
    }
}