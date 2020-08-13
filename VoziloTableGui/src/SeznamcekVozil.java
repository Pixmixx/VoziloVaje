/*  
vaja : 32
Avtor: Matjaz Kic
Naloga: glavni program iz vaje 28 razširite tako, da se bodo objekti zapisovali v dinamicni seznam. Napravite izpis vseh objektov v seznamu.
*/

import java.io.*;
import java.util.ArrayList;

// Deklariramo javni razred
public class SeznamcekVozil {

    // Definiramo glavno metodo
    public static void main(String[] args) {
ArrayList<Vozilo> SeznamVozil = new ArrayList<Vozilo>();
        // inicializiramo lastnost
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
while(true) {
        // deklariramo in incializiramo lokalne spremenljivke
        String znamkaVozila = "Neznana znamkaVozila ";
        String tipVozila = "Neznana tipVozila ";
        int kapacitetaGoriva = 0;
        String barvaVozila = "barvaVozila";
        // poskusimo vprasati kaksna je tip vozila
       
        try {
            System.out.print("Vnesite tip vozila: ");
            tipVozila = in.readLine();
        }
        // ce bi bila sporocena izjema

        catch (Exception e) {
            System.err.println("Napaka" + e);

        }
        // poskusimo vprasati kaksna je znamka
        try {
            System.out.print("Vnesite znamko vozila: ");
            znamkaVozila = in.readLine();
        }
        // ce bi bila sporocena izjema

        catch (Exception e) {
            System.err.println("Napaka" + e);

        }

        // poskusimo vprasati kaksna je kapaciteta
        try {
            System.out.print("Vnesite kapaciteto goriva vozila: ");
            String str1kapacitetaGoriva = in.readLine();
            kapacitetaGoriva = Integer.parseInt(str1kapacitetaGoriva);
        }
        // ce bi bila sporocena izjema

        catch (Exception e) {
            System.err.println("Napaka" + e);

        }
        // poskusimo vprasati kaksna je barva
        try {
            System.out.print("Vnesite barvo vozila: ");
            barvaVozila = in.readLine();
        }
        // ce bi bila sporocena izjema

        catch (Exception e) {
            System.err.println("Napaka" + e);

        }

        Vozilo vozilo;
        // ustvarimo vozilo in izpisemo v konzolo kakseno vozilo smo ustvarili
        
        // ce je kot tip vozila vnesen motor se naredi vozilo podrazreda motor
        if (tipVozila.equalsIgnoreCase("MOTOR")) {
            String kategorijaIzpita = "A";
            try {
                // motor ima posebnost, da je potrebna dolocena kategorija izpita za upravljanje vozila
                System.out.print("Vnesite potrebno kategorija izpita za vozilo: ");
                kategorijaIzpita = in.readLine();
            }
            // ce bi bila sporocena izjema

            catch (Exception e) {
                System.err.println("Napaka" + e);

            }
            
            vozilo = new Motor(znamkaVozila, kapacitetaGoriva, barvaVozila, kategorijaIzpita);
            
            // ce je kot tip vozila vnesen tank se naredi vozilo podrazreda tank
        } else if (tipVozila.equalsIgnoreCase("TANK")) {
            vozilo = new Tank(znamkaVozila, kapacitetaGoriva, barvaVozila);
        } else {
            int kapacitetaOseb = 0;

            // poskusimo vprasati kaksna je kapaciteta oseb
            try {
                System.out.print("Vnesite kapaciteto oseb vozila: ");
                String str1kapacitetaOseb = in.readLine();
                kapacitetaOseb = Integer.parseInt(str1kapacitetaOseb);
            }
            // ce bi bila sporocena izjema

            catch (Exception e) {
                System.err.println("Napaka" + e);

            }
            vozilo = new Vozilo(znamkaVozila, tipVozila, kapacitetaGoriva, barvaVozila, kapacitetaOseb);
           
        }
        SeznamVozil.add(vozilo);
        // Vozilo avto = new Vozilo(znamkaVozila, tipVozila, kapacitetaGoriva,
        // barvaVozila, 5);
        
        String vecVozil = "ne";
          // vprasamo ce zelimo dodati se dodatna vozila 
          try {
            System.out.print("Za vnos dodatnega vozila vnesite >Da< ali karkoli drugega za izpis seznama ");
            vecVozil = in.readLine();
        }
        // ce bi bila sporocena izjema
        catch (Exception e) {
            System.err.println("Napaka" + e);

        }
        // ce je vnesen 'da' se loop ponovi, drugace naredi izpis seznama oz. lista
        if (vecVozil.equalsIgnoreCase("da"))
        {
          continue;  
        }
        else {
            System.out.println("Trenutno so na seznamu :");
            for (Vozilo v : SeznamVozil) 
            {
              System.out.println(v.getOpisVozila());
            }
            break;
        }

       
        

    }

}
}
