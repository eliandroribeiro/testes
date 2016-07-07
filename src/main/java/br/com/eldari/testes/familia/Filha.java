package br.com.eldari.testes.familia;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Filha
{
	private static final Logger logger = LoggerFactory.getLogger(Filha.class);

	private String nome;
	private Mae mae;

	protected Filha(String nome, Mae mae)
	{
		if (nome == null) throw new IllegalArgumentException("Sem nome");
		if (mae == null) throw new IllegalArgumentException("Sem mãe");

		this.nome = nome;
		this.mae = mae;
		logger.trace("Criou filha {}, da mãe {}", nome, mae.getNome());
	}

	public String getNome()
	{
		logger.trace(this.nome);
		return this.nome;
	}

	public String getApresentacao()
	{
		String apresentacao = getNome() + ", filha de " + mae.getNome();
		logger.trace(apresentacao);
		return apresentacao;
	}

	public Mae getMae()
	{
		logger.trace("{}", mae);
		return mae;
	}

	@Override
	public String toString()
	{
		return "filha " + this.nome;
	}
}
