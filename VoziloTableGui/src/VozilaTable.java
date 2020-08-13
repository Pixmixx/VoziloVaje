/*  
 * Vaja:36
Avtor: Matjaz Kic
Naloga: Graficni uporabniski vmesnik razsirite tako, da bo (preko metod) omogocal tudi spreminjanje lastnosti objektov poslovne logike iz prejsnje naloge.
*/

// uvozimo paket swing
import javax.swing.*;

// uvozimo paket za delo z dogodki
import java.awt.event.*;

// uvozimo paket za delo s tabelami
import javax.swing.table.*;

// Deklariramo javni razred VozilaTable ki implementira vmesnik action listener
public class VozilaTable extends DefaultTableModel implements ActionListener {

    // Definiramo atribute/lastnosti

    private JFrame okno;
    private JPanel povrsina;
    private JLabel besedilo;
    private JButton gumb;
    private JTextField vnosnoPolje;
    private JTextField vnosnoPolje2;
    private JTextField vnosnoPolje3;
    private JTextField vnosnoPolje4;
    private JTextField vnosnoPolje5;
    private JTable tabela;
    private VoziloTableModel modelTabele;
    private JButton btnNewButton;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblZaUrejenjeVrstic;

    // Staticna metoda, ki se zazene ob zacetku
    public static void main(String[] args) {

        // Ce je stevilo argumentov vsaj 1
        if (args.length > 0) {
            System.out.println("1. argument je :" + args[0]);
            // Objekt (lokalna spremenljivka) tipa Miza
            VozilaTable m = new VozilaTable(args[0]);

        } else {
            System.out.println("Program je bil zagnan brez argumentov");
        }

    }

    // konstruktor
    /**
     * @wbp.parser.entryPoint
     */
    public VozilaTable(String naslov) {
        // inicializiramo okno
        okno = new JFrame(naslov);

        // ustvarimo povrsino
        povrsina = new JPanel();

        // Ustvarimo vnosno polje
        vnosnoPolje = new JTextField(20);
        vnosnoPolje2 = new JTextField(16);
        vnosnoPolje3 = new JTextField(16);
        vnosnoPolje4 = new JTextField(16);
        vnosnoPolje5 = new JTextField(16);

        // ustvarimo okence z besedilo
        besedilo = new JLabel(" ");

        // ustvarimo model tabele
        // modelTabele = new DefaultTableModel();
        modelTabele = new VoziloTableModel();
        // dodamo stolpec modelu tabele
        // modelTabele.addColumn("Znamka Piva");

        // ustvarimo tabelo na podlagi modela, ki smo ga ustvarili
        tabela = new JTable(modelTabele);

        // dodamo povrsino v okno
        okno.getContentPane().add(povrsina);

        // Dodamo okence na površino
        povrsina.add(besedilo);

        // nastavimo velikost okna
        okno.setSize(600, 400);

        lblNewLabel = new JLabel("Tip Vozila:");
        povrsina.add(lblNewLabel);

        // dodamo polje na povrsino
        // JLabel("znamka vozila");
        povrsina.add(vnosnoPolje);

        lblNewLabel_1 = new JLabel("Znamka Vozila:");
        lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
        povrsina.add(lblNewLabel_1);
        // JLabel("Tip vozila");
        povrsina.add(vnosnoPolje2);

        lblNewLabel_2 = new JLabel("Kapaciteta Goriva:");
        povrsina.add(lblNewLabel_2);
        // JLabel("gorivo vozila");
        povrsina.add(vnosnoPolje3);

        lblNewLabel_3 = new JLabel("Barva Vozila:");
        povrsina.add(lblNewLabel_3);
        // JLabel("barva vozila");
        povrsina.add(vnosnoPolje4);

        lblNewLabel_4 = new JLabel("Max Kapaciteta oseb v Vozilu:");
        povrsina.add(lblNewLabel_4);
        // JLabel("oseb v vozila");
        povrsina.add(vnosnoPolje5);

        // inicializiramo gumb

        gumb = new JButton("Pritisni za vnos");

        // gumbu dolocimo poslusalca dogodkov
        gumb.addActionListener(this);

        // dodamo gumb na povrsino
        povrsina.add(gumb);

        btnNewButton = new JButton("Uredi");
        povrsina.add(btnNewButton);

        lblZaUrejenjeVrstic = new JLabel(
                "Za urejenje vrstic, kliknite na zeleno vrstico in nato vnesite nove podatke v polja in pritisnite uredi.");
        povrsina.add(lblZaUrejenjeVrstic);

        // dodamo tabelo na povrsino
        povrsina.add(tabela);

        // metoda, ki okno prikaže
        okno.setVisible(true);

        // Nastavimo delovanje tako, da se ob zapiranju okna ustavi tudi program
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // implementiramo metodo, ki jo predpisuje vmesnik
    public void actionPerformed(ActionEvent e) {

        System.out.println("Vsebina vnosnega polja: " + vnosnoPolje.getText());

        // dodamo vrstico v tabelo
        // modelTabele.addRow(vrstica);

        // modelTabele.addVozilo(new Vozilo("audi ", vnosnoPolje.getText(), 50, "camo",
        // 5));

        // dodamo vrednosti v tabelo
        modelTabele.addVozilo(
                new Vozilo(vnosnoPolje2.getText(), vnosnoPolje.getText(), Integer.parseInt(vnosnoPolje3.getText()),
                        vnosnoPolje4.getText(), Integer.parseInt(vnosnoPolje5.getText())));
        addColumn("tip");
        addColumn("znamka");
        addColumn("kapaciteta goriva");
        addColumn("barva vozila");
        addColumn("kapaciteta oseb");

        // pocistimo vnosno polje
        vnosnoPolje.setText("");
        vnosnoPolje2.setText("");
        vnosnoPolje3.setText("");
        vnosnoPolje4.setText("");
        vnosnoPolje5.setText("");

        // metoda za spreminjanje vrstice
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // zamenjamo vrednosti
                tabela.setValueAt(vnosnoPolje.getText(), tabela.getSelectedRow(), 0);
                tabela.setValueAt(vnosnoPolje2.getText(), tabela.getSelectedRow(), 1);
                tabela.setValueAt(vnosnoPolje3.getText(), tabela.getSelectedRow(), 2);
                tabela.setValueAt(vnosnoPolje4.getText(), tabela.getSelectedRow(), 3);
                tabela.setValueAt(vnosnoPolje5.getText(), tabela.getSelectedRow(), 4);

            }
        });
        /*
         * private void actionPerformedMouse(ActionEvent e) {
         * vnosnoPolje.setText(tabela.getValueAt(tabela.getSelectedRow(),
         * 0).toString());
         * vnosnoPolje2.setText(tabela.getValueAt(tabela.getSelectedRow(),
         * 1).toString());
         * vnosnoPolje3.setText(tabela.getValueAt(tabela.getSelectedRow(),
         * 2).toString());
         * vnosnoPolje4.setText(tabela.getValueAt(tabela.getSelectedRow(),
         * 3).toString());
         * vnosnoPolje5.setText(tabela.getValueAt(tabela.getSelectedRow(),
         * 4).toString());
         * 
         * };
         */
    };

    /*
     * private void mouseClicked (ActionEvent m) {
     * 
     * 
     * vnosnoPolje.setText(tabela.getValueAt(tabela.getSelectedRow(),
     * 0).toString());
     * vnosnoPolje2.setText(tabela.getValueAt(tabela.getSelectedRow(),
     * 1).toString());
     * vnosnoPolje3.setText(tabela.getValueAt(tabela.getSelectedRow(),
     * 2).toString());
     * vnosnoPolje4.setText(tabela.getValueAt(tabela.getSelectedRow(),
     * 3).toString());
     * vnosnoPolje5.setText(tabela.getValueAt(tabela.getSelectedRow(),
     * 4).toString()); };
     * 
     * 
     */

}
