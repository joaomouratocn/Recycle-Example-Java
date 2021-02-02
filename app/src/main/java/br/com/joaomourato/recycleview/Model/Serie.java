package br.com.joaomourato.recycleview.Model;

public class Serie {
    private int id;
    private String title;
    private String description;
    private int cover;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCover() {
        return cover;
    }

    //construtor que recebe o builder
    private Serie(SerieBuilder serieBuilder) {
        this.id = serieBuilder.id;
        this.title = serieBuilder.title;
        this.description = serieBuilder.description;
        this.cover = serieBuilder.cover;
    }

    //builder pattern
    public static class SerieBuilder{
        private int id;
        private String title;
        private String description;
        private int cover;

        //construtor privado para não ser instanciado
        private SerieBuilder() {}

        public static SerieBuilder seriesBuilder(){return new SerieBuilder();}

        public SerieBuilder setId(int id){
            this.id = id;
            return this;
        }

        public SerieBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public SerieBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public SerieBuilder setCover(int cover){
            this.cover = cover;
            return this;
        }

        public Serie build(){return new Serie(this);}
    }
}
