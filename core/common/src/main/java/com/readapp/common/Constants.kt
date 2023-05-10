package com.readapp.common

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager


fun test(): String {
    return "tested"
}

@SuppressLint("QueryPermissionsNeeded")
fun installAppList(context: Context): MutableList<ApplicationInfo> {
    val pm: PackageManager = context.packageManager
    //var myAppsToUpdate = ArrayList<AppDa>()
    return pm.getInstalledApplications(0)
}