package com.readapp.readapp.screens

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.readapp.common.installAppList
import com.readapp.readapp.Model.AppData

@Composable
fun HomeScreen() {
    val context = LocalContext.current

//    val myAppsToUpdate: List<AppData> = emptyList()

    var myAppsToUpdate = mutableListOf<AppData>()
    val pm: PackageManager = context.packageManager
    var installedApps = installAppList(context)


    for (aInfo in installedApps) {
        if (aInfo.flags and ApplicationInfo.FLAG_SYSTEM != 0) {
            // System apps
        } else {
            // Users apps
//            Log.d("dataxx", "app name: ${aInfo.loadLabel(pm)}")
           /* try {
                myAppsToUpdate.add(AppData(aInfo.loadLabel(pm).toString(), aInfo.packageName))
            } catch (e: Exception) {
                Log.e("ERROR", "we could not get the user's apps")
            }*/
        }

        try {
            myAppsToUpdate.add(AppData(aInfo.loadLabel(pm).toString(), aInfo.packageName))
        } catch (e: Exception) {
            Log.e("ERROR", "we could not get the user's apps")
        }


    }


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row() {
                Text(text = "Total Installed Apps:: ")
                Text(text = installAppList(context).size.toString())
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(myAppsToUpdate) { app ->
                    ItemCompose(app.name, app.packageName)
                }
            }
        }
    }

}


@Composable
fun ItemCompose(appName: String, appPackageName: String) {
    Card(backgroundColor = Color.LightGray, modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(
                text = appName,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )

            Text(
                text = appPackageName,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewHomeScreen() {
    HomeScreen()
}