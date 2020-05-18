package com.codeExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
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
    private JButton btnHomicidiosHomens;
    private JButton btnSair;

    private static final String HOMENS_NAO_NEGROS_PAIS = "homicidiosHomensNaoNegrosPais.xlsx";
    private static final String HOMENS_NEGROS_PAIS = "homicidiosHomensNegrosPais.xlsx";
    private static final String MULHERES_NEGRAS_PAIS = "homicidiosMulheresNegrasPais.xlsx";
    private static final String MULHERES_NAO_NEGRAS_PAIS = "homicidiosMulheresNaoNegrasPais.xlsx";
    private static final String MULHERES_PAIS = "homicidiosMulheresPais.xlsx";
    private static final String HOMICIDIOS_PESSOAS_NEGRAS = "homicidiosNegrosPais.xlsx";
    private static final String HOMICIDIOS_PESSOAS_NAO_NEGRAS = "homicidiosNaoNegrosPais.xlsx";
    private static final String HOMICIDIOS_HOMENS = "homicidiosHomens.xlsx";

    public static final JFrame frame = new JFrame();




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

        btnHomicidiosHomens.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Chart3 chart3 = new Chart3();
                try {
                    chart3.abrirExcel(HOMICIDIOS_HOMENS);

                    if(rdnMedia.isSelected()){
                        chart3.Chart3(HOMICIDIOS_HOMENS, "media", "Homicidios Homens");
                    }
                    if(rdnTotal.isSelected()){
                        chart3.Chart3(HOMICIDIOS_HOMENS, "total", "Homicidios Homens");
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

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                btnSair.setBounds(12, 12, 30, 25);

            }
        });
    }

    public static void main(String[] args) {
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(600, 600);
        frame.setResizable(false);

        //frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        //frame.pack();
        frame.setVisible(true);
    }

}
