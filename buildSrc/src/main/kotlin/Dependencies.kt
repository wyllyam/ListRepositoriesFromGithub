import org.gradle.api.JavaVersion

object ApplicationId {
    val id = "com.wyllyam.githubrepositories"
}

object Config {
    const val minSdk = 21
    const val compileSdk = 30
    const val targetSdk = 30

    const val appName = "Github Repositories"
    const val appVersionName = "1.0"
    const val appVersionCode = 1

    val javaVersion = JavaVersion.VERSION_1_8
}

object Versions {
    val kotlin = "1.4.10"
    val gradle = "4.0.1"
    val appCompat = "1.1.0"
    val constraintLayout = "1.1.3"
    val coroutines = "1.3.3"
    val koin = "2.2.1"
    val lifecycle = "2.2.0"
    val recyclerview = "1.1.0"
    val material = "1.1.0"
    val paging = "3.0.0-alpha09"

    val retrofit = "2.6.2"
    val retrofitGson = "2.6.2"
    val retrofitCoroutines = "0.9.2"
    val gson = "2.8.5"
    val okHttp = "3.12.1"
    val timber = "4.7.1"

    val coil = "1.1.0"

    val junit = "4.12"
    val junitExt = "1.1.1"
    val espresso = "3.2.0"

    val mockk = "1.10.0"
    val androidXTesting = "2.1.0"
}

object Android {
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    val material = "com.google.android.material:material:${Versions.material}"
    val cardView = "com.google.android.material:material:${Versions.material}"
    val swipeToRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.material}"
    val paging = "androidx.paging:paging-runtime:${Versions.paging}"
}

object Kotlin {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val kotlinCoroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
}

object AndroidTest {
    val junit = "junit:junit:${Versions.junit}"
    val junitExt= "androidx.test.ext:junit:${Versions.junitExt}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    val mockk_core = "io.mockk:mockk:${Versions.mockk}"
    val koinTest = "org.koin:koin-test:${Versions.koin}"
    val androidXTesting = "androidx.arch.core:core-testing:${Versions.androidXTesting}"
}

object Koin {
    val koin = "org.koin:koin-android:${Versions.koin}"
    val koinScope = "org.koin:koin-androidx-scope:${Versions.koin}"
    val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
}

object Retrofit {
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitCoroutineAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutines}"
}

object Gson {
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}"
}

object OkHttp {
    val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
}

object Timber {
    val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}

object Coil {
    val coil = "io.coil-kt:coil:${Versions.coil}"
}