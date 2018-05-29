package ml.derrickabreo.footballacademy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import ml.derrickabreo.footballacademy.fragments.navgiationDrawer.BoardMembersFragment;
import ml.derrickabreo.footballacademy.fragments.navgiationDrawer.GalleryFragment;
import ml.derrickabreo.footballacademy.fragments.navgiationDrawer.HomeFragment;
import ml.derrickabreo.footballacademy.fragments.navgiationDrawer.MomentsFragment;
import ml.derrickabreo.footballacademy.fragments.navgiationDrawer.TopGoalScorersFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*This is Home Fragment which shows details about matches.
          This fragment will be a tabbed activity.
          The 3 tabs will hold details about Ongoing Upcoming and Finished matches
         */
        fragment = new HomeFragment();
        handleFragmentTransaction(fragment);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            fragment = new HomeFragment();

        } else if (id == R.id.nav_gallery) {
            fragment = new GalleryFragment();

        } else if (id == R.id.nav_members) {
            fragment = new BoardMembersFragment();

        } else if (id == R.id.nav_scorers) {
            fragment = new TopGoalScorersFragment();

        } else if (id == R.id.nav_moments) {
            fragment = new MomentsFragment();
        }

        handleFragmentTransaction(fragment);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    /*
        This method is used to handle fragment transactions
        i.e Changing the fragments appropriately from navigation drawer
     */
    private void handleFragmentTransaction(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frames, fragment);
        fragmentTransaction.commit();
    }
}
