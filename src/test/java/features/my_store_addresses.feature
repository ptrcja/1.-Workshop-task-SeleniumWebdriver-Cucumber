Feature: MyStore Address Management

  Scenario Outline: Adding new address with verification
    Given I'm on mystore main page
    When I sign in with email '<email>' and password '<password>'
    And I click on addresses tile
    And I click Create new address
    And I fill the address form with '<alias>', '<address>', '<city>', '<postalCode>', '<country>', '<phone>'
    Then the address data should be correct for '<alias>', '<address>', '<city>', '<postalCode>', '<country>', '<phone>'
    When I delete the address
    Then I can see success message "Address successfully deleted!"
    And I close mystore browser

    Examples:
      | email          | password         | alias | address         | city   | postalCode | country        | phone     |
      |  bla@gmail.com |testingtesting&*( | Home  | Avenida Marconi | Lisbon | 100-205    | United Kingdom | 254598524 |