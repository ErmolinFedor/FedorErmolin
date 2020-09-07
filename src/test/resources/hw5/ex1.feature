Feature: Different Elements page UI feature
  In order to check elements
  As a user
  I want to check Log area

  Scenario:
    Given I open JDI GitHub site
    And I login as user 'Roman Iovlev'
    When I click on Service button in Header
    And I click on Different Elements Page button in Service dropdown
    And Select checkboxes 'Water Wind'
    And Select radiobutton 'Selen'
    And Select in dropdown 'Yellow'
    Then Name should be displayed and equals to expected username "ROMAN IOVLEV"
    And Log rows are displayed and checkbox name and its status are corresponding to selected
    And Log rows are displayed and radio button name and it status is corresponding to selected
    And Log rows are displayed and dropdown name and selected value is corresponding to selected