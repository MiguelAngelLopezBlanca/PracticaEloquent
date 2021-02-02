package miguelangellopezblanca.psp.practicaeloquent.laravel.Clientes;

import java.util.ArrayList;
import java.util.List;

import miguelangellopezblanca.psp.practicaeloquent.laravel.Pojo.Judogui;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface JudoguiCliente {

         /*
    GET     | judogui
    POST    | judogui
    GET     | judogui/{id}
    PUT     | judogui/{id}
    DELETE  | judogui/{id}
     */


    @DELETE("judogui/{id}")
    Call<Integer> deleteJudogui(@Path("id") long id);

    @GET("judogui/{id}")
    Call<Judogui> getJudogui(@Path("id") long id);

    @GET("judogui")
    Call<List<Judogui>> getJudoguis();

    @POST("judogui")
    Call<Long> postJudogui(@Body Judogui judogui);

    @PUT("judogui/{id}")
    Call<Boolean> putJudogui(@Path("id") long id, @Body Judogui judogui);
}
