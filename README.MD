## Framework includes
- TestNG 
 > - remove comment in pom.xml to config suite - suiteXmlFiles;
 > - path to xml: src/test/resources/${testng.suiteXml}

- Selenium 
> - use webdrivermanager
> - WebDriverFactory path: src/main/java/common/WebDriverFactory.java
> - Main config const: src/main/java/common/ConfigFramework.java
> - Add cookies example: src/main/java/page/addCookiesSmsHub/InfoPage.java

- Allure report
> - path to properties: src\test\resources\allure.properties;
> - resultsDirectory: {project.basedir}/allure-results;
> - reportDirectory: {project.basedir}/allureReport; 

- Rest Assured
> - path to response-request spec: src/main/java/helpers/specApiRequestResponse/Specification.java
> - JSON Schema Validation example path: src/test/java/apiReqres/JsonSchemaValidationTest.java \
> JSON Schema Validation schema.json path: src/test/resources/schema.json


- Typesafe config reader
> - path to example config file: src\test\resources\app.conf
> - config interface: src\main\java\common\ConfigProvider.java

- DataProvider with Excel
> - Java API To Access Microsoft Format Files , maven dependency: poi, poi-ooxml, poi-ooxml-schemas
> - ExcelReader path: src/main/java/common/ExcelReader.java
> - Excel DataProvider example path: src/main/java/constants/ExcelDataProviders.java

- Connect to DB SQL
> - path to connect config: src\main\java\common\ConnectDB.java

---

- *  Properties var
> - path to .properties file: src\test\resources\app.properties

- * Mockito for mocking
> - example path: src\test\java\mokitoExample

- * WireMock for stubing API
> - example path: src\test\java\wireMockExample
> - if we use Standalone server we need create mapping end start server(example mapping in comment into file: src\test\java\wireMockExample\myAStandaloneTest.java )

- * Flaky Test
> - config to count retry: src/main/java/common/TestNgFlakyRetry.java
> - add in every Flaky test annotation @BeforeClass with code example: src/test/java/flackyTests/FlakyTest.java

- * Soft Assertions
> - example: src/test/java/softAssertions/softAssertionsTest.java