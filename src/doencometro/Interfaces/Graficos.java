package doencometro.Interfaces;

import javax.swing.*;

import doencometro.banco.Sql;

import java.awt.*;

public class Graficos extends JPanel {

    private static final int COLUMN_WIDTH = 100;
    private static final int COLUMN_GAP = 20;
    private static final int GRAPH_HEIGHT = 200;
    private static final Color[] COLORS = { new Color(82, 127, 215), 
                                            new Color(189, 87, 87), 
                                            new Color(80, 176, 108), 
                                            new Color(255, 204, 102), 
                                            new Color(134, 111, 177) };
    private static final String[] LABELS = {"Sao Paulo", 
                                            "Sao Bernardo", 
                                            "Sao Caetano", 
                                            "Santo Andre", 
                                            "Campinas"}; 

    public Graficos() {
        setBackground(new Color(204, 255, 229));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = COLUMN_GAP; 

        for (int i = 0; i < LABELS.length; i++) {
            int quantidade = Sql.obterQuantidadeDeCasos(LABELS[i]);
            int columnHeight = (int) (quantidade / 250.0 * GRAPH_HEIGHT); 
            int y = GRAPH_HEIGHT - columnHeight;

            // Desenha a sombra da coluna
            g.setColor(new Color(0, 0, 0, 50)); 
            Graphics2D g2d = (Graphics2D) g;
            g2d.fillRect(x + 4, y + 4, COLUMN_WIDTH, columnHeight);

            // Desenha a coluna
            g.setColor(COLORS[i]);
            g.fillRect(x, y, COLUMN_WIDTH, columnHeight);

            // Adiciona rótulo no centro da coluna
            g.setColor(Color.BLACK);
            FontMetrics fm = g.getFontMetrics();
            int labelX = x + (COLUMN_WIDTH - fm.stringWidth(LABELS[i])) / 2;
            int labelY = y + columnHeight / 2 + fm.getAscent() / 2;
            g.drawString(LABELS[i], labelX, labelY);

            x += COLUMN_WIDTH + COLUMN_GAP; 
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Gráficos em Colunas em Java");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(670, 300);
            frame.getContentPane().add(new Graficos());
            frame.setVisible(true);
        });

    }
}