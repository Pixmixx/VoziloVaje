/* Ime: Vaja 28
Avtor: Matjaz Kic
Naloga : Prejsnjo vajo razširite tako, da z dedovanjem smiselno ustvarite svoje podrazrede razreda Exception za za vsaj 2 tipa izjem. */





public class Tank extends Vozilo 

{// Deklariramo lastnosti
    private String potrebnaKategorijaIzpita; 
    private int minimalnaKapacitetaOseb; 
  
    

 // Deklariramo konstruktor s katerim ustvarimo nov objekt podrazreda tank
    // Vhod: znamka vozila, max kapaciteto goriva in barvo
    // Vrne: nov objekt podrazreda tank
    public Tank(String zv, int kg, String bv)
    {
        // poklicemo nadrazred
     super(zv, "Oklepnik", kg, bv, 8);
       this.jeOdklenjen = true;
       this.potrebnaKategorijaIzpita = "vojasko usposabljanje";
       this.minimalnaKapacitetaOseb = 3;
    }
// naredimo posebni 'getOpisVozila' ki bo override-al standardno verzijo 
    @Override
    public String getOpisVozila()
    {
        return "[+] tank znamke " + this.getznamkaVozila() + " tip vozila je "
                + this.gettipVozila() + " kapaciteta goriva je za " + this.getKolicinaGoriva() + " km"
                + " barva vozila je " + this.getbarvaVozila() + " maksimalno stevilo potnikov vkljucno z voznikom je "
                + this.getkapacitetaOseb() + " Potrebna kategorija izpita je " + this.potrebnaKategorijaIzpita + " Minimalno stevilo oseb za voznjo je " + this.minimalnaKapacitetaOseb;


    }

    // metoda ki pelje tank ce so v tanku vsaj 3 osebe
    // izhod: nova kolicina goriva po voznji oz. stara ce ni dovolj oseb
    @Override
    public int pelji(int d) throws Exception {
        if (this.osebVAvtu < this.minimalnaKapacitetaOseb)
        {
            throw new NiDovoljPosadkeException();
        }
        
       return super.pelji(d);
        

 }
}
