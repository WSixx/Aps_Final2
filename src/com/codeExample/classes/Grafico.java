package com.codeExample.classes;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Grafico extends Homicidios { //Extende de Homicidios e herda

    //Criar o gráfico recebe um dataSet que são os dados usados no gráfico e o titulo que aparecera
    public JFreeChart createChart(CategoryDataset dataset, String tituloGrafico) {

        //Criar um chart tipo bar sao setados alguns parametros not null e retorna um BarChart
        JFreeChart barChart = ChartFactory.createBarChart(
                tituloGrafico,
                "Anos",
                "Mortes",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        return barChart;
    }

    //Retorna um dataset que sera passado para o chartBar
    //recebe as variaveis que serao passadas para dataset
    public CategoryDataset createDataset(String tipo, ArrayList<String> anos,  ArrayList<String> valor, double media, double mediana,  double moda, double desvioPadrao, double varPop, double varAmostral) {

        var dataset = new DefaultCategoryDataset();
        //Se tipo = total faz pelo total um for de 0 até o tamanho a lista adicionando os valores de ano e homicidios
        if(tipo == "total"){
            for (int i = 0; i < anos.size(); i++) {
                dataset.setValue(Double.parseDouble(valor.get(i)), "valor",anos.get(i));
            }
        }
        //Se tipo = media faz pela media
        if(tipo == "media"){
            dataset.setValue(media,"Media Aritmética", "Media A");
            dataset.setValue(mediana,"Mediana", "Mediana");
            dataset.setValue(moda,"Moda", "Moda");
            dataset.setValue(desvioPadrao,"Desvio Padrão", "Desvio Padrão");
            dataset.setValue(varPop,"Variância Populacional", "Variância Populacional");
            dataset.setValue(varAmostral,"Variancia Amostral", "Variancia Amostral");
        }

        return dataset;
    }

    //Inicia a UI que recebe o tipo, tituloGráfico e
    // Objeto tipo ExcelOpen(aqui irá precisar para pegar as variaveis que são publicas)
    void initUI(String tipo, String tituloGrafico, ExcelOpen excelOpen) {

        //Objeto Grafico
        Grafico grafico = new Grafico();
        //Objeto Grafico Dataset
        CategoryDataset dataset = grafico.createDataset(tipo, excelOpen.anos, excelOpen.valor, excelOpen.mediaA, excelOpen.mediana, excelOpen.moda, excelOpen.desvioPadrao, excelOpen.varianciaPopulacional, excelOpen.varianciaAmostral);
        //Objeto JFreechart
        JFreeChart chart = grafico.createChart(dataset, tituloGrafico);
        //Objeto Render
        CategoryItemRenderer renderer = ((CategoryPlot)chart.getPlot()).getRenderer();

        //Aqui eu modifiquei as labels que aparecem dentro do gráfico ou seja um valor nas barras dos graficos
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setDefaultItemLabelsVisible(true);
        ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE1,
                TextAnchor.TOP_CENTER);
        renderer.setDefaultPositiveItemLabelPosition(position);
        ChartPanel chartPanel = new ChartPanel(chart);

        chart.setBackgroundPaint(Color.white); //Fundo cor
        chart.getTitle().setPaint(Color.BLACK); //Cor titulo

        // Aqui eu modifico como ira aparecer as labels do eixo X
        CategoryPlot p = chart.getCategoryPlot();
        CategoryAxis axis = p.getDomainAxis();
        axis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        p.setRangeGridlinePaint(Color.red);

        // Esse jFrame é a base do nosso grafico/layout
        JFrame jFrame = new JFrame();
        jFrame.setLayout(new BorderLayout());
        jFrame.setBackground(Color.blue);
        jFrame.add(chartPanel, BorderLayout.CENTER);

        //Icone
        ImageIcon img = new ImageIcon("src/icon/line-stats.png");
        jFrame.setIconImage(img.getImage());

        //Abre ele maximizado
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jFrame.setVisible(true);
        //OnClose ele não ira encerrar a aplicacao, apenas fecha a janela em questão
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }
}
