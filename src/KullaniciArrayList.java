public class KullaniciArrayList{

    static int sizemaxsize = 30000;
    int normalsize = 0;
    public Users[] kullanicilar;



    public KullaniciArrayList(){

        kullanicilar = new Users[sizemaxsize];


    }

public void kullaniciEkle(Users user){

        kullanicilar[normalsize] = user;
        normalsize++;


    }

    public Users[] getKullanicilar() {
        return kullanicilar;
    }

    public void setKullanicilar(Users[] kullanicilar) {
        this.kullanicilar = kullanicilar;
    }
}
