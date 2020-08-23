import javax.swing.*;
import javax.swing.Timer;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;


public class second extends JPanel implements ActionListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Timer t = new Timer(5, this);
    double x = 0, y = 0, yVel = 1, xVel = 1, grav = .1;


    private ImageIcon image;
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        image = new ImageIcon("imgs/yellowbird-midflap.png");
        image.paintIcon(this, g, (int)x, (int)y);
        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        x += xVel;
        y += yVel;
        yVel += grav;
        repaint();
    }
}