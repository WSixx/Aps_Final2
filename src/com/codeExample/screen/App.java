package com.codeExample.screen;

import com.codeExample.classes.ExcelOpen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class App {

    //Delacração dos objetos da tela Swing
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

    //Variaveis constantes
    //Arquivos do excel de onde saem os dados para criação dos gráficos
    private static final String HOMENS_NAO_NEGROS_PAIS = "homicidiosHomensNaoNegrosPais.xlsx";
    private static final String HOMENS_NEGROS_PAIS = "homicidiosHomensNegrosPais.xlsx";
    private static final String MULHERES_NEGRAS_PAIS = "homicidiosMulheresNegrasPais.xlsx";
    private static final String MULHERES_NAO_NEGRAS_PAIS = "homicidiosMulheresNaoNegrasPais.xlsx";
    private static final String MULHERES_PAIS = "homicidiosMulheresPais.xlsx";
    private static final String HOMICIDIOS_PESSOAS_NEGRAS = "homicidiosNegrosPais.xlsx";
    private static final String HOMICIDIOS_PESSOAS_NAO_NEGRAS = "homicidiosNaoNegrosPais.xlsx";
    private static final String HOMICIDIOS_HOMENS = "homicidiosHomens.xlsx";

    //JFrame
    public static final JFrame frame = new JFrame();

    //Classe APP do Form
    public App() {

        //Ação do botão ****
        btnHomensNegros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Tenta abrir o gráfico passando para o método escolhaTipo(nomeArquivo, tituloGráfico)
                try {
                    escolhaTipo(HOMENS_NEGROS_PAIS, "Homicídios Homens Negros");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    //printa a Exceção
                }
            }
        });

        //Ação do botão ****
        btnHomensNaoNegros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Tenta abrir o gráfico passando para o método escolhaTipo(nomeArquivo, tituloGráfico)
                try {
                    escolhaTipo(HOMENS_NAO_NEGROS_PAIS, "Homicídios Homens Não Negros");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    //printa a Exceção
                }
            }
        });

        //Ação do botão ****
        btnMulheresNaoNegras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Tenta abrir o gráfico passando para o método escolhaTipo(nomeArquivo, tituloGráfico)
                try {
                    escolhaTipo(MULHERES_NAO_NEGRAS_PAIS, "Homicídios Mulheres Não Negras");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    //printa a Exceção
                }
            }
        });

        //Ação do botão ****
        btnHomicidiosMulheresNegrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Tenta abrir o gráfico passando para o método escolhaTipo(nomeArquivo, tituloGráfico)
                try {
                    escolhaTipo(MULHERES_NEGRAS_PAIS, "Homicídios Mulheres Negras");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    //printa a Exceção
                }
            }
        });

        //Ação do botão ****
        btnMulheresPais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Tenta abrir o gráfico passando para o método escolhaTipo(nomeArquivo, tituloGráfico)
                try {
                    escolhaTipo(MULHERES_PAIS, "Homicídios Mulheres");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    //printa a Exceção
                }
            }
        });

        //Ação do botão ****
        btnHomicidiosNaoNegros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Tenta abrir o gráfico passando para o método escolhaTipo(nomeArquivo, tituloGráfico)
                try {
                    escolhaTipo(HOMICIDIOS_PESSOAS_NAO_NEGRAS, "Homicídios Pessoas Não Negras");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    //printa a Exceção
                }
            }
        });

        //Ação do botão ****
        btnHomicidiosPessoasNegras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Tenta abrir o gráfico passando para o método escolhaTipo(nomeArquivo, tituloGráfico)
                try {
                    escolhaTipo(HOMICIDIOS_PESSOAS_NEGRAS, "Homicídios Pessoas Negras");

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    //printa a Exceção
                }
            }
        });

        //Ação do botão ****
        btnHomicidiosHomens.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Tenta abrir o gráfico passando para o método escolhaTipo(nomeArquivo, tituloGráfico)
                try {
                    escolhaTipo(HOMICIDIOS_HOMENS, "Homicídios de Homens");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    //printa a Exceção
                }
            }
        });

        //Acao do RadioButton
        rdnTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Deixa o clicado marcado e desmarca o outro
                rdnMedia.setSelected(false);
                rdnTotal.setSelected(true);
            }
        });
        //Acao do RadioButton
        rdnMedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Deixa o clicado marcado e desmarca o outro
                rdnTotal.setSelected(false);
                rdnMedia.setSelected(true);
            }
        });
        //Ação do botão Sair do aplicativo
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                btnSair.setBounds(12, 12, 30, 25);
                //setBounds arredondamento das bordas;
            }
        });
    }

    //Método escolha tipo
    private void escolhaTipo(String arquivo, String tituloGrafico) throws IOException {
        //criancao da instancia da classe excelOpen
        ExcelOpen excelOpen = new ExcelOpen();
        if (rdnMedia.isSelected()) {
            //Se radioButton Media estiver selecionado ele irá chamar o metodo Chart3 da classe excelOpen
            //Recebe o nomeArquivo, tipoDeDado, tituloDoGráfico
            excelOpen.Chart3(arquivo
                    , "media", tituloGrafico);
        }
        if (rdnTotal.isSelected()) {
            //Se radioButton Total estiver selecionado ele irá chamar o metodo Chart3 da classe excelOpen
            //Recebe o nomeArquivo, tipoDeDado, tituloDoGráfico
            excelOpen.Chart3(arquivo, "total", tituloGrafico);
        }
    }

    public static void main(String[] args) {
        frame.setContentPane(new App().panelMain);
        //setDefaultCloseOperation = Sair da aplicacao no X button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Size do frame
        frame.setSize(520, 560);
        //Redimensionamento = false
        frame.setResizable(false);

        //Cria uma nova imagem a partir do caminho
        ImageIcon img = new ImageIcon("src/icon/line-stats.png");
        //Set o icone como img
        frame.setIconImage(img.getImage());

        //Abrir a janela no centro da Tela
        frame.setLocationRelativeTo(null);

        //Frame Visible
        frame.setVisible(true);
    }
}
