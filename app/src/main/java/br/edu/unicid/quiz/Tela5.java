package br.edu.unicid.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Tela5 extends AppCompatActivity {

    private RadioGroup idRdgTela05;
    private RadioButton rd1Tela05, rd2Tela05, rd3Tela05, rd4Tela05;
    private Button btnResponderTela05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela5);


        idRdgTela05 = (RadioGroup) findViewById(R.id.rgbTela05);
        rd1Tela05 = (RadioButton) findViewById(R.id.rd1Tela05);
        rd2Tela05 = (RadioButton) findViewById(R.id.rd2Tela05);
        rd3Tela05 = (RadioButton) findViewById(R.id.rd3Tela05);
        rd4Tela05 = (RadioButton) findViewById(R.id.rd4Tela05);
        btnResponderTela05 = (Button) findViewById(R.id.btnResponderTela05);

        rd1Tela05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela05.setEnabled(true);
            }
        });
        rd2Tela05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela05.setEnabled(true);
            }
        });
        rd3Tela05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela05.setEnabled(true);
            }
        });
        rd4Tela05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela05.setEnabled(true);
            }
        });

        btnResponderTela05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int aux = idRdgTela05.getCheckedRadioButtonId();
                int res = 0;
                if (aux == R.id.rd2Tela05) {
                    res = 1;
                }

                Intent it = getIntent();

                //Recuperando a informação através da chave “msg”.
                String mensagem = it.getStringExtra("resposta");
                int restu = Integer.parseInt(mensagem)+res;

                Intent itd  = new Intent(Tela5.this, Tela6.class);
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
        Intent it  = new Intent(Tela5.this,MainActivity.class);
        startActivity(it);
    }
}
