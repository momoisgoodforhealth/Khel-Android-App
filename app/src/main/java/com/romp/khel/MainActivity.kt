package com.romp.khel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
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
var ltpcontact:String?=null
var ltpaddinfo:String?=null

var timeeeee1:Int?=0
var timeeeee2:Int?=0
var keyy:String?=null


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation : BottomNavigationView = findViewById(R.id.bottom_navigation)
        val navController=findNavController(R.id.fragment)


        bottomNavigation.setupWithNavController(navController)
            }

        }

