package br.edu.unicid.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Tela9 extends AppCompatActivity {

    private RadioGroup idRdgTela09;
    private RadioButton rd1Tela09, rd2Tela09, rd3Tela09, rd4Tela09;
    private Button btnResponderTela09;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela9);

        idRdgTela09 = (RadioGroup) findViewById(R.id.rgbTela09);
        rd1Tela09 = (RadioButton) findViewById(R.id.rd1Tela09);
        rd2Tela09 = (RadioButton) findViewById(R.id.rd2Tela09);
        rd3Tela09 = (RadioButton) findViewById(R.id.rd3Tela09);
        rd4Tela09 = (RadioButton) findViewById(R.id.rd4Tela09);
        btnResponderTela09 = (Button) findViewById(R.id.btnResponderTela09);

        rd1Tela09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela09.setEnabled(true);
            }
        });
        rd2Tela09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela09.setEnabled(true);
            }
        });
        rd3Tela09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela09.setEnabled(true);
            }
        });
        rd4Tela09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela09.setEnabled(true);
            }
        });

        btnResponderTela09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int aux = idRdgTela09.getCheckedRadioButtonId();
                int res = 0;
                if (aux == R.id.rd2Tela09) {
                    res = 1;
                }

                Intent it = getIntent();

                //Recuperando a informação através da chave “msg”.
                String mensagem = it.getStringExtra("resposta");
                int restu = Integer.parseInt(mensagem)+res;

                Intent itd  = new Intent(Tela9.this, Tela10.class);
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
        Intent it  = new Intent(Tela9.this,MainActivity.class);
        startActivity(it);
    }
}
