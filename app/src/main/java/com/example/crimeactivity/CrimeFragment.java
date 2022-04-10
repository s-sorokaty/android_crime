package com.example.crimeactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;


public class CrimeFragment extends Fragment {
    private Crime mCrime; // преступление
    private EditText mTitleField; //наименование преступления
    private Button mDateButton; //дата преступления
    private CheckBox mSolvedCheckBox; // исправлено ли преступление

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =
                inflater.inflate(R.layout.fragment_crime, container, false);
        mTitleField = (EditText) v.findViewById(R.id.crime_title);
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged( CharSequence s, int start,
                                           int count, int after) {
                //Здесь намеренно оставлено пустое место
            }
            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                mCrime.setmTitle(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
                //И здесь тоже
            }
        });
        // Установка даты преступления
        mDateButton = (Button) v.findViewById(R.id.crime_date);
        67
        mDateButton.setText(mCrime.getmDate().toString());
        mDateButton.setEnabled(false);
        // Изменяется ли флажок исправленного преступления
        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setOnCheckedChangeListener(
                new CompoundBut ton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
            boolean isChecked) {
                mCrime.setmSolved(isChecked);
            }
        });
        return v;
    }
}