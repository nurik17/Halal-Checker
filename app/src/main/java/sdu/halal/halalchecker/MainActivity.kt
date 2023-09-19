package sdu.halal.halalchecker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import sdu.halal.halalchecker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = binding.bottomNavigationView
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        bottomNavigationView.setupWithNavController(navController)


        navController.addOnDestinationChangedListener{_,destination, _ ->
            if(destination.id == R.id.homeFragment || destination.id == R.id.archiveFragment || destination.id == R.id.scannerFragment){
                bottomNavigationView.visibility = View.VISIBLE
            }else{
                bottomNavigationView.visibility = View.INVISIBLE
            }
        }
    }
}