
Feature: ToDo List test containing following features :
  As a user I should be able to add , edit, complete, delete item in todo list.


  Scenario: I add item to ToDo list
    Given I am on ToDo list page
    When I enter an item to the list "test"
    And I press Enter
    Then I see "test" is available in the ToDo List
    When I edit item name to "test_updated"
    Then I see "test_updated" is available in the ToDo List
    When I select an item
    Then the item should be completed
    When I delete "test_updated"
    Then I should not see "test_updated" in the ToDo list