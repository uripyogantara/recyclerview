package yogantara.urip.com.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyRecycleViewAdapter.ItemClickListener{
    MyRecycleViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> bengkel = new ArrayList<>();

        bengkel.add("Urip Motor");
        bengkel.add("Surabaya Motor");
        bengkel.add("Denpasar Motor");
        bengkel.add("Bangli Motor");
        bengkel.add("Jimbaran Motor");
        bengkel.add("ALKSJD Motor");
        bengkel.add("slkfja Motor");
        bengkel.add("lafksjla Motor");
        bengkel.add("salkfjsa Motor");
        bengkel.add("asfjlkaa Motor");
        bengkel.add("skjflkasf Motor");
        bengkel.add("lksafjlk Motor");
        bengkel.add("slkfjlas Motor");
        bengkel.add("alskfja Motor");
        bengkel.add("lasfdj Motor");
        bengkel.add("lsafkjsl Motor");
        bengkel.add("Urip Motor");
        bengkel.add("Surabaya Motor");
        bengkel.add("Denpasar Motor");
        bengkel.add("Bangli Motor");
        bengkel.add("Jimbaran Motor");
        bengkel.add("ALKSJD Motor");
        bengkel.add("slkfja Motor");
        bengkel.add("lafksjla Motor");
        bengkel.add("salkfjsa Motor");
        bengkel.add("asfjlkaa Motor");
        bengkel.add("skjflkasf Motor");
        bengkel.add("lksafjlk Motor");
        bengkel.add("slkfjlas Motor");
        bengkel.add("alskfja Motor");
        bengkel.add("lasfdj Motor");
        bengkel.add("lsafkjsl Motor");bengkel.add("Urip Motor");
        bengkel.add("Surabaya Motor");
        bengkel.add("Denpasar Motor");
        bengkel.add("Bangli Motor");
        bengkel.add("Jimbaran Motor");
        bengkel.add("ALKSJD Motor");
        bengkel.add("slkfja Motor");
        bengkel.add("lafksjla Motor");
        bengkel.add("salkfjsa Motor");
        bengkel.add("asfjlkaa Motor");
        bengkel.add("skjflkasf Motor");
        bengkel.add("lksafjlk Motor");
        bengkel.add("slkfjlas Motor");
        bengkel.add("alskfja Motor");
        bengkel.add("lasfdj Motor");
        bengkel.add("lsafkjsl Motor");bengkel.add("Urip Motor");
        bengkel.add("Surabaya Motor");
        bengkel.add("Denpasar Motor");
        bengkel.add("Bangli Motor");
        bengkel.add("Jimbaran Motor");
        bengkel.add("ALKSJD Motor");
        bengkel.add("slkfja Motor");
        bengkel.add("lafksjla Motor");
        bengkel.add("salkfjsa Motor");
        bengkel.add("asfjlkaa Motor");
        bengkel.add("skjflkasf Motor");
        bengkel.add("lksafjlk Motor");
        bengkel.add("slkfjlas Motor");
        bengkel.add("alskfja Motor");
        bengkel.add("lasfdj Motor");
        bengkel.add("lsafkjsl Motor");

//        RecyclerView recyclerView= (RecyclerView)findViewById(R.id.rvAnimals);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new MyRecycleViewAdapter(this,bengkel);
//        adapter.setClickListener(this);
//        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "Klik"+adapter.getItem(position), Toast.LENGTH_SHORT).show();
    }
}
