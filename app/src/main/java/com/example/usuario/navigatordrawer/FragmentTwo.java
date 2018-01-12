package com.example.usuario.navigatordrawer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentTwo extends Fragment {
    public static String TAG = "FragmentTwo";
    private OnFragmentTwoListener mListener;

    public FragmentTwo() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view =  inflater.inflate(R.layout.fragment_fragment_two, container, false);

        return  view;
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnFragmentTwoListener) {
            mListener = (OnFragmentTwoListener) activity;
        } else {
            throw new RuntimeException(activity.toString()
                    + " must implement OnFragmentTwoListener");
        }
    }



    public interface OnFragmentTwoListener {

    }


}
