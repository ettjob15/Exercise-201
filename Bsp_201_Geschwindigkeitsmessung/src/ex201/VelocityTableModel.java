package ex201;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.table.AbstractTableModel;

public class VelocityTableModel extends AbstractTableModel {

    private ArrayList<Measurement> liste;
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public VelocityTableModel() {
        this.liste = new ArrayList();
    }

    public void add(Measurement measure) {
        liste.add(measure);
        liste.sort(new Comparator<Measurement>() {

            @Override
            public int compare(Measurement o1, Measurement o2) {
                if (o1.getUeberschreitung() < o2.getUeberschreitung()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        this.fireTableDataChanged();
    }

    public void remove(int index[]) {
        for (int i = 0; i < index.length; i++) {
            liste.remove(0);
            this.fireTableDataChanged();
            index[0] = i;
        }
    }

    public int average() {
        int average = 0;
        for (int i = 0; i < liste.size(); ++i) {
            average += liste.get(i).getUeberschreitung();
        }
        average /= liste.size();
        return average;
    }

    public ArrayList<Measurement> getList() {
        return liste;
    }

    private String[] col = {"Datum", "Uhrzeit", "Kennzeichen", "Gemessen", "Erlaubt", "Übertretung"};

    @Override
    public int getRowCount() {
        return liste.size();
    }

    @Override
    public int getColumnCount() {
        return col.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Measurement measure = liste.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return measure.getDatum().format(dtf);
            case 1:
                return measure.getUhrzeit();
            case 2:
                return measure.getKennzeichen();
            case 3:
                return measure.getsGem();
            case 4:
                return measure.getsErl();
            case 5:
                return measure.getUeberschreitung();
            default:
                return "ERROR! Es geht nix mehr!";
        }
    }

    @Override
    public String getColumnName(int column) {
        return col[column];
    }

    void save(File f) throws IOException {
        DAL dal = new DAL();
        dal.save(liste, f);
    }

    void load(File f) throws IOException, ClassNotFoundException {
        DAL dal = new DAL();
        liste = dal.load(f);
        this.fireTableDataChanged();
    }

}
