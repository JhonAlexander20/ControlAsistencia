package mx.itson.controlasistencia.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import mx.itson.controlasistencia.R;

public class QrGenerator extends AppCompatActivity {

    ImageView qrImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        qrImage = (ImageView) findViewById(R.id.QrImage);
        String QrText = "http://asistenciapp.pitalla.mx/clases/1";
        MultiFormatWriter mfw = new MultiFormatWriter();
        try{
            BitMatrix btm =  mfw.encode(QrText, BarcodeFormat.QR_CODE,500,500);
            BarcodeEncoder ben = new BarcodeEncoder();
            Bitmap bitm =  ben.createBitmap(btm);
            qrImage.setImageBitmap(bitm);
        }catch (WriterException e){
            e.printStackTrace();
        }
    }

}
