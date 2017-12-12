package form;

import java.awt.*;
import java.awt.GridLayout;

import javax.swing.*;

/**
 * 
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza Moraes
 *
 * Classe da janela de menu
 *
 * A classe contém botões que abrem o cadastro de locomotivas, cadastro de
 * vagões e cadastro de composições
 */
public class JanelaMenu extends JFrame {

    //Um novo painel que deve conter as informações é criado dentro da janela
    JPanel painel = new JPanel();

    //Componentes da classe JanelaMenu
    private JButton btnCadastrarLocomotiva, btnCadastrarVagao, btnCadastrarComposicao;

    public JanelaMenu() {
        super("Menu");

        //Botões do menu
        btnCadastrarLocomotiva = new JButton("Locomotivas");
        btnCadastrarVagao = new JButton("Vagões");
        btnCadastrarComposicao = new JButton("Composições");

        painel.setLayout(new GridLayout(7, 2, 5, 5)); //painel com 7 linhas, 2 colunas e 5 de distância 
        painel.setBackground(Color.WHITE); //Fundo branco

        //Botões são adicionados no painel
        painel.add(btnCadastrarLocomotiva);
        painel.add(btnCadastrarVagao);
        painel.add(btnCadastrarComposicao);
        pack();

        //Propriedades da janela como botão para fechar e redimensionamento
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(painel);

        //Métodos que adicionam ações aos botões
        btnCadastrarLocomotiva.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocomotivaForm l = new LocomotivaForm();
                l.setVisible(true);
                l.setSize(680, 480);
                l.setLocation(300, 300);
            }
        });

        btnCadastrarVagao.addActionListener(new java.awt.event.ActionListener() {
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


