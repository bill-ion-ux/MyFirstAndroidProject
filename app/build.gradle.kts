plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.myfirstandroidproject"
    compileSdk {
        version = release(36)
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            merges += "META-INF/androidx.cardview_cardview.version"
        }
    }

    defaultConfig {
        applicationId = "com.example.myfirstandroidproject"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}
dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Use the modern Navigation Component libraries
    // CORRECT (stable versions)
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")


    // Use the most up-to-date Material library
    implementation("com.google.android.material:material:1.13.0")

    // This is the modern replacement for the old cardview-v7
    implementation("androidx.cardview:cardview:1.0.0")

    // The circle image view library
    implementation("de.hdodenhof:circleimageview:3.1.0")

    // AdMob library (make sure you have the meta-data tag in AndroidManifest.xml)
    implementation(libs.play.services.ads)

    // Testing libraries (no changes needed here)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
