import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform") version "1.7.0"
    java
    application
}

repositories {
    mavenCentral()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

java {
    this.sourceCompatibility = JavaVersion.VERSION_17
    this.targetCompatibility = JavaVersion.VERSION_17
}

application {
    mainClass.set("io.github.zeculesu.itmo.programming.lab3.Main")
}


kotlin {
    explicitApi = ExplicitApiMode.Strict
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "17"
        }

        tasks.register<Jar>("buildFatJar") {
            duplicatesStrategy = DuplicatesStrategy.EXCLUDE
            group = "application"
            // archiveVersion.set("v${project.version}")
            manifest {
                attributes["Main-Class"] = application.mainClass.get()
            }
            from(compilations["main"].output.classesDirs)
            from(compilations["main"].runtimeDependencyFiles.map { d -> if (d.isDirectory) d else zipTree(d) })
            with(tasks.jar.get() as CopySpec)
            @Suppress("DEPRECATION")
            destinationDirectory = projectDir.resolve("out")
        }

        withJava()
    }
}