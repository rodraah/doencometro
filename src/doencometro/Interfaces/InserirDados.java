package doencometro.Interfaces;

import javax.swing.*;

import doencometro.Cidade;
import doencometro.Doenca;
import doencometro.Ocorrencia.AdicionarOcorrencia;
import doencometro.Ocorrencia.DeletarOcorrencia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InserirDados extends JFrame {

    private JTextField dataField; // Campo de texto para o nome do paciente
    private JTextField casosField;
    private JComboBox<String> doencaComboBox; // ComboBox para selecionar a doença
    private JComboBox<String> estadoComboBox; // ComboBox para selecionar o estado do paciente
    private JComboBox<String> cidadeComboBox; // ComboBox para selecionar a cidade
    private JButton finalizarButton; // Botão para finalizar o cadastro
    private JButton adicionarNovaOcorrencia; // Botão para ver a tabela
    private JButton adicionarOcorrencia;

    public InserirDados() {

        setTitle("Cadastro de Cidade para Gripe"); // Define o título da janela
        setSize(500, 300); // Define o tamanho da janela
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Define a operação padrão de fechamento da janela
        setLocationRelativeTo(null); // Define a posição da janela centralizada na tela
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5)); // Cria um novo painel com layout de grade
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Define a borda do painel

        JLabel qtdeCasos = new JLabel("Quantidade de casos: ");
        casosField = new JTextField();

        JLabel dataLabel = new JLabel("Data:");
        dataField = new JTextField();

        JLabel estadoLabel = new JLabel("Estado do paciente:");
        estadoComboBox = new JComboBox<>(new String[]{"Vivo", "Internado", "Contaminado", "Óbito"});

        JLabel doencaLabel = new JLabel("Selecione a doença:");
        doencaComboBox = new JComboBox<>(new String[]{"Gripe", "COVID-19"}); // Gripe é a opção pré-selecionada

        JLabel cidadeLabel = new JLabel("Selecione a cidade:");
        cidadeComboBox = new JComboBox<>(new String[]{"Sao Bernardo", "Santo Andre", "Sao Caetano", "Sao Paulo", "Campinas"});


        adicionarOcorrencia = new JButton("Adicionar Ocorrência");
        adicionarOcorrencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                dadosOcorrencia();
                String mensagem = "A Ocorrência Foi Adicionada";
                JOptionPane.showMessageDialog(null, mensagem, "Cadastro Finalizado", JOptionPane.INFORMATION_MESSAGE);
                panel.remove(adicionarOcorrencia);
                panel.add(finalizarButton);
                panel.add(adicionarNovaOcorrencia);
                dataField.setText("");
                casosField.setText("");
                panel.revalidate();
        }});

        // Cria um botão para finalizar o cadastro
        finalizarButton = new JButton("Finalizar");
        // Adiciona um ActionListener ao botão "Finalizar"
        finalizarButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // exibição dentro do showMenssageDialog apos clicar em finalizar
                String mensagem = "Processo finalizado";
                JOptionPane.showMessageDialog(null, mensagem, "Cadastro Finalizado", JOptionPane.INFORMATION_MESSAGE);
                Graficos.main(null);
                DeletarOcorrencia.deletarUltimaOcorrencia();
                dispose(); // Fecha a tela atual
            }
        });

        //Cria um botão para ver a tabela
        adicionarNovaOcorrencia = new JButton("Adicionar Nova Ocorrência");
        // Adiciona um ActionListener ao botão "Ver Tabela"
        adicionarNovaOcorrencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dadosOcorrencia();
                dataField.setText("");
                casosField.setText("");
            }
        });

        // Adiciona os componentes ao painel
        panel.add(qtdeCasos);
        panel.add(casosField);
        panel.add(dataLabel);
        panel.add(dataField);
        panel.add(doencaLabel);
        panel.add(doencaComboBox);
        panel.add(estadoLabel);
        panel.add(estadoComboBox);
        panel.add(cidadeLabel);
        panel.add(cidadeComboBox);
        panel.add(adicionarOcorrencia);

        add(panel, BorderLayout.CENTER); // Adiciona o painel ao centro da janela
    }

    public static void chamarInterface(){
        SwingUtilities.invokeLater(() -> {
            InserirDados telaGripeCidade = new InserirDados();
            telaGripeCidade.setVisible(true);
        });
        
    }

    public void dadosOcorrencia(){
        int qtdeCasos = Integer.parseInt(casosField.getText());
        String dataLabel = dataField.getText();
        String doencaLabel = doencaComboBox.getSelectedItem().toString();
        String estadoLabel = estadoComboBox.getSelectedItem().toString();
        String cidadeLabel = cidadeComboBox.getSelectedItem().toString();

        int cidadeId = Cidade.acharCidade(cidadeLabel).obterId();
        int doencaId = Doenca.acharDoencaPorNome(doencaLabel).obterId();

        AdicionarOcorrencia.adicionarOcorrencia(qtdeCasos, dataLabel, estadoLabel, cidadeId, doencaId);
    }
}
