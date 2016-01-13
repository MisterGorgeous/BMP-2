
import javax.swing.*;
import java.awt.*;


public class Commands{
    private String currentComand;
    private JTextPane textPane;
    private int comCounter;
    private final String commands[] = {"Switch the lamp.","Turn the handle of the ax down until it locks.","Stall tower."};



    public Commands(JTextPane textPane){
        this.textPane = textPane;
        currentComand = commands[0];
        comCounter = 0;
        textPane.setBackground(Color.cyan);
        textPane.setFont(new Font("Serif", Font.PLAIN, 16));
        textPane.setForeground(Color.red);
        //textPane.setHorizontalAlignment(JLabel.CENTER);
        textPane.setPreferredSize(new Dimension(100,20));
        textPane.setLocation(150,5);
    /*try {
        byte[] data = str.getBytes("");
        string = new String(str.getBytes("UTF-8"),"Cp866");
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }*/
        textPane.setText(currentComand);
    }

    public boolean perfomeCommand(int comIndex){
        if(comCounter == comIndex){
            ++comCounter;
            currentComand = commands[comCounter];
            textPane.setText(currentComand);
            return true;
        }
        else{
            return false;
        }

    }

    public void repaintPane(){
        textPane.repaint();
    }

}
