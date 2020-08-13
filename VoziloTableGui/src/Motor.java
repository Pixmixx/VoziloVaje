/* Ime: Vaja 28
Avtor: Matjaz Kic
Naloga : Prejsnjo vajo razširite tako, da z dedovanjem smiselno ustvarite svoje podrazrede razreda Exception za za vsaj 2 tipa izjem. */



public class Motor extends Vozilo 
 {// Deklariramo lastnosti
    private String potrebnaKategorijaIzpita; 
  
    

 // Deklariramo konstruktor s katerim ustvarimo nov objekt podrazreda motor
    // Vhod: znamka vozila, max kapaciteto goriva in barvo
    // Vrne: nov objekt podrazreda motor
    public Motor(String zv, int kg, String bv, String pki)
    { // poklicemo nadrazred
        super(zv, "Motor", kg, bv, 1);
       this.jeOdklenjen = true;
       this.potrebnaKategorijaIzpita = pki;
    }
// naredimo posebni 'getOpisVozila' ki bo override-al standardno verzijo 
    @Override
    public String getOpisVozila()
    {
        return "[+] motor znamke " + this.getznamkaVozila() + " tip vozila je "
                + this.gettipVozila() + " kapaciteta goriva je za " + this.getKolicinaGoriva() + " km"
                + " barva vozila je " + this.getbarvaVozila() + " maksimalno stevilo potnikov vkljucno z voznikom je "
                + this.getkapacitetaOseb() + " Potrebna kategorija izpita je " + potrebnaKategorijaIzpita;


    }
 }

