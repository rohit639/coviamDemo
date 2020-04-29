# TestVagrant Demp

This Project is made only for demo purpose.
> Report will be auto open for Windows & Mac, Only if **localSlow** is enabled.
> In config.properties **localSlow** & **timeToSlow** is provided. If reviewer want to slow the process and verify each steps.
> If **localSlow** is enabled then after complition of automation, local report will be automatically genrated. This is to avoid Allure reports in local.
> created small .sh file to run scripts
```
sh run_testng_xml.sh xmlFileName.xml
```

### Please Note
**Config Properties** file is saved outside. Its not in resources as its demo project and accessing will be easy.


####  Prerequisites
* MAVEN 
* JAVA
* Browser (Chrome/Firefox)
* Allure (report)

## How to run ?

* Can be simply run via IDE, *testNG* plugin is must
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
* For now url, browser can be passed via maven goal. Apart from these nothing additional added to pass via maven.
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
    * *This will auto genrated after run from below :-*
		*  IDE
		* XML Files
		* Maven
        > 	Could easily be found under project with **AppName** provided in config file, with *HTML* extension
2. ****Extension Report****
    * This will only be genrated once maven run is completed.
    * Mandatory to have allure installed.
    *  To genrate allure report use below command once maven is completed.
    ```
    allure serve 
    ```

