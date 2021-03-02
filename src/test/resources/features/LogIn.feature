Feature: LogIn Herb Site.
  @RegressionTest
  Scenario: Validate LogIn Herb
    Given I browser to page using chrome
  And I click Yes im 21 years
  Then I entered User ID
  And I entered Password
  And I click LogIn button
  Then The Login it's correct