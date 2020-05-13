package com.codeExample;

public class Homicidios {

    private int ano ;
    private int valor;
    private double mediaAritmetica;
    private double desvioMedio;
    private double desvioPadrao;
    private double varianciaPopulacional;
    private double coeficienteVariaçao;
    private double varianciaAmostral;

    public Homicidios(){}

    public Homicidios(int ano, int valor, double mediaAritmetica, double desvioMedio, double desvioPadrao,
                      double varianciaPopulacional, double coeficienteVariaçao, double varianciaAmostral) {
        this.ano = ano;
        this.valor = valor;
        this.mediaAritmetica = mediaAritmetica;
        this.desvioMedio = desvioMedio;
        this.desvioPadrao = desvioPadrao;
        this.varianciaPopulacional = varianciaPopulacional;
        this.coeficienteVariaçao = coeficienteVariaçao;
        this.varianciaAmostral = varianciaAmostral;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public double getMediaAritmetica() {
        return mediaAritmetica;
    }

    public void setMediaAritmetica(double mediaAritmetica) {
        this.mediaAritmetica = mediaAritmetica;
    }

    public double getDesvioMedio() {
        return desvioMedio;
    }

    public void setDesvioMedio(double desvioMedio) {
        this.desvioMedio = desvioMedio;
    }

    public double getDesvioPadrao() {
        return desvioPadrao;
    }

    public void setDesvioPadrao(double desvioPadrao) {
        this.desvioPadrao = desvioPadrao;
    }

    public double getVarianciaPopulacional() {
        return varianciaPopulacional;
    }

    public void setVarianciaPopulacional(double varianciaPopulacional) {
        this.varianciaPopulacional = varianciaPopulacional;
    }

    public double getCoeficienteVariaçao() {
        return coeficienteVariaçao;
    }

    public void setCoeficienteVariaçao(double coeficienteVariaçao) {
        this.coeficienteVariaçao = coeficienteVariaçao;
    }

    public double getVarianciaAmostral() {
        return varianciaAmostral;
    }

    public void setVarianciaAmostral(double varianciaAmostral) {
        this.varianciaAmostral = varianciaAmostral;
    }
}
