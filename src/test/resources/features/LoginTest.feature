@login
Feature: Login Test Cases

  @scenario-outline
  Scenario Outline: Login successfully 
    Given go to Login page
    And input Email as <email>
    And input Password as <password>
    And click on SignIn button
    Then verify user is logged in successfully

    Examples:
      | email                  | password   	|
      | thaobtt@smartosc.com   | Thao123456# 	|
      
      
    Scenario Outline: Login with invalid email
    	Given go to Login page
    	And input Email as <email>
    	And input Password as <password>
    	And click on SignIn button
    	Then verify login with invalid email
    	
    Examples:
    	|	email     		|	password	|  
    	|	@#$%			|	Thao123456#	|
	   	|					|	Thao123456#	|
	
#	Scenario Outline: Login with invalid password
#		Given go toLogin Page
#		And input Email as <email>
#		And input Password as <password>
#		And click on SignIn button
#		Then verify login with invalid password
		
#	Examples:
#		|	email					|	password	|
#		|	thaobtt@smartosc.com	|	@%#			|
#		|	thaobtt@smartosc.com	|				|
	
    	
  