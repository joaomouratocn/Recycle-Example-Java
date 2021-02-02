package br.com.joaomourato.recycleview.Adapters;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.joaomourato.recycleview.Model.Serie;
import br.com.joaomourato.recycleview.R;

public class GridLayoutAdapter extends RecyclerView.Adapter<GridLayoutAdapter.Viewholder> {

    List<Serie> serieList;
    OnClickListener onClickListener;

    public GridLayoutAdapter(List<Serie> serieList) {
        this.serieList = serieList;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }


    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_grid, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Serie serie = serieList.get(position);

        holder.bind(serie);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.OnClickListener(position);
            }
        });

        holder.more_options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //para construir um pouopMenu, passa-se o contexto e a view onde ele ira ancorar
                PopupMenu popupMenu = new PopupMenu(holder.itemView.getContext(), holder.more_options);
                popupMenu.inflate(R.menu.grid_layout_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return onClickListener.OnItemClick(item);
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return serieList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{
        ImageView cover, more_options;
        TextView title , description;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            cover = itemView.findViewById(R.id.img_cover);
            title = itemView.findViewById(R.id.grid_txt_title);
            more_options = itemView.findViewById(R.id.grid_img_more_options);
            description = itemView.findViewById(R.id.grid_txt_description);
        }

        public void bind(Serie serie) {
            cover.setImageResource(serie.getCover());
            title.setText(serie.getTitle());
            description.setText(serie.getDescription());
        }

    }

    public interface OnClickListener{
        void OnClickListener(int position);
        boolean OnItemClick(MenuItem menuItem);
    }
}