import javax.swing.*;
import javax.swing.Timer;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;



public class second extends JPanel implements ActionListener, KeyListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Timer t = new Timer(5, this);
    double x = 100, y = 100, yVel = 0, xVel = 0, grav = .03;
    private ImageIcon bird;
    
    public second()
    {
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
    }

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

    @Override
    public void keyTyped(KeyEvent e)
    {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_SPACE)
        {
            yVel = -2;
            System.out.println("Typed");
        }
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_SPACE)
        {
            yVel = -3;
            System.out.println("pressed");
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}