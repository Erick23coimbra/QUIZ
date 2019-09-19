package br.edu.unicid.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Tela11 extends AppCompatActivity {
    private RadioGroup idRdgTela11;
    private RadioButton rd1Tela11, rd2Tela11, rd3Tela11, rd4Tela11;
    private Button btnResponderTela11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela11);

        idRdgTela11 = (RadioGroup) findViewById(R.id.rgbTela11);
        rd1Tela11 = (RadioButton) findViewById(R.id.rd1Tela11);
        rd2Tela11 = (RadioButton) findViewById(R.id.rd2Tela11);
        rd3Tela11 = (RadioButton) findViewById(R.id.rd3Tela11);
        rd4Tela11 = (RadioButton) findViewById(R.id.rd4Tela11);
        btnResponderTela11 = (Button) findViewById(R.id.btnResponderTela11);

        rd1Tela11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela11.setEnabled(true);
            }
        });
        rd2Tela11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela11.setEnabled(true);
            }
        });
        rd3Tela11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela11.setEnabled(true);
            }
        });
        rd4Tela11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela11.setEnabled(true);
            }
        });


        btnResponderTela11
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int aux = idRdgTela11.getCheckedRadioButtonId();
                int res = 0;
                if (aux == R.id.rd4Tela11) {
                    res = 1;
                }

                Intent it = getIntent();

                //Recuperando a informação através da chave “msg”.
                String mensagem = it.getStringExtra("resposta");
                int restu = Integer.parseInt(mensagem)+res;

                Intent itd  = new Intent(Tela11.this, TelaRanking.class);
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
        Intent it  = new Intent(Tela11.this,MainActivity.class);
        startActivity(it);
    }
}
