import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Macheads 
{
    public static int screenWidth = 400, screenHeight = 548;
    public static void main(String args[])
    {
        second s = new second();
        JFrame f = new JFrame("Flappy Bird");
        ImageIcon icon = new ImageIcon("assets/sprites/yellowbird-midflap.png");
        f.setIconImage(icon.getImage());
        f.add(s);
        f.setSize(screenWidth, screenHeight);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
}


