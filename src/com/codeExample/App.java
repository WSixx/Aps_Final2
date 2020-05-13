package com.codeExample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class App {
    private JPanel panelMain;
    private JButton btnHomensNegros;
    private JButton btnHomensNaoNegros;
    private JRadioButton rdnTotal;
    private JRadioButton rdnMedia;
    private JButton btnHomicidiosMulheresNegrasButton;
    private JButton btnMulheresPais;
    private JButton btnHomicidiosNaoNegros;
    private JButton btnMulheresNaoNegras;
    private JButton btnHomicidiosPessoasNegras;

    private static final String HOMENS_NAO_NEGROS_PAIS = "homicidiosHomensNaoNegrosPais.xlsx";
    private static final String HOMENS_NEGROS_PAIS = "homicidiosHomensNegrosPais.xlsx";
    private static final String MULHERES_NEGRAS_PAIS = "homicidiosMulheresNegrasPais.xlsx";
    private static final String MULHERES_NAO_NEGRAS_PAIS = "homicidiosMulheresNaoNegrasPais.xlsx";
    private static final String MULHERES_PAIS = "homicidiosMulheresPais.xlsx";
    private static final String HOMICIDIOS_PESSOAS_NEGRAS = "homicidiosNegrosPais.xlsx";
    private static final String HOMICIDIOS_PESSOAS_NAO_NEGRAS = "homicidiosNaoNegrosPais.xlsx";


    public App() {
        btnHomensNegros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Chart3 chart3 = new Chart3();
                try {
                    chart3.abrirExcel(HOMENS_NEGROS_PAIS);

                    if(rdnMedia.isSelected()){
                        chart3.Chart3(HOMENS_NEGROS_PAIS
                                , "media", "Homens Negros");
                    }
                    if(rdnTotal.isSelected()){
                        chart3.Chart3(HOMENS_NEGROS_PAIS, "total", "Homens Negros");
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        btnHomensNaoNegros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Chart3 chart3 = new Chart3();
                try {
                    chart3.abrirExcel(HOMENS_NAO_NEGROS_PAIS);

                    if(rdnMedia.isSelected()){
                        chart3.Chart3(HOMENS_NAO_NEGROS_PAIS, "media", "Homens Não Negros");
                    }
                    if(rdnTotal.isSelected()){
                        chart3.Chart3(HOMENS_NAO_NEGROS_PAIS, "total", "Homens Não Negros");
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        btnMulheresNaoNegras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Chart3 chart3 = new Chart3();
                try {
                    chart3.abrirExcel(MULHERES_NAO_NEGRAS_PAIS);

                    if(rdnMedia.isSelected()){
                        chart3.Chart3(MULHERES_NAO_NEGRAS_PAIS, "media", "Mulheres Não Negras");
                    }
                    if(rdnTotal.isSelected()){
                        chart3.Chart3(MULHERES_NAO_NEGRAS_PAIS, "total", "Mulheres Não Negras");
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        btnHomicidiosMulheresNegrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Chart3 chart3 = new Chart3();
                try {
                    chart3.abrirExcel(MULHERES_NEGRAS_PAIS);

                    if(rdnMedia.isSelected()){
                        chart3.Chart3(MULHERES_NEGRAS_PAIS, "media", "Mulheres Negras");
                    }
                    if(rdnTotal.isSelected()){
                        chart3.Chart3(MULHERES_NEGRAS_PAIS, "total", "Mulheres Negras");
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        btnMulheresPais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Chart3 chart3 = new Chart3();
                try {
                    chart3.abrirExcel(MULHERES_PAIS);

                    if(rdnMedia.isSelected()){
                        chart3.Chart3(MULHERES_PAIS, "media", "Homicidios Mulheres");
                    }
                    if(rdnTotal.isSelected()){
                        chart3.Chart3(MULHERES_PAIS, "total", "Homicidios Mulheres");
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        btnHomicidiosNaoNegros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Chart3 chart3 = new Chart3();
                try {
                    chart3.abrirExcel(HOMICIDIOS_PESSOAS_NAO_NEGRAS);

                    if(rdnMedia.isSelected()){
                        chart3.Chart3(HOMICIDIOS_PESSOAS_NAO_NEGRAS, "media", "??????");
                    }
                    if(rdnTotal.isSelected()){
                        chart3.Chart3(HOMICIDIOS_PESSOAS_NAO_NEGRAS, "total", "?????");
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        btnHomicidiosPessoasNegras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Chart3 chart3 = new Chart3();
                try {
                    chart3.abrirExcel(HOMICIDIOS_PESSOAS_NEGRAS);

                    if(rdnMedia.isSelected()){
                        chart3.Chart3(HOMICIDIOS_PESSOAS_NEGRAS, "media", "??????");
                    }
                    if(rdnTotal.isSelected()){
                        chart3.Chart3(HOMICIDIOS_PESSOAS_NEGRAS, "total", "??????");
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        rdnTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rdnMedia.setSelected(false);
                rdnTotal.setSelected(true);
            }
        });
        rdnMedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rdnTotal.setSelected(false);
                rdnMedia.setSelected(true);

            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tabelas");
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // frame.pack();
        frame.setVisible(true);
    }

}
