package miguelangellopezblanca.psp.practicaeloquent.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import miguelangellopezblanca.psp.practicaeloquent.Adapter.AdapterIDCompetidor;
import miguelangellopezblanca.psp.practicaeloquent.R;
import miguelangellopezblanca.psp.practicaeloquent.laravel.Pojo.Competidor;
import miguelangellopezblanca.psp.practicaeloquent.laravel.Pojo.Judogui;
import miguelangellopezblanca.psp.practicaeloquent.viewmodel.ViewModelActivity;


public class InsertJudoguiFragment extends Fragment {

    private ViewModelActivity viewModelActivity;
    private List<Competidor> listId = new ArrayList<>();

    public InsertJudoguiFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insert_judogui, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModelActivity = new ViewModelProvider(getActivity()).get(ViewModelActivity.class);
        final NavController navController = Navigation.findNavController(view);

        EditText etMarca = view.findViewById(R.id.etInsertJudoguiMarca);
        EditText etModelo = view.findViewById(R.id.etInsertJudoguiModelo);
        EditText etTalla = view.findViewById(R.id.etInsertJudoguiTalla);
        EditText etColor = view.findViewById(R.id.etInsertJudoguiColor);
        EditText etUrlImg = view.findViewById(R.id.etInsertJudoguiImagen);
        TextView tvId = view.findViewById(R.id.tvId);
        //Spinner idCompetidor = view.findViewById(R.id.spinner);

        RecyclerView idCompetidor = view.findViewById(R.id.recyclerID);
        AdapterIDCompetidor adapter = new AdapterIDCompetidor(getContext(), listId, view);

        idCompetidor.setAdapter(adapter);
        idCompetidor.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModelActivity.getCompetidores().observe(getActivity(), new Observer<List<Competidor>>() {
            @Override
            public void onChanged(List<Competidor> competidors) {
                listId.clear();
                listId.addAll(competidors);
                adapter.notifyDataSetChanged();
            }
        });



        Button btInsertJudogui = view.findViewById(R.id.btInsertarJudogui);
        btInsertJudogui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Judogui judogui = new Judogui(Integer.parseInt(tvId.getText().toString()), etMarca.getText().toString(), etModelo.getText().toString(), etUrlImg.getText().toString(), etColor.getText().toString()
                        ,Integer.parseInt(etTalla.getText().toString()));

                viewModelActivity.insertarJudogui(judogui);
                navController.navigate(R.id.inicioFragment);
            }
        });
    }
}