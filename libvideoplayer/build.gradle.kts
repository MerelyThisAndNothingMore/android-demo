@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.application)
    alias(libs.plugins.kotlin)
    id("kotlin-kapt")
}

apply(from = "../base_lib.gradle")


android {
    namespace = "com.example.libvideoplayer"
    resourcePrefix = "libplayer_"
}

dependencies {

    implementation(project(path = ":lib_common"))
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.swiperefreshlayout)
}