plugins {
    kotlin("jvm")
}
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    api("javax.inject:javax.inject:1")
    implementation(libs.coroutines.core)
}