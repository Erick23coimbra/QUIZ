package br.edu.unicid.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Tela7 extends AppCompatActivity {

    private RadioGroup idRdgTela07;
    private RadioButton rd1Tela07, rd2Tela07, rd3Tela07, rd4Tela07;
    private Button btnResponderTela07;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela7);

        idRdgTela07 = (RadioGroup) findViewById(R.id.rgbTela07);
        rd1Tela07 = (RadioButton) findViewById(R.id.rd1Tela07);
        rd2Tela07 = (RadioButton) findViewById(R.id.rd2Tela07);
        rd3Tela07 = (RadioButton) findViewById(R.id.rd3Tela07);
        rd4Tela07 = (RadioButton) findViewById(R.id.rd4Tela07);
        btnResponderTela07 = (Button) findViewById(R.id.btnResponderTela07);

        rd1Tela07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela07.setEnabled(true);
            }
        });
        rd2Tela07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela07.setEnabled(true);
            }
        });
        rd3Tela07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela07.setEnabled(true);
            }
        });
        rd4Tela07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela07.setEnabled(true);
            }
        });

        btnResponderTela07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int aux = idRdgTela07.getCheckedRadioButtonId();
                int res = 0;
                if (aux == R.id.rd3Tela07) {
                    res = 1;
                }

                Intent it = getIntent();

                //Recuperando a informação através da chave “msg”.
                String mensagem = it.getStringExtra("resposta");
                int restu = Integer.parseInt(mensagem)+res;

                Intent itd  = new Intent(Tela7.this, Tela8.class);
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
        Intent it  = new Intent(Tela7.this,MainActivity.class);
        startActivity(it);
    }
}
