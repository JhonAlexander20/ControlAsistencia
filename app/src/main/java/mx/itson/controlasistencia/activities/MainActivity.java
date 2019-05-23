package mx.itson.controlasistencia.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import mx.itson.controlasistencia.R;
import mx.itson.controlasistencia.api.Api;
import mx.itson.controlasistencia.modelo.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText etUsuario, etContrasena;
    ImageButton btnIniciarSesion;
    UserService userService;
    Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etContrasena = (EditText) findViewById(R.id.etContrasena);
        btnIniciarSesion = (ImageButton) findViewById(R.id.btIniciarSesion);
        userService = Api.getUserService();
        spn = (Spinner) findViewById(R.id.SpnRol);


        String[] arraySpinner = new String[] {"Alumno","Maestro"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(adapter);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = etUsuario.getText().toString();
                String contrasena = etContrasena.getText().toString();

                //validar
                if(validarInicio(usuario, contrasena)){
                    // do logi
                    String tipoUsuario = spn.getSelectedItem().toString();
                    if(tipoUsuario.equals("Alumno")){
                        doLoginAlumno(usuario,contrasena);
                    }else if(tipoUsuario.equals("Maestro")){
                        doLoginMaestro(usuario, contrasena);
                    }
                }
            }
        });

    }

    private boolean validarInicio(String usuario, String password){
        if(usuario == null || usuario.trim().length() == 0){
            Toast.makeText(this, "El telefono es requerido", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password == null || password.trim().length() == 0){
            Toast.makeText(this, "La contrasena es requerida", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    private void doLoginMaestro (final String usuario, final String contrasena){
       Call<Maestro> call = userService.maestroLogin(usuario, contrasena);
       call.enqueue(new Callback<Maestro>() {
           @Override
           public void onResponse(Call<Maestro> call, Response<Maestro> response) {
               if (response.isSuccessful()){
                   Maestro maestro = response.body();
                   if(maestro.getTelefono().equals(usuario) || maestro.getContrasena().equals(contrasena)){
                       //login
                       Intent intent = new Intent(MainActivity.this, ListaMaestrosActivity.class);
                       intent.putExtra("Id Maestro", maestro.getId());
                       startActivity(intent);
                   }else{
                       Toast.makeText(MainActivity.this, "El numero de telefono o contrasena esta incorrecto", Toast.LENGTH_SHORT).show();
                   }
               }else{
                   Toast.makeText(MainActivity.this, "Error, por favor intente de nuevo", Toast.LENGTH_SHORT).show();
               }
           }

           @Override
           public void onFailure(Call<Maestro> call, Throwable t) {

           }
       });

    }

    private void doLoginAlumno (final String usuario, final String contrasena){
        Call<Alumno> call2 = userService.alumnoLogin(usuario, contrasena);
        call2.enqueue(new Callback<Alumno>() {
            @Override
            public void onResponse(Call<Alumno> call, Response<Alumno> response) {
                if (response.isSuccessful()){
                    Alumno alumno = response.body();
                    if(alumno.getTelefono().equals(usuario) || alumno.getContrasena().equals(contrasena)){
                        //login
                        Intent intent = new Intent(MainActivity.this, ListaClasesAlumnosActivity.class);
                        intent.putExtra("Id Alumno", alumno.getId());
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "El numero de telefono o contrasena esta incorrecto", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Error, por favor intente de nuevo", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Alumno> call, Throwable t) {

            }

        });

    }
}
