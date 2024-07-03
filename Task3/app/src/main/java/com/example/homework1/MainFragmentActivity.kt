package com.example.homework1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.homework1.databinding.ActivityFragmentMainBinding

class MainFragmentActivity : AppCompatActivity() {
    private var binding: ActivityFragmentMainBinding? = null

    private var controller: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        controller = (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment)
            .navController

        controller?.let { navController ->
            binding?.bottomNavigation?.setupWithNavController(navController)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}