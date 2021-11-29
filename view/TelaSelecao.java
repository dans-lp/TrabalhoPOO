package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

	class TelaSelecao implements ActionListener {
	
	Toolkit tk=Toolkit.getDefaultToolkit();
	Dimension screenSize=tk.getScreenSize();
	
	JFrame frame = new JFrame();
	JButton dois =new JButton("2-Padrão");
	JButton quatro =new JButton("4-Comp");
	JButton quatroDupla = new JButton ("4-Duplas");
	JLabel NomeGame = new JLabel ("LATITUDE 90");
	JLabel selecao = new JLabel("Selecione a Quantidade de jogadores");
	
	TelaSelecao(){
		final int LARG_DEFAULT=1200;
		final int ALT_DEFAULT=700;
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_DEFAULT/2;
		int y=sa/2-ALT_DEFAULT/2;
		
		//Dois Jogaroes
		
		dois.setBounds(x+180, y+70,100, 35);
		dois.setFocusable(false);//desnecessario
		
		//Quatro jogadores
		
		quatroDupla.setBounds(x+180, y+120,100, 35);
		quatroDupla.setFocusable(false);//desnecessario
	
		quatro.setBounds(x+180, y+170,100, 35);
		quatro.setFocusable(false);//desnecessario
		
		
		//NOme Game
		NomeGame.setBounds(x+155, y-100,200, 35);
		NomeGame.setFont(new Font(null,Font.PLAIN,25));
		
		//PErgunta
		selecao.setBounds(x+50, y,900, 35);
		selecao.setFont(new Font(null,Font.PLAIN,25));
		
		
		//ADICIONANDO 
		frame.add(NomeGame);
		frame.add(selecao);
		frame.add(dois);
		frame.add(quatro);
		frame.add(quatroDupla);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200,700);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==dois){
			frame.dispose();
			DesenhaTabuleiro desenha = new DesenhaTabuleiro(1);
		}
		
	}
	
	
	

}
