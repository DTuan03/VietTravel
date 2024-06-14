plugins {
    alias(libs.plugins.androidApplication)
    id("com.google.gms.google-services")    // services của fỉrebase
}

android {
    namespace = "com.httt.viettravel"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.httt.viettravel"
        minSdk = 24
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
    sourceSets {
        getByName("main") {
            java {
                srcDirs("src/main/java", "src/main/java/Adapter")
            }
        }
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.recyclerview)
    implementation(files("jtds-1.3.1.jar")) //thu vien ho tro ket noi sql server
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("de.hdodenhof:circleimageview:3.1.0")
    implementation(platform("com.google.firebase:firebase-bom:33.1.0")) // thư viện firebase
    implementation("com.google.firebase:firebase-database") // thư viện firebase real time
    implementation ("com.google.firebase:firebase-storage") // thư viện firebase storage
    implementation ("com.squareup.picasso:picasso:2.5.2") //thu vien ho tro load hinh anh tu url
}