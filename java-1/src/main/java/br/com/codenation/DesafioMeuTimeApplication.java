package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private List<Time> times = new ArrayList<Time>();
	private List<Jogador> jogadores = new ArrayList<Jogador>();

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {

		for (Time time: times) {
			if(time.getId().equals(id)){
				throw new IdentificadorUtilizadoException();
			}
		}
		this.times.add(new Time(id,nome,dataCriacao,corUniformePrincipal,corUniformeSecundario));
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {

		for (Jogador jogador: jogadores) {
			if(jogador.getId().equals(id)){
				throw new IdentificadorUtilizadoException();
			}
		}

		verificaTime(idTime);

		this.jogadores.add(new Jogador(id,idTime,nome,dataNascimento,nivelHabilidade,salario));
	}

	public void definirCapitao(Long idJogador) {

		verificaJogador(idJogador);

		for (Time time: times) {
			time.setIdCapitao(idJogador);
		}
	}

	public Long buscarCapitaoDoTime(Long idTime) {

		for (Time time: times) {
			if (time.getId().equals(idTime)) {
				if(time.getIdCapitao().equals(0l)) {
					throw new CapitaoNaoInformadoException();
				} else {
					return time.getIdCapitao();
				}
			}
		}
		throw new TimeNaoEncontradoException();
	}

	public String buscarNomeJogador(Long idJogador) {
		for (Jogador jogador: jogadores) {
			if(jogador.getId().equals(idJogador)){
				return jogador.getNome();
			}
		}
		throw new JogadorNaoEncontradoException();
	}

	public String buscarNomeTime(Long idTime) {

		for (Time time: times) {
			if (time.getId().equals(idTime)) {
				return time.getNome();
			}
		}
		throw new TimeNaoEncontradoException();
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		List<Long> listaIdJogadores = new ArrayList<Long>();

		verificaTime(idTime);

		for (Jogador jogador : jogadores) {
			listaIdJogadores.add(jogador.getId());
		}
		return listaIdJogadores;
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		int i = 0;
		Jogador melhorJogador = null;

		verificaTime(idTime);

		for (Jogador jogador : jogadores) {
			if (jogador.getNivelHabilidade() > i) {
				i = jogador.getNivelHabilidade();
				melhorJogador = jogador;
			}
		}
		return melhorJogador.getId();
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		LocalDate data = LocalDate.now();
		Jogador jogadorOlder = null;

		verificaTime(idTime);

		for(Jogador jogador: jogadores) {
			if (jogador.getDataNascimento().isBefore(data)) {
				data = jogador.getDataNascimento();
				jogadorOlder = jogador;
			}
		}
		return jogadorOlder.getId();
	}

	public List<Long> buscarTimes() {
		List<Long> listaIdTimes = new ArrayList<Long>();

		for (Time time: times) {
			listaIdTimes.add(time.getId());
		}
		return listaIdTimes;
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		BigDecimal salario = BigDecimal.ZERO;
		Jogador jogadorSalario = null;

		verificaTime(idTime);

		for (Jogador jogador : jogadores) {
			if (jogador.getSalario().compareTo(salario) == 1) {
				salario = jogador.getSalario();
				jogadorSalario = jogador;
			}
		}
		return jogadorSalario.getId();
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {

		for (Jogador jogador: jogadores) {
			if(jogador.getId().equals(idJogador)){
				return jogador.getSalario();
			}
		}
		throw new JogadorNaoEncontradoException();
	}

	public List<Long> buscarTopJogadores(Integer top) {
		List<Long> listaTop = new ArrayList<Long>();
		int cont = jogadores.size();
		int[] array = new int[cont];
		int i = 0;

		for (Jogador jogador: jogadores) {
			array[i] = jogador.getNivelHabilidade();
			i++;
		}

		Arrays.sort(array);

		for (i = top; i > 0; i--) {
			for (Jogador jogador: jogadores) {
				if (jogador.getNivelHabilidade() == array[i]) {
					listaTop.add(jogador.getId());
				}
			}
		}
		return listaTop;
	}

	private int verificaTime(Long idTime) {
		for (Time time : times) {
			if (time.getId().equals(idTime)) {
				return 0;
			}
		}
		throw new TimeNaoEncontradoException();
	}

	private int verificaJogador(Long idJogador) {
		for (Jogador jogador : jogadores) {
			if (jogador.getId().equals(idJogador)) {
				return 0;
			}
		}
		throw new JogadorNaoEncontradoException();
	}

}
