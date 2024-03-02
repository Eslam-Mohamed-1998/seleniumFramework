Feature: User Can Make A Payment Request With Minus Amount data
      The User Try To add New Payment Request With Minus Amount Vlaue
       
       Scenario Outline: inValid Payment Request 
       Given The User Be At Kahir Loging Page  
       When Enter Valid "<UserEmail>" and Click On Next
       And Enter Valid "<UserPassword>" and Click On Login
       And Move To Test Mode 
       And Open The Payment Request Screen 
       And Click Add New Payment Request 
       And User Insert Valid "<CustomerName>" and "<MinusAmountValue>" and Click On add button  
       Then An Alret Message That The Total amount Must Be Greater Than Zero Is appear 

Examples:
|UserEmail|UserPassword|CustomerName|MinusAmountValue|
|kashierpaymenttests@gmail.com|P@ssw0rd|Test1|-1000|