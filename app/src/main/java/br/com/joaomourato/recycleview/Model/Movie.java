package br.com.joaomourato.recycleview.Model;

public class Movie {
    private int id;
    private String title;
    private int img_url;

    public Movie(MovieBuilder movieBuilder) {
        this.id = movieBuilder.id;
        this.title = movieBuilder.title;
        this.img_url = movieBuilder.img_url;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getImg_url() {
        return img_url;
    }

    public static class MovieBuilder{
        private int id;
        private String title;
        private int img_url;

        private MovieBuilder(){}

        public static MovieBuilder movieBuilder(){return new MovieBuilder();}

        public MovieBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public MovieBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public MovieBuilder setImg_url(int img_url) {
            this.img_url = img_url;
            return this;
        }

        public Movie build(){return new Movie(this);}
    }
}
