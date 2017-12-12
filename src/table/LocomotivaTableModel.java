package table;

import javax.swing.table.AbstractTableModel;

import entity.Locomotiva;

import java.util.List;

/**
 * 
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza Moraes
 *
 * Classe que cria uma tabela para armazenar as locomotivas
 */
public class LocomotivaTableModel extends AbstractTableModel {

    //Componentes da classe
    private static final int COL_ID = 0;
    private static final int COL_CLASSE = 1;
    private static final int COL_DESCRICAO = 2;
    private static final int COL_PESOMAXREBOC = 3;
    private static final int COL_PESOMAXLOC = 4;
    private static final int COL_BITOLA = 5;
    private static final int COL_COMPRIMENTO = 6;
    private List<Locomotiva> valores;
    
    //Construtor parametrizado com a lista de locomotivas
    public LocomotivaTableModel(List<Locomotiva> valores) {
        this.valores = valores;
    }

    //Obtém a quantidade de linhas
    public int getRowCount() {
        return valores.size();
    }

    //Obtém a quantidade de colunas
    public int getColumnCount() {
        return 7;
    }

    //Método que instancia locomotiva e obtém as informações de acordo com a coluna
    public Object getValueAt(int rowIndex, int columnIndex) {
        Locomotiva Locomotiva = valores.get(rowIndex);
        if (columnIndex == COL_ID) {
            return Locomotiva.getId();
        } else if (columnIndex == COL_CLASSE) {
            return Locomotiva.getClasse();
        } else if (columnIndex == COL_DESCRICAO) {
            return Locomotiva.getDescricao();
        } else if (columnIndex == COL_PESOMAXREBOC) {
            return Locomotiva.getPesoMaxRebocavel();
        } else if (columnIndex == COL_PESOMAXLOC) {
            return Locomotiva.getPesoMaxLoc();
        } else if (columnIndex == COL_BITOLA) {
            return Locomotiva.getBitolaLoc();
        } else if (columnIndex == COL_COMPRIMENTO) {
            return Locomotiva.getComprimentoLoc();
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
            case COL_CLASSE:
                coluna = "Classe";
                break;
            case COL_DESCRICAO:
                coluna = "Descrição";
                break;
            case COL_PESOMAXREBOC:
                coluna = "PESO";
                break;
            case COL_PESOMAXLOC:
                coluna = "PESOLOC";
                break;
            case COL_BITOLA:
                coluna = "BITOLA";
                break;
            case COL_COMPRIMENTO:
                coluna = "COMPRIMENTO";
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
        } else if (columnIndex == COL_CLASSE) {
            return String.class;
        } else if (columnIndex == COL_DESCRICAO) {
            return String.class;
        } else if (columnIndex == COL_PESOMAXREBOC) {
            return String.class;
        } else if (columnIndex == COL_PESOMAXLOC) {
            return String.class;
        } else if (columnIndex == COL_BITOLA) {
            return String.class;
        } else if (columnIndex == COL_COMPRIMENTO) {
            return String.class;
        }
        return null;
    }

    //Método que obtém os valores na linha
    public Locomotiva get(int row) {
        return valores.get(row);
    }
}