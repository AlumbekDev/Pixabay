plugins {
    id("com.android.library")
    kotlin("android")
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
    implementation (project(":domain"))

    // Retrofit 2
    val retrofit_version = "2.9.0"
    implementation (libs.bundles.retrofitBundle)

    // | Gson
    implementation ("com.squareup.retrofit2:converter-gson:$retrofit_version")

    // OkHttp
    implementation ("com.squareup.okhttp3:okhttp-bom:4.9.0")
    implementation ("com.squareup.okhttp3:okhttp:")
    implementation ("com.squareup.okhttp3:logging-interceptor")
}