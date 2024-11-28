Feature: API Testing for Clients and Resources

  # Test Case 1: Change the phone number of the first Client named Laura
  Scenario: Update the phone number of the first client named Laura
    Given there are at least 10 registered clients
    When I find the first client named Laura
    And I save her current phone number
    And I update her phone number
    Then the phone number should be updated
    And the response status code should be 200
    And the response body schema should be valid

  # Test Case 2: Get the list of active resources
  Scenario: Update all active resources to inactive
    Given there are at least 5 active resources
    When I find all active resources
    And I update resources to inactive
    Then the resources should be inactive
    And the response status code should be 200
    And the response body schema should be valid

  # Test Case 3: Create, Update, and Delete a New Client
  Scenario: Create a new client and update it
    Given I create a new client with name "John Doe" and phone "123-555-7890"
    When I retrieve the newly created client
    And I update the client's phone number to "987-654-3210"
    Then the client's phone number should be updated to "987-654-3210"
    And the response status code should be 200
    And the response body schema should be valid

  # Test Case 4: Update the last created resource
  Scenario: Update the last created resource
    Given there are at least 15 resources in the system
    When I find the latest created resource
    And I update all the parameters of this resource
    Then the resource parameters should be updated
    And the response status code should be 200
    And the response body schema should be valid
