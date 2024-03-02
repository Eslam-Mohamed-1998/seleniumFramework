Feature: User Can Make A Payment Request
      The User With Valid Credintials & Valid Data Can Make A Payment Request 
       
       Scenario Outline: Valid Payment Request 
       Given The User at Kahier Login Page 
       When Insert "<EmailAddressOrPhoneNo>" and Click On Next button
       And Insert "<Password>" And Click On Login button
       And Switch To Test Mode 
       And Open Payment Request page 
       And Click On Add Payment Request button 
       And Enter Valid "<CustomerName>" and "<Amount>" and Click On add button
       And Click On Share button then Click On Redirection Link Icon 
       And Accept Terms and Condations and Click On Pay Now button  
       Then Back To The Payment Request To Check That Payment Request Reflect At The Payment Requests List 

Examples:
|EmailAddressOrPhoneNo|Password|CustomerName|Amount|
|kashierpaymenttests@gmail.com|P@ssw0rd|Test1|1000|