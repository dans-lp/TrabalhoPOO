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
	JButton NovoJogo = new JButton ("Novo Jogo");
	JButton carregar = new JButton ("Carregar");
	JLabel NomeGame = new JLabel ("LATITUDE 90");
	
	TelaInicial(){
		
		final int LARG_DEFAULT=1200;
		final int ALT_DEFAULT=700;
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_DEFAULT/2;
		int y=sa/2-ALT_DEFAULT/2;
		
		//Butao Novo Jogo
		NovoJogo.setBounds(x+180, y+70,100, 35);
		NovoJogo.setFocusable(false);//desnecessario
		NovoJogo.addActionListener((ActionListener) this);
		
		//Butao Carregar
		
		carregar.setBounds(x+180, y+120,100, 35);
		carregar.setFocusable(false);//desnecessario
		
		//Nome do jogo
		
		NomeGame.setBounds(x+155, y,200, 35);
		NomeGame.setFont(new Font(null,Font.PLAIN,25));
		
		//ADICIONANDO 
		frame.add(NovoJogo);
		frame.add(carregar);
		frame.add(NomeGame);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200,700);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==NovoJogo){
			frame.dispose();
			TelaSelecao telaSelecao =new TelaSelecao();
			
		}
		
		
		
		
		
		
	}
}
