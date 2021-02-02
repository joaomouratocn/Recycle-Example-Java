package br.com.joaomourato.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.joaomourato.recycleview.Adapters.LinearLayoutAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CardView linear_recycle, grid_recycle, staggered_recycle, nested_recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linear_recycle = findViewById(R.id.linear_recycle);
        grid_recycle = findViewById(R.id.grid_recycle);
        staggered_recycle = findViewById(R.id.staggered_recycle);
        nested_recycle = findViewById(R.id.nested_recycle);

        linear_recycle.setOnClickListener(this);
        grid_recycle.setOnClickListener(this);
        staggered_recycle.setOnClickListener(this);
        nested_recycle.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()){
            case R.id.linear:
                intent = new Intent(this, LinearLayout.class);
                startActivity(intent);
                break;
            case R.id.grid_recycle:
                intent = new Intent(this, GridLayout.class);
                startActivity(intent);
                break;
            case R.id.staggered_recycle:
                intent = new Intent(this, StaggeredLayout.class);
                startActivity(intent);
                break;
            case R.id.nested_recycle:
                intent = new Intent(this, NestedRecycle.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}