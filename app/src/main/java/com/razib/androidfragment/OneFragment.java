package com.razib.androidfragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import java.util.Calendar;


public class OneFragment extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    Spinner spinnerGender;
    String[] gender = { "Select","Male", "Female" ,"Others"};

    DatePickerDialog picker;
    EditText dateOfBirth,sname;
    Button sendBtn;
    boolean isAllFieldsChecked = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.fragment_one);
        // Inflate the layout for this fragment
        // return

        View view = inflater.inflate(R.layout.fragment_one, container, false);

        spinnerGender = view.findViewById(R.id.spinner);
        spinnerGender.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,gender);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(aa);


        dateOfBirth=view.findViewById(R.id.dob);
        // dateOfBirth.setInputType(InputType.TYPE_NULL);
        dateOfBirth.setCursorVisible(false);
        dateOfBirth.setFocusable(false);
        dateOfBirth.setOnClickListener(this);

        dateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                dateOfBirth.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }


        });
        sendBtn=view.findViewById(R.id.save);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sname=view.findViewById(R.id.name);

                String itemText = (String) spinnerGender.getSelectedItem();

                String name=sname.getText().toString();
                String dobirth=dateOfBirth.getText().toString();

                isAllFieldsChecked = CheckAllFields();


                if (isAllFieldsChecked) {


                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    Fragment twoFragment = new TwoFragment();

                    Bundle bundle = new Bundle();
                    bundle.putString("NAME",name);
                    bundle.putString("DOB",dobirth);
                    bundle.putString("GENDER",itemText);
                    twoFragment.setArguments(bundle);
                  //  getChildFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,twoFragment).commit();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, twoFragment).addToBackStack(null).commit();


                }

            }
        });

        return view;
    }

    private boolean CheckAllFields() {
        if (sname.length() == 0) {
            sname.setError("This field is required");
            return false;
        }

        if (dateOfBirth.length() == 0) {
            dateOfBirth.setError("This field is required");
            return false;
        }


        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {

    }
}


