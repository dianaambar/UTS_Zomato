package pnj.ac.id.utszomato;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListRestaurantAdapter extends ArrayAdapter<RestaurantModel> {
    Context context;
    int resource;

    public ListRestaurantAdapter(Context context, int resource){
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    public View getView(final int position, View convertView, ViewGroup parent){
        ListRestaurantAdapter.Holder holder = null;

        if(convertView == null){
            holder = new ListRestaurantAdapter.Holder();
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
            holder.txtNamaRestaurant = convertView.findViewById(R.id.txtNamaRestaurant);
            holder.txtLokasirestaurant = convertView.findViewById(R.id.txtLokasiRestaurant);
            holder.txtHarga = convertView.findViewById(R.id.txtHarga);
            holder.imgRestaurant = convertView.findViewById(R.id.imgRestaurant);
            holder.layout_grid = convertView.findViewById(R.id.layout_grid);
            convertView.setTag(holder);
        }
        else {
            holder = (ListRestaurantAdapter.Holder) convertView.getTag();
        }
        holder.txtNamaRestaurant.setText(getItem(position).getNamaRestaurant());
        holder.txtLokasirestaurant.setText(getItem(position).getLokasiRestaurant());
        holder.txtHarga.setText(getItem(position).getHarga());

        holder.layout_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Detail.class);
                intent.putExtra("URL", getItem(position).getImageURL());
                context.startActivity(intent);
            }
        });
        new Gambar(holder.imgRestaurant).execute(new String[]{getItem(position).getImageURL()});
        return convertView;
    }

    class Holder{
        TextView txtNamaRestaurant, txtLokasirestaurant, txtHarga;
        ImageView imgRestaurant;
        ConstraintLayout layout_grid;
    }
}
