package yogantara.urip.com.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ApiActivity extends AppCompatActivity implements MyRecycleViewAdapter.ItemClickListener{
    MyRecycleViewAdapter adapter;
    String url;
    ArrayList<HashMap<String,String>> myArray;
    RequestQueue queue;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        //deklatasi recycle view
        recyclerView= (RecyclerView)findViewById(R.id.rvAnimals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Instantiate the RequestQueue.
        queue = Volley.newRequestQueue(this);
        url ="https://jsonplaceholder.typicode.com/users";

        callApi();


//        adapter = new MyRecycleViewAdapter(this,item);
//        adapter.setClickListener(this);
//        recyclerView.setAdapter(adapter);
    }

    public void callApi(){
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
//                        mTextView.setText("Response is: "+ response.substring(0,500));
                        try{
                            JSONArray result= new JSONArray(response);
                            myArray = new ArrayList<>();
                            for (int i=0;i<result.length();i++){
                                JSONObject item= (JSONObject)result.get(i);
                                HashMap<String,String> temp= new HashMap<>();
                                temp.put("name",item.get("name").toString());
                                temp.put("username",item.get("username").toString());
                                temp.put("email",item.get("email").toString());
//                                item.add(title);
                                myArray.add(temp);
                            }
                            setAdapter();

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                mTextView.setText("That didn't work!");
                Toast.makeText(ApiActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    public  void setAdapter(){
        adapter = new MyRecycleViewAdapter(ApiActivity.this,myArray);
        adapter.setClickListener(ApiActivity.this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "Klik"+myArray.get(position), Toast.LENGTH_SHORT).show();
    }
}
