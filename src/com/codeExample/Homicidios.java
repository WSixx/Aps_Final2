package com.codeExample;

public class Homicidios {

    private int ano ;
    private int valor;
    private double mediaAritmetica;
    private double mediana;
    private double desvioPadrao;
    private double varianciaPopulacional;
    private double moda;
    private double varianciaAmostral;

    public Homicidios(){}

    public Homicidios(int ano, int valor, double mediaAritmetica, double mediana, double desvioPadrao,
                      double varianciaPopulacional, double moda, double varianciaAmostral) {
        this.ano = ano;
        this.valor = valor;
        this.mediaAritmetica = mediaAritmetica;
        this.mediana = mediana;
        this.desvioPadrao = desvioPadrao;
        this.varianciaPopulacional = varianciaPopulacional;
        this.moda = moda;
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

    public double getMediana() {
        return mediana;
    }

    public void setMediana(double mediana) {
        this.mediana = mediana;
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

    public double getModa() {
        return moda;
    }

    public void setModa(double moda) {
        this.moda = moda;
    }

    public double getVarianciaAmostral() {
        return varianciaAmostral;
    }

    public void setVarianciaAmostral(double varianciaAmostral) {
        this.varianciaAmostral = varianciaAmostral;
    }
}
