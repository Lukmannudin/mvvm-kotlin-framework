package radhika.yusuf.id.mvvmkotlin.mvvm.home;

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import radhika.yusuf.id.mvvmkotlin.R
import radhika.yusuf.id.mvvmkotlin.mvvm.home.empty.EmptyFragment
import radhika.yusuf.id.mvvmkotlin.utils.extension.replaceFragmentInActivity

class HomeActivity : AppCompatActivity(), HomeNavigator {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupFragment()
        setupBottomNav()
    }

    private fun setupBottomNav() {
        bn_main.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home_menu -> loadFragment(HomeFragment())
                R.id.empty_menu -> loadFragment(EmptyFragment())
            }
            true
        }
    }

    private fun setupFragment() {
        supportFragmentManager.findFragmentById(R.id.frame_main_content)
        HomeFragment.newInstance().let {
            replaceFragmentInActivity(it, R.id.frame_main_content)
        }
    }

    private fun loadFragment(fragment: Fragment) {
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.frame_main_content, fragment)
            .commit();
    }

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, HomeActivity::class.java))
        }
    }
}
