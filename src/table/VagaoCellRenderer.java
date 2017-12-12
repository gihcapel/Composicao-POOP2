package table;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 31/03/13
 * Time: 04:19
 * http://www.mballem.com/
 */
public class VagaoCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (row % 2 == 0) {
            setBackground(Color.YELLOW);
        } else {
            setBackground(null);
        }

        if (isSelected) {
            setBackground(Color.GREEN);
        }

        table.getColumnModel().getColumn(0).setMaxWidth(50);
        table.getColumnModel().getColumn(1).setMaxWidth(400);
        table.getColumnModel().getColumn(2).setMaxWidth(500);
        table.getColumnModel().getColumn(3).setMaxWidth(200);

        return this;
    }
}
