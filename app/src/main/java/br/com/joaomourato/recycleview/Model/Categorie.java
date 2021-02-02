package br.com.joaomourato.recycleview.Model;

import java.util.List;

public class Categorie {
    private int id;
    private String categorie_name;
    private List<Movie> list_movies;

    public Categorie(CategorieBuilder categorieBuilder) {
        this.id = categorieBuilder.id;
        this.categorie_name = categorieBuilder.categorie_name;
        this.list_movies = categorieBuilder.list_movies;
    }

    public int getId() {
        return id;
    }

    public String getCategorie_name() {
        return categorie_name;
    }

    public List<Movie> getList_movies() {
        return list_movies;
    }

    public static class CategorieBuilder{
        private int id;
        private String categorie_name;
        private List<Movie> list_movies;

        public CategorieBuilder() {}

        public static CategorieBuilder categorieBuilder(){return new CategorieBuilder();}

        public CategorieBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public CategorieBuilder setCategorie_name(String categorie_name) {
            this.categorie_name = categorie_name;
            return this;
        }

        public CategorieBuilder setList_movies(List<Movie> list_movies) {
            this.list_movies = list_movies;
            return this;
        }

        public Categorie build(){return new Categorie(this);}
    }
}
