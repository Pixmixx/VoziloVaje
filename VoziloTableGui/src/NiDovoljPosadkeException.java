/* Ime: Vaja 31
Avtor: Matjaz Kic
Naloga : Prejšnjo vajo razširite tako, da z dedovanjem smiselno ustvarite svoje podrazrede razreda Exception za za vsaj 2 tipa izjem. */



// ustvarimo podrazred exception za javlanje napake pri tanku, ce ni dovolj posadke za premik

public class NiDovoljPosadkeException extends Exception
{
  public NiDovoljPosadkeException()
    {
      // tukaj je sporocilo vedno isto
        super("Tank potrebuje vsaj 3 clane posadke za voznjo");

    }


}