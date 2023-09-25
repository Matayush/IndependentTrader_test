Feature: Login

  "User story"

  Scenario: Correct Credentials
    Given I go to login page
    When I type "mceniuk@hotmail.com" as login
    And I type "qwerty@" as password
    And I click login button
    Then I am logged in

  Scenario: Incorrect Credentials
    Given I go to login page
    When I type "mngr525086" as login
    And I type "IncorrectPassword" as password
    And I click login button
    Then I am NOT logged in


  Scenario Outline: Check credentials
    Given  I go to login page
    When I type "<login>" as login and "<password>" as password
    Then <expectedResult>
    Examples:
      | login               | password          | expectedResult     |
      | mceniuk@hotmail.com | qwerty@           | I am logged in     |
      | mngr525086          | IncorrectPassword | I am NOT logged in |

