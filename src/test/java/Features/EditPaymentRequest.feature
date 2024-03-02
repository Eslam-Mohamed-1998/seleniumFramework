Feature: User Can Edit Payment Request data 
      The User Change Thge Payment request details and Save the New Data  
       
       Scenario Outline: inValid Payment Request 
       Given User Start With Kashir Login Page 
       When User Begin To Enter "<UserEmail>"
       And and Enter The "<UserPassword>" then Login To The Website
       And Test Mode Is Switched 
       And Payment Request Page Is Open
       And User Click On Payment Request Add button 
       And Enter The "<CusName>" and "<TotalAmount>" and click On Add Btn
       And click On Edit Request Data button 
       And Change The Request "<NewCusName>" and "<NewAmount>" then click On Save button 
       Then Check That The Updated Successfully Alret Message Is Appear 

Examples:
|UserEmail|UserPassword|CusName|TotalAmount|NewCusName|NewAmount|
|kashierpaymenttests@gmail.com|P@ssw0rd|Test1|1000|NewCustomerName|5000|