package miguelangellopezblanca.psp.practicaeloquent.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import miguelangellopezblanca.psp.practicaeloquent.R;
import miguelangellopezblanca.psp.practicaeloquent.laravel.Pojo.Competidor;

public class AdapterIDCompetidor extends RecyclerView.Adapter<AdapterIDCompetidor.ViewHolder> {

    private Context context;
    private List<Competidor> idCompetidor;
    private TextView tvId;
    private View v;


    public AdapterIDCompetidor(Context context, List<Competidor> idCompetidor, View v) {
        this.context = context;
        this.idCompetidor = idCompetidor;
        this.v = v;
    }

    @NonNull
    @Override
    public AdapterIDCompetidor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.id_item, parent, false);
        ViewHolder holder = new ViewHolder(vista);
        tvId = v.findViewById(R.id.tvId);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterIDCompetidor.ViewHolder holder, int position) {
        holder.tvNombreCompetidor.setText(idCompetidor.get(position).getNombre());
        holder.tvIdCompetidor.setText(String.valueOf(idCompetidor.get(position).getId()));
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvId.setText(String.valueOf(idCompetidor.get(position).getId()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return idCompetidor.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvIdCompetidor;
        TextView tvNombreCompetidor;
        ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIdCompetidor = itemView.findViewById(R.id.tvIdCompetidor);
            tvNombreCompetidor = itemView.findViewById(R.id.tvNombreCompetidor);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);

        }
    }
}
