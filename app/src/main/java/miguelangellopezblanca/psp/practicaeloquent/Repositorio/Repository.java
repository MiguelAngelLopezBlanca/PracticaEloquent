package miguelangellopezblanca.psp.practicaeloquent.Repositorio;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import miguelangellopezblanca.psp.practicaeloquent.laravel.Clientes.CompetidorCliente;
import miguelangellopezblanca.psp.practicaeloquent.laravel.Clientes.JudoguiCliente;
import miguelangellopezblanca.psp.practicaeloquent.laravel.Pojo.Competidor;
import miguelangellopezblanca.psp.practicaeloquent.laravel.Pojo.Judogui;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {

    private Retrofit retrofit;

    private CompetidorCliente competidorCliente;
    private JudoguiCliente judoguiCliente;

    private Context context;

    public Repository(Context context) {
        String url = "https://informatica.ieszaidinvergeles.org:9030/PSP/practicaEloquent/public/api/";
        retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        this.context = context;
    }

    /* ---------- METODOS COMPETIDOR ---------- */

    public void insertarCompetidor(Competidor competidor){
        competidorCliente = retrofit.create(CompetidorCliente.class);
        Call<Long> insertarCompetidor = competidorCliente.postCompetidor(competidor);
        insertarCompetidor.enqueue(new Callback<Long>() {
            @Override
            public void onResponse(Call<Long> call, Response<Long> response) {
                Toast.makeText(context, "Se ha insertado corractamente el competidor", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Long> call, Throwable t) {
                Log.v("xyzyx", t.getLocalizedMessage());
                Toast.makeText(context, "No se ha podido insertar el competidor", Toast.LENGTH_LONG).show();

            }
        });
    }

    public void actualizarCompetidor(long id, Competidor competidor){
        competidorCliente = retrofit.create(CompetidorCliente.class);
        Call<Boolean>  actualizar = competidorCliente.putCompetidor(id, competidor);
        actualizar.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                Toast.makeText(context, "El competidor se ha actualizado correctamente", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Toast.makeText(context, "No se ha podido actualizar el competidor", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void deleteCompetidor(long id){
        competidorCliente = retrofit.create(CompetidorCliente.class);
        Call<Integer> delete = competidorCliente.deleteCompetidor(id);
        delete.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                Toast.makeText(context, "El competidor se ha borrado correctamente", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Toast.makeText(context, "No se ha podido borrar el competidor", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getCompetidor(long id){
        competidorCliente = retrofit.create(CompetidorCliente.class);
        Call<Competidor> competidor = competidorCliente.getCompetidor(id);
        competidor.enqueue(new Callback<Competidor>() {
            @Override
            public void onResponse(Call<Competidor> call, Response<Competidor> response) {
                Toast.makeText(context, "Se ha obtenido el competidor por id", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Competidor> call, Throwable t) {
                Toast.makeText(context, "El id del competidor no existe", Toast.LENGTH_LONG).show();
            }
        });
    }

    public MutableLiveData<List<Competidor>> getCompetidores(){
        competidorCliente = retrofit.create(CompetidorCliente.class);
        MutableLiveData<List<Competidor>> liveDataCompetidores = new MutableLiveData<>();
        Call<List<Competidor>> competidores = competidorCliente.getCompetidores();
        competidores.enqueue(new Callback<List<Competidor>>() {
            @Override
            public void onResponse(Call<List<Competidor>> call, Response<List<Competidor>> response) {
                liveDataCompetidores.setValue(response.body());

            }
            @Override
            public void onFailure(Call<List<Competidor>> call, Throwable t) {
                Toast.makeText(context, "No existe competidores", Toast.LENGTH_LONG).show();
            }
        });

        return liveDataCompetidores;
    }



    /* ---------- METODOS JUDOGUI ---------- */

    public void insertarJudogui(Judogui judogui){
        judoguiCliente = retrofit.create(JudoguiCliente.class);
        Call<Long> insertar = judoguiCliente.postJudogui(judogui);
        insertar.enqueue(new Callback<Long>() {
            @Override
            public void onResponse(Call<Long> call, Response<Long> response) {
                Toast.makeText(context, "Se ha insertado correctamente el judogui", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Long> call, Throwable t) {
                Toast.makeText(context, "No se ha podido insertar el judogui", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void actualizarJudogui(long id, Judogui judogui){
        judoguiCliente = retrofit.create(JudoguiCliente.class);
        Call<Boolean> actualizar = judoguiCliente.putJudogui(id, judogui);
        actualizar.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                Toast.makeText(context, "El judogui se ha actualizado correctamente", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Toast.makeText(context, "No se ha podido actualizar el judogui", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void deleteJudogui(long id){
        judoguiCliente = retrofit.create(JudoguiCliente.class);
        Call<Integer> delete = judoguiCliente.deleteJudogui(id);
        delete.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                Toast.makeText(context, "El judogui se ha borrado correctamente", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Toast.makeText(context, "No se ha podido borrar el judogui", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getJudogui(long id){
        judoguiCliente = retrofit.create(JudoguiCliente.class);
        Call<Judogui> judogui = judoguiCliente.getJudogui(id);
        judogui.enqueue(new Callback<Judogui>() {
            @Override
            public void onResponse(Call<Judogui> call, Response<Judogui> response) {
                Toast.makeText(context, "Se ha obtenido el judogui por id", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Judogui> call, Throwable t) {
                Toast.makeText(context, "El id del judogui no existe", Toast.LENGTH_LONG).show();
            }
        });
    }

    public MutableLiveData<List<Judogui>> getJudoguis(){
        judoguiCliente = retrofit.create(JudoguiCliente.class);
        MutableLiveData<List<Judogui>> liveDataJudoguis = new MutableLiveData<>();
        Call<List<Judogui>> judoguis = judoguiCliente.getJudoguis();
        judoguis.enqueue(new Callback<List<Judogui>>() {
            @Override
            public void onResponse(Call<List<Judogui>> call, Response<List<Judogui>> response) {
                liveDataJudoguis.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Judogui>> call, Throwable t) {
                Toast.makeText(context, "No existe judoguis", Toast.LENGTH_LONG).show();
            }
        });

        return liveDataJudoguis;
    }

}
























