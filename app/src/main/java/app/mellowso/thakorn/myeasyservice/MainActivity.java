package app.mellowso.thakorn.myeasyservice;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import app.mellowso.thakorn.myeasyservice.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {
private DrawerLayout drawerLayout;


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


  } // main class

    private void textCONTROLLER() {
        TextView maintextview = (TextView) findViewById(R.id.txtMainFragment);
        TextView secondtextview = (TextView) findViewById(R.id.txtSecondFragment);
        TextView exittextview = (TextView) findViewById(R.id.txtExit);

        // For MAIN FRAGMENT

        maintextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();

            }
        });


        // FOR SECOND FRANGMENT
        secondtextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();

            }
        });


        // FOR EXIT
        exittextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();

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
