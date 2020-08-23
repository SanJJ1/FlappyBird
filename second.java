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
    double x = 100, y = 100, yVel = 0, xVel = 0, grav = .03, birdWidth = 34, birdHeight = 25;
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
        Ellipse2D birdHitBox = new Ellipse2D.Double((int)x, (int)y, birdWidth, birdHeight);

        g2.draw(birdHitBox);

        //edge detection
        if (y > Macheads.screenHeight - birdHeight - 30)
        {
            bounce();
        }
        else if (y < 0)
        {
            y = 0;
            yVel = 0;
        }



        t.start();
    }

    public void bounce()
    {
        yVel = -3;
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

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_SPACE)
        {
            bounce();
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}