import javax.swing.*;
import javax.swing.Timer;
// import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.concurrent.ThreadLocalRandom;



public class second extends JPanel implements ActionListener, KeyListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Timer t = new Timer(10, this);
    double x = 100, y = 100, yVel = 0, xVel = 0, grav = .1, 
            birdWidth = 34, birdHeight = 25,
            bgX = 0, bgVel = .5, bX = 0, bVel = 1;
    String s = "assets/sprites/";
    int i = ThreadLocalRandom.current().nextInt(0, 3), j = 0;

    ImageIcon[] backgrounds = 
    {
        new ImageIcon(s + "background-night.png"),
        new ImageIcon(s + "background-night.png")
    };
    ImageIcon[][] birdFrames = 
    { 
        {
            new ImageIcon(s + "yellowbird-downflap.png"),
            new ImageIcon(s + "yellowbird-midflap.png"),
            new ImageIcon(s + "yellowbird-upflap.png")
        },
        {
            new ImageIcon(s + "redbird-downflap.png"),
            new ImageIcon(s + "redbird-midflap.png"),
            new ImageIcon(s + "redbird-upflap.png")
        },
        {
            new ImageIcon(s + "bluebird-downflap.png"),
            new ImageIcon(s + "bluebird-midflap.png"),
            new ImageIcon(s + "bluebird-upflap.png")
        }  
    };

    ImageIcon background = backgrounds[ThreadLocalRandom.current().nextInt(0, 2)];
    ImageIcon base = new ImageIcon(s + "base.png");

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

        background.paintIcon(this, g, (int)bgX, 0);
        background.paintIcon(this, g, (int)bgX + 288, 0);
        background.paintIcon(this, g, (int)bgX + 576, 0);
        bgX -= bgVel;
        bgX %= 288;
        base.paintIcon(this, g, (int)bX, 420);
        base.paintIcon(this, g, (int)bX + 336, 420);
        base.paintIcon(this, g, (int)bX + 336 + 336, 420);
        bX -= bVel;
        bX %= 336;


        j++;
        j %= 3;
        bird = birdFrames[i][j];
        bird.paintIcon(this, g, (int)x, (int)y); 
        Ellipse2D birdHitBox = new Ellipse2D.Double((int)x, (int)y, birdWidth, birdHeight);
        g2.draw(birdHitBox);


        detectEdges();


        t.start();
    }

    public void detectEdges()
    {
        if (y > Macheads.screenHeight - birdHeight - 30)
        {
            bounce();
        }
        else if (y < 0)
        {
            y = 0;
            yVel = 0;
        }
    }

    public void bounce()
    {
        yVel = -5;
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

