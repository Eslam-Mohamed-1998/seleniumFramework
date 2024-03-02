Feature: User Make Payment request With Empty Data
      The User Try To Submit Payment Request With Empty Customer Name and Empty amount  
       
       Scenario Outline: inValid Payment Request 
       Given The User Open Kashir Login Page  
       When Enter "<Email>" and click On Next button
       And Enter "<Password>" then Click On Login
       And Swap To The Test Mode 
       And Navigate To Payment Request Page  
       And Add New Payment Request
       And Enter Empty "<CustomerName>" and Empty "<Amount>" and Click On add Button  
       Then An Hint Message Will Appear This Field Is Required 

Examples:
|Email|Password|CustomerName|Amount|
|kashierpaymenttests@gmail.com|P@ssw0rd| | |