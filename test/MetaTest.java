package test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Meta;

class MetaTest {

	@Test
	void testMetaDisponivel() {
		Meta meta = new Meta();
		boolean  metadisp = meta.metaDisponivel();
		assertTrue(metadisp == true);
	}

}
