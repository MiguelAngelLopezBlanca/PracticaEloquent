package miguelangellopezblanca.psp.practicaeloquent.laravel.Clientes;

import java.util.ArrayList;
import java.util.List;

import miguelangellopezblanca.psp.practicaeloquent.laravel.Pojo.Competidor;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CompetidorCliente {

     /*
    GET     | competidor
    POST    | competidor
    GET     | competidor/{id}
    PUT     | competidor/{id}
    DELETE  | competidor/{id}
     */


    @DELETE("competidor/{id}")
    Call<Integer> deleteCompetidor(@Path("id") long id);

    @GET("competidor/{id}")
    Call<Competidor> getCompetidor(@Path("id") long id);

    @GET("competidor")
    Call<List<Competidor>> getCompetidores();

    @POST("competidor")
    Call<Long> postCompetidor(@Body Competidor competidor);

    @PUT("competidor/{id}")
    Call<Boolean> putCompetidor(@Path("id") long id, @Body Competidor competidor);

}
