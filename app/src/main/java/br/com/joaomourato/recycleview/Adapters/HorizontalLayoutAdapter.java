package br.com.joaomourato.recycleview.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.joaomourato.recycleview.Model.Categorie;
import br.com.joaomourato.recycleview.Model.Movie;
import br.com.joaomourato.recycleview.R;

public class HorizontalLayoutAdapter extends RecyclerView.Adapter<HorizontalLayoutAdapter.ViewHolder> {

    List<Movie> movieList;

    public HorizontalLayoutAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_horizontal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movieList.get(position);

        holder.bind(movie);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img_url;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            img_url = itemView.findViewById(R.id.img_url);
        }

        public void bind(Movie movie) {
            img_url.setImageResource(movie.getImg_url());
        }
    }
}
