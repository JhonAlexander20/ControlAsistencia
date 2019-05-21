package mx.itson.controlasistencia.api;

import mx.itson.controlasistencia.modelo.RetrofitClient;
import mx.itson.controlasistencia.modelo.UserService;

public class Api {

    public static final String BASE_URL = "http://asistenciapp.pitalla.mx";

    public static UserService getUserService(){
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }
}
