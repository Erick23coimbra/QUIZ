package br.edu.unicid.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Tela6 extends AppCompatActivity {

    private RadioGroup idRdgTela06;
    private RadioButton rd1Tela06, rd2Tela06, rd3Tela06, rd4Tela06;
    private Button btnResponderTela06;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela6);


        idRdgTela06 = (RadioGroup) findViewById(R.id.rgbTela06);
        rd1Tela06 = (RadioButton) findViewById(R.id.rd1Tela06);
        rd2Tela06 = (RadioButton) findViewById(R.id.rd2Tela06);
        rd3Tela06 = (RadioButton) findViewById(R.id.rd3Tela06);
        rd4Tela06 = (RadioButton) findViewById(R.id.rd4Tela06);
        btnResponderTela06 = (Button) findViewById(R.id.btnResponderTela06);

        rd1Tela06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela06.setEnabled(true);
            }
        });
        rd2Tela06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela06.setEnabled(true);
            }
        });
        rd3Tela06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela06.setEnabled(true);
            }
        });
        rd4Tela06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela06.setEnabled(true);
            }
        });

        btnResponderTela06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int aux = idRdgTela06.getCheckedRadioButtonId();
                int res = 0;
                if (aux == R.id.rd3Tela06) {
                    res = 1;
                }

                Intent it = getIntent();

                //Recuperando a informação através da chave “msg”.
                String mensagem = it.getStringExtra("resposta");
                int restu = Integer.parseInt(mensagem)+res;

                Intent itd  = new Intent(Tela6.this, Tela7.class);
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
        Intent it  = new Intent(Tela6.this,MainActivity.class);
        startActivity(it);
    }
}
