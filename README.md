# IMS-Project



How to use IMS application

Overview
The IMS Project is used to perform CRUD related operations in Mysql database for inventory management system.

Guidelines
Clone this repository into the Eclipse.

Once the application imported into the eclipse,go to the main project explorer structure ,
First you need to use your Mysql credentials  in to the src/main/resources/db.properties to connect to the 
database and include all queries in src/main/resources/sql-schema.sql and src/main/resources/sql-data.sql .
Next run Runner.java as right click -> Run as ->  then select java application.
It will ask to enter Which entity would you like to use? like below
CUSTOMER: Information about customers
ITEM: Individual Items
ORDER: Purchases of items
STOP: To close the application

You can enter if you want to perform CRUD operations related to the CUSTOMER.
You can perform same CRUD operations to ITEM and ORDER tables also.


How to test IMS application

For testing the application create another database schema to perform CRUD realted test oprations in Mysql.
Mention this information in   src/test/resources/db.properties and schema related information in src/test/resources/sql-schema.sql and src/test/resources/sql-data.sql .
Then right click on src/test/java->  select  Run as -> JUnit Test.
If you want to check your testing coverage then click on src/test/java->  select  Coverage as -> JUnit Test to get how much percentage entire application is tesed.
Better percentage for testing is 76%.

Important

Add below code  into the .gitignore file before push into the your GitHub repo so it will not display  your credential information about your Mysql database to others .

src/main/resources/db.properties