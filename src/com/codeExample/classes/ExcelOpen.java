package com.codeExample.classes;

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

public class ExcelOpen extends JFrame {

    public final ArrayList<String> anos = new ArrayList();
    public final ArrayList<String> valor = new ArrayList();
    public double mediaA, mediana, desvioPadrao, varianciaPopulacional, moda, varianciaAmostral;

    Grafico grafico = new Grafico();

    //Lista do Objeto Homicidios
    List<Homicidios> listaHomicidios = new ArrayList<Homicidios>();

    //Recebe o Arquivo, tipo(total ou media) e Titulo do gráfico
    public void Chart3(String filePath, String tipo, String tituloGrafico) throws IOException {
        abrirExcel(filePath);
        //Inicia a UI onde será mostrado o gráfico
        grafico.initUI(tipo, tituloGrafico, this);

    }

    public void abrirExcel(String fileName) throws IOException {

        try {
            //abre o arqivo para manipulacao
            FileInputStream arquivo = new FileInputStream(new File(
                    fileName));

            //cria um novo Workbook passando o arquivo
            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);

            //Sheet iniciando na coluna 0
            XSSFSheet sheetHomicidios = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheetHomicidios.iterator();

            //Limpar variaveis
            mediaA = 0;
            mediana = 0;
            moda = 0;
            desvioPadrao = 0;
            varianciaPopulacional = 0;
            varianciaAmostral = 0;
            anos.clear();
            valor.clear();

            //Enquanto tiver dado ele fara o proximo
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                Homicidios homicidios = new Homicidios();
                listaHomicidios.add(homicidios);
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        //Caso coluna 0
                        case 0:
                            //Pega o valor numero da celula em questao e passa para objeto homicidios
                            homicidios.setAno((int) cell.getNumericCellValue());
                            break;
                        //Caso coluna 1
                        case 1:
                            //Pega o valor numero da celula em questao e passa para objeto homicidios
                            homicidios.setValor((int) (cell.getNumericCellValue()));
                            break;
                        //Caso coluna 2
                        case 2:
                            //Pega o valor numero da celula em questao e passa para objeto homicidios
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
            //Fecha o arquivo para economizar recursos dp sistema
            arquivo.close();

            //Catch da excecao Arq nao encontrado
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo Excel não encontrado!");
        }

        //Se não pegar nenhum dado a lista vai ser 0
        if (listaHomicidios.size() == 0) {
            System.out.println("Nenhum dado encontrado!");
        } else {
            //For-Each que vai de Objeto homicidios pela lista(array) de homicidios
            for (Homicidios homicidios : listaHomicidios) {

                anos.add(String.valueOf(homicidios.getAno()));
                valor.add(String.valueOf(homicidios.getValor()));

                //Os if servem para ter certeza que não pegou valor 0 ou seja : uma célula vazia
                //Se caso houver um valor 0 ele irá adicionar a váriavel em questao
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
    }
}