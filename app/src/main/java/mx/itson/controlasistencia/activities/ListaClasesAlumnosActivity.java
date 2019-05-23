package mx.itson.controlasistencia.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;

import mx.itson.controlasistencia.R;
import mx.itson.controlasistencia.api.Api;
import mx.itson.controlasistencia.modelo.AlumnoClaseListAdapter;
import mx.itson.controlasistencia.modelo.MaestroListAdapter;
import mx.itson.controlasistencia.modelo.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaClasesAlumnosActivity extends AppCompatActivity {

    private ListView listViewClasesAlumno;
    private List<Clase> mProductList;
    UserService userService;
    TextView textEstado;

    int posicion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lista_clases_alumnos);
        listViewClasesAlumno = (ListView) findViewById(R.id.listview_alumno);
        userService = Api.getUserService();
        textEstado = findViewById(R.id.tv_estado);
        listViewClasesAlumno.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                IntentIntegrator integrator  = new IntentIntegrator(ListaClasesAlumnosActivity.this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);

                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
                integrator.getMoreExtras();
                posicion = position;
            }
        });


        Call call = userService.maestroClases();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                mProductList = (List<Clase>) response.body();
                Bundle extras = getIntent().getExtras();
                int idAlumno = extras.getInt("Id Alumno");
                mProductList = filterList(mProductList, idAlumno);
                listViewClasesAlumno.setAdapter(new AlumnoClaseListAdapter(getApplicationContext(), mProductList));

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {
            if(scanResult.getContents()==null){
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this, scanResult.getContents(), Toast.LENGTH_LONG).show();
                String [] r = scanResult.getContents().split(",");
                String idLista = r[2];
                int idListaO = Integer.parseInt(idLista);
                Bundle extras = getIntent().getExtras();
                int idAlumno = extras.getInt("Id Alumno");
                Call call = userService.alumnoAsistencia(idListaO, idAlumno);
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        textEstado = findViewById(R.id.tv_estado);
                        
                       ListaAsistenciaAlumno lista = (ListaAsistenciaAlumno) response.body();
                       if(lista.getId() != 0 || lista.getEstado() != "presente" ) {
                           textEstado.setText("Presente");
                           textEstado.setTextColor(getResources().getColor(R.color.colorGreen));
                       }else{
                           textEstado.setText("No presente");
                           textEstado.setTextColor(getResources().getColor(R.color.colorRed));
                       }

                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }
    //Metodo para filtrar la lista que contienen el id del maestro que inicio sesion
    public List<Clase> filterList(List<Clase> mProductList, int id_Maestro){
        List<Clase> newList = new ArrayList<>();
        int length = mProductList.size();
        for(int i=0; i<length; i++){
            int idM = mProductList.get(i).getId_maestro();
            if(idM==id_Maestro){
                int id = mProductList.get(i).getId();
                int idMaster = mProductList.get(i).getId_maestro();
                String nombre = mProductList.get(i).getNombre();
                String aula = mProductList.get(i).getAula();
                String inicio = mProductList.get(i).getHora_inicio();
                String duracion =  mProductList.get(i).getDuracion();
                String carrera = mProductList.get(i).getCarrera();
                String dias = mProductList.get(i).getDias();
                String qr = mProductList.get(i).getQr();
                Clase c = new Clase(id, idMaster, nombre, aula, inicio,duracion,carrera,dias,qr);

                newList.add(c);
            }
        }
        return newList;
    }



}
