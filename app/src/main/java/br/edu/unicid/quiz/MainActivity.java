package br.edu.unicid.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtNome;
    private TextView txtNomeRecebido, txtRGMRecebido;
    private Button btnIniciar, btnSair, btnArquivo;
    private ImageView ftFoto;
    private final int PERMISSION_REQUEST = 2;
    private final int GALERIA_IMAGENS =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PERMISSION_REQUEST);
            }
        }


        txtNome = (EditText) findViewById(R.id.txtNome);

        txtNomeRecebido = (TextView) findViewById(R.id.txtNomeRecebido);
        txtRGMRecebido = (TextView) findViewById(R.id.txtRGMRecebido);
        btnArquivo = (Button) findViewById(R.id.btnArquivo);
        btnIniciar = (Button) findViewById(R.id.btnIniciar);
        btnSair = (Button) findViewById(R.id.btnSair);
        ftFoto = (ImageView) findViewById(R.id.ftFoto);
        txtNome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String nome = txtNome.getText().toString().trim().toUpperCase();
                btnIniciar.setEnabled(!nome.isEmpty());
               // btnIniciar.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        txtNomeRecebido.setText(String.valueOf("Nome: Alecio e Caio " ));
        txtRGMRecebido.setText(String.valueOf("RGM: 19950039/20133201" ));
        btnArquivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(intent, GALERIA_IMAGENS);
            }
        });
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();


            }
        });

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = txtNome.getText().toString();

                if(nome.length()==0) {

                }else{
                    nome = txtNome.getText().toString();


                    txtNomeRecebido.setText(String.valueOf("Nome: Vinicius Souza  "));
                    txtRGMRecebido.setText(String.valueOf("RGM: 19841451"));


                    Intent it = new Intent(MainActivity.this, Tela2.class);
                    it.putExtra("nome", nome);
                    startActivity(it);
                }

                finish();





            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == GALERIA_IMAGENS) {
            Uri selectedImage = data.getData();
            String[] filePath = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePath[0]);
            String picturePath = c.getString(columnIndex);
            c.close();
            Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
            ftFoto.setImageBitmap(thumbnail);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
// A permissão foi concedida. Pode continuar
            } else {
// A permissão foi negada. Precisa ver o que deve ser desabilitado
            }
            return;
        }
    }
}