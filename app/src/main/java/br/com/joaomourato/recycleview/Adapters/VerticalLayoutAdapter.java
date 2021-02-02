package br.com.joaomourato.recycleview.Adapters;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.joaomourato.recycleview.Model.Categorie;
import br.com.joaomourato.recycleview.R;

public class VerticalLayoutAdapter extends RecyclerView.Adapter<VerticalLayoutAdapter.Viewholder> {

    List<Categorie> categorieList;

    public VerticalLayoutAdapter(List<Categorie> categorieList) {
        this.categorieList = categorieList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_vertical, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Categorie categorie = categorieList.get(position);

        holder.bind(categorie);
    }

    @Override
    public int getItemCount() {
        return categorieList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{
        TextView categorie_name;
        RecyclerView layout_horizontal;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            categorie_name = itemView.findViewById(R.id.categorie_name);
            layout_horizontal = itemView.findViewById(R.id.layout_horizontal);
        }

        public void bind(Categorie categorie) {
            categorie_name.setText(categorie.getCategorie_name());
            layout_horizontal.setLayoutManager(new LinearLayoutManager(itemView.getContext(), RecyclerView.HORIZONTAL, false));
            layout_horizontal.setAdapter(new HorizontalLayoutAdapter(categorie.getList_movies()));
        }
    }
}
