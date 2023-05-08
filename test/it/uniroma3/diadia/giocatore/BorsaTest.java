package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {

	Borsa b = new Borsa();
	Borsa b1 = new Borsa();
	Borsa b2 = new Borsa();
	Attrezzo falce;
	Attrezzo sega;
	Attrezzo piedediporco;
	Attrezzo piuma;
	Attrezzo libro;
	Attrezzo ps;
	Attrezzo piombo;
	
	@Before
	public void setUp() {
		falce = new Attrezzo("falce", 2);
		sega = new Attrezzo("sega", 16);
		piedediporco = new Attrezzo("piedediporco", 2);
		piuma = new Attrezzo("piuma", 1);
		piombo = new Attrezzo("piombo", 10);
		libro = new Attrezzo("libro", 5);
		ps = new Attrezzo("ps", 5);
	}

	@Test
	public void testAddAttrezzoPesoMinoreDiDieci() {
		assertTrue(b.addAttrezzo(falce));

	}
	
	@Test
	public void testAddAttrezzoPesoMaggioreDiDieci() {
		assertFalse(b.addAttrezzo(sega));

	}
	
	@Test
	public void testGetPeso() {
		b.addAttrezzo(falce);
		assertEquals(falce, b.getAttrezzo("falce"));

	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPesoAttrezziStessoPeso() {  //piedediporco peso 2, falce peso 2
		assertTrue(b1.addAttrezzo(piedediporco));
		assertTrue(b1.addAttrezzo(falce));
		Set<Attrezzo> expected = new TreeSet<>(new ComparatoreAttrezziPerPeso());
		expected.add(falce);
		expected.add(piedediporco);
		assertArrayEquals(expected.toArray(), b1.getSortedSetOrdinatoPerPeso().toArray());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPesoAttrezziDiversiPesoDiverso() {
		assertTrue(b2.addAttrezzo(piombo));
		assertTrue(b2.addAttrezzo(piuma));
		Set <Attrezzo> expected = new TreeSet<>(new ComparatoreAttrezziPerPeso());
		expected.add(piombo);
		expected.add(piuma);
		assertArrayEquals(expected.toArray(), b2.getSortedSetOrdinatoPerPeso().toArray());
	
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoPesiDiversi() {
		assertTrue(b2.addAttrezzo(falce));
		assertTrue(b2.addAttrezzo(libro));
		Set <Attrezzo> expected = new TreeSet<>(new ComparatoreAttrezziPerPeso());
		expected.add(falce);
		expected.add(libro);
		assertArrayEquals(expected.toArray(), b2.getContenutoOrdinatoPerPeso().toString());
		
	}
}
