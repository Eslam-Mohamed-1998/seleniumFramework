Feature: User Can Change The Payment Currency
      The User Try To Change Payment request to USD and Add Payment Request
       
       Scenario Outline: Valid Payment Request 
       Given The Website Of Kashir Login page is The Beginning 
       When Move To Enter "<EmailAddressOrPhoneNo>"
       And then Insert The User "<Pass>" and Continue to Login Action
       And The User need to Be At test Mode 
       And He Need to Navigate To Payment Request page
       And Change The Payment Currency To USD  
       And and Try To Add or Create New Payment Request 
       And Will Be Able To Enter "<Cus_Name>" and "<Amount>" and click On Add   
       Then Check That The total amount Is In USD Currency  

Examples:
|EmailAddressOrPhoneNo|Pass|Cus_Name|Amount|
|kashierpaymenttests@gmail.com|P@ssw0rd|Test1|1000|