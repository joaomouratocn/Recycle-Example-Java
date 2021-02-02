package br.com.joaomourato.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.joaomourato.recycleview.Adapters.StaggeredLayoutAdapter;
import br.com.joaomourato.recycleview.Model.Person;

public class StaggeredLayout extends AppCompatActivity {
    List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_layout);

        personList = createList();

        RecyclerView recyclerView = findViewById(R.id.recycle_staggered);

        StaggeredLayoutAdapter staggeredAdapter = new StaggeredLayoutAdapter(personList);

        staggeredAdapter.setOnClickListener(new StaggeredLayoutAdapter.OnClickListener() {
            @Override
            public void OnClick(int position) {
                Toast.makeText(StaggeredLayout.this, "Position touch "+position, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(staggeredAdapter);
    }

    private List<Person> createList() {
        List<Person> people = new ArrayList<>();
        Random random = new Random();

        people.add(Person.PersonBuilder.personBuilder()
                .setId(random.nextInt(100))
                .setName("Sheldon")
                .setPhoto(R.drawable.sheldon)
                .build());

        people.add(Person.PersonBuilder.personBuilder()
                .setId(random.nextInt(100))
                .setName("Leonard")
                .setPhoto(R.drawable.leonard)
                .build());

        people.add(Person.PersonBuilder.personBuilder()
                .setId(random.nextInt(100))
                .setName("Rajest")
                .setPhoto(R.drawable.rajest)
                .build());

        people.add(Person.PersonBuilder.personBuilder()
                .setId(random.nextInt(100))
                .setName("Horward")
                .setPhoto(R.drawable.howard)
                .build());

        people.add(Person.PersonBuilder.personBuilder()
                .setId(random.nextInt(100))
                .setName("Penny")
                .setPhoto(R.drawable.penny)
                .build());

        people.add(Person.PersonBuilder.personBuilder()
                .setId(random.nextInt(100))
                .setName("Amy")
                .setPhoto(R.drawable.amy)
                .build());

        people.add(Person.PersonBuilder.personBuilder()
                .setId(random.nextInt(100))
                .setName("Bernadette")
                .setPhoto(R.drawable.bernadet)
                .build());

        people.add(Person.PersonBuilder.personBuilder()
                .setId(random.nextInt(100))
                .setName("Leonard")
                .setPhoto(R.drawable.leonard)
                .build());

        people.add(Person.PersonBuilder.personBuilder()
                .setId(random.nextInt(100))
                .setName("Sheldon")
                .setPhoto(R.drawable.sheldon)
                .build());

        people.add(Person.PersonBuilder.personBuilder()
                .setId(random.nextInt(100))
                .setName("Amy")
                .setPhoto(R.drawable.amy)
                .build());

        people.add(Person.PersonBuilder.personBuilder()
                .setId(random.nextInt(100))
                .setName("Rajest")
                .setPhoto(R.drawable.rajest)
                .build());

        people.add(Person.PersonBuilder.personBuilder()
                .setId(random.nextInt(100))
                .setName("Penny")
                .setPhoto(R.drawable.penny)
                .build());

        people.add(Person.PersonBuilder.personBuilder()
                .setId(random.nextInt(100))
                .setName("Howard")
                .setPhoto(R.drawable.howard)
                .build());

        people.add(Person.PersonBuilder.personBuilder()
                .setId(random.nextInt(100))
                .setName("Bernadette")
                .setPhoto(R.drawable.bernadet)
                .build());

        people.add(Person.PersonBuilder.personBuilder()
                .setId(random.nextInt(100))
                .setName("Sheldon")
                .setPhoto(R.drawable.sheldon)
                .build());

        people.add(Person.PersonBuilder.personBuilder()
                .setId(random.nextInt(100))
                .setName("Rajest")
                .setPhoto(R.drawable.rajest)
                .build());

        return people;
    }
}