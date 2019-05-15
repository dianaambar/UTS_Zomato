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

import java.util.ArrayList;

public class ListKategoriAdapter extends ArrayAdapter<MenuModel> {
    Context context;
    int resources;

    public ListKategoriAdapter(Context context, int resource) {
        super(context, resource);

        this.context = context;
        this.resources = resource;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
    Holder holder = null;

    if(convertView == null){
        holder = new Holder();
        convertView = LayoutInflater.from(context).inflate(resources,parent,false);
        holder.txtJudul = convertView.findViewById(R.id.txtJudul);
        holder.txtDetail = convertView.findViewById(R.id.txtDetail);
        holder.txtKeterangan = convertView.findViewById(R.id.txtKeterangan);
        holder.imgFood = convertView.findViewById(R.id.imageHeader);
        holder.MenuView = convertView.findViewById(R.id.MenuView);
        convertView.setTag(holder);

    }
    else{
        holder = (Holder) convertView.getTag();
    }

    holder.txtJudul.setText(getItem(position).getJudul());
    holder.txtDetail.setText(getItem(position).getDetail());
    holder.txtKeterangan.setText(getItem(position).getKeterangan());

    holder.MenuView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, Restaurant.class);
            intent.putExtra("URL", getItem(position).getImageURL());
            context.startActivity(intent);
        }
    });

    new Gambar(holder.imgFood).execute(new String[]{getItem(position).getImageURL()});
    return convertView;
    }

    class Holder{
        TextView txtJudul, txtDetail, txtKeterangan;
        ImageView imgFood;
        ConstraintLayout MenuView;
    }
}
