@wishlist
Feature: Wishlist Test Cases

	@scenario-outline
  	Scenario Outline: Login successfully
    	Given go to Login page
    	And input Email as <email>
    	And input Password as <password>
   	    And click on SignIn button
   		And verify user is logged in successfully
   		And clear product in wishlist
     	And add 2 product to wishlist
      	And verify Product info is correct in wishlist page
      	Then verify list product in wishlist

    Examples:
      | email                  | password    |
      |thaobtt@smartosc.com	   | Thao123456# |
         
      


	
	

	