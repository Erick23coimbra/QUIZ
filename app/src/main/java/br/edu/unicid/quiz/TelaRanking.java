package br.edu.unicid.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class TelaRanking extends AppCompatActivity {
    private TextView txtRanking,txtResposta;
    private Button btnResponderNovamente,btnTelaPrincipal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tela_ranking);
        btnResponderNovamente = (Button) findViewById(R.id.btnResponderNovamente);
        btnTelaPrincipal = (Button) findViewById(R.id.btnTelaPrincipal);
        txtRanking = (TextView)findViewById(R.id.txtRanking);
        txtResposta = (TextView)findViewById(R.id.txtResposta);
        //Obtendo o objeto Intent enviado da tela Principal.
        Intent it = getIntent();

        String nome = it.getStringExtra("nome");
        //Recuperando a informação através da chave “msg”.
        String mensagem = it.getStringExtra("resposta");
        //Ranking Rank = new Ranking("oi","oi");
        txtResposta.setText(String.valueOf(mensagem));
        txtRanking.setText(String.valueOf(nome));


        btnResponderNovamente .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itd = getIntent();
                Intent it = new Intent(TelaRanking.this, Tela2.class);
                String nome = itd.getStringExtra("nome");
                it.putExtra("nome", nome);

                startActivity(it);
                finish();
            }
        });

        btnTelaPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(TelaRanking.this, MainActivity.class);
                startActivity(it);
                finish();
            }
        });


    }


}


