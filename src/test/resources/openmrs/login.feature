Feature: login functionality

  Scenario: validate the successful login process for open mrs
    Given user is open mrs user provides their credentials
    Then user validates title as 'Home' and 'https://demo.openmrs.org/openmrs/referenceapplication/home.page'

  Scenario Outline: negative scenario for open mrs login functionality
    Given user is on open mrs login page and user provides invalid credentials as userName as'<userName>' and '<password>'
    Then user validates an error message as '<Invalid username/password. Please try again.>'
    Examples: test data for open mrs negative test cases
      | userName | password |
      | test     | perepep  |
      |          | sadgag   |
      | asffds   |          |
      | 1232432  | Admin123 |
      | admin    | 123432   |
      | ADMIN    | Admin123 |
      | admin    | ADMIN123 |