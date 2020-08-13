/*  
Avtor: Matjaz Kic
Naloga: Izdelajte graficni uporabniški vmesnik (GUI) za delo z objekti in njihovim seznamom, ki ste jih implementirali od 27. vaje naprej.
 Razsirite abstraktni razred TableModel tako, da bo omogocal vnasanje seznama objektov z njihovimi (vsaj dvemi) lastnostmi, ki ste jih implementirali.

*/
// importamo potrebne pakete
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

// naredimo class
public class VoziloTableModel extends DefaultTableModel {
    private String[] columnNames = {"znamka", "tip vozila",  "kapaciteta goriva", "barva vozila", "kapaciteta oseb"};
    private ArrayList<Vozilo> SeznamVozil;

    // vrne stevilo stolpcev
    public int getColumnCount() {
        return columnNames.length;
    }

    // konstruktor
public VoziloTableModel()
{   super();
    SeznamVozil = new ArrayList<Vozilo>();
    addColumn("tip vozila");
    addColumn("znamka");
    addColumn("kapaciteta goriva");
    addColumn("barva vozila");
    addColumn("kapaciteta oseb");
    
}

//     // vrne stevilo vrstic - stevilo steklenic v seznamu
//     public int getRowCount() {
//         int size;
//         if (SeznamVozil == null) {
//             size = 0;
//         } else {
//             size = SeznamVozil.size();
//         }
//         return size;
//     }

//     public Object getValueAt(int row, int col) {
//         Object temp = null;
//         if (col == 0) {
//             temp = SeznamVozil.get(row).gettipVozila();
//         } else if (col == 1) {
//             temp = SeznamVozil.get(row).getznamkaVozila();
//         } else if (col == 2) {
//             temp = new Integer(SeznamVozil.get(row).getKolicinaGoriva());
//         } else if (col == 3) {
//             temp = SeznamVozil.get(row).getbarvaVozila();
//         } else if (col == 4) {
//             temp = new Integer(SeznamVozil.get(row).getkapacitetaOseb());
//         }
//         return temp;
//     }

//     // needed to show column names in JTable
//     public String getColumnName(int col) {
//         return columnNames[col];
//     }

//    public Class getColumnClass(int col) {
//       if (col == 2) {
//          return Integer.class;
//       }
//         else if (col == 4) {

//             return Integer.class;
//       }
//       else {
//          return String.class;
//       } }
// dodamo metodo za dodajanje steklenic



  // metoda za dodajanje vozila na seznam
   public void addVozilo(Vozilo v)
   {
       // doda vozilo na seznam
    SeznamVozil.add(v);
    // dodamo vrednosti v tabelo
    Object[] vrstica = new Object[] {v.gettipVozila(), v.getznamkaVozila(), ""+v.getKolicinaGoriva(), v.getbarvaVozila(), ""+v.getkapacitetaOseb()};
    for  (int c=0; c<vrstica.length; c++)
   {
      System.out.println(c + "stolpec:" + vrstica[c]+ "tip:" + vrstica[c].getClass());
   }
    addRow(vrstica);

    // obvesti o spremembi
    fireTableDataChanged();
     

   }
   }
