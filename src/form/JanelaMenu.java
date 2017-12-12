package form;
import java.awt.*;
import java.awt.GridLayout;

import javax.swing.*;

public class JanelaMenu extends JFrame{ 

		//Um novo painel que deve conter as informações é criado dentro da janela
		JPanel painel= new JPanel();

		//Componentes da classe JanelaMenu
		private JButton btnCadastrarLocomotiva, btnCadastrarVagao, btnCadastrarComposicao;

		public JanelaMenu(){
			super("Composi��o Ferrovi�ria"); //Título da janela

			//Botões do menu
			btnCadastrarLocomotiva = new JButton("Locomotivas");
			btnCadastrarVagao = new JButton("Vag�es");
			btnCadastrarComposicao = new JButton("Composi��es");

			painel.setLayout(new GridLayout(7, 2, 5, 5)); //painel com 7 linhas, 2 colunas e 5 de distância 
			painel.setBackground(Color.WHITE); //Fundo branco


			//Botões são adicionados no paínel
			painel.add(btnCadastrarLocomotiva);
			painel.add(btnCadastrarVagao);
			painel.add(btnCadastrarComposicao);
			pack();

			setResizable(false); //Janela não pode mudar de tamanho
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Botão X fecha a janela
			setContentPane(painel);

			//Métodos que adicionam ações aos botões
			btnCadastrarLocomotiva.addActionListener(new java.awt.event.ActionListener(){
				@Override
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					LocomotivaForm l = new LocomotivaForm();
					l.setVisible(true);
					l.setSize(680,480);
					l.setLocation(300,300);
				}                            
			});
			

			btnCadastrarVagao.addActionListener(new java.awt.event.ActionListener(){
				@Override
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					VagaoForm v = new VagaoForm();
					v.setVisible(true);
				}                            
			});

			/*btnCadastrarComposicao.addActionListener(new java.awt.event.ActionListener(){
				@Override
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					JanelaComposicao c = new JanelaComposicao();
					c.setVisible(true);
					c.setSize(680,480);
					c.setLocation(300,300);

				}                            
			});
		}*/
	}
}



