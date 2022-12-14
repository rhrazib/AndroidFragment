package com.razib.androidfragment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.razib.androidfragment.R;


public class SecondFragment extends Fragment {
   private TextView mName, mDob, mGender;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);

        mName = view.findViewById(R.id.nameTv);
        mDob = view.findViewById(R.id.dobTv);
        mGender = view.findViewById(R.id.genderTv);

        Bundle bundle = this.getArguments();

        String name = bundle.getString("NAME");
        String dateOfBirth = bundle.getString("DOB");
        String gender = bundle.getString("GENDER");


        mName.setText("Name: " + name);
        mDob.setText("Selected Date: " + dateOfBirth);
        mGender.setText("Gender Is: " + gender);

        return view;
    }
}