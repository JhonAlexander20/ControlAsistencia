package mx.itson.controlasistencia.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mx.itson.controlasistencia.R;
import mx.itson.controlasistencia.modelo.AlumnoClaseListAdapter;

public class ListaClasesAlumnosActivity extends AppCompatActivity {

    private ListView lvProduct;
    private AlumnoClaseListAdapter adapter;
    private List<Alumno> mProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_clases_alumnos);

        lvProduct = (ListView)findViewById(R.id.listview_product);

        mProductList = new ArrayList<>();
        //Add sample data for list
        //We can get data from DB, webservice here
        mProductList.add(new Alumno(1, "iPhone4", 200, "Apple iPhone4 16GB"));
        mProductList.add(new Alumno(3, "iPhone4S", 250, "Apple iPhone4S 16GB"));
        mProductList.add(new Alumno(4, "iPhone5", 300, "Apple iPhone5 16GB"));
        mProductList.add(new Alumno(5, "iPhone5S", 350, "Apple iPhone5S 16GB"));
        mProductList.add(new Alumno(6, "iPhone6", 400, "Apple iPhone6 16GB"));
        mProductList.add(new Alumno(7, "iPhone6S", 450, "Apple iPhone6S 16GB"));
        mProductList.add(new Alumno(8, "iPhone7", 500, "Apple iPhone7 16GB"));
        mProductList.add(new Alumno(9, "iPhone7S", 600, "Apple iPhon7S 16GB"));
        mProductList.add(new Alumno(10, "iPhone8", 700, "Apple iPhone8 16GB"));
        mProductList.add(new Alumno(11, "iPhone8S", 800, "Apple iPhone8S 16GB"));

        //Init adapter
        adapter = new AlumnoClaseListAdapter(getApplicationContext(), mProductList);
        lvProduct.setAdapter(adapter);

        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Do something
                //Ex: display msg with product id get from view.getTag
                Toast.makeText(getApplicationContext(), "Clicked product id =" + view.getTag(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    }
