plugins {
    alias(libs.plugins.androidApplication) // Keep only the alias
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.compose.compiler)

}

android {
    namespace = "com.example.kmpapiapp.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.example.kmpapiapp.android"
        minSdk = 30
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_7
        targetCompatibility = JavaVersion.VERSION_1_7
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

kotlin {
    jvmToolchain(18)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}


dependencies {
    implementation(projects.shared)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.appcompat)
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.1.0")
    debugImplementation(libs.compose.ui.tooling)
}
