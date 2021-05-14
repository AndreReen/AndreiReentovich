Feature: BDD style testing

  Scenario: User Table Page elements test
    Given I open JDI GitHub site
    And I login as user Roman Iovlev
    And I click on Service button in Header
    And I click on User Table button in Service dropdown
    When I select 'vip' checkbox for Sergey Ivan
    Then I log row has 'Vip: condition changed to true text' in log section