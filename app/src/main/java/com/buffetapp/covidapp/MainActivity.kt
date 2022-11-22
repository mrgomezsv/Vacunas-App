package com.buffetapp.covidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toolbar: ActionBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = supportActionBar!!
        val bottomNavigation:BottomNavigationView = findViewById(R.id.bottom_nav)

        bottomNavigation.setOnItemSelectedListener {
                item ->
            when(item.itemId){
                R.id.home->{
                    toolbar.title = "Home"
                    val homeFragment = Home.newInstance()
                    changeFragment(homeFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.perfil->{
                    toolbar.title = "Perfil"
                    val profileFragment = Profile.newInstance()
                    changeFragment(profileFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.settings->{
                    toolbar.title = "Settings"
                    val settingsFragment = Settings.newInstance()
                    changeFragment(settingsFragment)
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
        //Mostrar por defecto el fragment que definido a continuación
        toolbar.title = "Home"
        val home = Home.newInstance()
        changeFragment(home)
    }

    private fun changeFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
}