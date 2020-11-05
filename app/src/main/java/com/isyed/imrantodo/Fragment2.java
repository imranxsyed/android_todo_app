package com.isyed.imrantodo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    public static final String F_NAME = "F_NAME";
    public static Fragment2 newInstance(String input){
        Fragment2 fragment = new Fragment2();
        Bundle bundle = new Bundle();
        bundle.putString(F_NAME,input);

        fragment.setArguments(bundle);

        return fragment;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttachFragment(@NonNull Fragment childFragment) {
        super.onAttachFragment(childFragment);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_2,container, false);

        TextView displayData = view.findViewById(R.id.tv_fragment_2);
        String name = getArguments().getString(F_NAME);
        displayData.setText(name);

        return view;

    }
}
