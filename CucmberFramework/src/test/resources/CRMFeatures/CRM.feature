@BackgroundTag
Feature: Test Background Feature

Background: User in Logged in
Given User is already on login page
When Title of login page is free crm
Then User enters credentials
	|username|password|
	|anandhi_k|crmpro@123|
Then User click on login button
Then User is on Home Page

Scenario: Create a new deal
Then User moves to New Deal page
Then User enters deal details
	|title|amount|probability|commission|
	|testdata123|5000|10|5|

Scenario: Create a new contact
Then User moves to New Contact page
Then User enters contact details
	|firstname|lastname|
	|Mick|John|