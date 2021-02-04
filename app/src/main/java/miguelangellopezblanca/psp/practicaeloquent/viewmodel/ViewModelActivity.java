package miguelangellopezblanca.psp.practicaeloquent.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import miguelangellopezblanca.psp.practicaeloquent.repositorio.Repository;
import miguelangellopezblanca.psp.practicaeloquent.laravel.Pojo.Competidor;
import miguelangellopezblanca.psp.practicaeloquent.laravel.Pojo.Judogui;

public class ViewModelActivity extends AndroidViewModel {

    private Repository repository;
    private boolean recyclerView;

    private Competidor competidor;
    private Judogui judogui;

    public ViewModelActivity(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public void insertarCompetidor(Competidor competidor) {
        repository.insertarCompetidor(competidor);
    }

    public void actualizarCompetidor(long id, Competidor competidor) {
        repository.actualizarCompetidor(id, competidor);
    }

    public void deleteCompetidor(long id) {
        repository.deleteCompetidor(id);
    }

    public void getCompetidor(long id) {
        repository.getCompetidor(id);
    }

    public MutableLiveData<List<Competidor>> getCompetidores() {
        return repository.getCompetidores();
    }

    public void insertarJudogui(Judogui judogui) {
        repository.insertarJudogui(judogui);
    }

    public void actualizarJudogui(long id, Judogui judogui) {
        repository.actualizarJudogui(id, judogui);
    }

    public void deleteJudogui(long id) {
        repository.deleteJudogui(id);
    }

    public void getJudogui(long id) {
        repository.getJudogui(id);
    }

    public MutableLiveData<List<Judogui>> getJudoguis() {
        return repository.getJudoguis();
    }

    public boolean isRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(boolean recyclerView) {
        this.recyclerView = recyclerView;
    }

    public Competidor getCompetidor() {
        return competidor;
    }

    public void setCompetidor(Competidor competidor) {
        this.competidor = competidor;
    }

    public Judogui getJudogui() {
        return judogui;
    }

    public void setJudogui(Judogui judogui) {
        this.judogui = judogui;
    }
}
