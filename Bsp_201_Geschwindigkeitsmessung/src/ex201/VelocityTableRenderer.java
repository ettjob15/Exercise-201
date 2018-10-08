package ex201;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class VelocityTableRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        int col = table.convertColumnIndexToModel(column);

        if (col == 5) {
            if (Integer.parseInt(value.toString()) > 30) {
                setBackground(Color.RED);
            } else if (Integer.parseInt(value.toString()) <= 30 && Integer.parseInt(value.toString()) > 20) {
                setBackground(Color.ORANGE);
            } else if (Integer.parseInt(value.toString()) <= 20 && Integer.parseInt(value.toString()) > 10) {
                setBackground(Color.YELLOW);
            } else if (Integer.parseInt(value.toString()) <= 10) {
                setBackground(Color.BLUE);
            }
        } else {
            setBackground(Color.WHITE);
        }

        if (isSelected) {
            setForeground(Color.BLACK);
            setBackground(Color.GREEN);
        }

        return comp;
    }

}
