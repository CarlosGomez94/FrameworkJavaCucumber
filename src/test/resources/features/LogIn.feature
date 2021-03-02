Feature: LogIn Herb Site Browsers

  @RegressionTest
  Scenario: Validate LogIn Herb
  Given I browser to page using chrome
  And I click Yes im 21 years
  Then I entered User ID
  And I entered Password
  And I click LogIn button
  Then The Login it's correct

  @RegressionTest
  Scenario: Validate LogIn Herb
    Given I browser to page using firefox
    And I click Yes im 21 years
    Then I entered User ID
    And I entered Password
    And I click LogIn button
    Then The Login it's correct

  @RegressionTest
  Scenario: Validate LogIn Herb
    Given I browser to page using safari
    And I click Yes im 21 years
    Then I entered User ID
    And I entered Password
    And I click LogIn button
    Then The Login it's correct