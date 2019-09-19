package br.edu.unicid.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Tela2 extends AppCompatActivity {
    private RadioGroup idRdgTela2;
    private RadioButton rd1Tela2, rd2Tela2, rd3Tela2, rd4Tela2;
    private Button btnResponderTela2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        idRdgTela2 = (RadioGroup) findViewById(R.id.idRdgTela2);
        rd1Tela2 = (RadioButton) findViewById(R.id.rd1Tela2 );
        rd2Tela2 = (RadioButton) findViewById(R.id.rd2Tela2);
        rd3Tela2 = (RadioButton) findViewById(R.id.rd3Tela2);
        rd4Tela2 = (RadioButton) findViewById(R.id.rd4Tela2);
        btnResponderTela2 = (Button) findViewById(R.id.btnResponderTela2);


        rd1Tela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela2.setEnabled(true);
            }
        });
        rd2Tela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela2.setEnabled(true);
            }
        });
        rd3Tela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela2.setEnabled(true);
            }
        });
        rd4Tela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela2.setEnabled(true);
            }
        });


        btnResponderTela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int aux = idRdgTela2.getCheckedRadioButtonId();
                int res = 0;
                if (aux == R.id.rd4Tela2) {
                    res = 1;
                }

                Intent it  = new Intent(Tela2.this,Tela3.class);
                it.putExtra("resposta", Integer.toString(res));

                Intent intent = getIntent();
                String nome = intent.getStringExtra("nome");
                it.putExtra("nome",nome);
                startActivity(it);

                finish();


            }
        });


    }
    @Override
    public void onBackPressed()
    {
        Intent it  = new Intent(Tela2.this,MainActivity.class);
        startActivity(it);
    }
}
