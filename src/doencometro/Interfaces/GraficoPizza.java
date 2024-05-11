package doencometro.Interfaces;

import javax.swing.*;
import java.awt.*;

public class GraficoPizza extends JPanel {

    private static final Color[] COLORS = { new Color(82, 127, 215),
                                            new Color(189, 87, 87),
                                            new Color(80, 176, 108),
                                            new Color(255, 204, 102),
                                            new Color(134, 111, 177) };
    private static final String[] LABELS = {"São Paulo",
                                            "Rio de Janeiro",
                                            "Minas Gerais",
                                            "Bahia",
                                            "Paraná"};
    private static final int[] DATA = {50, 100, 150, 200, 250};

    public GraficoPizza() {
        setBackground(new Color(204, 255, 229)); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int total = 0;
        for (int value : DATA) {
            total += value; // Calcula o total dos dados
        }

        int startAngle = 0;
        for (int i = 0; i < DATA.length; i++) {
            int arcAngle = (int) (360.0 * DATA[i] / total); 

            g.setColor(COLORS[i]);
            g.fillArc(50, 50, 200, 200, startAngle, arcAngle);

            // Adiciona rótulo no centro da fatia
            g.setColor(Color.BLACK);
            FontMetrics fm = g.getFontMetrics();
            int labelX = 150 + (int) (100 * Math.cos(Math.toRadians(startAngle + arcAngle / 2)));
            int labelY = 150 + (int) (100 * Math.sin(Math.toRadians(startAngle + arcAngle / 2)));
            g.drawString(LABELS[i], labelX - fm.stringWidth(LABELS[i]) / 2, labelY + fm.getAscent() / 2);

            startAngle += arcAngle; 
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Gráfico de Pizza em Java");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 300);
            frame.getContentPane().add(new GraficoPizza());
            frame.setVisible(true);
        });
    }
}
