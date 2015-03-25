# springmvc-architecture-gradle
A multi-project Spring MVC example with gradle

This is a Spring MVC web application example based on the <a href="https://github.com/lucaslouca/spring-architecture-gradle" target="_blank">spring-architecture-gradle</a> project.


###How to Import into Eclipse
* **File** -> **Import...** -> **Gradle** -> **Gradle Project**
* Click **Next**
* Click **Browse...** for the **Root Directory**
* Select and open **spring-app**
* Click **Build Model**
* Select all projects
* Click **Finish**

Notes: 
* You may need <a href="http://marketplace.eclipse.org/content/gradle-integration-eclipse-44" target="_blank">Gradle Integration for Eclipse</a>
* If you are using <a href="https://www.jetbrains.com/idea/" target="_blank">IntelliJ IDEA</a> make sure to replace ``apply plugin: 'eclipse'`` with ``apply plugin: 'idea'`` in the **build.gradle** file located in **spring-app**.

###Building
You can run:

```
gradle build
```

Or if you are behind a proxy:
```
gradle -Dhttp.proxyHost=proxy.address -Dhttp.proxyPort=80 -Dhttp.proxyUser=myusername -Dhttp.proxyPassword=mypassword build
```

###Replacing Dao implementations
The project as it is uses the Dummy Dao implementation. To use the the Jdbc or Hibernate implementation just change
the ``build.gradle`` file of the **spring-app-service** project from:
```
description = 'spring-app-service'
dependencies {
  . . .
  compile project(':spring-app-dao-dummy')
  . . .
}
```
to

```
description = 'spring-app-service'
dependencies {
  . . .
  compile project(':spring-app-dao-jdbc')
  . . .
}
```
or
```
description = 'spring-app-service'
dependencies {
  . . .
  compile project(':spring-app-dao-hibernate')
  . . .
}
```
and run ``gradle clean`` and ``gradle build`` or refresh projects in your IDE.

###References
<a href="http://www.gradle.org/docs/current/userguide/java_plugin.html" target="_blank">Gradle Java plugin</a><br>
<a href="http://www.gradle.org/docs/current/userguide/maven_plugin.html" target="_blank">Gradle Maven plugin</a><br>
<a href="http://www.gradle.org/docs/current/userguide/eclipse_plugin.html" target="_blank">Gradle Eclipse plugin</a><br>
<a href="http://www.gradle.org/docs/current/userguide/idea_plugin.html" target="_blank">Gradle Idea plugin</a><br>
