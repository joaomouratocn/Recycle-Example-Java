package br.com.joaomourato.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.joaomourato.recycleview.Adapters.GridLayoutAdapter;
import br.com.joaomourato.recycleview.Model.Serie;
import br.com.joaomourato.recycleview.Adapters.GridLayoutAdapter.OnClickListener;

public class GridLayout extends AppCompatActivity {
    List<Serie> serieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);

        RecyclerView recyclerView = findViewById(R.id.recycle_grid);

        serieList = createList();

        GridLayoutAdapter gridLayoutAdapter = new GridLayoutAdapter(serieList);
        gridLayoutAdapter.setOnClickListener(new OnClickListener() {
            //evento click do item
            @Override
            public void OnClickListener(int position) {
                Toast.makeText(GridLayout.this, "Item position "+position, Toast.LENGTH_SHORT).show();
            }

            //evento de click dos itens do menu
            @Override
            public boolean OnItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.item_details:
                        Toast.makeText(GridLayout.this, "Touch detail item", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.item_delete:
                        Toast.makeText(GridLayout.this, "Touch delete item", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });

        recyclerView.setAdapter(gridLayoutAdapter);
    }


    private List<Serie> createList(){
        List<Serie> serieList = new ArrayList<>();
        Random random = new Random();

        serieList.add(Serie.SerieBuilder.seriesBuilder()
                .setId(random.nextInt(10))
                .setCover(R.drawable.big_bang)
                .setTitle("The Big Bang Theory")
                .setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,\n" +
                        "when an unknown printer took a galley of type and scrambled it to make a type\n" +
                        "specimen book. It has survived not only five centuries, but also the leap into\n" +
                        "electronic typesetting, remaining essentially unchanged.\n" +
                        "It was popularised in the 1960s with the release of Letraset sheets containing\n" +
                        "Lorem Ipsum passages, and more recently with desktop publishing software like\n" +
                        "Aldus PageMaker including versions of Lorem Ipsum.")
                .build());

        serieList.add(Serie.SerieBuilder.seriesBuilder()
                .setId(random.nextInt(10))
                .setCover(R.drawable.friends)
                .setTitle("Friends")
                .setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,\n" +
                        "when an unknown printer took a galley of type and scrambled it to make a type\n" +
                        "specimen book. It has survived not only five centuries, but also the leap into\n" +
                        "electronic typesetting, remaining essentially unchanged.\n" +
                        "It was popularised in the 1960s with the release of Letraset sheets containing\n" +
                        "Lorem Ipsum passages, and more recently with desktop publishing software like\n" +
                        "Aldus PageMaker including versions of Lorem Ipsum.")
                .build());


        serieList.add(Serie.SerieBuilder.seriesBuilder()
                .setId(random.nextInt(10))
                .setCover(R.drawable.modern_family)
                .setTitle("Modern Family")
                .setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,\n" +
                        "when an unknown printer took a galley of type and scrambled it to make a type\n" +
                        "specimen book. It has survived not only five centuries, but also the leap into\n" +
                        "electronic typesetting, remaining essentially unchanged.\n" +
                        "It was popularised in the 1960s with the release of Letraset sheets containing\n" +
                        "Lorem Ipsum passages, and more recently with desktop publishing software like\n" +
                        "Aldus PageMaker including versions of Lorem Ipsum.")
                .build());

        serieList.add(Serie.SerieBuilder.seriesBuilder()
                .setId(random.nextInt(10))
                .setCover(R.drawable.mrrobot)
                .setTitle("Young Sheldon")
                .setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,\n" +
                        "when an unknown printer took a galley of type and scrambled it to make a type\n" +
                        "specimen book. It has survived not only five centuries, but also the leap into\n" +
                        "electronic typesetting, remaining essentially unchanged.\n" +
                        "It was popularised in the 1960s with the release of Letraset sheets containing\n" +
                        "Lorem Ipsum passages, and more recently with desktop publishing software like\n" +
                        "Aldus PageMaker including versions of Lorem Ipsum.")
                .build());

        serieList.add(Serie.SerieBuilder.seriesBuilder()
                .setId(random.nextInt(10))
                .setCover(R.drawable.young_sheldon)
                .setTitle("Young Sheldon")
                .setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,\n" +
                        "when an unknown printer took a galley of type and scrambled it to make a type\n" +
                        "specimen book. It has survived not only five centuries, but also the leap into\n" +
                        "electronic typesetting, remaining essentially unchanged.\n" +
                        "It was popularised in the 1960s with the release of Letraset sheets containing\n" +
                        "Lorem Ipsum passages, and more recently with desktop publishing software like\n" +
                        "Aldus PageMaker including versions of Lorem Ipsum.")
                .build());

        serieList.add(Serie.SerieBuilder.seriesBuilder()
                .setId(random.nextInt(10))
                .setCover(R.drawable.big_bang)
                .setTitle("The Big Bang Theory")
                .setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,\n" +
                        "when an unknown printer took a galley of type and scrambled it to make a type\n" +
                        "specimen book. It has survived not only five centuries, but also the leap into\n" +
                        "electronic typesetting, remaining essentially unchanged.\n" +
                        "It was popularised in the 1960s with the release of Letraset sheets containing\n" +
                        "Lorem Ipsum passages, and more recently with desktop publishing software like\n" +
                        "Aldus PageMaker including versions of Lorem Ipsum.")
                .build());

        serieList.add(Serie.SerieBuilder.seriesBuilder()
                .setId(random.nextInt(10))
                .setCover(R.drawable.friends)
                .setTitle("Friends")
                .setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,\n" +
                        "when an unknown printer took a galley of type and scrambled it to make a type\n" +
                        "specimen book. It has survived not only five centuries, but also the leap into\n" +
                        "electronic typesetting, remaining essentially unchanged.\n" +
                        "It was popularised in the 1960s with the release of Letraset sheets containing\n" +
                        "Lorem Ipsum passages, and more recently with desktop publishing software like\n" +
                        "Aldus PageMaker including versions of Lorem Ipsum.")
                .build());

        serieList.add(Serie.SerieBuilder.seriesBuilder()
                .setId(random.nextInt(10))
                .setCover(R.drawable.mrrobot)
                .setTitle("Young Sheldon")
                .setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,\n" +
                        "when an unknown printer took a galley of type and scrambled it to make a type\n" +
                        "specimen book. It has survived not only five centuries, but also the leap into\n" +
                        "electronic typesetting, remaining essentially unchanged.\n" +
                        "It was popularised in the 1960s with the release of Letraset sheets containing\n" +
                        "Lorem Ipsum passages, and more recently with desktop publishing software like\n" +
                        "Aldus PageMaker including versions of Lorem Ipsum.")
                .build());

        serieList.add(Serie.SerieBuilder.seriesBuilder()
                .setId(random.nextInt(10))
                .setCover(R.drawable.modern_family)
                .setTitle("Modern Family")
                .setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,\n" +
                        "when an unknown printer took a galley of type and scrambled it to make a type\n" +
                        "specimen book. It has survived not only five centuries, but also the leap into\n" +
                        "electronic typesetting, remaining essentially unchanged.\n" +
                        "It was popularised in the 1960s with the release of Letraset sheets containing\n" +
                        "Lorem Ipsum passages, and more recently with desktop publishing software like\n" +
                        "Aldus PageMaker including versions of Lorem Ipsum.")
                .build());


        serieList.add(Serie.SerieBuilder.seriesBuilder()
                .setId(random.nextInt(10))
                .setCover(R.drawable.young_sheldon)
                .setTitle("Young Sheldon")
                .setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,\n" +
                        "when an unknown printer took a galley of type and scrambled it to make a type\n" +
                        "specimen book. It has survived not only five centuries, but also the leap into\n" +
                        "electronic typesetting, remaining essentially unchanged.\n" +
                        "It was popularised in the 1960s with the release of Letraset sheets containing\n" +
                        "Lorem Ipsum passages, and more recently with desktop publishing software like\n" +
                        "Aldus PageMaker including versions of Lorem Ipsum.")
                .build());


        serieList.add(Serie.SerieBuilder.seriesBuilder()
                .setId(random.nextInt(10))
                .setCover(R.drawable.mrrobot)
                .setTitle("Young Sheldon")
                .setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,\n" +
                        "when an unknown printer took a galley of type and scrambled it to make a type\n" +
                        "specimen book. It has survived not only five centuries, but also the leap into\n" +
                        "electronic typesetting, remaining essentially unchanged.\n" +
                        "It was popularised in the 1960s with the release of Letraset sheets containing\n" +
                        "Lorem Ipsum passages, and more recently with desktop publishing software like\n" +
                        "Aldus PageMaker including versions of Lorem Ipsum.")
                .build());


        return serieList;
    }
}