package pnj.ac.id.utszomato;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class Kategori extends AppCompatActivity {
    ListView listView;
    ListKategoriAdapter adapter;
    Resources res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);
        listView = findViewById(R.id.listView);
        adapter = new ListKategoriAdapter(this, R.layout.item_list_view);
        listView.setAdapter(adapter);
        res = getResources();

        initData();
    }

    void initData(){
        String[] judul = res.getStringArray(R.array.judulKategori);
        String[] detail = res.getStringArray(R.array.detail);
        String[] keterangan = res.getStringArray(R.array.keterangan);
        String[] imgFood = res.getStringArray(R.array.imageURL);

        for(int i=0; i<judul.length; i++){
            MenuModel model = new MenuModel();
            model.setJudul(judul[i]);
            model.setDetail(detail[i]);
            model.setKeterangan(keterangan[i]);
            model.setImageURL(imgFood[i]);
            adapter.add(model);
        }
        adapter.notifyDataSetChanged();
     }
}
