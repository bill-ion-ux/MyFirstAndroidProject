package com.example.myfirstandroidproject

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import com.example.myfirstandroidproject.R.id
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController


class MainActivity2 : AppCompatActivity() {
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // enableEdgeToEdge()
        // EdgeToEdge displays windows the entire width and height by drawing behind system bars(navigation bar,status bar, caption bar)
        setContentView(R.layout.activity_main2)
        val toolbar: Toolbar = findViewById(id.TBMainAct)
        setSupportActionBar(toolbar)

        //what does insets do?
        //Insets = tell you how big those system bars are, so your UI doesn’t get overlapped
        //tells your app how much padding your layout need based on the system bars size
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//            //Applying insets to the root layout pushes everything down, including the toolbar.
//        }


    // Find the DrawerLayout view from our XML layout using its ID, 'main'.
    // A DrawerLayout is a special layout from Google that acts as the root container for our screen.
    // Its main purpose is to manage the side navigation menu (the "drawer").
    // It listens for swipe gestures from the edge of the screen to reveal the hidden

        drawerLayout = findViewById(id.main)//used for side nav
        val sideNavView: NavigationView = findViewById(id.sideNav)
        val bottomNavView: BottomNavigationView = findViewById(R.id.bottom_nav_view)


//This line finds the specific androidx . fragment . app . Fragment that is designated as the "navigation host" in your layout.
//  It uses the supportFragmentManager (the Android system component that manages all Fragments in an Activity)
//  to look for a view with the ID 'fragmentContainerView' inside your activity_main2.xml layout.
//  Since we know this container is a special NavHostFragment, we cast it using 'as NavHostFragment'
//  to get access to its navigation-specific properties.
//  Loads the graph
//  Displays the active destination
//  Manages the back stack automatically

        val navHostFragment = supportFragmentManager.findFragmentById(id.fragmentContainerView) as NavHostFragment

// Once we have the NavHostFragment (the "stage"), this line gets its associated NavController (the "stage manager").
// The NavController is the most important object for navigation. It's the "brain" that actually performs
// the fragment transactions (swapping screens), manages the back stack, and handles all navigation actions.
// We store it in our 'navController' property to use it for setting up the UI components (like the toolbar and bottom navigation).
        navController = navHostFragment.navController

        // Define top-level destinations for AppBarConfiguration so the hamburger icon appears.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                id.DestHome,
                id.DestAboutApp
            ), drawerLayout
        )
        // Add hamburger toggle
//        toggle = ActionBarDrawerToggle(
//            this, drawerLayout, toolbar,
//            R.string.navigation_drawer_open, R.string.navigation_drawer_close
//        )
//        drawerLayout.addDrawerListener(toggle)
//        toggle.syncState()

        // This is a key function that connects your app's top Toolbar/ActionBar to the NavController.
        // It automatically does two main things:
        // 1. Updates the title in the Toolbar to match the label of the current fragment.
        // 2. Displays an Up button (<-) or a hamburger icon (☰) on the Toolbar and handles their clicks.
        // It uses the 'appBarConfiguration' to know which screens are "top-level" (and should show the hamburger icon)
        // and which screens are "deeper" (and should show the Up button).
        setupActionBarWithNavController(navController, appBarConfiguration)

        // This line connects your NavigationView (the slide-out side menu) to the NavController.
        // When you tap an item in the side navigation drawer (e.g., "Home" or "About"),
        // this setup automatically tells the NavController to navigate to the destination
        // in your navigation graph that has the same ID as the menu item.
        sideNavView.setupWithNavController(navController)

        // Similarly, this connects your BottomNavigationView (the navigation bar at the bottom) to the NavController.
        // When you tap an icon in the bottom bar, this automatically triggers a navigation event
        // to the destination with the matching ID, just like the side navigation view.
        bottomNavView.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        // This line is crucial. It tells NavigationUI to try to navigate up in the navigation graph first.
        // If that's not possible (because you are on a top-level destination), it will open the navigation drawer.
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp()
    }


}