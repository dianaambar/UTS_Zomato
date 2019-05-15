package pnj.ac.id.utszomato;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Gambar extends AsyncTask<String, Void, Bitmap> {
    ImageView gambarHeader;
    public Gambar(ImageView gambarHeader){ this.gambarHeader = gambarHeader; }

    protected Bitmap doInBackground(String... strings) {
        String urlImage = strings[0];
        Bitmap bitmap = null;

        InputStream inputStream = null;
        try{
            inputStream = new URL(urlImage).openStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e ){
            Log.e("Error",e.getMessage());
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        gambarHeader.setImageBitmap(bitmap);
    }
}
