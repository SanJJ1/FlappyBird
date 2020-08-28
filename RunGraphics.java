import javax.swing.*;
import javax.swing.Timer;
// import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.concurrent.ThreadLocalRandom;


public class RunGraphics extends JPanel implements ActionListener, KeyListener
{
    private static final long serialVersionUID = 1L;
    Timer t = new Timer(7, this);
    double x = 70, y = 100, yVel = 0, xVel = 0, grav = .13, 
            birdWidth = 34, birdHeight = 25,
            bgX = 0, bgVel = .3;

    public static double bX = 0, bVel = 1.3;
    String s = "assets/sprites/";
    int i = ThreadLocalRandom.current().nextInt(0, 3), j = 0;

    ImageIcon[] backgrounds = 
    {
        new ImageIcon(s + "background-day.png"),
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
    
    public RunGraphics()
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
        background.paintIcon(this, g, (int)bgX + 280, 0);
        background.paintIcon(this, g, (int)bgX + 560, 0);
        bgX -= bgVel;
        bgX %= 280;

        Pipe.draw(this, g);


        base.paintIcon(this, g, (int)bX, 420);
        base.paintIcon(this, g, (int)bX + 336, 420);
        base.paintIcon(this, g, (int)bX + 336 + 336, 420);
        bX -= bVel;
        bX %= 336;
        Rectangle2D baseHitBox = new Rectangle2D.Double(0, 420, Main.screenWidth, 112);


        j++;
        j %= 3;
        bird = birdFrames[i][j];
        bird.paintIcon(this, g, (int)x, (int)y); 
        Ellipse2D birdHitBox = new Ellipse2D.Double((int)x, (int)y, birdWidth, birdHeight);


        detectEdges(birdHitBox, baseHitBox);


        t.start();
    }

    public void detectEdges(Ellipse2D birdhit, Rectangle2D basehit)
    {

        if (y < 3)
        {
            y = 3;
        }
        else if(birdhit.intersects(basehit))
        {
            bounce();
        }

    }

    public void bounce()
    {
        yVel = -5;
    }

    private static double sigmoid(double x)
    {
        int n = 20;
        double nd2 = 10;
        double nd = .05;
        return n / (1 + Math.exp(-4 * x * nd)) - nd2;
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        x += xVel;
        y += yVel;
        yVel += grav;
        yVel = sigmoid(yVel);
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

