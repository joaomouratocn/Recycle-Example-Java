package br.com.joaomourato.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.joaomourato.recycleview.Adapters.VerticalLayoutAdapter;
import br.com.joaomourato.recycleview.Model.Categorie;
import br.com.joaomourato.recycleview.Model.Movie;

public class NestedRecycle extends AppCompatActivity {
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_recycle);

        random = new Random();

        RecyclerView recyclerView = findViewById(R.id.recycle_vertical);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new VerticalLayoutAdapter(createCategorieList()));

    }

    //LISTA DE CATEGORIAS
    private List<Categorie> createCategorieList(){
        List<Categorie> categorieList = new ArrayList<>();

        categorieList.add(Categorie.CategorieBuilder.categorieBuilder()
                .setId(random.nextInt(100))
                .setCategorie_name("Categoria 1")
                .setList_movies(createMovieList())
                .build()
        );

        categorieList.add(Categorie.CategorieBuilder.categorieBuilder()
                .setId(random.nextInt(100))
                .setCategorie_name("Categoria 2")
                .setList_movies(createMovieList())
                .build()
        );

        categorieList.add(Categorie.CategorieBuilder.categorieBuilder()
                .setId(random.nextInt(100))
                .setCategorie_name("Categoria 3")
                .setList_movies(createMovieList())
                .build()
        );

        categorieList.add(Categorie.CategorieBuilder.categorieBuilder()
                .setId(random.nextInt(100))
                .setCategorie_name("Categoria 4")
                .setList_movies(createMovieList())
                .build()
        );

        categorieList.add(Categorie.CategorieBuilder.categorieBuilder()
                .setId(random.nextInt(100))
                .setCategorie_name("Categoria 5")
                .setList_movies(createMovieList())
                .build()
        );

        categorieList.add(Categorie.CategorieBuilder.categorieBuilder()
                .setId(random.nextInt(100))
                .setCategorie_name("Categoria 6")
                .setList_movies(createMovieList())
                .build()
        );

        categorieList.add(Categorie.CategorieBuilder.categorieBuilder()
                .setId(random.nextInt(100))
                .setCategorie_name("Categoria 7")
                .setList_movies(createMovieList())
                .build()
        );

        return categorieList;
    }


    //LISTA DE FILMES
    private List<Movie> createMovieList(){
        List<Movie> movieList = new ArrayList<>();

        //LISTA DE FILMES
        movieList.add(Movie.MovieBuilder.movieBuilder()
                .setId(random.nextInt(100))
                .setTitle("Jobs")
                .setImg_url(R.drawable.jobs)
                .build()
        );
        movieList.add(Movie.MovieBuilder.movieBuilder()
                .setId(random.nextInt(100))
                .setTitle("Piratas")
                .setImg_url(R.drawable.piratas)
                .build()
        );
        movieList.add(Movie.MovieBuilder.movieBuilder()
                .setId(random.nextInt(100))
                .setTitle("Rede Social")
                .setImg_url(R.drawable.rede_social)
                .build()
        );
        movieList.add(Movie.MovieBuilder.movieBuilder()
                .setId(random.nextInt(100))
                .setTitle("Piratas")
                .setImg_url(R.drawable.piratas)
                .build()
        );
        movieList.add(Movie.MovieBuilder.movieBuilder()
                .setId(random.nextInt(100))
                .setTitle("Jogo da Imitação")
                .setImg_url(R.drawable.imitacao)
                .build()
        );
        movieList.add(Movie.MovieBuilder.movieBuilder()
                .setId(random.nextInt(100))
                .setTitle("snowden")
                .setImg_url(R.drawable.snowden)
                .build()
        );
        movieList.add(Movie.MovieBuilder.movieBuilder()
                .setId(random.nextInt(100))
                .setTitle("Rede Social")
                .setImg_url(R.drawable.rede_social)
                .build()
        );
        movieList.add(Movie.MovieBuilder.movieBuilder()
                .setId(random.nextInt(100))
                .setTitle("Jobs")
                .setImg_url(R.drawable.jobs)
                .build()
        );
        movieList.add(Movie.MovieBuilder.movieBuilder()
                .setId(random.nextInt(100))
                .setTitle("Imitação")
                .setImg_url(R.drawable.imitacao)
                .build()
        );
        movieList.add(Movie.MovieBuilder.movieBuilder()
                .setId(random.nextInt(100))
                .setTitle("Title")
                .setImg_url(R.drawable.piratas)
                .build()
        );

        return movieList;
    }
}