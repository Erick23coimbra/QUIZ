package br.edu.unicid.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Tela8 extends AppCompatActivity {

    private RadioGroup idRdgTela08;
    private RadioButton rd1Tela08, rd2Tela08, rd3Tela08, rd4Tela08;
    private Button btnResponderTela08;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela8);


        idRdgTela08 = (RadioGroup) findViewById(R.id.rgbTela08);
        rd1Tela08 = (RadioButton) findViewById(R.id.rd1Tela08);
        rd2Tela08 = (RadioButton) findViewById(R.id.rd2Tela08);
        rd3Tela08 = (RadioButton) findViewById(R.id.rd3Tela08);
        rd4Tela08 = (RadioButton) findViewById(R.id.rd4Tela08);
        btnResponderTela08= (Button) findViewById(R.id.btnResponderTela08);

        rd1Tela08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela08.setEnabled(true);
            }
        });
        rd2Tela08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela08.setEnabled(true);
            }
        });
        rd3Tela08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela08.setEnabled(true);
            }
        });
        rd4Tela08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela08.setEnabled(true);
            }
        });

        btnResponderTela08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int aux = idRdgTela08.getCheckedRadioButtonId();
                int res = 0;
                if (aux == R.id.rd1Tela08) {
                    res = 1;
                }

                Intent it = getIntent();

                //Recuperando a informação através da chave “msg”.
                String mensagem = it.getStringExtra("resposta");
                int restu = Integer.parseInt(mensagem)+res;

                Intent itd  = new Intent(Tela8.this, Tela9.class);
                itd.putExtra("resposta", Integer.toString(restu));

                String nome = it.getStringExtra("nome");
                itd.putExtra("nome", nome);
                startActivity(itd);


                finish();


            }
        });
    }
    @Override
    public void onBackPressed()
    {
        Intent it  = new Intent(Tela8.this,MainActivity.class);
        startActivity(it);
    }
}
