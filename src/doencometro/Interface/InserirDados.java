package doencometro.Interface;

import javax.swing.*;
import javax.swing.border.Border;

import doencometro.Cidade;
import doencometro.Doenca;
import doencometro.Ocorrencia.AdicionarOcorrencia;
import doencometro.Ocorrencia.DeletarOcorrencia;
import doencometro.Ocorrencia.Ocorrencia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InserirDados extends JFrame {

    private JTextField dataField;
    private JTextField casosField;
    private JComboBox<String> doencaComboBox;
    private JComboBox<String> estadoComboBox;
    private JComboBox<String> cidadeComboBox;
    private JButton finalizarButton;
    private JButton adicionarNovaOcorrencia;
    private JButton adicionarOcorrencia;

    public InserirDados(boolean admin) {

        setTitle("Cadastro de Cidade para Gripe");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Define a posição da janela centralizada na tela
        setResizable(false);

        Border borda = BorderFactory.createEmptyBorder(20,20,20,20);

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, 1));
        painelPrincipal.setBorder(borda);

        JPanel painel = new JPanel(new GridLayout(6, 2, 5, 5));

        JPanel rodape = new JPanel();
        painel.setBorder(borda);

        JLabel qtdeCasos = new JLabel("Quantidade de casos: ");
        casosField = new JTextField();

        JLabel dataLabel = new JLabel("Data:");
        dataField = new JTextField();

        JLabel estadoLabel = new JLabel("Estado do paciente:");
        estadoComboBox = new JComboBox<>(Ocorrencia.ESTADOS);

        JLabel doencaLabel = new JLabel("Selecione a doença:");
        doencaComboBox = new JComboBox<>(new String[]{"Gripe", "COVID-19"});

        JLabel cidadeLabel = new JLabel("Selecione a cidade:");
        cidadeComboBox = new JComboBox<>(new String[]{"Sao Bernardo", "Santo Andre", "Sao Caetano", "Sao Paulo", "Campinas"});


        adicionarOcorrencia = new JButton("Adicionar Ocorrência");
        adicionarOcorrencia.addActionListener(new ActionListener() {
            // Adiciona o override pra sobrescrever o componente JFrame
            @Override
            public void actionPerformed(ActionEvent e){
                adicionarOcorrencia();
                String mensagem = "A Ocorrência Foi Adicionada";
                JOptionPane.showMessageDialog(null, mensagem, "Cadastro Finalizado", JOptionPane.INFORMATION_MESSAGE);
                painel.remove(adicionarOcorrencia);
                painel.add(adicionarNovaOcorrencia);
                dataField.setText("");
                casosField.setText("");
                painel.revalidate();
            }
        });

        adicionarNovaOcorrencia = new JButton("Adicionar Nova Ocorrência");
        adicionarNovaOcorrencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarOcorrencia();
                dataField.setText("");
                casosField.setText("");
            }
        });

        JButton deletarOcorrencia  = new JButton("Deletar Ocorrência");
        deletarOcorrencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeletarOcorrencia.deletarUltimaOcorrencia();
                JOptionPane.showMessageDialog(painelPrincipal, "A última ocorrência foi deletada!");
            }
        });

        finalizarButton = new JButton("Finalizar");
        finalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mensagem = "Processo finalizado";
                JOptionPane.showMessageDialog(null, mensagem, "Cadastro Finalizado", JOptionPane.INFORMATION_MESSAGE);
                // Se o usuário for da upa, fecha a janela
                // Se não, abre os gráficos
                if (admin) {
                    Graficos.desenharInterface();
                } else {
                    TelaLogin.chamarInterface();
                    dispose();
                }
            }
        });

        rodape.add(finalizarButton);

        painel.add(qtdeCasos);
        painel.add(casosField);
        painel.add(dataLabel);
        painel.add(dataField);
        painel.add(doencaLabel);
        painel.add(doencaComboBox);
        painel.add(estadoLabel);
        painel.add(estadoComboBox);
        painel.add(cidadeLabel);
        painel.add(cidadeComboBox);
        painel.add(deletarOcorrencia);
        painel.add(adicionarOcorrencia);

        painelPrincipal.add(painel);
        painelPrincipal.add(rodape);

        add(painelPrincipal, BorderLayout.CENTER);
    }

    public static void desenharInterface(boolean admin){
        SwingUtilities.invokeLater(() -> {
            InserirDados telaGripeCidade;
            if (admin) {
                telaGripeCidade = new InserirDados(true);
            } else {
                telaGripeCidade = new InserirDados(false);
            }
            telaGripeCidade.setVisible(true);
        });
        
    }

    private void adicionarOcorrencia(){
        int qtdeCasos = Integer.parseInt(casosField.getText());
        String dataLabel = dataField.getText();
        String doencaLabel = doencaComboBox.getSelectedItem().toString();
        String estadoLabel = estadoComboBox.getSelectedItem().toString();
        String cidadeLabel = cidadeComboBox.getSelectedItem().toString();

        int cidadeId = Cidade.acharCidade(cidadeLabel).obterId();
        int doencaId = Doenca.acharDoencaPorNome(doencaLabel).obterId();

        AdicionarOcorrencia.adicionar(qtdeCasos, dataLabel, estadoLabel, cidadeId, doencaId);
    }
}
