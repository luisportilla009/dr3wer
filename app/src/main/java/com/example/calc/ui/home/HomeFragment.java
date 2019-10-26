package com.example.calc.ui.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.calc.R;
import com.fathzer.soft.javaluator.DoubleEvaluator;


public class HomeFragment extends Fragment implements View.OnClickListener{

    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bc,bce,bplus,bmin,bmul,bdiv,bpoint,beq;

    private TextView put_Into;
    private TextView put_Into_2;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        b0=view.findViewById(R.id.button_0);
        b0.setOnClickListener(this);
        b1=view.findViewById(R.id.button_1);
        b1.setOnClickListener(this);
        b2=view.findViewById(R.id.button_2);
        b2.setOnClickListener(this);
        b3=view.findViewById(R.id.button_3);
        b3.setOnClickListener(this);
        b4=view.findViewById(R.id.button_4);
        b4.setOnClickListener(this);
        b5=view.findViewById(R.id.button_5);
        b5.setOnClickListener(this);
        b6=view.findViewById(R.id.button_6);
        b6.setOnClickListener(this);
        b7=view.findViewById(R.id.button_7);
        b7.setOnClickListener(this);
        b8=view.findViewById(R.id.button_8);
        b8.setOnClickListener(this);
        b9=view.findViewById(R.id.button_9);
        b9.setOnClickListener(this);
        bc=view.findViewById(R.id.button_clear);
        bc.setOnClickListener(this);
        bce=view.findViewById(R.id.button_clear_all);
        bce.setOnClickListener(this);
        bplus=view.findViewById(R.id.button_plus);
        bplus.setOnClickListener(this);
        bmin=view.findViewById(R.id.button_minus);
        bmin.setOnClickListener(this);
        bmul=view.findViewById(R.id.button_mul);
        bmul.setOnClickListener(this);
        bdiv=view.findViewById(R.id.button_div);
        bdiv.setOnClickListener(this);
        bpoint=view.findViewById(R.id.button_point);
        bpoint.setOnClickListener(this);
        beq=view.findViewById(R.id.button_equal);
        beq.setOnClickListener(this);
        put_Into = view.findViewById(R.id.chain);
        put_Into_2 = view.findViewById(R.id.chain_2);
        return view;
    }

    @Override
    public void onClick(View v) {
        String total = put_Into.getText().toString();
        String subtotal = put_Into_2.getText().toString();
        DoubleEvaluator evaluator = new DoubleEvaluator();
        switch (v.getId()){
            case R.id.button_0:
                total = total + '0';
                //DoubleEvaluator evaluator = new DoubleEvaluator();
                if(compare(total)) subtotal = evaluator.evaluate(total).toString();

                break;
            case R.id.button_1:
                total = total + '1';
                //DoubleEvaluator evaluator = new DoubleEvaluator();
                if(compare(total)) subtotal = evaluator.evaluate(total).toString();
                break;
            case R.id.button_2:
                total = total + '2';
                if(compare(total)) subtotal = evaluator.evaluate(total).toString();
                break;
            case R.id.button_3:
                total = total + '3';
                if(compare(total)) subtotal = evaluator.evaluate(total).toString();
                break;
            case R.id.button_4:
                total = total + '4';
                if(compare(total)) subtotal = evaluator.evaluate(total).toString();
                break;
            case R.id.button_5:
                total = total + '5';
                if(compare(total)) subtotal = evaluator.evaluate(total).toString();
                break;
            case R.id.button_6:
                total = total + '6';
                if(compare(total)) subtotal = evaluator.evaluate(total).toString();
                break;
            case R.id.button_7:
                total = total + '7';
                if(compare(total)) subtotal = evaluator.evaluate(total).toString();
                break;
            case R.id.button_8:
                total = total + '8';
                if(compare(total)) subtotal = evaluator.evaluate(total).toString();
                break;
            case R.id.button_9:
                total = total + '9';
                if(compare(total)) subtotal = evaluator.evaluate(total).toString();
                break;
            case R.id.button_div:
                if(compare(total)) {
                    total = total + '/';
                    bpoint.setEnabled(true);
                }
                break;
            case R.id.button_mul:
                if(compare(total)) {
                    total = total + '*';
                    bpoint.setEnabled(true);
                }
                break;
            case R.id.button_minus:
                if(total.length() == 0) {
                    total = total + '-';
                    break;
                }
                if(compare2(total)) {
                    total = total + '-';
                    bpoint.setEnabled(true);
                }
                break;
            case R.id.button_plus:
                if(compare(total)) {
                    total = total + '+';
                    bpoint.setEnabled(true);
                }
                break;
            case R.id.button_point:
                if(compare(total)) {
                    total = total + '.';
                    bpoint.setEnabled(false);
                }

                break;
            case R.id.button_equal:
                //if(compare(total)) total = String.valueOf(eval(total));
                if(compare(total)) {
                    //DoubleEvaluator evaluator = new DoubleEvaluator();
                    subtotal = "";
                    String operation = total;
                    total = evaluator.evaluate(total).toString();
                    bpoint.setEnabled(false);
                    //operation = operation + " = " + total + "\r\n";
                    //operation = operation + 1;
                    SharedPreferences preferencias =
                            this.getActivity().getSharedPreferences("operations",
                                    Context.MODE_PRIVATE);
                    SharedPreferences.Editor obj_editor = preferencias.edit();
                    obj_editor.putString(operation,total);
                    obj_editor.apply();

                }
                break;
            /*case R.id.button_about:
                Intent about = new Intent(this,AboutActivity.class);
                startActivity(about);
                break;*/
            case R.id.button_clear:
                if(total.length() != 0) total = total.substring(0, total.length() - 1);
                if(compare(total)) subtotal = evaluator.evaluate(total).toString();
                bpoint.setEnabled(true);
                break;
            case R.id.button_clear_all:
                while (total.length() != 0) total = total.substring(0, total.length() - 1);
                bpoint.setEnabled(true);
                break;
            /*case R.id.button_par0:
                if(!compare(total)){
                    count_Par ++;
                    total = total + '(';
                    v.findViewById(R.id.button_point).setEnabled(true);
                }
                break;
            case R.id.button_par1:
                if(compare(total) && count_Par > 0){
                    count_Par --;
                    total = total + ')';
                    v.findViewById(R.id.button_point).setEnabled(true);
                }
                break;
            case R.id.button_p:
                total = total + '^';
                break;
            case R.id.button_sqrt:
                total = total + "sqrt";
                break;*/

        }
        if (total.equals("Infinity")) total = "";

        put_Into_2.setText(subtotal);
        if (total.equals("")) put_Into_2.setText("");
        put_Into.setText(total);

    }
    private Boolean compare(String total){
        String list_0 = "0123456789";
        int i = 1;
        if (total.length() != 0) {
            while (total.charAt(total.length() - 1) != list_0.charAt(list_0.length() - i)
                    && i != 10 ) i++;
            return total.charAt(total.length() - 1) == list_0.charAt(list_0.length() - i);

        }
        return false;
    }
    private Boolean compare2(String total){
        String list_0 = "0123456789/*()";
        int i = 1;
        if (total.length() != 0) {
            while (total.charAt(total.length() - 1) != list_0.charAt(list_0.length() - i)
                    && i != 14 ) i++;
            return total.charAt(total.length() - 1) == list_0.charAt(list_0.length() - i);

        }
        return false;
    }
}