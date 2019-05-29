# CVApp

Hi there !

Run
./gradlew testDebugUnitTestCoverage to run the unit tests and produce the coverage report

you can open the html with the following commands :

open ./app/build/reports/jacoco/testDebugUnitTestCoverage/html/index.html

Json used to populate the data:

https://gist.githubusercontent.com/laithnurie/4543f02da001c483186f2a2c53645b89/raw/e90952d518c0b7b14b2edeb7144d0adb1404e3e8/laith_cv.json

Project details:

* MVVM architecture
* Libs used Dagger2, RxJava2, Retrofit2
* Testing tools, Junit, Mockito and Jacoco for coverage
* Security, basic proguard rule and fake debug keystore for signing to make it more *production* ready

I didn't exggarated the amount of unit testing in every class, but I think I wrote enough unit tests to demostrate my skills in writing basic unit tests and for RXjava code unit tests.

More than happy to have a pair programming session at the interview to take it further.
