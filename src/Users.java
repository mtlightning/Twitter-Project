import com.google.gson.JsonArray;

public class Users {
    String kullaniciAdi;
     String adSoyad;
     int takipciSayisi;
     int takipEdilenSayisi;
     String dil;
     String bolge;
     BizimArraylist<String> tweetler;
     BizimArraylist<String> takipEdilenler;
     BizimArraylist<String> takipciler;

     public Users(String kullaniciAdi)
     {
         this.tweetler=new BizimArraylist<>();
         this.takipEdilenler=new BizimArraylist<>();
         this.takipciler = new BizimArraylist<>();
         this.kullaniciAdi=kullaniciAdi;

     }
    public Users(String kullaniciAdi, String adSoyad, int takipciSayisi, int takipEdilenSayisi, String dil, String bolge) {
        this.tweetler = new BizimArraylist<>();
        this.takipEdilenler = new BizimArraylist<>();
        this.takipciler = new BizimArraylist<>();
        this.kullaniciAdi = kullaniciAdi;
        this.adSoyad = adSoyad;
        this.dil = dil;
        this.bolge = bolge;
        this.takipciSayisi = takipciSayisi;
        this.takipEdilenSayisi = takipEdilenSayisi;
    }



    public String getKullaniciAdi() {
        return kullaniciAdi.toString();
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public int getTakipciSayisi() {
        return takipciSayisi;
    }

    public void setTakipciSayisi(int takipciSayisi) {
        this.takipciSayisi = takipciSayisi;
    }

    public int getTakipEdilenSayisi() {
        return takipEdilenSayisi;
    }

    public void setTakipEdilenSayisi(int takipEdilenSayisi) {
        this.takipEdilenSayisi = takipEdilenSayisi;
    }

    public String getDil() {
        return dil;
    }

    public void setDil(String dil) {
        this.dil = dil;
    }

    public String getBolge() {
        return bolge;
    }

    public void setBolge(String bolge) {
        this.bolge = bolge;
    }

    public BizimArraylist<String> getTweetler() {
        return tweetler;
    }

    public void setTweetler(BizimArraylist<String> tweetler) {
        this.tweetler = tweetler;
    }

    public BizimArraylist<String> getTakipEdilenler() {
        return takipEdilenler;
    }

    public void setTakipEdilenler(BizimArraylist<String> takipEdilenler) {
        this.takipEdilenler = takipEdilenler;
    }
    public Iterable<String> takipEdilenleriGetir() {
        return takipEdilenler;
    }
    public Iterable<String> takipcileriGetir() {
        return takipciler;
    }
    public BizimArraylist<String> getTakipciler() {
        return takipciler;
    }

    public void setTakipciler(CustomLinkedList<String> takipciler) {

    }
    public void takipcileriYazdir() {

       BizimArraylist<String> kullanilcakyeni = this.getTakipciler();


        System.out.println("Takipçiler:");
        for (int i = 0; i < kullanilcakyeni.size(); i++) {
            String takipci = kullanilcakyeni.get(i);
            System.out.println(takipci);
            System.out.println(i); // kontrol için ... ama demekki takipciler boş...



            
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Users user = (Users) obj;
        return kullaniciAdi.equals(user.kullaniciAdi);
    }

    @Override
    public int hashCode() {
        return kullaniciAdi.hashCode();
    }

    public void addTakipEdilen(String takipEdilen) {
        this.takipEdilenler.add(takipEdilen);
    }

    public void addTakipci(String takipci) {

         this.takipciler.add(takipci);
    }



    public Iterable<? extends String> takipciler() {
        return takipciler;
    }

}
