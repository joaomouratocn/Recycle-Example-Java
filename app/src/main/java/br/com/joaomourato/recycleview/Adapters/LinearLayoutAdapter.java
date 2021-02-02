package br.com.joaomourato.recycleview.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.joaomourato.recycleview.Model.Email;
import br.com.joaomourato.recycleview.R;

public class LinearLayoutAdapter extends RecyclerView.Adapter<LinearLayoutAdapter.ViewHolder> {
    List<Email> emailList;
    OnItemClickListener onItemClickListener;

    public LinearLayoutAdapter(List<Email> emailList) {
        this.emailList = emailList;
    }

    public void setOnClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_linear, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Email email = emailList.get(position);
        holder.bind(email);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.OnClickListener(position);
            }
        });

        holder.icon_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.is_favorite()){
                    email.setIs_favorite(false);
                    holder.icon_favorite.setImageResource(R.drawable.star_border_icon);
                }else{
                    email.setIs_favorite(true);
                    holder.icon_favorite.setImageResource(R.drawable.star_icon);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return emailList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView email_icon, email_title, email_subject, email_text;
        ImageView icon_favorite;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            email_icon = itemView.findViewById(R.id.recycleview_list_txt_icon);
            email_title = itemView.findViewById(R.id.recycleview_list_txt_title);
            email_subject = itemView.findViewById(R.id.recycleview_list_txt_subject);
            email_text = itemView.findViewById(R.id.recycleview_list_txt_text_email);
            icon_favorite = itemView.findViewById(R.id.recycleview_list_img_star);
        }

        public void bind(Email email) {
            email_icon.setText(email.getText().substring(0,1));
            email_title.setText(email.getTitle());
            email_subject.setText(email.getSubject());
            email_text.setText(email.getText());
            if (email.is_favorite()){icon_favorite.setImageResource(R.drawable.star_icon);}
        }
    }

    public interface OnItemClickListener {
        void OnClickListener(int positon);
    }
}
