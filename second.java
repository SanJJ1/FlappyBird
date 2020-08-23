import javax.swing.*;
import javax.swing.Timer;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;



public class second extends JPanel implements ActionListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Timer t = new Timer(10, this);
    double x = 0, y = 0, yVel = 0, xVel = 0, grav = .0001;


    private ImageIcon bird;
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        bird = new ImageIcon("imgs/yellowbird-midflap.png");
        bird.paintIcon(this, g, (int)x, (int)y); 
        Ellipse2D birdHitBox = new Ellipse2D.Double((int)x, (int)y, 34, 25);

        g2.draw(birdHitBox);
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