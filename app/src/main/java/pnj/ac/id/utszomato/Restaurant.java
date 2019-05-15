package pnj.ac.id.utszomato;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

public class Restaurant extends AppCompatActivity {
    GridView gridView;
    ListRestaurantAdapter adapter;
    Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        gridView = findViewById(R.id.grid_view);
        adapter = new ListRestaurantAdapter(this, R.layout.grid_view_restaurant);

        gridView.setAdapter(adapter);
        res = getResources();

        initData();

    }

    void initData(){
        String[] nama_restaurant = res.getStringArray(R.array.nama_restaurant);
        String[] nama_lokasi = res.getStringArray((R.array.nama_lokasi));
        String[] harga = res.getStringArray(R.array.harga);
        String[] url_restaurant = res.getStringArray(R.array.url_restaurant);

        for(int i=0; i<nama_restaurant.length; i++){
            RestaurantModel model = new RestaurantModel();
            model.setNamaRestaurant(nama_restaurant[i]);
            model.setLokasiRestaurant(nama_lokasi[i]);
            model.setHarga(harga[i]);
            model.setImageURL(url_restaurant[i]);
            adapter.add(model);
        }
        adapter.notifyDataSetChanged();
    }

}
