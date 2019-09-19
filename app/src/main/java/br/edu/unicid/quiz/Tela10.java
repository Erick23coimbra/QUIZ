package br.edu.unicid.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Tela10 extends AppCompatActivity {

    private RadioGroup idRdgTela10;
    private RadioButton rd1Tela10, rd2Tela10, rd3Tela10, rd4Tela10;
    private Button btnResponderTela10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela10);

        idRdgTela10 = (RadioGroup) findViewById(R.id.rgbTela10);
        rd1Tela10 = (RadioButton) findViewById(R.id.rd1Tela10);
        rd2Tela10 = (RadioButton) findViewById(R.id.rd2Tela10);
        rd3Tela10 = (RadioButton) findViewById(R.id.rd3Tela10);
        rd4Tela10 = (RadioButton) findViewById(R.id.rd4Tela10);
        btnResponderTela10 = (Button) findViewById(R.id.btnResponderTela10);

        rd1Tela10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela10.setEnabled(true);
            }
        });
        rd2Tela10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela10.setEnabled(true);
            }
        });
        rd3Tela10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela10.setEnabled(true);
            }
        });
        rd4Tela10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnResponderTela10.setEnabled(true);
            }
        });

        btnResponderTela10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int aux = idRdgTela10.getCheckedRadioButtonId();
                int res = 0;
                if (aux == R.id.rd1Tela10) {
                    res = 1;
                }

                Intent it = getIntent();

                //Recuperando a informação através da chave “msg”.
                String mensagem = it.getStringExtra("resposta");
                int restu = Integer.parseInt(mensagem)+res;

                Intent itd  = new Intent(Tela10.this, Tela11.class);
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
        Intent it  = new Intent(Tela10.this,MainActivity.class);
        startActivity(it);
    }
}
