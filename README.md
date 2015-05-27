Competion application for Pitney Bows company
=========================
Steps to run the application
--------------
* The first step:
To start you have to download the project. To do so click on the button 
named 'Download ZIP'.

* The second step:
To run application propertly, you must have database. To do so you have to open 
your 'Workbench MySQL' and execute SQL file name 'InitialData.sql'. This file
is located in 'maciej/src/main/resoutces/SQL'.

* The third step:
Application used conection to database. To do this, aplication contains few 
configuration files. To run apllication you have to edit two files spring.xml
and security-config.xml. In the first file there is a bean with id 'dataSource'.
There are two properties to change, named 'password' and 'username'. You have to
do the same for the second file. 
The first file is located in 'maciej/src/main/resource' and second 
in 'maciej/src/webapp/WEB-INF'

* The last step:
After everything is done correctly just run the application and have fun :)

About project:
--------------
To make this competition application I used 'Maven-project'. In file 'pom.xml'
I added dependencies to all 'spring MVC' libraries. On the User Interface, I used
bootstrap to have responsive layout. In the background almost every controller 
return data in JSON format. On the UI, I used AngularJS with UI Bootstrap. 
To get data from database, I used ORM, Hibernate

Author:
------
Kuchejda Maciej
