plugins {
	java
	id("org.springframework.boot") version "3.5.5"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "Spring"
version = "0.0.1-SNAPSHOT"
description = "Demo project for Spring Boot"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(24)
	}
}

repositories {
	mavenCentral()
}

dependencies {
    // Spring Boot
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-amqp")



    implementation("org.hibernate.orm:hibernate-core:7.1.1.Final")
    implementation("jakarta.persistence:jakarta.persistence-api:3.2.0")
    implementation("com.h2database:h2:2.3.232")
    implementation("redis.clients:jedis:6.2.0")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    runtimeOnly("com.h2database:h2")
    implementation("com.rabbitmq:amqp-client:5.21.0")

}

tasks.withType<Test> {
	useJUnitPlatform()
}



tasks.register("produce", JavaExec::class) {
    mainClass = "package Spring.jpa.messaging.PollProducer;"
    classpath = sourceSets.named("main").get().runtimeClasspath
    group = "messaging"
}

tasks.register("consumer", JavaExec::class) {
    mainClass = "package Spring.jpa.messaging.PollConsumer"
    classpath = sourceSets.named("main").get().runtimeClasspath
    group = "messaging"
}

/**
tasks.register("exhangeProduce", JavaExec::class) {
    mainClass = "no.hvl.dat250.messaging.ExchangeProducer"
    classpath = sourceSets.named("main").get().runtimeClasspath
    group = "messaging"
}

tasks.register("exchangeConsumer", JavaExec::class) {
    mainClass = "no.hvl.dat250.messaging.ExchangeConsumer"
    classpath = sourceSets.named("main").get().runtimeClasspath
    group = "messaging"
}
**/