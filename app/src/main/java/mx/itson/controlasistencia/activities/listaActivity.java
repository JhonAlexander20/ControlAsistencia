package mx.itson.controlasistencia.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mx.itson.controlasistencia.R;

public class listaActivity extends AppCompatActivity {

    TextView txtUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        txtUsuario = (TextView)findViewById(R.id.txtUsuario);
        Bundle extras = getIntent().getExtras();
        String usuario;

        if(extras!= null){
            usuario = extras.getString("usuario");
            txtUsuario.setText(usuario);
        }
    }
}
