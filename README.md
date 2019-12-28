# StateStreetTest

I attached a Spring Boot Application which provides the solution for the given test. Following are details.
---------------------------------------------------------------------------------------------------------------------
Tech Stack:

Hibernate/JPA - As ORM
Spring Boot - Integration Framework
H2 Database - As DataBase which will be run in server mode
----------------------------------------------------------------------------------------------------------------------
Code for Entity beans Exist in the package : hibernate-test\src\main\java\com\statestreet\test\dto

To Record scrore for a course for each student introduced follwoing Entities under above folder : CourseRecord and StudentCourse

Student Dao with require methods are at the class : hibernate-test\src\main\java\com\statestreet\test\dao\StudentDao.java

In Student Dao, Used Programmetic transaction. This class also has required SQLS for the given Queries

Similar functionality can be achived by using JPARepositoties where we can use Declarative transactions sample code exist at below,
hibernate-test\src\main\java\com\statestreet\test\dao\CourseRepository.java
hibernate-test\src\main\java\com\statestreet\test\dao\StudentRepository.java


Bese Practices Regarding Hibernate :

1. Use efficient Data type for association perfer Set than list on many side of association
2. Provide utility method to add/remove association
3. Avoid using CascaseType 
4. Prefer LAZY fetch type
5. Analyse sql queries and execution plans, for complex queries use native queries
6. Perform update and delete in bulks

Hibernate Best 

1. active and vibrant community supported by Red hat
2. Best suited for new applicaion development

How to Use the App:
First start the Server.java at packge : org.h2.tools in dependecy jar : h2-1.4.200.jar

