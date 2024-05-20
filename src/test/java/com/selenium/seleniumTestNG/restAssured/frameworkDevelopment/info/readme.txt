Framework - maintain all project related files.

Objectives
------------
1)Re-usability
2)Maintainability
3)Readability

Hybrid Driven
-------------

Phases
-------------
1)Understanding requirement
  - Functional specifications (static)
  - Swagger

2)Choose automation tool - Rest Assured Library

3)Design

4)Development

5)Execution + CI

@Test
public void test(){
//pre-requisites
//request type
//response validation
}
-----------------------

//pre-requisites
Step 1 - Create Maven Project

Step 2 - pom.xml add dependencies
org.testng
io.rest-assured rest-assured
io.rest-assured json-path and/or xml-path
io.rest-assured json-schema-validator
org.json
com.github.javafaker
com.github.scribejava
com.aventstack extentreports
org.apache.poi poi
org.apache.poi poi-ooxml

Step 3 - create Folder structure

----------------------------

Step 4 - Create Routes class --> contains url`s

Step 5 - Create UserEndPoints class --> contains CRUD methods implementation



