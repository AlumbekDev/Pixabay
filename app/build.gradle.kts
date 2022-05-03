plugins {

    // Application
    id("com.android.application")

    // Kotlin
    id("kotlin-android")

    // Kapt
    id("kotlin-kapt")

    // Navigation SafeArgs
    id("androidx.navigation.safeargs.kotlin")

    // Hilt
    id("com.google.dagger.hilt.android")


    id("kotlin-parcelize")

}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.example.pixabaykt"
        minSdk = 23
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    //ViewBinding
    buildFeatures.viewBinding = true
}

dependencies {

    implementation(project(":data"))

    implementation(project(":domain"))

    // UI Components
    implementation(libs.bundles.uiComponents)

    // Core
    implementation(libs.android.core)

    // Activity
    implementation(libs.activity.activity)

    // Fragment
    implementation(libs.fragment.fragment)

    // Lifecycle
    implementation(libs.bundles.lifecycleBundle)

    // Navigation
    implementation(libs.bundles.navigationBundle)

    // Retrofit
    implementation(libs.bundles.retrofitBundle)

    // OkHttpClient
    implementation(libs.bundles.okHttp)


    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    // Legacy Support
    implementation(libs.legacySupport.legacySupport)

    // Glide
    implementation(libs.glide.glide)

    // SplashScreen
    implementation(libs.ui.splashScreen)
}