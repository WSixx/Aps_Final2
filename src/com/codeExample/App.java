package com.codeExample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class App {
    private JPanel panelMain;
    private JButton btn2;
    private JButton chart3Button;
    private JRadioButton rdnTotal;
    private JRadioButton rdnMedia;

    private static final String FILE_PATH = "homicidiosHomensNaoNegrosPaisQTD.xlsx";
    private static final String FILE_PATH2 = "homicidiosHomensNegrosPaisQTD.xlsx";



    public App() {
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Chart3 chart3 = new Chart3();
                try {
                    chart3.abrirExcel(FILE_PATH2);

                    if(rdnMedia.isSelected()){
                        chart3.Chart3(FILE_PATH2, "media");
                    }
                    if(rdnTotal.isSelected()){
                        chart3.Chart3(FILE_PATH2, "total");
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        chart3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Chart3 chart3 = new Chart3();
                try {
                    chart3.abrirExcel(FILE_PATH);

                    if(rdnMedia.isSelected()){
                        chart3.Chart3(FILE_PATH, "media");
                    }
                    if(rdnTotal.isSelected()){
                        chart3.Chart3(FILE_PATH, "total");
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
        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // frame.pack();
        frame.setVisible(true);
    }

}
