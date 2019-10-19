package com.example.calc.ui.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.calc.R;

public class ToolsFragment extends Fragment implements View.OnClickListener {

    private ToolsViewModel toolsViewModel;
    private RadioButton r_seg, r_rad, r_grad;
    private SharedPreferences preferencias;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tools, container, false);

        r_seg = view.findViewById(R.id.circle_DEG);
        r_rad = view.findViewById(R.id.circle_rad);
        r_grad = view.findViewById(R.id.circle_Grad);
        Button save = view.findViewById(R.id.btn_tools);
        save.setOnClickListener(this);
        preferencias = this.getActivity().getSharedPreferences("btn",Context.MODE_PRIVATE);
        if (r_seg.isChecked() == true)
        r_seg.setChecked(preferencias.getBoolean("val",r_seg.isChecked()));
        else if (r_rad.isChecked() == true)
        r_rad.setChecked(preferencias.getBoolean("val",r_rad.isChecked()));
        else if (r_grad.isChecked() == true)
        r_grad.setChecked(preferencias.getBoolean("val",r_grad.isChecked()));
        /*r_seg.setOnClickListener(this);
        r_rad.setOnClickListener(this);
        r_grad.setOnClickListener(this);
        preferencias = this.getActivity().getSharedPreferences("bntChecked", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putBoolean("bntChecked",r_seg.isChecked());*/
        return view;
    }



    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_tools){
            preferencias = this.getActivity().getSharedPreferences("btn", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferencias.edit();
            if (r_seg.isChecked() == true)
                editor.putBoolean("val",r_seg.isChecked());
            else if (r_rad.isChecked() == true)
                editor.putBoolean("val",r_rad.isChecked());
            else if (r_grad.isChecked() == true)
                editor.putBoolean("val",r_grad.isChecked());
            editor.commit();


        }
        /*preferencias = this.getActivity().getSharedPreferences("bntChecked", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_edit = preferencias.edit();
        switch (view.getId()) {
            case R.id.circle_DEG:
                preferencias.edit().putBoolean("bntChecked", r_seg.isChecked()).apply();
                obj_edit.commit();
                break;
            case R.id.circle_rad:
                preferencias.edit().putBoolean("bntChecked", r_rad.isChecked()).apply();
                obj_edit.commit();
                break;
            case R.id.circle_Grad:
                preferencias.edit().putBoolean("bntChecked", r_grad.isChecked()).apply();
                obj_edit.commit();

                break;
        }
        //preferencias = this.getActivity().getSharedPreferences("")*/
    }
}