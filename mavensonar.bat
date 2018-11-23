SET MAVEN_HOME=D:\plateforme-production\apache-maven-3.5.2
SET JAVA_HOME=D:\plateforme-production\jdk1.8.0_131
SET PATH=%JAVA_HOME%\bin;%MAVEN_HOME%\bin;%PATH%
mvn.cmd clean verify sonar:sonar -Dhttps.proxyHost=proxy.unicaen.fr -Dhttps.proxyPort=3128
