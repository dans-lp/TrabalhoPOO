package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Dados;

class DadosTest {


	@Test
	void testSomaDados() {
		Dados dado = new Dados();
		int resultadodadsoma = dado.SomaDados();
		assertTrue( resultadodadsoma <= 12);
	}

	@Test
	void testejogaDado1() {
		
		Dados dado1 = new Dados();
		int resultadodado1 = dado1.jogaDado1();
		assertTrue( resultadodado1 <= 12);
		
		
	}
	@Test
void testejogaDado2() {
		Dados dado2 = new Dados();
		int resultadodado2 = dado2.jogaDado1();
		assertTrue( resultadodado2 <= 12);
		
		
	}


}
