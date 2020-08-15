package br.com.codenation.listas;

import java.time.LocalDate;

public class Time{

    private Long id;
    private String nomeTime;
    private LocalDate dataCriacao;
    private String corUniformePrincipal;
    private String corUniformeSecundario;
    private Long capitao=0l;

    public Time(Long id, String nomeTime, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario){

        this.id = id;
        this.nomeTime = nomeTime;
        this.dataCriacao = dataCriacao;
        this.corUniformePrincipal = corUniformePrincipal;
        this.corUniformeSecundario = corUniformeSecundario;

    }

    public Long getId(){return id;}
    public String getNomeTime(){return nomeTime;}
    public LocalDate getDataCriacao(){return dataCriacao;}
    public String getCorUniformePrincipal(){return corUniformePrincipal;}
    public String getCorUniformeSecundario(){return corUniformeSecundario;}
    public Long getCapitao(){return capitao;}


    public void setId(Long id){this.id = id;}
    public void setNomeTime(String nomeTime){this.nomeTime = nomeTime;}
    public void setDataCriacao(LocalDate dataCriacao){this.dataCriacao = dataCriacao;}
    public void setCorUniformePrincipal(String corUniformePrincipal){this.corUniformePrincipal = corUniformePrincipal;}
    public void setCorUniformeSecundario(String corUniformeSecundario){this.corUniformeSecundario = corUniformeSecundario;}
    public void setCapitao(Long capitao){this.capitao = capitao;}

}