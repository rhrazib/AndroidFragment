package com.example.androidfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class TwoFragment extends Fragment {
    TextView sname,sdob,sgender;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_two, container, false);

        sname=view.findViewById(R.id.sname);
        sdob=view.findViewById(R.id.sdob);
        sgender=view.findViewById(R.id.sgender);

       Bundle bundle = this.getArguments();

        String name = bundle.getString("NAME");
        String dateOfBirth = bundle.getString("DOB");
        String gender = bundle .getString("GENDER");




        sname.setText("Name: "+ name);
        sdob.setText("Selected Date: "+ dateOfBirth);
        sgender.setText("Gender Is: "+ gender);

        return view;
    }
}