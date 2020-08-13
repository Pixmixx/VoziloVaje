/* Ime: Vaja 31
Avtor: Matjaz Kic
Naloga : Prejšnjo vajo razširite tako, da z dedovanjem smiselno ustvarite svoje podrazrede razreda Exception za za vsaj 2 tipa izjem. */

// naredimo podrazred exceptiona za javlanje napake
public class VoziloJeZaklenjenoException extends Exception
{
  public VoziloJeZaklenjenoException(String msg)
    {
      // vrne kar vnesemo
        super(msg);

    }


}