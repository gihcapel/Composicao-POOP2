package table;



import javax.swing.table.AbstractTableModel;

import entity.Vagao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 31/03/13
 * Time: 02:01
 * http://www.mballem.com/
 */
public class VagaoTableModel extends AbstractTableModel {

    private static final int COL_ID = 0;
    private static final int COL_TIPO = 1;
    private static final int COL_SUBTIPO = 2;
    private static final int COL_BITOLA = 3;
    private static final int COL_PROPRIETARIO = 4;

    private List<Vagao> valores;

    public VagaoTableModel(List<Vagao> valores) {
        this.valores = valores;
    }

    public int getRowCount() {
        return valores.size();
    }

    public int getColumnCount() {
        return 5;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Vagao Vagao = valores.get(rowIndex);
        if (columnIndex == COL_ID) {
            return Vagao.getId();
        } else if (columnIndex == COL_TIPO) {
            return Vagao.getTipo();
        } else if (columnIndex == COL_SUBTIPO) {
            return Vagao.getSubtipo();
        } else if (columnIndex == COL_BITOLA) {
            return Vagao.getBitola();
        } else if (columnIndex == COL_PROPRIETARIO) {
            return Vagao.getProprietario();
        }
        
        return null;
    }

    @Override
    public String getColumnName(int column) {
        String coluna = "";
        switch (column) {
            case COL_ID:
                coluna = "Código";
                break;
            case COL_TIPO:
                coluna = "TIPO";
                break;
            case COL_SUBTIPO:
                coluna = "SUBTIPO";
                break;
            case COL_BITOLA:
                coluna = "BITOLA";
                break;
            case COL_PROPRIETARIO:
                coluna = "PROPRIETARIO";
                break;
            default:
                throw new IllegalArgumentException("Coluna inválida!");
        }
        return coluna;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == COL_ID) {
            return Long.class;
        } else if (columnIndex == COL_TIPO) {
            return String.class;
        } else if (columnIndex == COL_SUBTIPO) {
            return String.class;
        } else if (columnIndex == COL_BITOLA) {
            return String.class;
        }
        else if (columnIndex == COL_PROPRIETARIO) {
            return String.class;
        }
        return null;
    }

    public Vagao get(int row) {
        return valores.get(row);
    }
}
