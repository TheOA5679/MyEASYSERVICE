package app.mellowso.thakorn.myeasyservice;

import android.content.res.Configuration;
import android.graphics.drawable.RippleDrawable;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import app.mellowso.thakorn.myeasyservice.fragment.MainFragment;
import app.mellowso.thakorn.myeasyservice.fragment.SecondFragment;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // การ ADD FRAGMENT to ACTIVITY
        addFragment(savedInstanceState);

        // การ Setup DRAWER
        SetupDRAWER();

        // text CONTROLLER
        textCONTROLLER();

        // Create TOOLBAR
        createTOOLBAR();



  } // main method

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

        }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        actionBarDrawerToggle.syncState();

    }

    private void createTOOLBAR() {
        toolbar = (Toolbar) findViewById(R.id.toolbarmain1);
        setSupportActionBar(toolbar);

        actionBarDrawerToggle = new ActionBarDrawerToggle(
                MainActivity.this,
                drawerLayout,
                R.string.open,
                R.string.close

        );
       drawerLayout.setDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void textCONTROLLER() {
        TextView maintextview = (TextView) findViewById(R.id.txtMainFragment);
        TextView secondtextview = (TextView) findViewById(R.id.txtSecondFragment);
        TextView exittextview = (TextView) findViewById(R.id.txtExit);

        // For MAIN FRAGMENT

        maintextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentgfragmentmain, new MainFragment())
                        .commit();

            }
        });


        // FOR SECOND FRANGMENT
        secondtextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentgfragmentmain, new SecondFragment())
                        .commit();

            }
        });


        // FOR EXIT
        exittextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
                finish();


            }
        });
    }

    private void SetupDRAWER() {
        drawerLayout = (DrawerLayout) findViewById(R.id.myDrawerLayout);
    }

    private void addFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentgfragmentmain,new MainFragment()).commit();

        }
    }


} // main class
