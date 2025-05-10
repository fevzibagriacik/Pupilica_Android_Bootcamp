// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        // Safe Args plugin (Uygun sürüm)
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.7")

        // Hilt plugin
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.48")
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}
