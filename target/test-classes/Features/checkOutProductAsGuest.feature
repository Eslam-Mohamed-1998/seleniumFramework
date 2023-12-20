Feature: User Check Out Product As Guest 
      The User Search For Specific product , Add To Cart , Confirm The Required Data and Print The Invoice
       
       Scenario Outline: User Check Out Product As Guest 
       Given The User at The  E-Commerce Home Page 
       When  User Search For Specific Product Using The "<productName>" 
       And Add The Product to The Crtedit Cart
       And Open Check Out Product Page 
       And Click On Check Out Product As Guest button
       And The Guest User Check Out The Product 
       And Open Order Details Page  
       Then The User Can  Print The Order details

Examples:
|productName|
|Asus|