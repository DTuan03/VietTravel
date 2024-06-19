plugins {
    alias(libs.plugins.androidApplication)
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
    buildToolsVersion = "34.0.0"
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.recyclerview)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    //implementation ("com.microsoft.sqlserver:mssql-jdbc")
    implementation (libs.mssql.jdbc)
    //implementation("com.microsoft.sqlserver:mssql-jdbc:9.2.1.jre11")
    implementation(libs.sqlserver.mssql.jdbc)     //cái náy mới
   //implementation("net.sourceforge.jtds:jtds:1.3.1")
    implementation(libs.jtds)


}

