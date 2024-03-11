plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.wallace.ticketmaster"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.wallace.ticketmaster"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
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
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
    }

    packaging {
        resources.excludes.add("META-INF/AL2.0")
        resources.excludes.add("META-INF/LGPL2.1")
        resources.excludes.add("META-INF/LICENSE.md")
        resources.excludes.add("META-INF/LICENSE")
        resources.excludes.add("META-INF/LICENSE.txt")
        resources.excludes.add("META-INF/LICENSE-notice.md")
        resources.excludes.add("META-INF/license.txt")
        resources.excludes.add("META-INF/NOTICE")
        resources.excludes.add("META-INF/NOTICE.md")
        resources.excludes.add("META-INF/notice.txt")
        resources.excludes.add("META-INF/ASL2.0")
        resources.excludes.add("META-INF/*.kotlin_module")
    }
}

dependencies {
    val activityComposeVersion = "1.8.2"
    val androidxCoreVersion = "1.12.0"
    val appCompatVersion = "1.6.1"
    val coilComposeVersion = "2.6.0"
    val composeVersion = "1.6.3"
    val coroutinesVersion = "1.7.3"
    val coroutinesTestVersion = "1.7.3"
    val constraintLayoutVersion = "2.1.4"
    val dataStoreVersion = "1.0.0"
    val gsonVersion = "2.9.0"
    val junitVersion= "4.13.2"
    val koinVersion = "3.5.3"
    val kotlinTestVersion = "1.9.21"
    val loggingInterceptorVersion = "4.10.0"
    val materialVersion = "1.11.0"
    val mockkVersion = "1.13.10"
    val mockkImplementationVersion = "1.13.10"
    val retrofitVersion = "2.9.0"

    //  Coil Compose
    implementation("io.coil-kt:coil-compose:${coilComposeVersion}")

    //  Compose
    implementation("androidx.activity:activity-compose:${activityComposeVersion}")
    implementation("androidx.compose.foundation:foundation:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")

    //  Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${coroutinesVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${coroutinesVersion}")

    // DataStore
    implementation("androidx.datastore:datastore-preferences:${dataStoreVersion}")
    implementation("androidx.datastore:datastore-core:${dataStoreVersion}")

    //  Google Libraries
    implementation("androidx.appcompat:appcompat:${appCompatVersion}")
    implementation("androidx.constraintlayout:constraintlayout:${constraintLayoutVersion}")
    implementation("androidx.core:core-ktx:${androidxCoreVersion}")
    implementation("com.google.android.material:material:${materialVersion}")

    //  Gson
    implementation("com.squareup.retrofit2:converter-gson:${gsonVersion}")

    //  Koin
    implementation("io.insert-koin:koin-android:${koinVersion}")
    implementation("io.insert-koin:koin-androidx-compose:$koinVersion")
    implementation("io.insert-koin:koin-core:${koinVersion}")

    //  OkHttp
    implementation("com.squareup.okhttp3:logging-interceptor:$loggingInterceptorVersion")

    //  Retrofit
    implementation("com.squareup.retrofit2:retrofit:${retrofitVersion}")



    /* ========================= TESTS ========================= */
    //  Compose
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")

    //  Coroutines
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${coroutinesTestVersion}")

    //  Kotlin Test
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:${kotlinTestVersion}")

    //  MockK
    testImplementation("io.mockk:mockk:${mockkVersion}")

    //  JUnit
    testImplementation("junit:junit:${junitVersion}")
    androidTestImplementation("io.mockk:mockk-android:${mockkImplementationVersion}")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}