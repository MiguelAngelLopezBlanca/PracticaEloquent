package miguelangellopezblanca.psp.practicaeloquent.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;

import miguelangellopezblanca.psp.practicaeloquent.Adapter.AdapterCompetidor;
import miguelangellopezblanca.psp.practicaeloquent.R;
import miguelangellopezblanca.psp.practicaeloquent.viewmodel.ViewModelActivity;


public class InicioFragment extends Fragment {

    ViewModelActivity viewModelActivity;

    public InicioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModelActivity = new ViewModelProvider(getActivity()).get(ViewModelActivity.class);
        final NavController navController = Navigation.findNavController(view);
        Button btListarCompetidores = view.findViewById(R.id.btListadoCompetidores);
        btListarCompetidores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelActivity.setRecyclerView(true);
                navController.navigate(R.id.recyclerFragment);
            }
        });

        Button btListarJudoguis = view.findViewById(R.id.btListadoJudogui);
        btListarJudoguis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelActivity.setRecyclerView(false);
                navController.navigate(R.id.recyclerFragment);
            }
        });

        Button btInsertarCompetidor = view.findViewById(R.id.btInsertCompetidor);
        btInsertarCompetidor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.insertCompetidorFragment);
            }
        });

        Button btInsertarJudogui = view.findViewById(R.id.btInsertJudogui);
        btInsertarJudogui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.insertJudoguiFragment);
            }
        });

    }

}