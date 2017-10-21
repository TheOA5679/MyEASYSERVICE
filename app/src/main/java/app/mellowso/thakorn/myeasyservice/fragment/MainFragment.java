package app.mellowso.thakorn.myeasyservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.mellowso.thakorn.myeasyservice.R;

/**
 * Created by Thakorn on 10/21/2017.
 */

public class MainFragment extends Fragment{

//    การสร้างหน้ากาก


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frafment_main,container,false);
        return view;
    }
}   // new class
