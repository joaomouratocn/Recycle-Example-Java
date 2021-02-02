package br.com.joaomourato.recycleview.Model;

import android.os.Parcel;
import android.os.Parcelable;

/*
* Nesta classe estão implementadas duas ferramentas. O BUILDER PATTERN e o PARCELABLE
* BUILDER PATTERN -> Criamos uma classe statica que retorna uma estancia do objeto.
* A Melhoria esta que quando necessitarmos de uma estancia da classe, ao inves de passarmos os
* valores no construtor ou chamarmos os metodos sets. na classe estatica cada set vira uma função
**/

public class Email{
    private int id;
    private String title;
    private String subject;
    private String text;
    private boolean is_favorite;

    //get methods
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public boolean is_favorite() {
        return is_favorite;
    }

    public void setIs_favorite(boolean is_favorite) {
        this.is_favorite = is_favorite;
    }

    private Email(EmailBuilder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.subject = builder.subject;
        this.text = builder.text;
        this.is_favorite = builder.is_favorite;
    }

    //BUILDER PATTERN
    public static class EmailBuilder{
        private int id;
        private String title;
        private String subject;
        private String text;
        private boolean is_favorite;

        private EmailBuilder() {}

        public static EmailBuilder emailBuilder(){return new EmailBuilder();}

        public EmailBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public EmailBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public EmailBuilder setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public EmailBuilder setText(String text) {
            this.text = text;
            return this;
        }

        public EmailBuilder setIs_favorite(boolean is_favorite) {
            this.is_favorite = is_favorite;
            return this;
        }

        public Email build(){return new Email(this);}
    }
}
