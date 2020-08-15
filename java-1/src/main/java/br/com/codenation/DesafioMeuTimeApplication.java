package br.com.codenation;

import br.com.codenation.listas.Jogador;
import br.com.codenation.listas.Time;

import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.CapitaoNaoInformadoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.Comparator;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private List <Time> times = new ArrayList<>();
	private List <Jogador> jogadores = new ArrayList<>();

	//@Desafio("incluirTime")
	public void incluirTime(Long id, String nomeTime, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {

			if (times.stream().anyMatch(T -> T.getId().equals(id))){
				throw new IdentificadorUtilizadoException();
			}
				Time time = new Time(id, nomeTime, dataCriacao, corUniformePrincipal, corUniformeSecundario);
				times.add(time);
	}

	//@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nomeJogador, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {

					if (jogadores.stream().anyMatch(J -> J.getId().equals(id))){
						throw new IdentificadorUtilizadoException();}
					if(times.stream().noneMatch(T -> T.getId().equals(idTime))){
						throw new TimeNaoEncontradoException();}

					Jogador jogador = new Jogador(id, idTime, nomeJogador, dataNascimento, nivelHabilidade, salario);
					jogadores.add(jogador);

	}

	//@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		Jogador Capitao = jogadores.stream()
			.filter(j -> j.getId().equals(idJogador))
			.findAny()
			.orElseThrow(JogadorNaoEncontradoException :: new);

		for(Time time : times){
			time.setCapitao(idJogador);
		}
	}
	//@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		

		for(Time t : times){
			if(t.getId().equals(idTime)){
				if(t.getCapitao().equals(0l)){
					throw new CapitaoNaoInformadoException();
				}else{
					return t.getCapitao();
				}
			}
		}
		throw new TimeNaoEncontradoException();
	}

	//@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		Jogador buscarJog = jogadores.stream()
				.filter(J -> J.getId().equals(idJogador))
				.findFirst()
				.orElseThrow(JogadorNaoEncontradoException :: new);

		return buscarJog.getNomeJogador();

	}
	//@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		Time buscarTime = times.stream()
				.filter(T -> T.getId().equals(idTime))
				.findFirst()
				.orElseThrow(TimeNaoEncontradoException :: new);

		return buscarTime.getNomeTime();
	}
	//@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
			if(times.stream().noneMatch(time ->time.getId().equals(idTime))){
				throw new TimeNaoEncontradoException();}

		return jogadores.stream()
				.filter(buscarjogadores -> buscarjogadores.getIdTime().equals(idTime))
				.map(Jogador :: getId)
				.collect(Collectors.toList());
	}
	
	//@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		if(times.stream().noneMatch(T ->T.getId().equals(idTime))){
			throw new TimeNaoEncontradoException();}

		Integer nivelHabilidade = 0;
		Jogador melhorjogador = null;
		for(Jogador joga : jogadores){
			if(joga.getNivelHabilidade() > nivelHabilidade){
				nivelHabilidade = joga.getNivelHabilidade();
				melhorjogador = joga;
			}
		}

		return melhorjogador.getId();
	}
	//@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		if(times.stream().noneMatch(T ->T.getId().equals(idTime))){
			throw new TimeNaoEncontradoException();}

		LocalDate dataNascimento = LocalDate.now();
		Jogador maisVelho = null;
		for(Jogador joga : jogadores){
			if(joga.getIdTime() == idTime && joga.getDataNascimento().isBefore(dataNascimento)){
				dataNascimento = joga.getDataNascimento();
				maisVelho = joga;

			}
		}

		return maisVelho.getId();
	}
	//@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		List <Long> buscaTime = new ArrayList<>();
		for (Time T : times) {
			buscaTime.add(T.getId());
		}
		return buscaTime;
	}
	//@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		if(times.stream().noneMatch(T ->T.getId().equals(idTime))){
			throw new TimeNaoEncontradoException();}

		BigDecimal salario = BigDecimal.ZERO;
		Jogador salariomaior = null;
		for(Jogador joga : jogadores){
			if(joga.getIdTime() == idTime && joga.getSalario().compareTo(salario)>0){
				salario = joga.getSalario();
				salariomaior = joga;
			}
		}

		return salariomaior.getId();
	}
	//@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		Jogador buscarJog = jogadores.stream()
				.filter(J -> J.getId().equals(idJogador))
				.findFirst()
				.orElseThrow(JogadorNaoEncontradoException :: new);

		return buscarJog.getSalario();
	}

	//@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {

		int i;
		jogadores.sort(Comparator.comparingInt(Jogador::getNivelHabilidade).reversed());
		List<Long> Top = new ArrayList<>();

			if(jogadores.size()==0){return Top;}
			System.out.println(jogadores);

			for(i=0; i<top; i++){Top.add(jogadores.get(i).getId());}

		return Top;
	}

}
