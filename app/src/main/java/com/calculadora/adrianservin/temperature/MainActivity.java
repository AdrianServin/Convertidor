package com.calculadora.adrianservin.temperature;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    EditText input;
    Button bntConver;
    RadioButton ce,fa;
    RadioGroup group;
    TextView lblResult;
    double result,aux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.txtinput);
        bntConver = (Button) findViewById(R.id.btnConver);
        ce = (RadioButton) findViewById(R.id.rdoCent);
        fa = (RadioButton) findViewById(R.id.rdoFahr);
        group = (RadioGroup) findViewById(R.id.grupo);
        lblResult = (TextView) findViewById(R.id.lblResult);
        group.check(R.id.rdoCent);


        bntConver.setOnClickListener(new RadioGroup.OnClickListener() {
            public void onClick(View v) {
                if((String.valueOf(input.getText())).equals("")){ }else{
                    int Select=group.getCheckedRadioButtonId();
                    if(Select==2131296323){

                        aux=Double.parseDouble(String.valueOf(input.getText()));
                        result= (aux - 32) / 1.8;
                        lblResult.setText("Resultado: "+result+" °C");

                    }else if(Select==2131296324){

                        aux=Double.parseDouble(String.valueOf(input.getText()));
                        result= (aux * 1.8) + 32;
                        lblResult.setText("Resultado: "+result+" °F");
                    }
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
