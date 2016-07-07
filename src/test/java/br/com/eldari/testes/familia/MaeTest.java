package br.com.eldari.testes.familia;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.eldari.testes.familia.Filha;
import br.com.eldari.testes.familia.Mae;


@RunWith(MockitoJUnitRunner.class)
public class MaeTest
{
	private static final String NOME_MAE = "Maria";
	private static final String NOME_FILHA = "Ana";

	private Mae mae;

	@Before
	public void setUp()
	{
		mae = new Mae(NOME_MAE);
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarMaeSemNome()
	{
		new Mae(null);
	}

	@Test
	public void deveSeApresentarSemFilha()
	{
		assertNull(mae.getFilha());
		assertEquals(NOME_MAE + ", sem filha", mae.getApresentacao());
	}

	@Test
	public void deveSeApresentarComoMae()
	{
		mae.gerarFilhaUnica(NOME_FILHA);

		assertEquals(NOME_MAE + ", mãe de " + NOME_FILHA, mae.getApresentacao());
	}

	@Test
	public void deveGerarFilhaUnica()
	{
		Filha filha = mae.gerarFilhaUnica(NOME_FILHA);

		assertEquals(filha, mae.getFilha());
		assertNotNull(mae.getFilha());
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveGerarFilhaUnicaSemNome()
	{
		mae.gerarFilhaUnica(null);
	}
}
