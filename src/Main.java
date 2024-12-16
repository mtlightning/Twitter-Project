import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;

import static javax.swing.UIManager.get;

public class Main {
    private static final int TOP_WORDS_COUNT = 5;
    private static BizimHashMap<String, Integer> kelimeFrekanslari = new BizimHashMap<>();
    static BizimHashMap<String,Users> kullanıcılar=new BizimHashMap<>();
    static BizimHashMap<String,Users> followers=new BizimHashMap<>();
    static BizimHashMap<String,Users> takipEdilenler=new BizimHashMap<>();


    public static KullaniciArrayList kullanicilarArrayList = new KullaniciArrayList();
    public static KullaniciArrayList kullanicilarArrayList2 = new KullaniciArrayList();
    public static KullaniciArrayList kullanicilarArrayList3 = new KullaniciArrayList();
    public static BizimArraylist tweetlerArrayList = new BizimArraylist();
public static String hastag = null;


    private static Graf graf = new Graf();
    public static void main(String[] args) {

        try {

            Gson gson = new Gson();
            JsonArray jsonArray = gson.fromJson(new FileReader("fake_users_data.json"), JsonArray.class);

            for (JsonElement element : jsonArray) {
                JsonObject userObject = element.getAsJsonObject();

                JsonObject kullaniciBilgileri = userObject.getAsJsonObject("kullanici_bilgileri");
                String kullaniciAdi = kullaniciBilgileri.get("kullanici_adi").getAsString();
                String adSoyad = kullaniciBilgileri.get("ad_soyad").getAsString();
                int takipciSayisi = kullaniciBilgileri.get("takipci_sayisi").getAsInt();
                int takipEdilenSayisi = kullaniciBilgileri.get("takip_edilen_sayisi").getAsInt();
                String dil = kullaniciBilgileri.get("dil").getAsString();
                String bolge = kullaniciBilgileri.get("bolge").getAsString();

                Users kullanici = new Users(kullaniciAdi, adSoyad, takipciSayisi, takipEdilenSayisi, dil, bolge);


                JsonArray tweetler = userObject.getAsJsonArray("tweet_icerikleri");

                for (int i = 0; i < tweetler.size(); i++) {

                    JsonObject tweet = tweetler.get(i).getAsJsonObject();
                    int ID = tweet.get("tweet_id").getAsInt();
                    String icerik = tweet.get("icerik").getAsString();
                    String hashtag = tweet.get("hashtag").getAsString();
                    kullanici.tweetler.add(icerik + " " +hashtag);

                }

                JsonObject takipciler = userObject.getAsJsonObject("takip_edilen_ve_takipciler");
                JsonArray takipEdilenler = takipciler.getAsJsonArray("takip_edilenler");
                for (int i = 0; i < takipEdilenler.size(); i++) {
                    String takipEdilen = takipEdilenler.get(i).getAsString();
                    kullanici.addTakipEdilen(takipEdilen);
                    graf.takipciEkle(takipEdilen, kullaniciAdi);

                }

                JsonArray takipcilerListesi = takipciler.getAsJsonArray("takipciler");
                for (int j = 0; j < takipcilerListesi.size(); j++) {
                    String takipci = takipcilerListesi.get(j).getAsString();

                    kullanici.addTakipci(takipci);

                }

                kullanıcılar.put(kullaniciAdi,kullanici);
               kullanicilarArrayList.kullaniciEkle(kullanici);



            }

           Scanner scanner = new Scanner(System.in);
            System.out.println("takipcilerini görmek istediğiniz kullanıcıyı giriniz :");
            String ad = scanner.nextLine();

            Users kullanici = kullanıcılar.get(ad);





        } catch (Exception e) {
            e.printStackTrace();
        }

        kullaniciAdiGirisPanel aa = new kullaniciAdiGirisPanel();
        aa.setVisible(true);
hatstagilebulma BB = new hatstagilebulma();
BB.setVisible(true);



    }
}


