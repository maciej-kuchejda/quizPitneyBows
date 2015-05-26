Quiz application for Pitney Bows company
=========================
First to Edit:
--------------
*First step:
On your local instance of MySQL execute sql file named "InitialData.sql".
This file is located in maciej/src/main/resource/SQL/.

*Second step:
Edit file spring.xml in maciej/src/main/resource. In bean with id "dataSource",
There are one property to change, named "password". You must change value to your
root password.
Do the same thing in file:
maciej/src/webapp/WEB-INF/security-config.xml

About project:
--------------
To do this quiz, I has been used "Maven-project" and I added to dependency's all file used
in Spring-MVC. On the User Interface, I used bootstrap to have responsive layout.
In the background every controller return data in JSON format. On the UI I used AngularJS
with UI Boostrap. To get data from Database, I used ORM, Hibernate.

Author:
------
Kuchejda Maciej