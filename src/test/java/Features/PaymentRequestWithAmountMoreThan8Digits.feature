Feature: User Try To Make Payment Request With Amount More than Limit Digits
      The User Try To add New Payment Request With Amount Greter Than The accepted Number Limit Of Digits
       
       Scenario Outline: inValid Payment Request 
       Given User Open The Kshir Login Screen  
       When Insert "<Email>"
       And Insert "<Pass>" then login
       And User Be At Test Mode 
       And User Be At Payment Request Page  
       And Try To Add New Payment Request 
       And The User Enter it is "<Cus_Name>" and it is "<total_amount>" 
       Then An Hint Message Input must be Six or Eight digits & unique. Is Appear

Examples:
|Email|Pass|Cus_Name|total_amount|
|kashierpaymenttests@gmail.com|P@ssw0rd|Test1|1000000000|