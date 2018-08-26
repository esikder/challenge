package step;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import page.TodoBasePage;

public class TodoSteps {
    TodoBasePage todoPage =  new TodoBasePage(BrowserBeanFactory.driver);


    @And("^I enter an item to the list \"([^\"]*)\"$")
    public void enterItemName(String name){
        todoPage.addItem(name);
    }
    @When("^I press Enter$")
    public void iPressEnter()  {
        todoPage.enterKeyPressOnItem();
    }


    @Given("^I am on ToDo list page$")
    public void iAmOnToDoListPage()  {
        todoPage.goToUrl();
    }


    @When("^I delete \"([^\"]*)\"$")
    public void iDelete(String name) throws Throwable {
        todoPage.deleteItem(name);
    }

    @Then("^I should not see \"([^\"]*)\" in the ToDo list$")
    public void iShouldNotSeeInTheToDoList(String name) throws Throwable {
        Assert.assertTrue(todoPage.isElementWithGivenNameAvailableInList(name) );
    }

    @When("^I select an item$")
    public void iCheckAndItem() throws Throwable {
       todoPage.selectItem();
    }

    @Then("^the item should be completed$")
    public void theItemShouldBeCompleted() throws Throwable {
        todoPage.verifyTaskStatusIsCompleted();
    }


    @Then("^I see \"([^\"]*)\" is available in the ToDo List$")
    public void iSeeIsAvailableInTheToDoList(String name) throws Throwable {
       Assert.assertTrue( todoPage.isElementWithGivenNameAvailableInList(name));
    }

    @When("^I edit item name to \"([^\"]*)\"$")
    public void iEditItemNameTo(String name) throws Throwable {
       todoPage.editItem(name);
    }
}
