plugins {
	java
	id("org.springframework.boot") version "4.0.4"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "project"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-webmvc")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

// ─── Frontend build integration ────────────────────────────────────────────────

val frontendDir = file("${project.projectDir}/../frontend")
val frontendDist = file("${frontendDir}/dist")
val staticOutputDir = file("${project.projectDir}/src/main/resources/static")

tasks.register<Exec>("npmBuild") {
	description = "Runs 'npm run build' inside the frontend/ directory"
	group = "build"
	workingDir = frontendDir
	commandLine("cmd", "/c", "npm", "run", "build")
	inputs.dir(file("${frontendDir}/src"))
	inputs.file(file("${frontendDir}/package.json"))
	inputs.file(file("${frontendDir}/vite.config.js"))
	outputs.dir(frontendDist)
}

tasks.register<Copy>("copyFrontend") {
	description = "Copies Vite dist output into Spring Boot's static resources"
	group = "build"
	dependsOn("npmBuild")
	from(frontendDist)
	into(staticOutputDir)
}

tasks.named("processResources") {
	dependsOn("copyFrontend")
}
