package br.com.joaomourato.recycleview.Model;

public class Person {
    private int id;
    private String name;
    private int photo;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPhoto() {
        return photo;
    }

    private Person(PersonBuilder personBuilder) {
        this.id = personBuilder.id;
        this.name = personBuilder.name;
        this.photo = personBuilder.photo;
    }

    public static class PersonBuilder{
        private int id;
        private String name;
        private int photo;

        private PersonBuilder() {}

        public static PersonBuilder personBuilder(){return new PersonBuilder();}

        public PersonBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder setPhoto(int photo) {
            this.photo = photo;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }
}
