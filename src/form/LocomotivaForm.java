package form;
/**
 * 
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza Moraes
 *
 * Classe de formulario da locomotiva
 */

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

public class LocomotivaForm extends JFrame {

	private JLabel lbClasse, lbDescricao,  lbPesoMaxReboc,  lbPesoMaxLoc, lbBitola, lbComprimento;
	private JTextField txtClasse, txtDescricao, txtPesoMaxReboc, txtPesoMaxLoc, txtBitola, txtComprimento;
	private JPanel panelAdd, panelTable, panelButtons;
	private JButton btnNew, btnSave, btnUpdate, btnRemove, btnCancel;
	private JTable table;
	private JScrollPane scrollPane;

	private JLabel nLocomotivas;

	private List<Locomotiva> LocomotivaList;
	private Long idLocomotiva;

	//Construtor da janela de cadastro de locomotivas
	public LocomotivaForm() throws HeadlessException {
		super("Cadastro de Locomotivas");
		//Propriedades da janela como botão para fechar e redimensionamento
		setContentPane(new JPanel());
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Criação do painel e características como título, tamanho e posição
		panelAdd = new JPanel(new MigLayout());
		panelAdd.setBorder(BorderFactory.createTitledBorder("Adicionar Locomotivas"));
		panelAdd.setBounds(5, 0, 480, 200);
		//Título das labels
		lbClasse = new JLabel("Classe");
		lbDescricao = new JLabel("Descricao");
		lbPesoMaxReboc = new JLabel("Peso Max Rebocavel");
		lbPesoMaxLoc= new JLabel ("Peso Max Loc:");
		lbBitola = new JLabel("Bitola (m):");
		lbComprimento = new JLabel("Comprimento:");

		//Campo de texto
		txtClasse = new JTextField(50);
		txtDescricao = new JTextField(50);
		txtBitola = new JTextField(50);
		txtPesoMaxReboc= new JTextField(50);;
		txtPesoMaxLoc = new JTextField(50);;
		txtComprimento = new JTextField(50);;
		//Todas as labels e campos de texto são adicionados ao painel
		panelAdd.add(lbClasse);
		panelAdd.add(txtClasse, "span, growx");

		panelAdd.add(lbDescricao);
		panelAdd.add(txtDescricao, "span, growx");

		panelAdd.add(lbPesoMaxReboc);
		panelAdd.add(txtPesoMaxReboc, "span, growx");

		panelAdd.add(lbPesoMaxLoc);
		panelAdd.add(txtPesoMaxLoc, "span, growx");

		panelAdd.add(lbBitola);
		panelAdd.add(txtBitola, "growx");


		panelAdd.add(lbComprimento);
		panelAdd.add(txtComprimento, "span, growx");


		nLocomotivas = new JLabel("0");
		panelAdd.add(nLocomotivas, "wrap para");
		//Painel de botões é criado com características como título, tamanho e posição


		panelButtons = new JPanel(new MigLayout());
		panelButtons.setBorder(BorderFactory.createEtchedBorder());
		panelButtons.setBounds(5, 205, 480, 40);

		//Botões são criados
		btnNew = new JButton("Novo");
		btnSave = new JButton("Salvar");
		btnCancel = new JButton("Cancelar");
		btnRemove = new JButton("Remover");
		btnUpdate = new JButton("Atualizar");

		//Botões são adicionados ao painel

		panelButtons.add(btnNew, "gapleft 10");
		panelButtons.add(btnCancel);
		panelButtons.add(btnSave, "gap unrelated");
		panelButtons.add(btnUpdate, "gap unrelated");
		panelButtons.add(btnRemove);
		//Painel da tabela de locomotivas é criado com características como título, tamanho e posição
		panelTable = new JPanel(new MigLayout());
		panelTable.setBorder(BorderFactory.createTitledBorder("Lista de Locomotivas"));
		panelTable.setBounds(5, 250, 480, 240);
		//Nova tabela
		table = new JTable();
		//Barra de rolagem
		scrollPane = new JScrollPane(table);
		//Barra de rolagem é adicionada ao painel
		panelTable.add(scrollPane);

		refreshTable();
		enableFields(false);
		//Adiciona os paineis de botão e de tabela ao painel principal
		add(panelAdd);
		add(panelButtons);
		add(panelTable);
		//Insere a dimensão da janela e visibilidade
		setMinimumSize(new Dimension(500,600));
		setVisible(true);
		//Métodos que adicionam evento aos botões
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
	//Método para remover alguma locomotiva previamente adicionada
	private void onRemoverLocomotiva() {
		int rowIndex = table.getSelectedRow();

		if (rowIndex == -1) {
			JOptionPane.showMessageDialog(this, "Selecione o Locomotiva a ser removido!");
			return;
		}

		Locomotiva Locomotiva = new LocomotivaTableModel(LocomotivaList).get(rowIndex);

		int confirm = JOptionPane.showConfirmDialog(this, "Confirmar exclusÃ£o?", "Excluir Locomotiva", JOptionPane.YES_NO_OPTION);

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
	//Método para alterar alguma locomotiva previamente adicionada
	private void onAlterarLocomotiva() {
		int rowIndex = table.getSelectedRow();

		if (rowIndex == -1) {
			JOptionPane.showMessageDialog(this, "Selecione o Locomotiva a ser alterado!");
			return;
		}

		Locomotiva locomotiva = new LocomotivaTableModel(LocomotivaList).get(rowIndex);

		idLocomotiva = locomotiva.getId();

		txtClasse.setText(locomotiva.getClasse());
		txtDescricao.setText(locomotiva.getDescricao());
		txtBitola.setText(locomotiva.getBitolaLoc());
		txtPesoMaxReboc.setText(locomotiva.getPesoMaxRebocavel());
		txtComprimento.setText(locomotiva.getComprimentoLoc());
		txtPesoMaxLoc.setText(locomotiva.getPesoMaxLoc());
		enableFields(true);
	}
	//Método para adicionar nova locomotiva
	private void onNovoLocomotiva() {
		enableFields(true);
	}
	//Método para salvar a locomotiva adicionada
	private void onSaveLocomotiva() {
		Locomotiva locomotiva = new Locomotiva();

		if (txtClasse.getText().length() > 0 && txtDescricao.getText().length() > 0 && txtBitola.getText().length() > 0) {
			locomotiva.setClasse(txtClasse.getText());
			locomotiva.setDescricao(txtDescricao.getText());
			locomotiva.setBitolaLoc(txtBitola.getText());
			locomotiva.setPesoMaxRebocavel(txtPesoMaxReboc.getText());
			locomotiva.setComprimentoLoc(txtComprimento.getText());
			locomotiva.setPesoMaxLoc(txtPesoMaxLoc.getText());
		} else {
			JOptionPane.showMessageDialog(this, "Todos os campos sÃ£o obrigatÃ³rios!");
			return;
		}

		int result = 0;
		if (idLocomotiva == null) {
			result = new LocomotivaController().addLocomotiva(locomotiva);
		} else {
			locomotiva.setId(idLocomotiva);
			result = new LocomotivaController().alterarLocomotiva(locomotiva);
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
	//Método para cancelar a adição de uma nova locomotiva
	private void onCancelar() {
		txtClasse.setText("");
		txtDescricao.setText("");
		txtBitola.setText("");
		txtPesoMaxReboc.setText("");
		txtComprimento.setText("");
		txtPesoMaxLoc.setText("");
		enableFields(false);
	}
	//Método para habilitar os campos de texto para digitação
	private void enableFields(boolean b) {
		txtClasse.setEnabled(b);
		txtDescricao.setEnabled(b);
		txtBitola.setEnabled(b);
		txtPesoMaxReboc.setEnabled(b);
		txtComprimento.setEnabled(b);
		txtPesoMaxLoc.setEnabled(b);

	}
	//Método para atualizar a tabela e mostrar as novas adições, remoções ou alterações
	private void refreshTable() {
		LocomotivaList = new LocomotivaController().findlocomotivas();
		nLocomotivas.setText(String.valueOf(LocomotivaList.size()));
		if (LocomotivaList != null) {
			table.setModel(new LocomotivaTableModel(LocomotivaList));
			table.setDefaultRenderer(Object.class, new LocomotivaCellRenderer());
		}
	}
}
