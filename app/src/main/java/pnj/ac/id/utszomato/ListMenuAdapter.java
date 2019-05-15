package pnj.ac.id.utszomato;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class ListMenuAdapter extends ArrayAdapter<MenuModel> {
    Context context;
    int resources;

    public ListMenuAdapter(Context context, int resource) {
        super(context, resource);

        this.context = context;
        this.resources = resource;
    }
}
