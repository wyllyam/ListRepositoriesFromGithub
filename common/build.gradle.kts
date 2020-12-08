plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.1")

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Koin.koin)
    implementation(Kotlin.kotlinCoroutineCore)

    api(Android.lifecycleViewModel)
    api(Android.lifecycleExtensions)
}