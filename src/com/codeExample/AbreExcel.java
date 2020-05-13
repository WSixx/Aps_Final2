package com.codeExample;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AbreExcel {

    private static final String fileName = "homicidiosHomensNaoNegrosPaisQTD.xlsx";


        public AbreExcel() throws IOException {

        List<Homicidios> listaHomicidios = new ArrayList<Homicidios>();

        try {
            FileInputStream arquivo = new FileInputStream(new File(
                    AbreExcel.fileName));

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
                            homicidios.setAno((int)cell.getNumericCellValue());
                            break;
                        case 1:
                            homicidios.setValor((int)(cell.getNumericCellValue()));
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
                System.out.println("Valor: " + homicidios.getValor());
            }
            }
            System.out.println("Número total de anos: " + listaHomicidios.size());
        }

}