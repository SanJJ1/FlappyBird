import javax.swing.JFrame;


public class Macheads 
{
    public static void main(String args[])
    {
        second s = new second();
        JFrame f = new JFrame("Flappy Bird");
        f.add(s);
        f.setSize(600, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
}