package br.com.eldari.testes.familia;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Mae
{
	private static final Logger logger = LoggerFactory.getLogger(Mae.class);

	private String nome;
	private Filha filha;

	public Mae(String nome)
	{
		if (nome == null) throw new IllegalArgumentException("Sem nome");

		this.nome = nome;
		logger.trace("Criou mãe {}", nome);
	}

	public String getNome()
	{
		logger.trace(nome);
		return nome;
	}

	public String getApresentacao()
	{
		String apresentacao = null;

		if (getFilha() == null)
		{
			apresentacao = getNome() + ", sem filha";
		}
		else
		{
			apresentacao = getNome() + ", mãe de " + getFilha().getNome();
		}

		logger.trace(apresentacao);
		return apresentacao;
	}

	public Filha getFilha()
	{
		logger.trace("{}", filha);
		return filha;
	}

	public Filha gerarFilhaUnica(String nomeFilha)
	{
		filha = new Filha(nomeFilha, this);
		logger.trace(filha.getNome());
		return filha;
	}

	@Override
	public String toString()
	{
		return "mãe " + this.nome;
	}
}
