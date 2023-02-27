import javax.swing.*;

public class main extends pantalla{
    public static void main(String[] args){
        JFrame frame = new JFrame("Fechas");
        frame.setContentPane(new pantalla().pantalla1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
