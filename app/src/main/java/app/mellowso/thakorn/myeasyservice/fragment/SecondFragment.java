package app.mellowso.thakorn.myeasyservice.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import app.mellowso.thakorn.myeasyservice.R;

/**
 * Created by Thakorn on 10/22/2017.
 */


public class SecondFragment extends Fragment{
    private ImageView imageView;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Back CONTROLLER
        backCONTROLLER();

        //Image controller
        imageController();

    }// main method

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode,
                                 Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK) {

            try {
                Uri uri = data.getData();
                Bitmap bitmap = BitmapFactory
                        .decodeStream(getActivity().getContentResolver().openInputStream(uri));

                imageView.setImageBitmap(bitmap);

            } catch (Exception e) {
                e.printStackTrace();
                getActivity();

            }

        } else {
            Toast.makeText(getActivity(),"Why not Select Image", Toast.LENGTH_SHORT).show();

        }

    }

    private void imageController() {
        imageView = getView().findViewById(R.id.imvMellow);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent,"Please Select Ja"),1);
            }
        });
    }

    private void backCONTROLLER() {
        Button button = getView().findViewById(R.id.btnBackward);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

    }
//


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        return view;
    }
}// main class
