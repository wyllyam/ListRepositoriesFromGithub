plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.1")

    defaultConfig {
        applicationId = "com.wyllyam.githubrepositories"
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

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Android.appCompat)
    implementation(Android.material)
    implementation(Koin.koin)

    implementation(project(Modules.home))

    implementation(project(Modules.common))
    implementation(project(Modules.common_test))
    implementation(project(Modules.network))


//    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
//    implementation("androidx.core:core-ktx:1.3.2")
//    implementation("com.google.android.material:material:1.2.1")
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")

//    implementation(Koin.koinScope)
}