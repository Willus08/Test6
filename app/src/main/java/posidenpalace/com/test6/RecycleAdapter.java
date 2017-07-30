package posidenpalace.com.test6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;



public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
   List<MoviesList> moviesList = new ArrayList<>();

    public RecycleAdapter(List<MoviesList> temp) {
        this.moviesList = temp;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MoviesList temp = moviesList.get(position);
        holder.title.setText("Title: "+temp.getTitle());
        holder.language.setText("Language: "+temp.getLanguage());
        Glide.with(holder.itemView.getContext()).load(temp.getPosterPath()).into(holder.picture);

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(), "Passing: "+ temp.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), Details.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("movie" ,  temp);
                intent.putExtras(bundle);
                v.getContext().startActivity(intent);
            }

        });

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView language;
        ImageView picture;
        FrameLayout container;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            language = (TextView) itemView.findViewById(R.id.tvLanguage);
            picture = (ImageView) itemView.findViewById(R.id.ivPicture);
            container = (FrameLayout) itemView.findViewById(R.id.flContainer);
        }
    }
}
