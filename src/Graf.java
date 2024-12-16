import com.google.gson.JsonArray;

public class Graf {
    private BizimHashMap<String, Users> komsulukListesi;

    public Graf() {
        komsulukListesi = new BizimHashMap<>();
    }

    public void kullaniciEkle(String kullaniciAdi) {
        komsulukListesi.put(kullaniciAdi, new Users(kullaniciAdi));
    }

    public void takipciEkle(String takipci, String takipEden) {
        Users takipEdenKullanici = komsulukListesi.get(takipEden);
        Users takipciKullanici = komsulukListesi.get(takipci);

        if (takipEdenKullanici != null && takipciKullanici != null) {
            takipEdenKullanici.addTakipci(takipci);
            takipciKullanici.addTakipEdilen(takipEden);
        }
    }
    public Iterable<String> getTakipciler(String kullaniciAdi) {
        Users kullanici = komsulukListesi.get(kullaniciAdi);
        if (kullanici != null) {
            return kullanici.getTakipciler();
        } else {
            System.out.println("Kullanıcı bulunamadı.");
            return null;
        }
    }
    public void takipcileriYazdır(String kullaniciAdi) {
        Users kullanici = komsulukListesi.get(kullaniciAdi);
        if (kullanici != null) {
            System.out.print(kullaniciAdi + " takipçileri: ");
            for (String takipci : kullanici.getTakipciler()) {
                System.out.print(takipci + " ");
            }
            System.out.println();
        } else {
            System.out.println("Kullanıcı bulunamadı.");
        }
    }


    public void grafıYazdır(String kullaniciAdi) {
        Users kullanici = komsulukListesi.get(kullaniciAdi);
        if (kullanici != null) {
            System.out.print(kullaniciAdi + " takip ediyor: ");
            for (String takipci : kullanici.getTakipciler()) {
                System.out.print(takipci + " ");
            }
            System.out.println();
        } else {
            System.out.println("Kullanıcı bulunamadı.");
        }
    }

    public void grafıYazdır() {
        for (String kullanici : komsulukListesi.getKeys()) {
            grafıYazdır(kullanici);
        }
    }

    public BizimHashMap<String, Users> getKomsulukListesi() {
        return komsulukListesi;
    }
}
