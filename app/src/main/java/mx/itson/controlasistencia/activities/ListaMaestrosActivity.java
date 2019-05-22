package mx.itson.controlasistencia.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

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

        Call call = userService.maestroClases();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                mProductList = (List<Clase>) response.body();
                listViewClases.setAdapter(new MaestroListAdapter(getApplicationContext(), mProductList));
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
