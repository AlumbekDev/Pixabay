plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-kapt")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 23
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    implementation(project(":domain"))

    // Glide
    implementation(libs.glide.glide)

    // OkHttp
    implementation(libs.bundles.okHttp)

    // Retrofit
    implementation(libs.bundles.retrofitBundle)

    // Room
    implementation(libs.bundles.roomBundle)
    kapt(libs.room.compiler)
}