plugins {
	java
	id("org.springframework.boot") version "3.3.4"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

val manifoldVersion = "2024.1.34"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	implementation("systems.manifold:manifold-ext-rt:${manifoldVersion}")
	annotationProcessor("systems.manifold:manifold-ext:${manifoldVersion}")
}

tasks.withType<JavaCompile> {
	options.encoding = "UTF-8"
	options.compilerArgs.addAll(listOf("-Xplugin:Manifold"))
}

tasks.withType<Test> {
	useJUnitPlatform()
}
