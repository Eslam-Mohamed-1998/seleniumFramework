Feature: User Mark Payment Request As paid 
      The User Change The Payment request Status As Paid Payment 
       
       Scenario Outline: Valid Payment Request 
       Given The User Start With The Login Screen Of Thge Kashir Website 
       When Once He Enter The "<UserEmailOrPhoneNo>"
       And then Insert The "<Password>" He Can Login
       And He Want To Be At Test Mode  
       And and Move To Payment Request Page  
       And He Want To Add New Payment Request 
       And So He Must To Insert Valid "<Customername>" and Valid "<Amonut>" and Click On Add 
       And Mark The Payment Request as Paid and Confirm That  
       Then Check That The Payment request Is Already Be Paid Status

Examples:
|UserEmailOrPhoneNo|Password|Customername|Amonut|
|kashierpaymenttests@gmail.com|P@ssw0rd|Test1|6000|