package com.codeExample;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
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
import java.util.List;

public class Grafico extends Homicidios {

    private String catLabel;


    public JFreeChart createChart(CategoryDataset dataset, String tituloGrafico) {

        JFreeChart barChart = ChartFactory.createBarChart(
                tituloGrafico,
                "Anos",
                "Mortes",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        return barChart;
    }

    public CategoryDataset createDataset(String tipo, ArrayList<String> anos,  ArrayList<String> valor, double media, double mediana,  double moda, double desvioPadrao, double varPop, double varAmostral) {

        var dataset = new DefaultCategoryDataset();
        if(tipo == "total"){
            for (int i = 0; i < anos.size(); i++) {
                dataset.setValue(Double.parseDouble(valor.get(i)), "valor",anos.get(i));
            }
        }
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

    void initUI(String tipo, String tituloGrafico, Chart3 chart3) {

        Grafico grafico = new Grafico();

        CategoryDataset dataset = grafico.createDataset(tipo, chart3.anos, chart3.valor, chart3.mediaA, chart3.mediana, chart3.moda, chart3.desvioPadrao, chart3.varianciaPopulacional, chart3.varianciaAmostral);

        JFreeChart chart = grafico.createChart(dataset, tituloGrafico);

        CategoryItemRenderer renderer = ((CategoryPlot)chart.getPlot()).getRenderer();

        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setDefaultItemLabelsVisible(true);
        ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE1,
                TextAnchor.TOP_CENTER);
        renderer.setDefaultPositiveItemLabelPosition(position);



        ChartPanel chartPanel = new ChartPanel(chart);
        //chartPanel.setBorder(BorderFactory.createTitledBorder("Teste"));
        //chartPanel.setBackground(Color.blue);

        JFrame jFrame = new JFrame();
        jFrame.setLayout(new BorderLayout());
        jFrame.setBackground(Color.blue);
        jFrame.add(chartPanel, BorderLayout.CENTER);

        //add(jFrame);

        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //pack();
       /* setTitle("Bar chart");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);*/

    }
}
