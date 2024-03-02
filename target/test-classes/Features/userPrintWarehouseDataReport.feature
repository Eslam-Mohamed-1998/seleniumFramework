Feature: User Print Warehouse Data Report   
      The User Enter Valid UserName and Password and Click On Login button , Search For Warehouse Data Screen Enter The Parameters and Print A Report
       
       Scenario: User Print Warehouse Data Report
       Given The User at Sass Login Page 
       When  Enter The User name and The Password then click On Login button 
       And  Move To Saas Home Page
       And Enter The Screen Name and Search For it
       And  The User Move To The Target Screen
       And Open Specific WareHouse Data Screen 
       And Click On Print button and Generate The Report 
       Then The User Will Generate The Report
       
       

