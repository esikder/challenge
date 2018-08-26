
# Project Overview


This project has two separate modules apiTest and functionalTest, each with its individual build.gradlew file , so that
the modules are independent and can be added in different project.

# apiTest
In this module all the integration tests are added based on the apiPath under the todoComponent directory.
helper directory contains all the heplper class.

**ApiCalls** 
Contains all the apiCalls , so that the test doesnt need to handle the call and if the call changes anytime 
only changing here will be enough.

**ConfigHadler**
This class provides method to read the config property based on key.So in different places we dont need to 
read the config differently.

**DataHandler**
This class contains method for manipulating data. For different tests data needs to be created as prerequisite also data
needs to be deleted afterwards.This class provides that facility.

**Utility**
This class contains the functions for @Before and @After method. Wanted to keep it common across tests and for
changing anything will not need to modify in multiple places.

#Install 
Run the following command
./gradlew build

# Running api Test
Run the following command
./gradlew test

**@Ignored tests**
Some tests cannot be run now as the implementation of original api is not correct. The tests should work fine when
the api implementation is fixed on server side.




# functional Test
This module contains Selenium tests for UI functionality verification.
It is organized in following structure:

**feature**
Cucumber feature file is used to provide easy and simple way of test maintenance so that any one can add test from 
user's perspective. Only the positive user flow is captured in functinal test as the corner cases should be handled
in lower level.

**helper**
This directory contains all the supportive classes.

**ActionWrapper**
This class contains wrapper for generic Selenium actions. 

**BrowserLibrary**
This class contains the browser based driver initialization. It could be extended to add more browsers if needed.

**ConfigHandler**
This class provides method to read the config property based on key.So in different places we dont need to 
read the config differently.

**page**
This directory contains the page definition and BasePage. More page class should be added when the app has more pages.
All the elements should be defined in its page and the method for accessing the element should be provided in the 
corresponding page.

**step**
This class contains the driver manipulation methods.

**Runner**
This is the base runner class and based on different tags test could be run from here.

**resources**
It contains the driver file which could be included from gradle as well.


# Running Functional Test
Run the following command
./gradlew test


The test can run in Chrome or Firefox browsers and the browser is defined inside functionalTest/config.properties
For running the test in Firefox change the browser value to 'ff' and to run it in chrome set it as 'chrome' 
The test can run in different environments.
For running it in anywhere else other than localhost change the baseURI and Port value.


