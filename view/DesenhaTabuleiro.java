package view;

import javax.swing.JPanel;


import javax.swing.JFrame;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;

public class DesenhaTabuleiro extends JPanel implements MouseListener{
	private Image tabuleiro;
	private Image dado1[] = new Image[6];
	private Image dado2[]=new Image[6];
	private Image cartas[] = new Image[18]; 
	private int coordCasa[][] =new int[146][4];
	private Shape ret[] = new Shape[147];
	private Ellipse2D peao[];
	private int modoJogo;
	
	public DesenhaTabuleiro(int modoJogo) {
		
		coordCasa = montaCoordCasa();
		CarregaTabuleiro();
		addMouseListener(this);
		// CarregaDados();
		// CarregaCartas();
		this.modoJogo = modoJogo;
		JFrame janela = new JFrame("Latitude 90");
		setBackground(Color.BLACK);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.getContentPane().add(this);
		janela.setSize(860,730);
		janela.setVisible(true);
		
		
	}
	/*TROCAR CAMINHO DAS IMAGENS*/
	public void CarregaTabuleiro() {
		
		try {
            tabuleiro = ImageIO.read(new File("Tabuleiro_1.jpg"));
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
		
	}
	
	public void CarregaDados() {
		for(int i=0; i<6;i++) {
			try {
	            dado1[i] = ImageIO.read(new File("Dado"+ (i+1)+".png"));
	        }
	        catch(IOException e) {
	            System.out.println(e.getMessage());
	            System.exit(1);
	        }
			try {
	            dado2[i] = ImageIO.read(new File("die_face_"+ (i+1)+".png"));
	        }
	        catch(IOException e) {
	            System.out.println(e.getMessage());
	            System.exit(1);
	        }
		}
			
	}
	
	public void CarregaCartas() {
		
		 for(int i = 0; i <= 8; i++){
			 try {
		            cartas[i] = ImageIO.read(new File("C0"+ (i+1)+".png"));
		        }
		        catch(IOException e) {
		            System.out.println(e.getMessage());
		            System.exit(1);
		        }
		    }

		    for(int j = 9; j<=17; j++){
		    	try {
		            cartas[j] = ImageIO.read(new File("C"+ (j+1)+".png"));
		        }
		        catch(IOException e) {
		            System.out.println(e.getMessage());
		            System.exit(1);
		        }
		    }
	}
	
	private int[][] montaCoordCasa(){
		int lista[][] = {{182, 277, 72, 43}, {154, 300, 24, 20}, {154, 278, 24, 20}, {158, 261 , 26, 20},
					    {186, 235, 26, 20}, {221, 227, 26, 20}, {256, 240, 26, 20}, {257, 278, 22, 20}, // 4
						{257, 300, 22, 20}, {244, 338, 20, 22}, {222, 346, 22, 20}, {195, 340, 22, 20}, // 8
						{179, 325, 22, 20}, {127, 301, 24, 35}, {127, 263, 24, 35}, {132, 243, 38, 20}, // 12
						{170, 207, 38, 20}, {223, 195, 38, 20}, {276, 211, 38, 20}, {285, 262, 24, 35}, // 16
						{285, 300, 24, 35}, {260, 364, 36, 24}, {221, 376, 36, 24}, {182, 368, 36, 24}, // 20
						{153, 341, 36, 23}, { 99, 301, 24, 52}, { 99, 246, 24, 52}, {102, 227, 60, 20}, // 24
						{154, 180, 60, 20}, {222, 162, 60, 20}, {291, 183, 60, 20}, {312, 246, 24, 52}, // 28
						{312, 300, 24, 52}, {276, 391, 60, 22}, {219, 414, 60, 22}, {165, 398, 60, 22}, // 32
						{124, 358, 60, 22}, { 72, 301, 24, 66}, { 72, 232, 24, 66}, {76, 210,  75, 20}, // 36
						{138, 152, 75, 20}, {221, 129, 75, 20}, {307, 156, 75, 20}, {339, 230, 24, 66}, // 40
						{339, 300, 24, 66}, {293, 420, 80, 22}, {219, 440, 80, 22}, {150, 424, 80, 22}, // 44
						{ 97, 375, 60, 22}, { 44, 301, 24, 83}, { 44, 215, 24, 83}, { 47, 194, 90, 20}, // 48
						{121, 122, 90, 20}, {221,  99, 90, 20}, {325, 129, 90, 20}, {366, 214, 24, 83}, // 52
						{366, 300, 24, 83}, {308, 450, 90, 24}, {219, 477, 90, 24}, {133, 452, 90, 24}, // 56
						{ 69, 391, 80, 22}, { 16, 301, 24, 98}, { 16, 200, 24, 98}, { 20, 176,100, 20}, // 60
						{108, 95, 100, 20}, {221, 67, 100, 20}, {340, 103, 100,20}, {393, 198, 24, 98}, // 64
						{394, 300, 24, 98}, {324, 476, 90, 24}, {220, 504, 90, 24}, {118, 478, 90, 24}, // 68
						{ 42, 404, 90, 24}, // 72
						{585, 276, 72, 43}, {557, 300, 24, 20}, {557, 277, 24, 20}, {579, 239, 22, 20},
						{590, 235, 22, 20}, {625, 224, 22, 20}, {660, 235, 22, 20}, {661, 277, 22, 20},
						{661, 300, 22, 20}, {648, 336, 22, 20}, {626, 346, 22, 20}, {601, 341, 20, 22},
						{583, 326, 20, 22}, {530, 300, 24, 35}, {530, 261, 24, 35}, {559, 233},
						{601, 212}, {649, 211}, {684, 234}, {688, 261, 24, 35},
						{688, 300, 24, 35}, {684, 353}, {645, 380}, {599, 386},
						{560, 363}, {503, 300, 24, 52}, {503, 245, 24, 52}, {536, 210},
						{591, 178}, {653, 178}, {707, 212}, {716, 245, 24, 52},
						{716, 299, 24, 52}, {708, 384}, {653, 415}, {591, 415},
						{539, 387}, {476, 300, 24, 66}, {476, 231, 24, 66}, {513, 188},
						{585, 149}, {661, 149},	 {730, 187}, {743, 229, 24, 66},
						{743, 299, 24, 66}, {731, 406}, {661, 446}, {584, 448},
						{517, 412}, {449, 300, 24, 83}, {449, 214, 24, 83}, {443, 162},
						{575, 117}, {669, 115}, {752, 166}, {771, 213, 24, 83},
						{771, 299, 24, 83}, {754, 428}, {670, 479}, {575, 479},
						{497, 436}, {422, 300, 24, 98}, {422, 199, 24, 98}, {469, 141},
						{572,  89}, {677,  90}, {774, 142}, {798, 197, 24, 98},
						{798, 299, 24, 98}, {775, 453}, {677, 507}, {567, 508},
						{476, 463}};
		return lista;
	}
		
	private void CarregarCasas() {
        ret[0] = plotaRet(coordCasa[0][0], coordCasa[0][1], coordCasa[0][2], coordCasa[0][3], 0);
        
        for (int i=1; i<73; i+=6) {
        	ret[i] = plotaRet(coordCasa[i][0], coordCasa[i][1], coordCasa[i][2], coordCasa[i][3], 0);
            ret[i+1] = plotaRet(coordCasa[i+1][0], coordCasa[i+1][1], coordCasa[i+1][2], coordCasa[i+1][3], 0);
        }
        for (int i=3; i<64; i+=12) {
        	ret[i] = plotaRet(coordCasa[i][0], coordCasa[i][1], coordCasa[i][2], coordCasa[i][3], -45);
    		ret[i+1] = plotaRet(coordCasa[i+1][0], coordCasa[i+1][1], coordCasa[i+1][2], coordCasa[i+1][3], -15);
    		ret[i+6] = plotaRet(coordCasa[i+6][0], coordCasa[i+6][1], coordCasa[i+6][2], coordCasa[i+6][3], -45);
    		ret[i+1+6] = plotaRet(coordCasa[i+1+6][0], coordCasa[i+1+6][1], coordCasa[i+1+6][2], coordCasa[i+1+6][3], -15);
        }
        for(int i=5; i<66; i+=12) {
        	ret[i] = plotaRet(coordCasa[i][0], coordCasa[i][1], coordCasa[i][2], coordCasa[i][3], 15);
        	ret[i+1] = plotaRet(coordCasa[i+1][0], coordCasa[i+1][1], coordCasa[i+1][2], coordCasa[i+1][3], 45);
        	ret[i+6] = plotaRet(coordCasa[i+6][0], coordCasa[i+6][1], coordCasa[i+6][2], coordCasa[i+6][3], 15);
    		ret[i+1+6] = plotaRet(coordCasa[i+1+6][0], coordCasa[i+1+6][1], coordCasa[i+1+6][2], coordCasa[i+1+6][3], 50);
        }
        
        ret[73] = plotaRet(coordCasa[73][0], coordCasa[73][1], coordCasa[73][2], coordCasa[73][3], 0);
        
        for (int i=74; i<146; i+=6) {
        	ret[i] = plotaRet(coordCasa[i][0], coordCasa[i][1], coordCasa[i][2], coordCasa[i][3], 0);
            ret[i+1] = plotaRet(coordCasa[i+1][0], coordCasa[i+1][1], coordCasa[i+1][2], coordCasa[i+1][3], 0);
        }
		
	}
	
	private void CarregaPeao(int modoJogo, Graphics2D g2d){
		int x ,y, raio = 8;
		switch (modoJogo) {
		case 1: //modo padrao
			peao = new Ellipse2D[12];	
			x = 0;
			y = 0;
				
			for(int i =0;i<6;i++) {
				g2d.setColor(Color.BLACK);
				peao[i] = new Ellipse2D.Double(187+x,275+y,raio, raio);
				x+=raio;
				y+=raio;
				g2d.draw(peao[i]);
	        	g2d.fill(peao[i]);
					
			}
			x = 0;
			y = 0;
			for(int j=6; j<12;j++) {
				g2d.setColor(Color.BLUE);
				peao[j] = new Ellipse2D.Double(587+x,275+y,raio,raio);
				x+=raio;
				y+=raio;
				g2d.draw(peao[j]);
	        	g2d.fill(peao[j]);
				
			}
			break;
		case 2: 
			peao = new Ellipse2D[24];
			x = 0;
			y = 0;
				
			for(int i =0;i<12;i++) {
					
				g2d.setColor(Color.BLACK);
				if(i>=6){
					g2d.setColor(Color.GREEN);
					if (i==6) {
						y = -15;
						x = 20;
					}
				}
				peao[i] = new Ellipse2D.Double(187+x,275+y,raio,raio);
				x+=raio;
				y+=raio;
				g2d.draw(peao[i]);
	        	g2d.fill(peao[i]);
					
			}
			x = 0;
			y = 0;
			for(int j=12; j<24;j++) {
				g2d.setColor(Color.BLUE);
				if(j>=18) {
					g2d.setColor(Color.YELLOW);
					if (j==18) {
						y = -15;
						x = 20;
					}
				}
				peao[j] = new Ellipse2D.Double(587+x,275+y, raio, raio);
				x+=raio;
				y+=raio;
				g2d.draw(peao[j]);
	        	g2d.fill(peao[j]);
				
			}
			break;
		case 3:
			peao = new Ellipse2D[24];
			x = 0;
			y = 0;
				
			for(int i =0;i<12;i++) {
					
				g2d.setColor(Color.BLACK);
				if(i>=6){
					g2d.setColor(Color.GREEN);
					if (i==6) {
						y = -15;
						x = 20;
					}
				}
				peao[i] = new Ellipse2D.Double(187+x,275+y,raio,raio);
				x+=raio;
				y+=raio;
				g2d.draw(peao[i]);
	        	g2d.fill(peao[i]);
					
			}
			x = 0;
			y = 0;
			for(int j=12; j<24;j++) {
				g2d.setColor(Color.BLUE);
				if(j>=18) {
					g2d.setColor(Color.YELLOW);
					if (j==18) {
						y = -15;
						x = 20;
					}
				}
				peao[j] = new Ellipse2D.Double(587+x,275+y, raio, raio);
				x+=raio;
				y+=raio;
				g2d.draw(peao[j]);
	        	g2d.fill(peao[j]);
				
			}
			break;
		default:
			
		}
	}
	
	private static Shape plotaRet(int coordX, int coordY, int largura, int altura, int anguloRot){
		
		Rectangle2D newRet = new Rectangle2D.Double(coordX, coordY, largura, altura);
		AffineTransform tx = new AffineTransform();
		tx = AffineTransform.getRotateInstance(Math.toRadians(anguloRot), coordX, coordY);
		Shape retRotated = tx.createTransformedShape(newRet);
		
		return retRotated;
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        g.drawImage(tabuleiro, 0, 0, null);
        // g.drawImage(dado1[0],100,100,null);
        // g.drawImage(dado2[0],150,150,null);
        // g.drawImage(cartas[11],200,200,null);
        
        Graphics2D g2d =(Graphics2D) g;
        g2d.setColor(Color.RED);
        CarregarCasas();
     // Retangulo das cartas
        ret[146] = new Rectangle2D.Double(360, 581, 123, 108);
     // Mudar para ret.length
        for (int i=0; i<73; i++) {
        	g2d.draw(ret[i]);
        	g2d.fill(ret[i]);
        }
        CarregaPeao(modoJogo, g2d);
        
        

    }
	
	/*APAGAR A MAIN SO PARA TESTE*/
	public static void main(String[] args) {
		DesenhaTabuleiro tab = new DesenhaTabuleiro(3);
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		for (int i=1; i<73; i+=6) {
			if (ret[i].contains(x, y))
				System.out.println("Voce clicou na casa " + i + ".\n\n");
			if (ret[i+1].contains(x, y))
				System.out.println("Voce clicou na casa " + (i+1) + ".\n\n");
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}

}
