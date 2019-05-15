package pnj.ac.id.utszomato;

public class RestaurantModel {
    String namaRestaurant;
    String lokasiRestaurant;
    String harga;
    String imageURL;

    public String getNamaRestaurant() {
        return namaRestaurant;
    }

    public void setNamaRestaurant(String namaRestaurant) {
        this.namaRestaurant = namaRestaurant;
    }

    public String getLokasiRestaurant() {
        return lokasiRestaurant;
    }

    public void setLokasiRestaurant(String lokasiRestaurant) {
        this.lokasiRestaurant = lokasiRestaurant;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
