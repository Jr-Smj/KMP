plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version "1.8.20" // Użyj odpowiedniej wersji, która pasuje do Twojego projektu
    id("com.android.library")
}

kotlin {
    androidTarget()


    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                // Ktor client dependencies
                implementation("io.ktor:ktor-client-core:2.2.3")
                implementation("io.ktor:ktor-client-json:2.2.3")
                implementation("io.ktor:ktor-client-serialization:2.2.3")
                implementation("io.ktor:ktor-client-content-negotiation:2.2.3")

                // Kotlinx Serialization
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "com.example.kmpapiapp"
    compileSdk = 34
    defaultConfig {
        minSdk = 30
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
