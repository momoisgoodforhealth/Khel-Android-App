package com.romp.khel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.UpdateAvailability
import com.romp.khel.Fragments.*

var tname:String? = null
var tdes:String? = null
var tdate:String? = null
var trules:String? = null
var taward:String? = null
var tconc:String? = null
var tloc:String? = null
var vname:String?=null

var ltpfutsalname:String?=null
var ltplocation:String?=null
var ltptime:String?=null
var ltpdate:String?=null
var ltppricepp:String?=null
var ltpplayerlimit:Int?=null
var ltpplayercount:Int?=null
var ltpphone:String?=null
var ltpcontact:String?=null
var ltpaddinfo:String?=null

var timeeeee1:Int?=0
var timeeeee2:Int?=0
var daateeee=MutableLiveData<String>()
var keyyy= mutableListOf<String>()
var keyy:String?=null
var positionn:Int?=null


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
   /*     val MY_REQUEST_CODE=1
        // Creates instance of the manager.
        val appUpdateManager = AppUpdateManagerFactory.create(this)

// Returns an intent object that you use to check for an update.
        val appUpdateInfoTask = appUpdateManager.appUpdateInfo

// Checks that the platform will allow the specified type of update.
        appUpdateInfoTask.addOnSuccessListener { appUpdateInfo ->
            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE) {
                // Request the update.
                appUpdateManager.startUpdateFlowForResult(
                    // Pass the intent that is returned by 'getAppUpdateInfo()'.
                    appUpdateInfo,
                    // Or 'AppUpdateType.FLEXIBLE' for flexible updates.
                    AppUpdateType.IMMEDIATE,
                    // The current activity making the update request.
                    this,
                    // Include a request code to later monitor this update request.
                    MY_REQUEST_CODE)
            }
        }   */

        val bottomNavigation : BottomNavigationView = findViewById(R.id.bottom_navigation)
        val navController=findNavController(R.id.fragment)


        bottomNavigation.setupWithNavController(navController)
            }

        }

