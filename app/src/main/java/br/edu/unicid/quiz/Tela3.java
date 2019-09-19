package br.edu.unicid.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Tela3 extends AppCompatActivity {

    private RadioGroup idRdgTela03;
    private RadioButton rd1Tela03, rd2Tela03, rd3Tela03, rd4Tela03;
    private Button btnResponderTela03,btnTesteTela03;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);
        idRdgTela03 = (RadioGroup) findViewById(R.id.RgbTela03);
        rd1Tela03 = (RadioButton) findViewById(R.id.rd1Tela03);
        rd2Tela03 = (RadioButton) findViewById(R.id.rd2Tela03);
        rd3Tela03 = (RadioButton) findViewById(R.id.rd3Tela03);
        rd4Tela03 = (RadioButton) findViewById(R.id.rd4Tela03);
        btnResponderTela03 = (Button) findViewById(R.id.btnResponderTela03);

        rd1Tela03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela03.setEnabled(true);
            }
        });
        rd2Tela03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela03.setEnabled(true);
            }
        });
        rd3Tela03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela03.setEnabled(true);
            }
        });
        rd4Tela03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela03.setEnabled(true);
            }
        });


        btnResponderTela03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int aux = idRdgTela03.getCheckedRadioButtonId();
                int res = 0;
                if (aux == R.id.rd3Tela03) {
                    res = 1;
                }

                Intent it = getIntent();

                //Recuperando a informação através da chave “msg”.
                String mensagem = it.getStringExtra("resposta");
                int restu = Integer.parseInt(mensagem)+res;

                Intent itd  = new Intent(Tela3.this, Tela4.class);
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
        Intent it  = new Intent(Tela3.this,MainActivity.class);
        startActivity(it);
    }
}
