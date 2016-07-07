package br.com.eldari.testes.familia;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class FilhaTest
{
	private static final String NOME_MAE = "Maria";
	private static final String NOME_FILHA = "Ana";

	@Mock
	private Mae maeMock;

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarFilhaSemNome()
	{
		new Filha(null, maeMock);
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarFilhaSemMae()
	{
		new Filha(NOME_FILHA, null);
	}

	@Test
	public void deveSaberProprioNome()
	{
		Filha filha = new Filha(NOME_FILHA, maeMock);

		assertEquals(NOME_FILHA, filha.getNome());
	}

	@Test
	public void deveTerMaeMock()
	{
		doReturn(NOME_MAE).when(maeMock).getNome();

		Filha filha = new Filha(NOME_FILHA, maeMock);

		assertNotNull(filha.getMae());
		assertEquals(NOME_MAE, filha.getMae().getNome());
		assertEquals(NOME_FILHA + ", filha de " + NOME_MAE, filha.getApresentacao());
	}

	@Test
	public void deveTerMaeReal()
	{
		Filha filha = criarFilhaComMaeReal();

		assertNotNull(filha.getMae());
		assertEquals(NOME_MAE, filha.getMae().getNome());
	}

	@Test
	public void deveSeApresentarComoFilha()
	{
		Filha filha = criarFilhaComMaeReal();

		assertEquals(NOME_FILHA + ", filha de " + NOME_MAE, filha.getApresentacao());
	}

	private Filha criarFilhaComMaeReal()
	{
		Mae mae = new Mae(NOME_MAE);
		return new Filha(NOME_FILHA, mae);
	}
}
