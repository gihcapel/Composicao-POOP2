package table;

import javax.swing.table.AbstractTableModel;

import entity.Vagao;

import java.util.List;

/**
 * 
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza Moraes
 *
 * Classe que cria uma tabela para armazenar os vagões
 */
public class VagaoTableModel extends AbstractTableModel {

    //Componentes da classe
    private static final int COL_ID = 0;
    private static final int COL_TIPO = 1;
    private static final int COL_SUBTIPO = 2;
    private static final int COL_BITOLA = 3;
    private static final int COL_PROPRIETARIO = 4;
    private List<Vagao> valores;

    //Construtor parametrizado com a lista de vagões
    public VagaoTableModel(List<Vagao> valores) {
        this.valores = valores;
    }

    //Obtém a quantidade de linhas
    public int getRowCount() {
        return valores.size();
    }

    //Obtém a quantidade de colunas
    public int getColumnCount() {
        return 5;
    }

    //Método que instancia vagão e obtém as informações de acordo com a coluna
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

    //Método que obtém o nome da coluna
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

    //Método que obtém a classe referente à coluna
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
        } else if (columnIndex == COL_PROPRIETARIO) {
            return String.class;
        }
        return null;
    }

    //Método que obtém os valores na linha
    public Vagao get(int row) {
        return valores.get(row);
    }
}
