package mx.itson.controlasistencia.modelo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import mx.itson.controlasistencia.R;
import mx.itson.controlasistencia.activities.Alumno;
import mx.itson.controlasistencia.activities.Maestro;

public class MaestroListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Maestro> mProductList;

    //Constructor

    public MaestroListAdapter(Context mContext, List<Maestro> mProductList) {
        this.mContext = mContext;
        this.mProductList = mProductList;
    }

    @Override
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
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /** Modificar variables para el caso del listado de maestro, primeramente teniendolas en la clase
         * entidades Maestro**/

        View v = View.inflate(mContext, R.layout.item_maestro_list, null);
        TextView tvName = (TextView)v.findViewById(R.id.tv_name_maestro);
        TextView tvPrice = (TextView)v.findViewById(R.id.tv_maestro_data);
        TextView tvDescription = (TextView)v.findViewById(R.id.tv_maestro_data2);
        //Set text for TextView

        //Se necesita poner en la clase entidad las entidades que se van a jalar con el adaptador
        //Ya que solamente están las del login

        //tvName.setText(mProductList.get(position).getName());
        //tvPrice.setText(String.valueOf(mProductList.get(position).getPrice()) + " $");
        //tvDescription.setText(mProductList.get(position).getDescription());

        //Save product id to tag
        v.setTag(mProductList.get(position).getId());

        return v;
    }

}
