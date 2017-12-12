package form;


import net.miginfocom.swing.MigLayout;
import table.VagaoCellRenderer;
import table.VagaoTableModel;

import javax.swing.*;

import controller.VagaoController;
import entity.Vagao;

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
public class VagaoForm extends JFrame {

    private JLabel lbTipo, lbSubtipo, lbBitola, lbBitolaMetro, lbComprimento, lbPesoMax, lbProprietario;
    private JTextField txtTipo, txtSubtipo, txtBitola, txtBitolaMetro, txtComprimento, txtPesoMax, txtProprietario;;
    private JPanel panelAdd, panelTable, panelButtons;
    private JButton btnNew, btnSave, btnUpdate, btnRemove, btnCancel,btnValidate;
    private JTable table;
    private JScrollPane scrollPane;

    private JLabel nVagaos;

    private List<Vagao> VagaoList;
    private Long idVagao;

    public VagaoForm() throws HeadlessException {
        super("Cadastro de Vagaos");
        setContentPane(new JPanel());
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelAdd = new JPanel(new MigLayout());
        panelAdd.setBorder(BorderFactory.createTitledBorder("Adicionar Vagaos"));
        panelAdd.setBounds(5, 0, 480, 200);

        lbTipo = new JLabel("Tipo");
        lbSubtipo = new JLabel("Subtipo");
        lbBitola = new JLabel("Bitola");
        lbProprietario= new JLabel ("Proprietario:");
        lbBitolaMetro = new JLabel("Bitola (m):");
        lbComprimento = new JLabel("Comprimento:");
        lbPesoMax= new JLabel ("Peso Max (t):");
        
        

        txtTipo = new JTextField(50);
        txtSubtipo = new JTextField(50);
        txtBitola = new JTextField(50);
        txtProprietario= new JTextField(50);;
        txtBitolaMetro = new JTextField(50);;
        txtComprimento = new JTextField(50);;
        txtPesoMax= new JTextField(50);;

        panelAdd.add(lbTipo);
        panelAdd.add(txtTipo, "span, growx");

        panelAdd.add(lbSubtipo);
        panelAdd.add(txtSubtipo, "span, growx");

        panelAdd.add(lbBitola);
        panelAdd.add(txtBitola, "growx");
        
        panelAdd.add(lbProprietario);
        panelAdd.add(txtProprietario, "span, growx");
        
        panelAdd.add(lbBitolaMetro);
        panelAdd.add(txtBitolaMetro, "span, growx");
        
        panelAdd.add(lbComprimento);
        panelAdd.add(txtComprimento, "span, growx");
        
        panelAdd.add(lbPesoMax);
        panelAdd.add(txtPesoMax, "span, growx");

        nVagaos = new JLabel("0");
        panelAdd.add(nVagaos, "wrap para");

        panelButtons = new JPanel(new MigLayout());
        panelButtons.setBorder(BorderFactory.createEtchedBorder());
        panelButtons.setBounds(5, 205, 480, 40);

       
        btnNew = new JButton("NOVO");
        btnSave = new JButton("Salvar");
        btnCancel = new JButton("Cancelar");
        btnRemove = new JButton("Remover");
        btnUpdate = new JButton("Atualizar");
		btnValidate = new JButton("Validar");

        panelButtons.add(btnNew, "gapleft 10");
        panelButtons.add(btnCancel);
        panelButtons.add(btnSave, "gap unrelated");
        panelButtons.add(btnUpdate, "gap unrelated");
        panelButtons.add(btnRemove);
        panelButtons.add(btnValidate);

        panelTable = new JPanel(new MigLayout());
        panelTable.setBorder(BorderFactory.createTitledBorder("Lista de Vagaos"));
        panelTable.setBounds(5, 250, 480, 240);

        table = new JTable();

        scrollPane = new JScrollPane(table);

        panelTable.add(scrollPane);

        refreshTable();
        enableFields(false);

        add(panelAdd);
        add(panelButtons);
        add(panelTable);
        setMinimumSize(new Dimension(500,600));
        setVisible(true);

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onSaveVagao();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancelar();
            }
        });

        btnNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onNovoVagao();
            }
        });

        btnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRemoverVagao();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAlterarVagao();
            }
        });
		btnValidate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onValidate();
            }
        });
    }

    private void onRemoverVagao() {
        int rowIndex = table.getSelectedRow();

        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Selecione o Vagao a ser removido!");
            return;
        }

        Vagao Vagao = new VagaoTableModel(VagaoList).get(rowIndex);

        int confirm = JOptionPane.showConfirmDialog(this, "Confirmar exclusão?", "Excluir Vagao", JOptionPane.YES_NO_OPTION);

        if (confirm != 0) {
            return;
        }

        int result = new VagaoController().excluirVagao(Vagao.getId());

        if (result == 1) {
            JOptionPane.showMessageDialog(this, "Valor removido com sucesso!");
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(this, "Tente novamente!");
        }
    }

    private void onAlterarVagao() {
        int rowIndex = table.getSelectedRow();

        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Selecione o Vagao a ser alterado!");
            return;
        }

        Vagao vagao = new VagaoTableModel(VagaoList).get(rowIndex);

        idVagao = vagao.getId();

        txtTipo.setText(vagao.getTipo());
        txtSubtipo.setText(vagao.getSubtipo());
        txtBitola.setText(vagao.getBitola());
        txtBitolaMetro.setText(vagao.getBitolaMetro());
        txtComprimento.setText(vagao.getComprimento());
        txtBitola.setText(vagao.getBitola());
        txtProprietario.setText(vagao.getProprietario());
        enableFields(true);
    }

    private void onNovoVagao() {
        enableFields(true);
    }
	private void onValidate(){
		if (txtTipo.getText().length() > 0 && txtSubtipo.getText().length() > 0 && txtBitola.getText().length() > 0) {
		String tipos = "GPTFIHAC";
		if(tipos.indexOf(txtTipo.getText().charAt(0))!=-1){
				if(txtTipo.getText().equals("G")){
						if(!txtSubtipo.getText().equals("D") || !txtSubtipo.getText().equals("P") || !txtSubtipo.getText().equals("F") || !txtSubtipo.getText().equals("M") || !txtSubtipo.getText().equals("T") || !txtSubtipo.getText().equals("S") || !txtSubtipo.getText().equals("H") || !txtSubtipo.getText().equals("C") || !txtSubtipo.getText().equals("B") || !txtSubtipo.getText().equals("N") || !txtSubtipo.getText().equals("Q")) {
						JOptionPane.showMessageDialog(this, "Tudo certo!");	
						}else {
							JOptionPane.showMessageDialog(this, "Subtipo inválido");
						}
					}else if(txtTipo.getText().equals("P")){
						 if(!txtSubtipo.getText().equals("M") || !txtSubtipo.getText().equals("E") || !txtSubtipo.getText().equals("D") || !txtSubtipo.getText().equals("C") || !txtSubtipo.getText().equals("R") || !txtSubtipo.getText().equals("T") || !txtSubtipo.getText().equals("G") || !txtSubtipo.getText().equals("P") || !txtSubtipo.getText().equals("B") || !txtSubtipo.getText().equals("A") || !txtSubtipo.getText().equals("N") || !txtSubtipo.getText().equals("Q")) {
							JOptionPane.showMessageDialog(this, "Tudo certo!");	
						 }else {
								JOptionPane.showMessageDialog(this, "Subtipo inválido");
						 }
					}else if(txtTipo.getText().equals("T")){
						 if(!txtSubtipo.getText().equals("C") || !txtSubtipo.getText().equals("S") || !txtSubtipo.getText().equals("P") || !txtSubtipo.getText().equals("F") || !txtSubtipo.getText().equals("A") || !txtSubtipo.getText().equals("G") || !txtSubtipo.getText().equals("N") || !txtSubtipo.getText().equals("Q")) {
							JOptionPane.showMessageDialog(this, "Tudo certo!");	
						 }else {
								JOptionPane.showMessageDialog(this, "Subtipo inválido");
						 }
					}else if(txtTipo.getText().equals("F")){
						 if(!txtSubtipo.getText().equals("R") || !txtSubtipo.getText().equals("S") || !txtSubtipo.getText().equals("M") || !txtSubtipo.getText().equals("E") || !txtSubtipo.getText().equals("H") || !txtSubtipo.getText().equals("L") || !txtSubtipo.getText().equals("P") || !txtSubtipo.getText().equals("V") || !txtSubtipo.getText().equals("N") || !txtSubtipo.getText().equals("Q")) {
							JOptionPane.showMessageDialog(this, "Tudo certo!");	
						 }else {
								JOptionPane.showMessageDialog(this, "Subtipo inválido");
						 }
					}else if(txtTipo.getText().equals("I")){
						 if(!txtSubtipo.getText().equals("C") || !txtSubtipo.getText().equals("F") || !txtSubtipo.getText().equals("N") || !txtSubtipo.getText().equals("Q")) {
							JOptionPane.showMessageDialog(this, "Tudo certo!");	
						 }else {
								JOptionPane.showMessageDialog(this, "Subtipo inválido");
						 }
					}else if(txtTipo.getText().equals("H")){
						 if(!txtSubtipo.getText().equals("F") || !txtSubtipo.getText().equals("P") || !txtSubtipo.getText().equals("E") || !txtSubtipo.getText().equals("T") || !txtSubtipo.getText().equals("A") || !txtSubtipo.getText().equals("N") || !txtSubtipo.getText().equals("Q")) {
							JOptionPane.showMessageDialog(this, "Tudo certo!");	
						 }else {
								JOptionPane.showMessageDialog(this, "Subtipo inválido");
						 }
					}else if(txtTipo.getText().equals("A")){
						 if(!txtSubtipo.getText().equals("C") || !txtSubtipo.getText().equals("M") || !txtSubtipo.getText().equals("R") || !txtSubtipo.getText().equals("V") || !txtSubtipo.getText().equals("D") || !txtSubtipo.getText().equals("N") || !txtSubtipo.getText().equals("Q")) {
							JOptionPane.showMessageDialog(this, "Tudo certo!");	
						 }else {
								JOptionPane.showMessageDialog(this, "Subtipo inválido");
						 }
					}else if(txtTipo.getText().equals("C")){
						 if(!txtSubtipo.getText().equals("C") || !txtSubtipo.getText().equals("B") || !txtSubtipo.getText().equals("N") || !txtSubtipo.getText().equals("Q")) {
							 JOptionPane.showMessageDialog(this, "Tudo certo!");
						 }else {
							JOptionPane.showMessageDialog(this, "Subtipo inválido");
						 }
					}else{
						JOptionPane.showMessageDialog(this, "Tipo inválido");
					}
	} else {JOptionPane.showMessageDialog(this, "Tipo inválido");
            
        }
	}else{
		JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios!");
		return;
	}
	}
    private void onSaveVagao() {
        Vagao vagao = new Vagao();
      	vagao.setTipo(txtTipo.getText());
		vagao.setSubtipo(txtSubtipo.getText());
		vagao.setBitola(txtBitola.getText());
		vagao.setBitolaMetro(txtBitolaMetro.getText());
		vagao.setComprimento(txtComprimento.getText());
		vagao.setPesoMax(txtPesoMax.getText());
		vagao.setProprietario(txtProprietario.getText());
		int result = 0;
        if (idVagao == null) {
            result = new VagaoController().addVagao(vagao);
        } else {
            vagao.setId(idVagao);
            result = new VagaoController().alterarVagao(vagao);
            idVagao = null;
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
        txtTipo.setText("");
        txtSubtipo.setText("");
        txtBitola.setText("");
        txtBitolaMetro.setText("");
        txtComprimento.setText("");
        txtPesoMax.setText("");
        txtProprietario.setText("");
        enableFields(false);
    }

    private void enableFields(boolean b) {
        txtTipo.setEnabled(b);
        txtSubtipo.setEnabled(b);
        txtBitola.setEnabled(b);
        txtBitolaMetro.setEnabled(b);
        txtProprietario.setEnabled(b);
        txtComprimento.setEnabled(b);
        txtPesoMax.setEnabled(b);
    }

    private void refreshTable() {
        VagaoList = new VagaoController().findvagoes();
        nVagaos.setText(String.valueOf(VagaoList.size()));
        if (VagaoList != null) {
            table.setModel(new VagaoTableModel(VagaoList));
            table.setDefaultRenderer(Object.class, new VagaoCellRenderer());
        }
    }
}
