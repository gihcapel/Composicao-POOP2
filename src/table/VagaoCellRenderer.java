package table;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * 
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza Moraes
 *
 * Classe que renderiza a tabela de vagões
 */
public class VagaoCellRenderer extends DefaultTableCellRenderer {

    //Obtém os componentes do render da tabela, dando instruções de cor e tamanho
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (row % 2 == 0) {
            setBackground(Color.YELLOW);
        } else {
            setBackground(null);
        }
        //deixa verde a linha selecionada
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