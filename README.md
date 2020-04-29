# TestVagrant Demo

This Project is made only for demo purpose.
> In config.properties file **localSlow** & **timeToSlow** parameters are mentioned. 
> Report will open automatically for Windows & Mac, when **localSlow** is enabled.
> Parameter **timeToSlow** can be enabled if the reviewer want to slow the process and verify each steps.
> If **localSlow** is enabled then on completion of automation, local report will be automatically generated. This is to avoid Allure reports in local.
> created small .sh file to run scripts
```
sh run_testng_xml.sh xmlFileName.xml
```

### Please Note
**Config Properties** file is saved outside. It is not present in the resources folder since its a demo project and accessing from outside will be easier.


####  Prerequisites
* MAVEN
* JAVA
* Browser (Chrome/Firefox)
* Allure (report)

## How to run ?

* Can simply run via IDE, *testNG* plugin is must
    > Can run using xml files.
```
qa-smoke.xml
```
* Can run via maven
    > **browser & url** are ***optional***
```
mvn clean install -Dbrowser=chrome
```
## Options to pass parameters
* For now url and browser can be passed via maven goal. Apart from this nothing additional added to pass via maven.
    > **Must start with either "http://" or "https://"**
```
-Durl="https://google.com"
```

* URL can be passed from testng xml file as well. with parameter name = url.
```
<parameter name="url" value="https://ecom-optimus.myshopify.com/"></parameter>
```

* Priority for url is **1.** Maven **2.** testNG xml **3.** config.properties
* Browser value should be from below:-
1. ****chrome****
2. ****firefox****
3. ****mobileView****
* To pass xml files from maven use -DsuiteFiles=value.

```
 -DsuiteFile=qa-smoke.xml
```
## Options to see Reports and Logs
1. ****Extension Report****
    * *This will auto generated after run from below :-*
		* IDE
		* XML Files
		* Maven
        > 	Could easily be found under project with **AppName** provided in config file, with *HTML* extension
2. ****Extension Report****
    * This will only be generated once maven run is completed.
    * Mandatory to have allure installed.
    *  To generate allure report use below command once maven is completed.
    ```
    allure serve
    ```

## Options to pass parameters
