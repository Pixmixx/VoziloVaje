/* Ime: Vaja 27 
Avtor: Matjaz Kic
V Javi implementirajte razred, ki ste ga predhodno izbrali. Ima naj vsaj tri smiselne lastnosti in tri smiselne metode. Implementirajte še razred, ki bo prikazal uporabo metod. */

// Deklariramo javni razred
public class Vozilo {
    // Deklariramo lastnosti
    protected String znamkaVozila;
    protected String tipVozila;
    protected int kapacitetaGoriva;
    protected int kolicinaGoriva;
    protected String barvaVozila;
    protected boolean jeOdklenjen;
    protected int kapacitetaOseb;
    protected int osebVAvtu;
    protected int dolzinaVoznje;

    // Deklariramo konstruktor s katerim ustvarimo nov objekt
    // Vhod: lastnosti vozila kot so znamka, tip, kapaciteta goriva, barva,
    // kapaciteta oseb, dejansko stevilo oseb v avtu in tudi goriva
    // Vrne: nov objekt razreda Vozilo
    public Vozilo(String zv, String tv, int kg, String bv, int ko) {
        // inicializiramo lastnosti
        znamkaVozila = zv;
        tipVozila = tv;
        kapacitetaGoriva = kg;
        barvaVozila = bv;
        kapacitetaOseb = ko;
        kolicinaGoriva = kapacitetaGoriva;
        osebVAvtu = 0;
        jeOdklenjen = false;

    }

    // metoda, ki vrne trenutno kolicino goriva v vozilu
    // Vhod: /
    // Izhod: kolicina goriva
    public int getKolicinaGoriva() {

        return kolicinaGoriva;
    }

    // metoda, ki vrne znamko vozila
    // Vhod: /
    // Izhod: vrsta znamke
    public String getznamkaVozila() {

        return znamkaVozila;
    }

    // metoda, ki vrne barvo vozila
    // Vhod: /
    // Izhod: barva vozila
    public String getbarvaVozila() {

        return barvaVozila;
    }

    // metoda, ki vrne maksimalno stevilo potnikov v vozilu
    // Vhod: /
    // Izhod: max stevilo oseb v vozilu
    public int getkapacitetaOseb() {

        return kapacitetaOseb;
    }

    // metoda, ki vrne trenutno stevilo oseb v vozilu
    // Vhod: /
    // Izhod: trenutno stevilo oseb v avtu
    public int getosebVAvtu() {

        return osebVAvtu;
    }

    // metoda, ki vrne vrsto vozila
    // Vhod: /
    // Izhod: vrsta vozila
    public String gettipVozila() {

        return tipVozila;
    }

    // metoda za polnenje goriva v vozilo
    // Vhod: kolicina, ki jo zelimo napolniti
    // Izhod: kolicina po polnenju

    public int napolniGorivo(int go) throws Exception {
        // ce je manj goriva kot je maximum
        if (kapacitetaGoriva > kolicinaGoriva) {
            // napolnimo tank
            kolicinaGoriva = kolicinaGoriva + go;

        }
        // ce je goriva ze maximalno
        else {

            // vrzemo izjemo da je tank poln
            throw new Exception(" [-] Goriva je poln tank.");

        }
        return kolicinaGoriva;
    }

    // definiramo metodo za vstop potnika
    public int vstopPotnika(int po) throws Exception {
        // potnik vstopi ce je odklenjen
        if (!jeOdklenjen) {
            // ce ni odklenjeno, potniki ne morejo vstopiti
            throw new VoziloJeZaklenjenoException(" [-] Vozilo ni odklenjeno");
        }
        if (kapacitetaOseb < osebVAvtu + po)
        {
            // dodatna napaka ce je prevec potnikov v avtu
            throw new Exception(" [-] Prevec potnikov v avtu ");
        }
        osebVAvtu += po;
        return osebVAvtu;

    }



    // metoda ki pelje avto ce je voznik, pot odstejemo od bencina
    // vhod:
    // izhod: nova kolicina goriva po voznji oz. stara ce ni voznika
    public int pelji(int d) throws Exception {
        if (0 < osebVAvtu) {
            kolicinaGoriva = kolicinaGoriva - d;
        }

        else {
            throw new Exception(" [-] Vozilo nima voznika");
        }
        return kolicinaGoriva;
    }

    // metoda ki odklene avto
    // vhod:
    // izhod: nova kolicina goriva po voznji oz. stara ce ni voznika
    public boolean odkleni() {

        // spremenimo v odprto stanje
        jeOdklenjen = true;

        // v vskaem primeru vrne true
        return true;
    }
    // metoda ki nam vrne opis vozila, ki smo ga ustvarili oz. dodali na seznam
    public String getOpisVozila()
    {
        return "[+] vozilo znamke " + this.getznamkaVozila() + " tip vozila je "
                + this.gettipVozila() + " kapaciteta goriva je za " + this.getKolicinaGoriva() + " km"
                + " barva vozila je " + this.getbarvaVozila() + " maksimalno stevilo potnikov vkljucno z voznikom je "
                + this.getkapacitetaOseb();


    }

}