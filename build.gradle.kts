import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    val ktlintGradlePluginVersion = "9.3.0"
    repositories {
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("org.jlleitschuh.gradle:ktlint-gradle:$ktlintGradlePluginVersion")
    }
}

plugins {
    val kotlinVersion = "1.3.72"
    val ktlintGradlePluginVersion = "9.3.0"

    id("org.springframework.boot") version "2.3.3.RELEASE"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
    id("com.google.cloud.tools.jib") version "2.5.0"
    id("org.jlleitschuh.gradle.ktlint") version "$ktlintGradlePluginVersion"
}

group = "timrapp"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.springframework.boot:spring-boot-devtools")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	runtimeOnly("com.h2database:h2")
	testImplementation("org.mockito:mockito-inline:3.4.6")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
}

// build image and push to local docker registry
jib {
	from.image = "openjdk:12-jdk" // use latest image
	to {
		image = "vlorp"
		credHelper = "gcr"
		tags = setOf("latest")
	}
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint") // Version inherited from parent

    // configure plugin
    ktlint {
        debug.set(true)
    }
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}
