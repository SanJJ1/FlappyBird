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
    private ImageIcon image;
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        image = new ImageIcon("imgs/yellowbird-midflap.png");
        image.paintIcon(this, g, 0, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}