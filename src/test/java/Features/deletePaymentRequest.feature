Feature: User Delete Payment Request
      The User Delete Payment request He created  
       
       Scenario Outline: Valid Payment Request 
       Given The Kahir Login Page Is The Beginning 
       When Strat With Insertion "<UserEmailOrPhoneNo>"
       And then Move To Insertion The "<Pass>" and Click On Login button
       And The Test Mode is Active  
       And Navigate To Create Payment Request Screen   
       And User Create Add New Payment Request 
       And He Will Resposible To Insert "CustomerName" and "<amount>" 
       And Click On Delete Payment Request button  
       Then Check That Payment request Delted Successfully alret Is Appeqr 

Examples:
|UserEmailOrPhoneNo|Pass|CustomerName|amount|
|kashierpaymenttests@gmail.com|P@ssw0rd|Test1|6000|