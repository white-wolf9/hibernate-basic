# hibernate-basic
# TO-CHANGE in case of personal machine
# pom.xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.lti.entity</groupId>
	<artifactId>hibernate-intro</artifactId>
	<version>1.0</version>

	<dependencies>
		<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>5.3.0.Final</version>
		</dependency>
		<dependency>
			<groupId>com.oracle</groupId>
			<artifactId>ojdbc8</artifactId>
			<version>18.0.0</version>
		</dependency>
	</dependencies>
</project>

# persistence.xml

<persistence xmlns="http://java.sun.com/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"
             version="2.0">

   <persistence-unit name="oracleTest" transaction-type="RESOURCE_LOCAL">   
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        <properties>
            <property name="javax.persistence.jdbc.driver" value="oracle.jdbc.OracleDriver" />
            <property name="javax.persistence.jdbc.url" value="jdbc:oracle:thin:@localhost:1521:xe" />
            <property name="javax.persistence.jdbc.user" value="dummy" />
            <property name="javax.persistence.jdbc.password" value="dummy" />
            <property name="hibernate.dialect" value="org.hibernate.dialect.OracleDialect" />
            <property name="hibernate.hbm2ddl.auto" value="update" />
            <property name="hibernate.show_sql" value="true"/>   
        </properties>
    </persistence-unit>
</persistence>

# TO-CHANGE in case of office machine

# pom.xml
<dependency>
<groupId>com.oracle</groupId>
<artifactId>ojdbc8</artifactId>
<version>12.2.0.1</version>
</dependency>

# persistence.xml
<persistence xmlns="http://java.sun.com/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"
             version="2.0">

   <persistence-unit name="oracle-pu" transaction-type="RESOURCE_LOCAL">   
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        <properties>
            <property name="javax.persistence.jdbc.driver" value="oracle.jdbc.OracleDriver" />
            <property name="javax.persistence.jdbc.url" value="jdbc:oracle:thin:@localhost:1521:xe" />
            <property name="javax.persistence.jdbc.user" value="hr" />
            <property name="javax.persistence.jdbc.password" value="hr" />
            <property name="hibernate.hbm2ddl.auto" value="update" />
            <!-- Auto creation of table -->
            <property name="hibernate.show_sql" value="true" />
            <!--  Shows the SQL command -->
        </properties>
    </persistence-unit>
</persistence>
