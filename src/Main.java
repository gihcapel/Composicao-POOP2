import dao.Connect;
import form.JanelaMenu;

/**
 *
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza Moraes
 *
 * Classe main para testar todas as funções
 */
public class Main {

    public static void main(String[] args) {
        Connect.createTable();
        JanelaMenu janelamenu = new JanelaMenu();
        janelamenu.setSize(300, 300);
        janelamenu.setLocation(0, 300);
        janelamenu.show();
    }
}
