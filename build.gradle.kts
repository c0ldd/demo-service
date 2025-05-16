plugins {
	kotlin("jvm") version "2.1.0"
	kotlin("plugin.spring") version "2.1.0"
	id("org.springframework.boot") version "3.3.9"
	id("io.spring.dependency-management") version "1.1.7"
	id("io.freefair.aspectj.post-compile-weaving") version "8.12.1"
}

group = "com.example.aop"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(project("demo-api"))
	inpath(files("demo-api/build/libs/demo-api-0.0.1-SNAPSHOT.jar"))


	aspect("org.springframework:spring-aspects")
	implementation("org.aspectj:aspectjrt")

	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-aop")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	implementation("org.springframework:spring-tx")
	runtimeOnly("com.h2database:h2")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
