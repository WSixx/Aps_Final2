package com.codeExample;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Chart3 extends JFrame {

    private final ArrayList<String> anos = new ArrayList();
    private final ArrayList<String> valor = new ArrayList();
    double mediaA, desvioMedio, desvioPadrao, varianciaPopulacional, coeficienteVariaçao, varianciaAmostral;


    //private static final String fileName = "homicidiosHomensNaoNegrosPaisQTD.xlsx";
    List<Homicidios> listaHomicidios = new ArrayList<Homicidios>();


    public void Chart3(String filePath, String tipo, String tituloGrafico) {
        LineChart(filePath);
        initUI(tipo, tituloGrafico);
    }

    public void abrirExcel(String fileName) throws IOException {

        try {
            FileInputStream arquivo = new FileInputStream(new File(
                    fileName));

            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);

            XSSFSheet sheetHomicidios = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheetHomicidios.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                Homicidios homicidios = new Homicidios();
                listaHomicidios.add(homicidios);
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        case 0:
                            homicidios.setAno((int) cell.getNumericCellValue());
                            break;
                        case 1:
                            homicidios.setValor((int) (cell.getNumericCellValue()));
                            break;
                        case 2:
                            homicidios.setMediaAritmetica(cell.getNumericCellValue());
                            break;
                        case 3:
                            homicidios.setDesvioMedio(cell.getNumericCellValue());
                            break;
                        case 4:
                            homicidios.setDesvioPadrao(cell.getNumericCellValue());
                            break;
                        case 5:
                            homicidios.setVarianciaPopulacional(cell.getNumericCellValue());
                            break;
                        case 6:
                            homicidios.setCoeficienteVariaçao(cell.getNumericCellValue());
                            break;
                        case 7:
                            homicidios.setVarianciaAmostral(cell.getNumericCellValue());
                            break;
                    }
                }
            }
            arquivo.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo Excel não encontrado!");
        }

        if (listaHomicidios.size() == 0) {
            System.out.println("Nenhum dado encontrado!");
        } else {
            for (Homicidios homicidios : listaHomicidios) {
                System.out.println("Ano: " + homicidios.getAno());
                anos.add(String.valueOf(homicidios.getAno()));
                System.out.println("Valor: " + homicidios.getValor());
                valor.add(String.valueOf(homicidios.getValor()));
                if (homicidios.getMediaAritmetica() != 0) {
                    mediaA = homicidios.getMediaAritmetica();
                }
                if(homicidios.getDesvioMedio() != 0) {
                    desvioMedio = homicidios.getDesvioMedio();
                }
                if(homicidios.getDesvioPadrao() != 0) {
                    desvioPadrao = homicidios.getDesvioPadrao();
                }
                if(homicidios.getVarianciaPopulacional() != 0) {
                    varianciaPopulacional = homicidios.getVarianciaPopulacional();
                }
                if(homicidios.getCoeficienteVariaçao() != 0) {
                    coeficienteVariaçao = homicidios.getCoeficienteVariaçao();
                }
                if(homicidios.getVarianciaAmostral() != 0) {
                    varianciaAmostral = homicidios.getVarianciaAmostral();
                }
            }
        }
        System.out.println("Número total de anos: " + listaHomicidios.size());
        System.out.println(mediaA);

    }


    private void initUI(String tipo, String tituloGrafico) {

        CategoryDataset dataset = createDataset(tipo);

        JFreeChart chart = createChart(dataset, tituloGrafico);

        CategoryItemRenderer renderer = ((CategoryPlot)chart.getPlot()).getRenderer();

        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setDefaultItemLabelsVisible(true);
        ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE1,
                TextAnchor.TOP_CENTER);
        renderer.setDefaultPositiveItemLabelPosition(position);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Bar chart");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private CategoryDataset createDataset(String tipo) {

        var dataset = new DefaultCategoryDataset();
        listaHomicidios.size();
        if(tipo == "total"){
            for (int i = 0; i < anos.size(); i++) {
                dataset.setValue(Double.parseDouble(valor.get(i)), "valor", anos.get(i).toString());
            }
        }
        if(tipo == "media"){
            dataset.setValue(mediaA,"Media Aritmética", "Media A");
            dataset.setValue(desvioMedio,"Desvio Médio", "Desvio Médio");
            dataset.setValue(desvioPadrao,"Desvio Padrão", "Desvio Padrão");
            dataset.setValue(varianciaPopulacional,"Variância Populacional", "Variância Populacional");
            dataset.setValue(coeficienteVariaçao,"Coeficiencia Variacao", "Coeficiencia Variacao");
            dataset.setValue(varianciaAmostral,"Variancia Amostral", "Variancia Amostral");
        }

        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset, String tituloGrafico) {

        JFreeChart barChart = ChartFactory.createBarChart(
                tituloGrafico,
                "",
                "Mortes",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        return barChart;
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new Chart();
            ex.setVisible(true);
        });
    }

    public void LineChart(String filePath) {

        Chart lineChartEx = new Chart();
        lineChartEx.getGraphics();

        // Creating a Workbook from an Excel file (.xls or .xlsx)


    }

}