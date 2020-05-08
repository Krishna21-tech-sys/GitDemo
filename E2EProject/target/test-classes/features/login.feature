Feature: Login into Application

Scenario Outline: Positive test validating login
Given Initialize the browserwith chrome
And Navigate to "http://www.qaclickacademy.com/" Site
And Click on Login link in home page to land on sign in Page
When User enters <Username> and <Password> and logs in
Then Verify that user is successfully logged in
And close browsers

Examples:
|Username |Password |
|kdgandh1@neiu.edu |896865 |
|kdgh1@neiu.edu |89865 |