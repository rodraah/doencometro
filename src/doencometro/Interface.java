package doencometro;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Interface {
    static JPanel criarLinha(String texto, Object objeto) {
        JPanel linha = new JPanel();
        linha.add(new JLabel(texto));
        linha.add((Component) objeto);

        return linha;
    }

    static void relatorioOcorrencia() {
        JFrame janela = new JFrame("Relatório de ocorrência");
        janela.setSize(500,500);

        JPanel painel = new JPanel();
        painel.setBorder(new EmptyBorder(10,50,50,50));
        painel.setLayout(new javax.swing.BoxLayout(painel, 1));

        painel.add(new JLabel("Formulário de ocorrência"));
        painel.add(new JSeparator());
        
        // --- INPUT DO USUÁRIO
        Dimension dimensaoCaixa = new Dimension(200, 30);

        JTextField nomeUsuario = new JTextField();
        nomeUsuario.setPreferredSize(dimensaoCaixa);
        painel.add(criarLinha("Nome: ", nomeUsuario));

        ArrayList<Doenca> todasAsDoencas = Doenca.todasAsDoencas;
        String[] doencas = new String[todasAsDoencas.size()];
        for (int i=0;i<todasAsDoencas.size();i++) {
            Doenca doenca = todasAsDoencas.get(i);
            String nome = doenca.obterNome();
            doencas[i] = nome;
        }

        @SuppressWarnings({"unchecked", "rawtypes"})
        JComboBox<String> doencaRelator = new JComboBox(doencas);
        doencaRelator.setPreferredSize(dimensaoCaixa);
        painel.add(criarLinha("Doença: ", doencaRelator));

        JButton btnOk = new JButton("Sintomas");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Doenca doenca = Doenca.acharDoencaPorNome(doencaRelator.getSelectedItem().toString());
                // String texto = String.format("Sintomas de %s: %s", doenca.obterNome(), doenca.obterSintomas());
                // JOptionPane.showMessageDialog(painel, texto, "SINTOMAS", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        // --- Fim do input

        painel.add(btnOk);

        janela.add(painel);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setVisible(true);
    }
}