# Steps to reproduce the No Hibernate Session Error
simply run 

```shell
./gradlew check
```

you should see one of the test will fail with no hibernate session error.

```java
demo.controller.ManufacturerControllerTest > fetchManufacturer FAILED
    org.spockframework.runtime.ConditionFailedWithExceptionError at ManufacturerControllerTest.groovy:21
        Caused by: java.lang.AssertionError at ManufacturerControllerTest.groovy:21
            Caused by: java.lang.AssertionError at ManufacturerControllerTest.groovy:21

demo.service.ManufacturerServiceTest > test FAILED
    org.spockframework.runtime.UnallowedExceptionThrownError at ManufacturerServiceTest.groovy:19
        Caused by: org.hibernate.HibernateException at ManufacturerServiceTest.groovy:17

```

## Analysis
The project is using spring-boot, gorm-hibernate5-spring-boot, spock, and @SpringBean from spock.

With the use of @SpringBean, spring will start an application context for each test. without using spring bean, the spring will use one context and it will be fine.
