package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

	class TelaInicial implements ActionListener{
	
	
	Toolkit tk=Toolkit.getDefaultToolkit();
	Dimension screenSize=tk.getScreenSize();
	JFrame frame = new JFrame("Latitude 90");
	JButton dois =new JButton("2-Padrão");
	JButton quatro =new JButton("4-Comp");
	JButton quatroDupla = new JButton ("4-Duplas");
	JLabel NovoJogo = new JLabel ("Novo Jogo: ");
	JButton carregar = new JButton ("Carregar");
	JLabel NomeGame = new JLabel ("LATITUDE 90");
	
	public TelaInicial(){
		
		final int LARG_DEFAULT=1200;
		final int ALT_DEFAULT=700;
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_DEFAULT/2;
		int y=sa/2-ALT_DEFAULT/2;
		
		// Novo Jogo
		NovoJogo.setBounds(x+180, y+70,250, 35);
		NovoJogo.setFont(new Font(null,Font.PLAIN,20));
	
		
		//Butao Carregar
		
		carregar.setBounds(x+180, y+120,100, 35);
		carregar.setFocusable(false);//desnecessario
		
		//bt2
		dois.setBounds(x+288, y+70,100, 35);
		dois.setFocusable(false);//desnecessario
		dois.addActionListener((ActionListener) this);
		
		//bt 4 dupla
		
		quatroDupla.setBounds(x+400, y+70,100, 35);
		quatroDupla.setFocusable(false);//desnecessario
		quatroDupla.addActionListener((ActionListener) this);
		
		//bt 4 comp
		quatro.setBounds(x+512, y+70,100, 35);
		quatro.setFocusable(false);//desnecessario
		quatro.addActionListener((ActionListener) this);
		
		//Nome do jogo
		
		NomeGame.setBounds(x+155, y,200, 35);
		NomeGame.setFont(new Font(null,Font.PLAIN,25));
		
		//ADICIONANDO 
		frame.add(NovoJogo);
		frame.add(carregar);
		frame.add(NomeGame);
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
			//TelaSelecao telaSelecao =new TelaSelecao();
			DesenhaTabuleiro desenha = new DesenhaTabuleiro(1);
		}
		if(e.getSource()==quatroDupla){
			frame.dispose();
			//TelaSelecao telaSelecao =new TelaSelecao();
			DesenhaTabuleiro desenha = new DesenhaTabuleiro(2);
		}
		if(e.getSource()==quatro){
			frame.dispose();
			//TelaSelecao telaSelecao =new TelaSelecao();
			DesenhaTabuleiro desenha = new DesenhaTabuleiro(3);
		}

		
		
		
		
		
		
	}
}
