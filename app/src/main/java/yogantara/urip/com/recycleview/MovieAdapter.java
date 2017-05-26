package yogantara.urip.com.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Urip on 5/22/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{
    private ArrayList<HashMap<String,String>> mData= new ArrayList<>();
    private LayoutInflater inflater;
    private ItemClickListener mClickListener;
    private Context context;
    public MovieAdapter(Context context, ArrayList<HashMap<String,String>> data) {
        this.mData = data;
        this.inflater = LayoutInflater.from(context);
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= inflater.inflate(R.layout.activity_movie_row,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HashMap<String,String> row= mData.get(position);
        //TODO set holder
        holder.titleTextView.setText(row.get("title"));
        holder.subtitleTextView.setText(row.get("overview"));
        Glide.with(this.context).load("https://image.tmdb.org/t/p/w500"+row.get("poster_path")).into(holder.movieImage);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView titleTextView,subtitleTextView;
        public ImageView movieImage;
        public ViewHolder(View itemView){
            super(itemView);
            titleTextView= (TextView)itemView.findViewById(R.id.txt_title);
            subtitleTextView= (TextView)itemView.findViewById(R.id.txt_subtitle);
            movieImage = (ImageView)itemView.findViewById(R.id.img_movie);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener!=null){
                mClickListener.onItemClick(v,getAdapterPosition());
            }
        }
    }

    public String getItem(int id){
        HashMap<String,String> item= mData.get(id);
        return item.get("title");
    }

    public  void setClickListener(ItemClickListener itemClickListener){
        this.mClickListener=itemClickListener;
    }

    public interface ItemClickListener{
        void onItemClick(View view, int position);
    }
}
