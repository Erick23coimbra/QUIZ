package br.edu.unicid.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Tela4 extends AppCompatActivity {
    private RadioGroup idRdgTela04;
    private RadioButton rd1Tela04, rd2Tela04, rd3Tela04, rd4Tela04;
    private Button btnResponderTela04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela4);

        idRdgTela04 = (RadioGroup) findViewById(R.id.rgbTela04);
        rd1Tela04 = (RadioButton) findViewById(R.id.rd1Tela04);
        rd2Tela04 = (RadioButton) findViewById(R.id.rd2Tela04);
        rd3Tela04 = (RadioButton) findViewById(R.id.rd3Tela04);
        rd4Tela04 = (RadioButton) findViewById(R.id.rd4Tela04);
        btnResponderTela04 = (Button) findViewById(R.id.btnResponderTela04);

        rd1Tela04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela04.setEnabled(true);
            }
        });
        rd2Tela04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela04.setEnabled(true);
            }
        });
        rd3Tela04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela04.setEnabled(true);
            }
        });
        rd4Tela04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela04.setEnabled(true);
            }
        });

        btnResponderTela04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int aux = idRdgTela04.getCheckedRadioButtonId();
                int res = 0;
                if (aux == R.id.rd1Tela04) {
                    res = 1;
                }

                Intent it = getIntent();

                //Recuperando a informação através da chave “msg”.
                String mensagem = it.getStringExtra("resposta");
                int restu = Integer.parseInt(mensagem)+res;

                Intent itd  = new Intent(Tela4.this, Tela5.class);
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
        Intent it  = new Intent(Tela4.this,MainActivity.class);
        startActivity(it);
    }
}
