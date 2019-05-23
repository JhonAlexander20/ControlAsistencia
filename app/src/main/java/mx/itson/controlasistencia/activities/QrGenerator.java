package mx.itson.controlasistencia.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.ArrayList;
import java.util.List;

import mx.itson.controlasistencia.R;
import mx.itson.controlasistencia.api.Api;
import mx.itson.controlasistencia.modelo.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QrGenerator extends AppCompatActivity {

    ImageView qrImage;
    UserService userService;
    int idLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        qrImage = (ImageView) findViewById(R.id.QrImage);
        userService = Api.getUserService();

        final ArrayList<Clase> list = (ArrayList<Clase>) getIntent().getSerializableExtra("List");
        Bundle extras = getIntent().getExtras();
        final int posicion = extras.getInt("Posicion");
        int idMaestro = extras.getInt("idMaestro");
        ArrayList<Clase> lista2 = (ArrayList<Clase>) getIntent().getSerializableExtra("listdos");


        Call call = userService.maestroAsistencia(idMaestro, lista2.get(posicion).id);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                ListaAsistencia lista = (ListaAsistencia) response.body();
                idLista = lista.getId();
                String QrText = list.get(posicion).qr +","+ idLista;
                MultiFormatWriter mfw = new MultiFormatWriter();
                try {
                    BitMatrix btm = mfw.encode(QrText, BarcodeFormat.QR_CODE, 500, 500);
                    BarcodeEncoder ben = new BarcodeEncoder();
                    Bitmap bitm = ben.createBitmap(btm);
                    qrImage.setImageBitmap(bitm);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
