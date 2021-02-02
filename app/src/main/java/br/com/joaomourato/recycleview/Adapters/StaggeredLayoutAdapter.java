package br.com.joaomourato.recycleview.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.joaomourato.recycleview.Model.Person;
import br.com.joaomourato.recycleview.R;

public class StaggeredLayoutAdapter extends RecyclerView.Adapter<StaggeredLayoutAdapter.ViewHolder> {

    List<Person> personList;
    OnClickListener onClickListener;

    public StaggeredLayoutAdapter(List<Person> personList) {
        this.personList = personList;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_staggered, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Person person = personList.get(position);

        holder.bind(person);

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.OnClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        CardView container;
        ImageView img_person;
        TextView name_person;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.container_staggered);
            img_person = itemView.findViewById(R.id.person_photo);
            name_person = itemView.findViewById(R.id.name_person);
        }

        public void bind(Person person) {
            img_person.setImageResource(person.getPhoto());
            name_person.setText(person.getName());
        }
    }

    public interface OnClickListener{
        void OnClick(int position);
    }
}
