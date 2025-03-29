
@tag
Feature: Purchase order of the Ecommernce
  I want to use this template for my feature file
  
  Background:
  Given I landed the E commerance page

  @tag2
  Scenario Outline: positive test of purchase order
    Given Logged in with username <user> and password <password>
    When I add the product <productname>
    And checkout the <productname> and submit the order 
    Then "Thankyou for the order." message is displayed 

    Examples: 
      | user                    | password       |  productname     |
      | shetty@gmail.com | Iamking@000 | IPHONE 13 PRO  |
     
