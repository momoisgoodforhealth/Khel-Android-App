package com.example.romp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var homeFragment:HomeFragment
    lateinit var exploreFragment: ExploreFragment
    lateinit var settingFragment: SettingFragment
    lateinit var myteam: Myteam


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation : BottomNavigationView = findViewById(R.id.bottom_navigation)


        // this the default frag that will open

        homeFragment = HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()


        bottomNavigation.setOnNavigationItemSelectedListener { item ->

            when(item.itemId){

                R.id.nav_home -> {
                    homeFragment = HomeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container,homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.settings -> {
                    settingFragment = SettingFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container,settingFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.nav_explore -> {
                    exploreFragment = ExploreFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container,exploreFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.my_team -> {
                    myteam = Myteam()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container,myteam)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }





            }

            true


            }

        }

    }
