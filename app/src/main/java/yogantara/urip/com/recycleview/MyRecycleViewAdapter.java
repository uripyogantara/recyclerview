package yogantara.urip.com.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Urip on 5/22/2017.
 */

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder>{
    private ArrayList<HashMap<String,String>> mData= new ArrayList<>();
    private LayoutInflater inflater;
    private ItemClickListener mClickListener;

    public MyRecycleViewAdapter(Context context, ArrayList<HashMap<String,String>> data) {
        this.mData = data;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= inflater.inflate(R.layout.recycleview_row,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HashMap<String,String> row= mData.get(position);
        holder.namaTextView.setText(row.get("name"));
        holder.usernameTextView.setText(row.get("username"));
        holder.emailTextView.setText(row.get("email"));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView namaTextView,usernameTextView,emailTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            namaTextView= (TextView)itemView.findViewById(R.id.txt_name);
            usernameTextView= (TextView)itemView.findViewById(R.id.txt_username);
            emailTextView= (TextView)itemView.findViewById(R.id.txt_email);
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
        void onItemClick(View view,int position);
    }
}
