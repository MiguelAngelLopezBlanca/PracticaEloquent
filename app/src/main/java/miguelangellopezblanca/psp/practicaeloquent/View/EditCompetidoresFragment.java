package miguelangellopezblanca.psp.practicaeloquent.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import miguelangellopezblanca.psp.practicaeloquent.R;
import miguelangellopezblanca.psp.practicaeloquent.laravel.Pojo.Competidor;
import miguelangellopezblanca.psp.practicaeloquent.viewmodel.ViewModelActivity;


public class EditCompetidoresFragment extends Fragment {

    private ViewModelActivity viewModelActivity;

    public EditCompetidoresFragment() {
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
        return inflater.inflate(R.layout.fragment_edit_competidores, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModelActivity = new ViewModelProvider(getActivity()).get(ViewModelActivity.class);
        final NavController navController = Navigation.findNavController(view);

        ImageView imgEditCompetidor = view.findViewById(R.id.imageEditCompetidor);

        EditText etEditNombre = view.findViewById(R.id.etEditCompNombre);
        etEditNombre.setText(viewModelActivity.getCompetidor().getNombre());

        EditText etEditApellidos = view.findViewById(R.id.etEditCompApellido);
        etEditApellidos.setText(viewModelActivity.getCompetidor().getApellidos());

        EditText etEditEdad = view.findViewById(R.id.etEditCompEdad);
        etEditEdad.setText(String.valueOf(viewModelActivity.getCompetidor().getEdad()));

        EditText etUrlImg = view.findViewById(R.id.etEditCompImg);
        etUrlImg.setText(viewModelActivity.getCompetidor().getImgCompetidor());
        Glide.with(getContext()).load(viewModelActivity.getCompetidor().getImgCompetidor()).into(imgEditCompetidor);

        Button btDeleteComp = view.findViewById(R.id.btDeleteComp);
        btDeleteComp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelActivity.deleteCompetidor(viewModelActivity.getCompetidor().getId());
                navController.navigate(R.id.inicioFragment);
            }
        });

        Button btActualizarComp = view.findViewById(R.id.btUpdateComp);
        btActualizarComp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Competidor competidor = new Competidor(etEditNombre.getText().toString(), etEditApellidos.getText().toString(), Integer.parseInt(etEditEdad.getText().toString()),
                        etUrlImg.getText().toString());
                viewModelActivity.actualizarCompetidor(viewModelActivity.getCompetidor().getId(), competidor);
                navController.navigate(R.id.inicioFragment);
            }
        });

    }
}