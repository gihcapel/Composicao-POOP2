import dao.Connect;
import form.JanelaMenu;
import form.VagaoForm;

public class Main {
    public static void main(String[] args) {
        Connect.createTable();
        JanelaMenu janelamenu = new JanelaMenu();
        janelamenu.setSize(500,500);
        janelamenu.setLocation(300,300);
        janelamenu.show();
    }
}
