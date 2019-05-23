package mx.itson.controlasistencia.modelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import mx.itson.controlasistencia.R;
import mx.itson.controlasistencia.activities.Alumno;
import mx.itson.controlasistencia.activities.Clase;
import mx.itson.controlasistencia.activities.Maestro;

public class MaestroListAdapter extends ArrayAdapter<Clase> {

    private Context mContext;
    private List<Clase> mProductList;

    //Constructor

    public MaestroListAdapter(Context mContext, List<Clase> mProductList) {
        super(mContext, R.layout.item_maestro_list, mProductList);
        this.mContext = mContext;
        this.mProductList = mProductList;
    }

    /*@Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /** Modificar variables para el caso del listado de maestro, primeramente teniendolas en la clase
         * entidades Maestro**/

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(R.layout.item_maestro_list, parent, false);


        Clase clase = mProductList.get(position);

        TextView tv_name_maestro = (TextView)convertView.findViewById(R.id.tv_name_clase);
        TextView tv_aula = (TextView)convertView.findViewById(R.id.tv_aula);
        TextView tv_hora_inicio = (TextView)convertView.findViewById(R.id.tv_hora_inicio);
        TextView tv_duracion = (TextView)convertView.findViewById(R.id.tv_duracion);
        TextView tv_carrera = (TextView)convertView.findViewById(R.id.tv_carrera);
        TextView tv_dias = (TextView)convertView.findViewById(R.id.tv_dias);
        //Set text for TextView
        tv_name_maestro.setText(mProductList.get(position).getNombre());
        tv_aula.setText(mProductList.get(position).getAula());
        tv_hora_inicio.setText(mProductList.get(position).getHora_inicio());
        tv_duracion.setText(mProductList.get(position).getDuracion());
        tv_carrera.setText(mProductList.get(position).getCarrera());
        tv_dias.setText(mProductList.get(position).getDias());

        //Se necesita poner en la clase entidad las entidades que se van a jalar con el adaptador
        //Ya que solamente están las del login

        //tvName.setText(mProductList.get(position).getName());
        //tvPrice.setText(String.valueOf(mProductList.get(position).getPrice()) + " $");
        //tvDescription.setText(mProductList.get(position).getDescription());

        //Save product id to tag
        //v.setTag(mProductList.get(position).getId());

        return convertView;
    }

}
