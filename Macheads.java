import javax.swing.JFrame;


public class Macheads 
{
    public static int screenWidth = 600, screenHeight = 400;
    public static void main(String args[])
    {
        second s = new second();
        JFrame f = new JFrame("Flappy Bird");
        f.add(s);
        f.setSize(screenWidth, screenHeight);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
}