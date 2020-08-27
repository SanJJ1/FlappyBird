import javax.swing.*;
import javax.swing.Timer;
// import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.concurrent.ThreadLocalRandom;

public class Pipe
{
    public static String s = "assets/sprites/";
    public static ImageIcon pipe = new ImageIcon(s + "pipe-green.png");
    public static double pipeX = 0, pipeVel = RunGraphics.bVel;

    public Pipe()
    {

    }

    public static void draw(Component c, Graphics g)
    {
        pipe.paintIcon(c, g, 0, 0);
    }
}




