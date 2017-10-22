package app.mellowso.thakorn.myeasyservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import app.mellowso.thakorn.myeasyservice.R;

/**
 * Created by Thakorn on 10/21/2017.
 */

public class MainFragment extends Fragment{

//   การสร้าง method หลัก

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


//      button controller
        buttonController();


    } //main method

    private void buttonController() {

        // Initial View
        Button button = getView().findViewById(R.id.btnYes2ndPage);

        // Get Even from Click

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // go to SecondFragment
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentgfragmentmain, new SecondFragment())
                        .addToBackStack(null).commit();

            }  // ON CLICK
        });



    }


//    การสร้างหน้ากาก

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frafment_main,container,false);
        return view;
    }
}   // new class
