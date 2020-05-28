Feature: Hotel Booking End to End feature testing

Background: User Login in to Application
	Given Launch the application browser
	When Open the login web page in the browser.
	And Verify login page heading as "Hotel_Booking_Application" using xpath.
	And Enter UserName. Ensure that displays the error message " * Please enter userName." upon clicking on the Login button without entering any data in the text box.
	And Enter Password. Ensure that displays the error message " * Please enter password." upon clicking on the Login button without entering any data in the text box.
 	And Enter "admin" as username and "admin" as password for valid login. 
	Then Verify the title "Hotel Booking" of the page.
	
Scenario Outline: User check for the Hotel and confirm the booking with payment
	When Enter First_Name "<First_Name>"  Ensure that the alert box displays the message "Please_fill_the_First_Name" upon clicking on the Confirm Button without entering any data in the text box.
	And Enter Last_Name "<Last_Name>"  Ensure that the alert box displays the message "Please_fill_the_Last_Name" upon clicking on the Confirm Button without entering any data in the text box.
	And Enter Email "<Email>" Ensure that the alert box displays the message "Please_fill_the_Email" upon wrong email format entered in the text box. 
	And Enter mobile_no "<mobile_no>" Ensure that the alert box displays the message "Please_fill_the_Mobile_No." upon clicking on the Confirm Button without entering any data in the text box.
	And Enter address_details "<address_details>" validation for address.
	And Select City "<City>"  Ensure that alert box display the message "Please_select_city" upon clicking on the Confirm Button without selecting any city.
	And Select State "<State>" Ensure that alert box display the message "Please_select_state" upon clicking on the Confirm Button without selecting any state.
	And Select Number_of_people "<Number_of_people>" staying at the Hotel. Ensure that the alert box displays the message "Number_of_people_attending." upon clicking on the  Confirm button without entering any data in the box.
	And Enter Card_Holder_Name "<Card_Holder_Name>" Ensure that the alert box displays the message "Please_fill_the_Card_holder_name" upon clicking on the Confirm Button without entering any data in the text box.
	And Enter Debit_card_Number "<Debit_card_Number>" Ensure that the alert box displays the message "Please_fill_the_Debit_card Number" upon clicking on the Confirm Button without entering any data in the text box.
	And Enter CVV "<CVV>" Ensure that the alert box displays the message "Please_fill_the_CVV_Number" upon clicking on the Confirm Button without entering any data in the text box.
	And Enter Card_expiration_month "<Card_expiration_month>" Ensure that the alert box displays the message "Please_fill_expiration_month" upon clicking on the Confirm Button without entering any data in the text box.
	And Enter Card_expiration_year "<Card_expiration_year>" Ensure that the alert box displays the message "Please_fill_expiration_year" upon clicking on the Confirm Button without entering any data in the text box.
	And Click on Confirm Booking button.
	Then Ensure that it navigates to success page which displays the message "Booking Completed!".

Examples:
    |First_Name	|Last_Name	|Email		|mobile_no	|Number_of_people	|address_details	|City		|State		|Card_Holder_Name	|Debit_card_Numbe	|CVV	|Card_expiration_month	|Card_expiration_year	|
    |			| 			|			|			|					|					|			|			|					|					|		|						|						|
    |TestUser_1	| 			|			|			|					|					|			|			|					|					|		|						|						|
	|TestUser_1	|Tata@1234	|			|			|					|					|			|			|					|					|		|						|						|
	|TestUser_1	|Tata@1234	|xyz@tcs.com|			|					|					|			|			|					|					|		|						|						|
	|TestUser_1	|Tata@1234	|xyz@tcs.com|1234567891|					|					|			|			|					|					|		|						|						|
	|TestUser_1	|Tata@1234	|xyz@tcs.com|9566039213|					|					|			|			|					|					|		|						|						|
	|TestUser_1	|Tata@1234	|xyz@tcs.com|9566039213|3					|H No:1-7-377		|			|			|					|					|		|						|						|
	|TestUser_1	|Tata@1234	|xyz@tcs.com|9566039213|3					|H No:1-7-377		|Bangalore	|			|					|					|		|						|						|
	|TestUser_1	|Tata@1234	|xyz@tcs.com|9566039213|3					|H No:1-7-377		|Bangalore	|Karnataka	|					|					|		|						|						|
	|TestUser_1	|Tata@1234	|xyz@tcs.com|9566039213|3					|H No:1-7-377		|Bangalore	|Karnataka	|Vinaybabu			|					|		|						|						|
	|TestUser_1	|Tata@1234	|xyz@tcs.com|9566039213|3					|H No:1-7-377		|Bangalore	|Karnataka	|Vinaybabu			|123456789			|		|						|						|
	|TestUser_1	|Tata@1234	|xyz@tcs.com|9566039213|3					|H No:1-7-377		|Bangalore	|Karnataka	|Vinaybabu			|123456789			|111	|10						|						|
	|TestUser_1	|Tata@1234	|xyz@tcs.com|9566039213|3					|H No:1-7-377		|Bangalore	|Karnataka	|Vinaybabu			|123456789			|111	|10						|	2024				|
	
	
	
	