@Regression
Feature: login to saleforce Aplication

#Background:
#Given Launch the URL
#And Load URL

Scenario Outline:  login with positive data for Lead to Opporutunity 1
 Given Enter the User name <uname>
 And Enter the Password <pwd>
 When clik on login button

 When click on applauncher
 And click on viewall
 And click on slaes

When click on homepage

When click oncreateNewLead
And click on Salutation
And  Enter the lastName  
And Enter the CompanyName 
And click on save
Then Verify new lead is created
When click on EmailtoDolist
And click on DotoList Widget
And click on subject on DoToList
And enter the Date 
And select the Status in DoToList
And Click on save in DoToList
When click on Email Button
And Enter the Mail Id
And Enter the Subject for Mail
And Enter the Compose Mail
And Click on Send
When Click on Upcoming and Overdue
And Click on Change Status
When click on Status in upcoming
And Click on Completed in Status 
When click on Save 
When Click on Details Tab
And click edit icion details Tab 
And scroll To Select details Tab
And  Click on saved in details Tab
When click to status Completion 
And click on Dropdown
And click on Convert in dropdown
And click on convert in ConvertPage
When Refersh page for whole dropdown to convert
And Take A snapShot
And close the Popup Message

Then verify  lead is convert to opporunity
When lead is conver to opportunity click on opportunityTap

And Enter the Opportunity Name
When click on opportunity

And Click on PriceBook dropdown
And Select the ChoosePriceBook
When Clik on Save for price Book
And Click on priceBook dropdown
When Click on Add Product
And Search the Product which is SLA
And Click on SlA in Search Box
And Click SLA
When print all SLA Product
And Select All the SlA Product
And  Click on Next
And Enter Quantity of SLAProduct
When Click on UPloadSampleFile
And Click on  Done to close Sample file
And Click on Close after uploading
And click on ScheduleMeetingEvent
And Click on Event widget
When click on view calender

And click on New Button in Calender page
And click on subject view calender
And  click on Date in viewcalender
And Enter the  Description in viewcalender
And click on  save view calender


Examples:
|uname|pwd|
|kpriya@testleaf.com|March2016.|
|gokul.sekar@testleaf.com|Leaf$123|

 






