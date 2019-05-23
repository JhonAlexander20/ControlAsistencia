package mx.itson.controlasistencia.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mx.itson.controlasistencia.R;
import mx.itson.controlasistencia.api.Api;
import mx.itson.controlasistencia.modelo.MaestroListAdapter;
import mx.itson.controlasistencia.modelo.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaMaestrosActivity extends AppCompatActivity {

    private ListView listViewClases;
    private List<Clase> mProductList;
    UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_maestros);
        listViewClases = (ListView) findViewById(R.id.listview_maestros);
        userService = Api.getUserService();

        listViewClases.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListaMaestrosActivity.this, QrGenerator.class);
                startActivity(intent);
            }
        });

        Call call = userService.maestroClases();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                mProductList = (List<Clase>) response.body();
                Bundle extras = getIntent().getExtras();
                int idMaestro = extras.getInt("Id Maestro");
                mProductList = filterList(mProductList, idMaestro);
                listViewClases.setAdapter(new MaestroListAdapter(getApplicationContext(), mProductList));
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });
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
