package form;


import net.miginfocom.swing.MigLayout;
import table.LocomotivaCellRenderer;
import table.LocomotivaTableModel;

import javax.swing.*;

import controller.LocomotivaController;
import entity.Locomotiva;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 31/03/13
 * Time: 02:15
 * http://www.mballem.com/
 */
public class LocomotivaForm extends JFrame {

    private JLabel lbEditora, lbTitulo, lbIsbn;
    private JTextField txtEditora, txtTitulo, txtIsbn;
    private JPanel panelAdd, panelTable, panelButtons;
    private JButton btnNew, btnSave, btnUpdate, btnRemove, btnCancel;
    private JTable table;
    private JScrollPane scrollPane;

    private JLabel nLocomotivas;

    private List<Locomotiva> LocomotivaList;
    private Long idLocomotiva;

    public LocomotivaForm() throws HeadlessException {
        super("Cadastro de Locomotivas");
        setContentPane(new JPanel());
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelAdd = new JPanel(new MigLayout());
        panelAdd.setBorder(BorderFactory.createTitledBorder("Adicionar Locomotivas"));
        panelAdd.setBounds(5, 0, 480, 100);

        lbEditora = new JLabel("Editora");
        lbTitulo = new JLabel("Título");
        lbIsbn = new JLabel("ISBN");

        txtEditora = new JTextField(50);
        txtTitulo = new JTextField(50);
        txtIsbn = new JTextField(15);

        panelAdd.add(lbEditora);
        panelAdd.add(txtEditora, "span, growx");

        panelAdd.add(lbTitulo);
        panelAdd.add(txtTitulo, "span, growx");

        panelAdd.add(lbIsbn);
        panelAdd.add(txtIsbn, "growx");

        nLocomotivas = new JLabel("0");
        panelAdd.add(nLocomotivas, "wrap para");

        panelButtons = new JPanel(new MigLayout());
        panelButtons.setBorder(BorderFactory.createEtchedBorder());
        panelButtons.setBounds(5, 105, 480, 40);

       
        btnNew = new JButton("NOVO");
        btnSave = new JButton("Salvar");
        btnCancel = new JButton("Cancelar");
        btnRemove = new JButton("Remover");
        btnUpdate = new JButton("Atualizar");

        panelButtons.add(btnNew, "gapleft 90");
        panelButtons.add(btnCancel);
        panelButtons.add(btnSave, "gap unrelated");
        panelButtons.add(btnUpdate, "gap unrelated");
        panelButtons.add(btnRemove);

        panelTable = new JPanel(new MigLayout());
        panelTable.setBorder(BorderFactory.createTitledBorder("Lista de Locomotivas"));
        panelTable.setBounds(5, 150, 480, 240);

        table = new JTable();

        scrollPane = new JScrollPane(table);

        panelTable.add(scrollPane);

        refreshTable();
        enableFields(false);

        add(panelAdd);
        add(panelButtons);
        add(panelTable);
        setMinimumSize(new Dimension(500,420));
        setVisible(true);

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onSaveLocomotiva();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancelar();
            }
        });

        btnNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onNovoLocomotiva();
            }
        });

        btnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRemoverLocomotiva();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAlterarLocomotiva();
            }
        });
    }

    private void onRemoverLocomotiva() {
        int rowIndex = table.getSelectedRow();

        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Selecione o Locomotiva a ser removido!");
            return;
        }

        Locomotiva Locomotiva = new LocomotivaTableModel(LocomotivaList).get(rowIndex);

        int confirm = JOptionPane.showConfirmDialog(this, "Confirmar exclusão?", "Excluir Locomotiva", JOptionPane.YES_NO_OPTION);

        if (confirm != 0) {
            return;
        }

        int result = new LocomotivaController().excluirLocomotiva(Locomotiva.getId());

        if (result == 1) {
            JOptionPane.showMessageDialog(this, "Valor removido com sucesso!");
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(this, "Tente novamente!");
        }
    }

    private void onAlterarLocomotiva() {
        int rowIndex = table.getSelectedRow();

        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Selecione o Locomotiva a ser alterado!");
            return;
        }

        Locomotiva Locomotiva = new LocomotivaTableModel(LocomotivaList).get(rowIndex);

        idLocomotiva = Locomotiva.getId();

        txtEditora.setText(Locomotiva.getEditora());
        txtTitulo.setText(Locomotiva.getTitulo());
        txtIsbn.setText(Locomotiva.getIsbn());

        enableFields(true);
    }

    private void onNovoLocomotiva() {
        enableFields(true);
    }

    private void onSaveLocomotiva() {
        Locomotiva Locomotiva = new Locomotiva();

        if (txtEditora.getText().length() > 0 && txtTitulo.getText().length() > 0 && txtIsbn.getText().length() > 0) {
            Locomotiva.setEditora(txtEditora.getText());
            Locomotiva.setTitulo(txtTitulo.getText());
            Locomotiva.setIsbn(txtIsbn.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios!");
            return;
        }

        int result = 0;
        if (idLocomotiva == null) {
            result = new LocomotivaController().addLocomotiva(Locomotiva);
        } else {
            Locomotiva.setId(idLocomotiva);
            result = new LocomotivaController().alterarLocomotiva(Locomotiva);
            idLocomotiva = null;
        }

        if (result == 1) {
            JOptionPane.showMessageDialog(this, "Valor inserido com sucesso!");
            enableFields(false);
            onCancelar();
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(this, "Tente novamente!");
        }
    }

    private void onCancelar() {
        txtEditora.setText("");
        txtTitulo.setText("");
        txtIsbn.setText("");
        enableFields(false);
    }

    private void enableFields(boolean b) {
        txtEditora.setEnabled(b);
        txtTitulo.setEnabled(b);
        txtIsbn.setEnabled(b);
    }

    private void refreshTable() {
        LocomotivaList = new LocomotivaController().findlocomotivas();
        nLocomotivas.setText(String.valueOf(LocomotivaList.size()));
        if (LocomotivaList != null) {
            table.setModel(new LocomotivaTableModel(LocomotivaList));
            table.setDefaultRenderer(Object.class, new LocomotivaCellRenderer());
        }
    }
}
