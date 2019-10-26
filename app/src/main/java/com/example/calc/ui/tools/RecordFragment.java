package com.example.calc.ui.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.calc.R;

import java.util.Map;

public class RecordFragment extends Fragment implements View.OnClickListener {

    private ToolsViewModel toolsViewModel;
    private SharedPreferences preferencias;
    private TextView operate_see;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tools, container, false);
        Button clear = view.findViewById(R.id.btn_remove);
        clear.setOnClickListener(this);
        operate_see = view.findViewById(R.id.operations);
        preferencias = this.getActivity().getSharedPreferences(
                "operations", Context.MODE_PRIVATE);
        Map<String, ?> cad = preferencias.getAll();
        for (Map.Entry<String, ?> entry : cad.entrySet()) {
            Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());
            operate_see.append(entry.getKey() + " = " + entry.getValue().toString() + "\r\n");
        }


        return view;
    }



    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_remove) {
            preferencias = this.getActivity().getSharedPreferences(
                    "operations", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferencias.edit();
            editor.clear();
            editor.apply();
            operate_see.setText("");
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