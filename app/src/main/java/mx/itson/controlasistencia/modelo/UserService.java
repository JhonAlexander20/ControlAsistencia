package mx.itson.controlasistencia.modelo;


import java.util.List;

import mx.itson.controlasistencia.activities.Clase;
import mx.itson.controlasistencia.activities.Maestro;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {

    @FormUrlEncoded
    @POST("maestro/login")
    Call<Maestro>maestroLogin(
            @Field("telefono") String telefono,
            @Field("contrasena") String contrasena
    );

    /*@FormUrlEncoded
    @GET("maestro/clases/($id_maestro)")
    Call<Maestro>maestroClases(
            @Field("id") Integer id,
            @Field("id_maestro") Integer id_maestro,
            @Field("nombre") String nombre,
            @Field("aula") String aula,
            @Field("duracion") String duracion,
            @Field("duracion") String qr

    );*/

    @GET("clases")
    Call<List<Clase>> maestroClases();
}
