@Test
Feature: Online shopping

  Background:
    Given  User Launches "https://www.demoblaze.com/"

    @RegressionTest
    Scenario: Online Shopping cart
      When  User creates new account by clicking on Signs Up menu
      Then User can navigate item and add products to the shopping cart
      And User can Place order and finilize payment
