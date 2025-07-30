package Labs.FormEventHandling.done;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdvancedDrawing extends JPanel {
    private int shapeX = 50, shapeY = 50; // Initial position of the shape

    public AdvancedDrawing() {
        // Mouse Listener to change shape position on click
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                shapeX = e.getX();
                shapeY = e.getY();
                repaint(); // Redraw shapes at new position
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Anti-aliasing for smoother edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Gradient Paint
        GradientPaint gradient = new GradientPaint(50, 50, Color.RED, 150, 150, Color.YELLOW, true);
        g2d.setPaint(gradient);
        g2d.fillOval(shapeX, shapeY, 100, 60);

        // Solid Color
        g2d.setColor(Color.BLUE);
        g2d.fillRect(shapeX + 120, shapeY, 80, 60);

        // Custom Stroke (Dashed Line)
        float[] dashPattern = {10, 10}; // Dash pattern
        BasicStroke dashedStroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 10, dashPattern, 0);
        g2d.setStroke(dashedStroke);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(shapeX, shapeY + 100, shapeX + 200, shapeY + 100);

        // Polygon (Triangle)
        int[] xPoints = {shapeX + 50, shapeX + 100, shapeX};
        int[] yPoints = {shapeY + 120, shapeY + 200, shapeY + 200};
        g2d.setColor(Color.GREEN);
        g2d.fillPolygon(xPoints, yPoints, 3);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("2D Shapes Drawing");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new AdvancedDrawing());
        frame.setVisible(true);
    }
}

