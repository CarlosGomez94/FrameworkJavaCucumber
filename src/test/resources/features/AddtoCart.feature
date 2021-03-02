Feature: LogIn Herb Site Browsers
  @RegressionTest
  Scenario: Validate LogIn Herb
  Given I browser to page using chrome
  And I click Yes im 21 years
  Then I entered User ID
  And I entered Password
  And I click LogIn button
  And The Login it's correct
  Then I move to products
  And I Click in plus button to add to the cart
  And I move to the cart button
  Then The cart it's correct