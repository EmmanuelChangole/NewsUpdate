package com.example.newsupdate.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.newsupdate.adapter.MenuAdapter
import com.example.newsupdate.databinding.ActivityMainBinding
import com.mikepenz.materialdrawer.model.*
import com.mikepenz.materialdrawer.model.interfaces.*
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle
import java.util.*
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.utils.MDUtil.getStringArray
import com.example.newsupdate.R

import nl.psdcompany.duonavigationdrawer.views.DuoMenuView
import java.sql.Array
import kotlin.collections.ArrayList










class MainActivity : AppCompatActivity(),DuoMenuView.OnMenuClickListener {
    private final var HOME_ID=1
    private final var NEWS_ID =2
    private final var NETWORK_ID=3
    private final var CHATS_ID=4
    private lateinit var binding: ActivityMainBinding
   private lateinit var drawerLayout:DuoDrawerLayout
   private lateinit var toolbar: Toolbar
   private lateinit var menuAdapter:MenuAdapter
    private lateinit var mViewHolder:ViewHolder
    private var mTitles: ArrayList<String> = ArrayList()
    private var position:Int=0;
    private lateinit var  bottomNavigation:MeowBottomNavigation



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding= ActivityMainBinding.inflate(layoutInflater)
       val view=binding.root
       setContentView(view)
        mTitles.add("Home")
        mTitles.add("Skills")
        mTitles.add("Achievements")
        mViewHolder= ViewHolder(binding)

        setUpToolBar(savedInstanceState)
        setUpDrawer()
        menuAdapter =  MenuAdapter(mTitles);
        mViewHolder.mDuoMenuView.setOnMenuClickListener(this)
        mViewHolder.mDuoMenuView.setAdapter(menuAdapter)
        menuAdapter.setViewSelected(0, true)
        setTitle(mTitles.get(0))
        setUpFragment(HomeFragment())
        bottomNavInit(binding)


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true;

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.main_profile->{
                MaterialDialog(this).cornerRadius(20f).title(R.string.tvProfile).show{
                    customView(R.layout.update_profile)
                    maxWidth(R.dimen.max_width)

                }
            }


        }
      return super.onOptionsItemSelected(item)
    }



    private fun setUpToolBar(savedInstanceState: Bundle?)
    {
       toolbar=binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setTitle("Home")


    }

    private fun setUpDrawer()
    {
        drawerLayout=binding.root
        var drawerToggle: DuoDrawerToggle = DuoDrawerToggle(this,drawerLayout,toolbar,
            R.string.material_drawer_open,R.string.material_drawer_close)
        drawerLayout.setDrawerListener(drawerToggle)
        drawerToggle.syncState()

    }

    private fun setUpFragment(fragment:Fragment)
    {

        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.content,fragment)
        fragmentTransaction.commit()

    }

    private fun changeTitle(title:String)
    {
        supportActionBar?.setTitle(title)

    }


    private fun bottomNavInit(binding: ActivityMainBinding)
    {
        bottomNavigation = binding.bottomNavigation
        bottomNavigation.add(MeowBottomNavigation.Model(HOME_ID, R.drawable.ic_home))
        bottomNavigation.add(MeowBottomNavigation.Model(NEWS_ID, R.drawable.ic_news))
        bottomNavigation.add(MeowBottomNavigation.Model(NETWORK_ID, R.drawable.ic_network))
        bottomNavigation.add(MeowBottomNavigation.Model(CHATS_ID, R.drawable.ic_chat))
        bottomNavigation.setCount(CHATS_ID,"4")
        bottomNavigation.setOnClickMenuListener{
            when(it.id)
            {
              HOME_ID->{
                  setUpFragment(HomeFragment())
                  menuAdapter.setViewSelected(0, true);
                  setTitle(mTitles.get(0))
                  changeTitle(mTitles.get(0))
                  bottomNavigation.show(HOME_ID,false)

              }
              NEWS_ID->{setUpFragment(NewsFragment())
                  menuAdapter.unsetViewSelected(position, true)
                  changeTitle("News")

              }
              NETWORK_ID->{setUpFragment(NetworkFragment())
                  menuAdapter.unsetViewSelected(position,true)
                  changeTitle("Network")
              }
              CHATS_ID->{setUpFragment(ChatFragment())
                  menuAdapter.unsetViewSelected(position,true)
                  changeTitle("Chats")
              }

            }
        }
        bottomNavigation.setOnShowListener {

        }
        bottomNavigation.setOnReselectListener{
        }
        bottomNavigation.show(HOME_ID,true)

    }

    private class ViewHolder internal constructor(var binding:ActivityMainBinding) {
        val mDuoDrawerLayout: DuoDrawerLayout
        val mDuoMenuView: DuoMenuView
        private val mToolbar: Toolbar

        init {
            mDuoDrawerLayout = binding.root
            mDuoMenuView = mDuoDrawerLayout.menuView as DuoMenuView
            mToolbar = binding.toolbar
        }
    }

    override fun onFooterClicked() {

    }

    override fun onHeaderClicked() {

    }

    override fun onOptionClicked(position: Int, objectClicked: Any?)
    {
        setTitle(mTitles.get(position))
        changeTitle(mTitles.get(position))
        menuAdapter.setViewSelected(position, true)
        this.position=position
        when (position) {
            1-> {setUpFragment(SkillsFragment())
               bottomNavigation.visibility=View.GONE
                bottomNavigation.show(HOME_ID,true)
            }
            2->{setUpFragment(AchievementFragment())
                bottomNavigation.visibility=View.GONE
            }

            else -> {setUpFragment(HomeFragment())
                bottomNavigation.visibility=View.VISIBLE
                bottomNavigation.show(HOME_ID,false)
            }
        }

        // Close the drawer

        // Close the drawer
        mViewHolder.mDuoDrawerLayout.closeDrawer()

    }


}