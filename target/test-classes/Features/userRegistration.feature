@disabled
Feature: User Registration 
       The User Can Register With Successfull Data To NopCommerce Website 
       
       Scenario Outline: User Registration 
       Given The User Open The Website LandPage 
       When  The User Click On Register button 
       And Enter The "<fName>" , "<lName>" , "<email>" , "<pass>" 
       Then The Registration Success Message Is appeared 

Examples:
|fName|lName|email|pass|
|Eslam11|Mohamed11|eslam11@Test.com|1254644546|
|Mohamed11|Ayman11|Ayman11@Trest.com|5+4156465|