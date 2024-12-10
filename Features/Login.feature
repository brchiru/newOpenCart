Feature: Login Functionality

  @regression @sanity
  Scenario: Successful Login with Valid Credentials
    Given user on login page
    When user enter email as "testingbrc@email.com" and password as "test@123"
    And user clicks on Login button
    Then user should be redirected to MyAccount Page
  
  @sanity
	Scenario: Login with InValid Credentials
    Given user on login page
    When user enter email as "testingbrc@email.com" and password as "test@123"
    And user clicks on Login button
    Then user should be redirected to Login Page with Warning Message
    
  @regression
	Scenario Outline: Login Data Driven
    Given user on login page
    When user enter email as "<email>" and password as "<password>"
    And user clicks on Login button
    Then user should be redirected to Login Page with Warning Message
  
  	Examples:
  		|email								|	password	|
  		|testingbrc@email.com	|	test@123	|
  		|testingbrc@email.com	|	test@1234	|