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
org.apache.logging.log4j core and api

https://logging.apache.org/log4j/2.x/maven-artifacts.html


Step 3 - create Folder structure

----------------------------

Step 4 - Create Routes class --> contains url`s

Step 5 - Create UserEndPoints class --> contains CRUD methods implementation

Step 6 - Create Test Cases

Step 7 - Create Data Driven Test -
         excelSheet data
         ExcelUtility file
         Data providers

Step 8 - Generate extent reports

         Extend report utility
         testng.xml file

         location Practice Selenium - > reports

Step 9 - Add logs
         log4j2 dependency
         log4j2.xml src/test/resources

Step 10 - Add Jenkins to project
          Add 2 plugin
          1) maven surefire plugin
             https://maven.apache.org/surefire/maven-surefire-plugin/usage.html
          2) maven-compiler-plugin
             https://maven.apache.org/plugins/maven-compiler-plugin/usage.html
              <build>
                     <pluginManagement>
                         <plugins>
                             <plugin>
                                 <groupId>org.apache.maven.plugins</groupId>
                                 <artifactId>maven-compiler-plugin</artifactId>
                                 <version>3.8.1</version>
                                 <configuration>
                                     <source>14</source>
                                     <target>14</target>
                                     <encoding>UTF-8</encoding>
                                 </configuration>
                             </plugin>
                             <plugin>
                                 <groupId>org.apache.maven.plugins</groupId>
                                 <artifactId>maven-surefire-plugin</artifactId>
                                 <version>3.2.5</version>
                             </plugin>
                         </plugins>
                     </pluginManagement>
                 </build>


