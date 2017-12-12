package form;
import java.awt.*;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

import dao.ArrayListLocomotiva;
import dao.ArrayListVagao;
import entity.Composicao;


import java.awt.*;
import java.awt.GridLayout;

import javax.swing.*;

/**
 * 
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza Moraes
 *
 * Classe da janela de menu
 *
 * A classe cont�m bot�es que abrem o cadastro de locomotivas, cadastro de
 * vag�es e cadastro de composi��es
 */
public class JanelaMenu extends JFrame {

    //Um novo painel que deve conter as informa��es � criado dentro da janela
    JPanel painel = new JPanel();

    //Componentes da classe JanelaMenu
    private JButton btnCadastrarLocomotiva, btnCadastrarVagao, btnCadastrarComposicao;

    public JanelaMenu() {
        super("Menu");

        //Bot�es do menu
        btnCadastrarLocomotiva = new JButton("Locomotivas");
        btnCadastrarVagao = new JButton("Vag�es");
        btnCadastrarComposicao = new JButton("Composi��es");

        painel.setLayout(new GridLayout(7, 2, 5, 5)); //painel com 7 linhas, 2 colunas e 5 de dist�ncia 
        painel.setBackground(Color.WHITE); //Fundo branco

        //Bot�es s�o adicionados no painel
        painel.add(btnCadastrarLocomotiva);
        painel.add(btnCadastrarVagao);
        painel.add(btnCadastrarComposicao);
        pack();

        //Propriedades da janela como bot�o para fechar e redimensionamento
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(painel);

        //M�todos que adicionam a��es aos bot�es
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
        btnCadastrarComposicao.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					ArrayList vagoesselecionados = new ArrayList();
					ArrayList locomotivasselecionadas = new ArrayList();
					ArrayListVagao vagoesdisponiveis;
			    	vagoesdisponiveis= ArrayListVagao.getInstance();
			    	ArrayList locomotivasaleatorias = new ArrayList();
			    	ArrayListLocomotiva locomotivasdisponiveis;
			    	locomotivasdisponiveis= ArrayListLocomotiva.getInstance();
			    	int qtdvagao, qtdlocomotiva, i=2, p=1;
			    	Scanner t= new Scanner (System.in);
			    	System.out.println("Quantos vag�es voc� deseja?");
			    	qtdvagao= t.nextInt();
			    	System.out.println("Esses s�o os vag�es disponiveis");
			    	System.out.println(vagoesdisponiveis.toString());
			    	System.out.println("Escolha o vag�o");
			    	int vagaoindex= t.nextInt();
			    	String bitola= vagoesdisponiveis.getVagoesdisponiveis().get(vagaoindex).getBitola();
			    	while (i<qtdvagao){
			    		System.out.println("Escolha o vag�o");
			    		int vagaoindexdois= t.nextInt();
			    		if(vagoesdisponiveis.getVagoesdisponiveis().get(vagaoindexdois).getBitola() == bitola){
			    		vagoesselecionados.add(vagoesdisponiveis.getVagoesdisponiveis().get(vagaoindexdois));
			    		i++;
			    		}
			    		else 
			    			System.out.println("Vagoes devem possuir a mesma bitola");
			    	}
			    	System.out.println("Quantas locomotivas voc� deseja?");
			    	qtdlocomotiva= t.nextInt();
			    	System.out.println("Essas s�o as locomotivas disponiveis");
			    	System.out.println(locomotivasdisponiveis.toString());
			    	while (p<qtdlocomotiva){
			    		System.out.println("Escolha o vag�o");
			    		int locomotivaindexdois= t.nextInt();
			    		if(locomotivasdisponiveis.getLocomotivasdisponiveis().get(locomotivaindexdois).getBitolaLoc()== bitola){
			    		locomotivasselecionadas.add(locomotivasdisponiveis.getLocomotivasdisponiveis().get(locomotivaindexdois));
			    		p++;
			    	}
			    		else
			    			System.out.println("Locomotivas devem possuir a mesma bitola");
			    	
				} 
			    	Composicao composicao= new Composicao(locomotivasselecionadas, vagoesselecionados);
			    	System.out.println(composicao);
				}                            
			});
		}
}



