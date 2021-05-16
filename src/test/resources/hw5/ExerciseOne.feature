Feature: BDD style testing

  Scenario: JDI-testing site. Running Exercise 1 steps.
    Given I open JDI GitHub site
    And I login as user Roman Iovlev
    And I click on Service button in Header
    And Open Different Elements Page
    When I select checkbox Water
    And select checkbox Wind
    And  select radio button Selen
    And  select color "Yellow" from dropdown menu
    Then Log entry correspondent to checkbox Water is displayed "Water: condition changed to true"
    And Log entry correspondent to checkbox Wind is displayed "Wind: condition changed to true"
    And Log entry correspondent to radio button Selen is displayed "metal: value changed to  Selen"
    And Log entry correspondent color Yellow is displayed "Colors: value changed to Yellow"
