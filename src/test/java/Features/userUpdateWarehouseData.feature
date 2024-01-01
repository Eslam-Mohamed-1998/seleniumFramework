Feature: User Update Warehouse Data    
      The User Valid UserName and Password and Click On Login button , Search For Warehouse Data Screen , Select Item Record , Update The Warehouse Data and Save The New data 
       
       Scenario Outline: User Update Warehouse Data
       Given The User at SAAS Login Page 
       When  Enter The User Name and The Password then click On Login button 
       And  Move To SAAS Home Page
       And Enter The  Target Screen Name and Search For it
       And  The User Move To The Screen
       And Open Specific WareHouse Data Update Screen 
       And Update The "<WhName>" , "<whAddress>" , "<OperationUnit>" , "<employee>" , "<Location>" , "<Remarks>" , "<fDate>" , "<tDate>" , "<costCenter>" , "<subLedger2>" and Save The New Data
       Then Check That The Warehouse Data Update Is Completed Depend On The Test Condation 
       
Examples:
|WhName|whAddress|OperationUnit|employee|Location|Remarks|fDate|tDate|costCenter|subLedger2|
|NewAutomationWH|New Test1 Address|12 - Egypt Bran|100021 - Emp 100021|1067 - egypt|Just For Automation Test …|01/01/2024|05/01/2024|14101001 - Main Warehouse|1201002 - فرع عدن|
|NewAutomationWH|New Test1 Address2|12 - Egypt Bran|100021 - Emp 100021|1067 - egypt|Just For Automation Test … With Duplicated Name|01/01/2024|05/01/2024|14101001 - Main Warehouse|1201002 - فرع عدن|

      
       
       

