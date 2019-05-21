package mx.itson.controlasistencia.modelo;


import mx.itson.controlasistencia.activities.Maestro;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserService {

    @FormUrlEncoded
    @POST("maestro/login")
    Call<Maestro>maestroLogin(
            @Field("telefono") String telefono,
            @Field("contrasena") String contrasena
    );
}
