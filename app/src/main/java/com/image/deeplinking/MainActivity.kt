package com.image.deeplinking

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import com.image.deeplinking.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding:ActivityMainBinding ?= null
    private var navController: NavController? = null
    private var navHostFragment: NavHostFragment? = null
    private var graph: NavGraph? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val intent = intent.data
        println("intent-------------------->$intent")
        init()
        handleDeepLink(intent)
    }
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        println("------------------------------>1111111111111111111111111111111111111")

    }

    private fun init() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val inflater = navHostFragment?.navController?.navInflater
        graph = inflater?.inflate(R.navigation.my_nav)
        setDestination()
    }

    private fun setDestination() {
        graph?.setStartDestination( R.id.startFragment)
        navController = navHostFragment?.navController
        graph?.let { navController?.setGraph(it, intent.extras) }
    }

    private fun handleDeepLink(uri: Uri?) {
        println("------------------------------>2222222222222222222222222222222222")
        // Extract the destination key from the Uri
        val destinationKey = uri?.lastPathSegment
        println("Destination Key: $destinationKey")

        if (!destinationKey.isNullOrEmpty()) {
            println("------------------------------>3333333333333333333333333333333333333")
            println("Received destination key: $destinationKey")
            when (destinationKey) {
                "product1" -> {
                    // Navigate to the deepLinkFragment
                    navController?.navigate(R.id.startFragment)
                }
                "product2" -> {
                    // Navigate to the deepLinkFragment
                    navController?.navigate(R.id.destination2Fragment)
                }
                "product" -> {
                    // Navigate to the deepLinkFragment
                    navController?.navigate(R.id.deepLinkFragment)
                }
                // Add more cases for other destinations if needed
                else -> {
                    // Handle other destination keys or log a message
                }
            }
        }
    }




}