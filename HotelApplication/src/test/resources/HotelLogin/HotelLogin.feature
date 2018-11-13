#Author: Prashant
Feature: Login
Description: New

Scenario: check the heading of the login page
Given user is on login page
Then check the heading of the page

Scenario: Successful login with valid data
Description: to login user needs to enter his valid username, password
Given user is on login page
When user enters valid username, valid password
Then navigate to hotelBooking 

Scenario: prompt user to enter the data when he leaves the login fields empty
Given user is on login page
When user does not enter either username or password
And click the login Button
Then display appropriate message 

Scenario: Unsuccessful Login due to incorrect username or password
Given user is on login page
When user enters incorrect username or password 
Then display login failed message