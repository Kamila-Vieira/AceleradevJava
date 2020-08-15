package br.com.codenation.listas;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.Objects;


public class Jogador{

    private Long id;
    private Long idTime;
    private String nomeJogador;
    private LocalDate dataNascimento;
    private Integer nivelHabilidade;
    private BigDecimal salario;


    public Jogador(Long id, Long idTime, String nomeJogador, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario){

        this.id = id;
        this.idTime = idTime;
        this.nomeJogador = nomeJogador;
        this.dataNascimento = dataNascimento;
        this.nivelHabilidade = nivelHabilidade;
        this.salario = salario;

    }

    public Long getId(){return id;}
    public Long getIdTime(){return idTime;}
    public String getNomeJogador(){return nomeJogador;}
    public LocalDate getDataNascimento(){return dataNascimento;}
    public Integer getNivelHabilidade(){return nivelHabilidade;}
    public BigDecimal getSalario(){return salario;}

    public void setId(Long id){this.id = id;}
    public void setIdTime(Long idTime){this.idTime = idTime;}
    public void setNomeJogador(String nomeJogador){this.nomeJogador = nomeJogador;}
    public void setDataNascimento(LocalDate dataNascimento){ this.dataNascimento = dataNascimento;}
    public void setNivelHabilidade(Integer nivelHabilidade){this.nivelHabilidade = nivelHabilidade;}
    public void setSalario(BigDecimal salario){this.salario = salario;}


}

