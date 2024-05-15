package doencometro.Interface;

import javax.swing.*;

import doencometro.Ocorrencia.Ocorrencia;
import doencometro.Banco.Sql;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graficos extends JPanel {

    private static final int COLUMN_WIDTH = 100;
    private static final int COLUMN_GAP = 20;
    private static final int GRAPH_HEIGHT = 300;
    private static final Color[] COLORS = { new Color(82, 127, 215), 
                                            new Color(189, 87, 87), 
                                            new Color(80, 176, 108), 
                                            new Color(255, 204, 102), 
                                            new Color(134, 111, 177) };

    private static final String[] CIDADES = {"Sao Paulo", 
                                            "Sao Bernardo", 
                                            "Sao Caetano", 
                                            "Santo Andre", 
                                            "Campinas"}; 

    private static JComboBox<String> comboEstado;

    public Graficos() {
        setBackground(new Color(218,218,218));

        this.add(new JLabel("Situação: "));
        comboEstado = new JComboBox<String>(Ocorrencia.ESTADOS);
        this.add(comboEstado);
        // Quando o usuário interage com o combobox, desenha novamente a interface
        comboEstado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = COLUMN_GAP; 

        // percorrer as cidades (na velocidade máxima permitida!! não somos a favor de ultrapassar a velocidade da via)
        for (int i = 0; i < CIDADES.length; i++) {
            // aqui vai deciDIR O TAMANHO
            // pronto
            int quantidade = Sql.obterQuantidadeDeCasos(CIDADES[i], comboEstado.getSelectedItem().toString());
            int columnHeight = (int) (quantidade / 250.0 * GRAPH_HEIGHT); 
            int y = this.getHeight() - columnHeight - (COLUMN_GAP * 3);

            // Desenha a sombra da coluna
            g.setColor(new Color(0, 0, 0, 50)); 
            Graphics2D g2d = (Graphics2D) g;
            g2d.fillRect(x + 4, y + 4, COLUMN_WIDTH, columnHeight);

            // Desenha a coluna
            g.setColor(COLORS[i]);
            g.fillRect(x, y, COLUMN_WIDTH, columnHeight);

            // Adiciona rótulo em baixo da coluna
            g.setColor(Color.BLACK);
            FontMetrics fm = g.getFontMetrics();
            int labelX = x + (COLUMN_WIDTH - fm.stringWidth(CIDADES[i])) / 2;
            int labelY = this.getHeight() - (COLUMN_GAP * 2);
            g.drawString(CIDADES[i], labelX, labelY);

            // Desenha a quantidade
            g.drawString(String.valueOf(quantidade), labelX, (labelY + COLUMN_GAP));

            x += COLUMN_WIDTH + COLUMN_GAP; 
        }
    }

    public static void desenharInterface() {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Gráficos em Colunas em Java");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setMinimumSize(new Dimension(620,500));
            frame.setSize(620, 500);
            frame.getContentPane().add(new Graficos());
            frame.setVisible(true);
        });
    }
}