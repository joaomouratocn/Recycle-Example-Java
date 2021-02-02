package br.com.joaomourato.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.joaomourato.recycleview.Adapters.LinearLayoutAdapter;
import br.com.joaomourato.recycleview.Model.Email;
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class LinearLayout extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Email> emailList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        recyclerView = findViewById(R.id.recycle_linear);

        emailList = createList();

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);

        LinearLayoutAdapter linearLayoutAdapter = new LinearLayoutAdapter(emailList);

        linearLayoutAdapter.setOnClickListener(new LinearLayoutAdapter.OnItemClickListener() {
            @Override
            public void OnClickListener(int positon) {
                //Aqui implementar para abrir activity para exbir o conteudo do email
                Toast.makeText(LinearLayout.this, "Open email activity", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(linearLayoutAdapter);
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }

    //Estancia ItemCallBack para ser atachada na recycleview, para opções de reordenação e swipe na lista.
    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            int to_pos = target.getAdapterPosition();
            int from_pos = viewHolder.getAdapterPosition();

            Collections.swap(emailList, from_pos, to_pos);
            recyclerView.getAdapter().notifyItemMoved(from_pos, to_pos);

            return true;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            List<Email> emailsFiled = new ArrayList<>();
            int position = viewHolder.getAdapterPosition();

            switch (direction){
                case ItemTouchHelper.LEFT:
                    Email emailDelete = emailList.get(position);
                    emailList.remove(position);
                    recyclerView.getAdapter().notifyItemRemoved(position);
                    Snackbar.make(recyclerView, getString(R.string.strWasDeleted, emailDelete.getTitle()), Snackbar.LENGTH_LONG)
                            .setAction(R.string.strUndo, new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    emailList.add(position, emailDelete);
                                    recyclerView.getAdapter().notifyItemInserted(position);
                                }
                            }).show();
                    break;
                case ItemTouchHelper.RIGHT:
                    Email emailFiled = emailList.get(position);
                    emailList.remove(position);
                    emailsFiled.add(emailFiled);
                    recyclerView.getAdapter().notifyItemRemoved(position);
                    Snackbar.make(recyclerView, getString(R.string.strWasFiled, emailFiled.getTitle()), Snackbar.LENGTH_LONG)
                            .setAction(R.string.strUndo, new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    emailList.add(position, emailFiled);
                                    recyclerView.getAdapter().notifyItemInserted(position);
                                }
                            }).show();
                    break;
            }
        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            // para usar este metodo necessario implementação no gradle app -> swipedecorator projeto no GITHUB
            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addSwipeLeftBackgroundColor(ContextCompat.getColor(LinearLayout.this, R.color.remove))
                    .addSwipeLeftActionIcon(R.drawable.delete_icon)
                    .addSwipeRightBackgroundColor(ContextCompat.getColor(LinearLayout.this, R.color.filed))
                    .addSwipeRightActionIcon(R.drawable.archive_icon)
                    .create()
                    .decorate();
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };

    private List<Email> createList(){
        List<Email> emailList = new ArrayList<>();

        for (int i=0; i<10; i++){
            emailList.add(Email.EmailBuilder.emailBuilder()
                    .setId(i)
                    .setTitle("Lorem ipsum")
                    .setSubject("Lorem Ipsum is simply dummy text of the printing and typesetting industry")
                    .setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                            "Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s," +
                            "when an unknown printer took a galley of type and scrambled it to make a type " +
                            "specimen book. It has survived not only five centuries, " +
                            "but also the leap into electronic typesetting, remaining essentially unchanged." +
                            "It was popularised in the 1960s with the release of Letraset sheets containing " +
                            "Lorem Ipsum passages, and more recently with desktop publishing software like " +
                            "Aldus PageMaker including versions of Lorem Ipsum.")
                    .setIs_favorite(false)
                    .build());
        }

        return emailList;
    }
}