package com.codeExample;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Chart3 extends JFrame {

    public final ArrayList<String> anos = new ArrayList();
    public final ArrayList<String> valor = new ArrayList();
    public double mediaA, mediana, desvioPadrao, varianciaPopulacional, moda, varianciaAmostral;
    Grafico grafico = new Grafico();


    List<Homicidios> listaHomicidios = new ArrayList<Homicidios>();

    public void Chart3(String tipo, String tituloGrafico) {
        grafico.initUI(tipo, tituloGrafico, this);

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
                            homicidios.setMediana(cell.getNumericCellValue());
                            break;
                        case 4:
                            homicidios.setModa(cell.getNumericCellValue());
                            break;
                        case 5:
                            homicidios.setDesvioPadrao(cell.getNumericCellValue());
                            break;
                        case 6:
                            homicidios.setVarianciaPopulacional(cell.getNumericCellValue());
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
                if(homicidios.getMediana() != 0) {
                    mediana = homicidios.getMediana();
                }
                if(homicidios.getModa() != 0) {
                    moda = homicidios.getModa();
                }
                if(homicidios.getDesvioPadrao() != 0) {
                    desvioPadrao = homicidios.getDesvioPadrao();
                }
                if(homicidios.getVarianciaPopulacional() != 0) {
                    varianciaPopulacional = homicidios.getVarianciaPopulacional();
                }
                if(homicidios.getVarianciaAmostral() != 0) {
                    varianciaAmostral = homicidios.getVarianciaAmostral();
                }
            }
        }
        System.out.println("Número total de anos: " + listaHomicidios.size());
        System.out.println(mediaA);

    }


}