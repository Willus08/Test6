package posidenpalace.com.test6;

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
   List<Result> tempPojoList = new ArrayList<>();

    public RecycleAdapter(List<Result> temp) {
        this.tempPojoList = temp;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Result temp = tempPojoList.get(position);
        holder.title.setText(temp.getTitle());
        holder.description.setText(temp.getOverview());
        Glide.with(holder.itemView.getContext()).load(temp.getPosterPath()).into(holder.picture);

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(), "Passing: "+ temp.getTitle(), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(v.getContext(), .class);
//                Bundle bundle = new Bundle();
//                bundle.putParcelable("place" ,  place);
//                intent.putExtras(bundle);
                //v.getContext().startActivity(intent);
            }

        });

    }

    @Override
    public int getItemCount() {
        return tempPojoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        ImageView picture;
        FrameLayout container;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            description = (TextView) itemView.findViewById(R.id.tvDescription);
            picture = (ImageView) itemView.findViewById(R.id.ivPicture);
            container = (FrameLayout) itemView.findViewById(R.id.flContainer);
        }
    }
}
