/**
 * Created by Siarhei on 26.12.2015.
 */
import javax.swing.*;
import java.awt.*;

/**
 * Created by Siarhei on 16.11.2015.
 */
public class Commands{
    private String currentComand;
    private JLabel textPane;
    boolean snapSwitched;
    private final String first = new String("Check the operation of the electro runs guns and exhaust fan.");
    private final String seccond = new String("Switch the shooting mode switch to O.");
    private final String third = new String("Switch the shooting mode switch to M.");
    private final String fourth = new String("Switch the shooting mode switch to B.");


    public Commands(JLabel textPane){
        this.textPane = textPane;
        currentComand = first;
        snapSwitched = false;
        // String string = new String();
       // textPane.setOpaque(true);
        textPane.setBackground(Color.DARK_GRAY);
        textPane.setFont(new Font("Serif", Font.PLAIN, 16));
        textPane.setForeground(Color.red);
        textPane.setHorizontalAlignment(JLabel.CENTER);
        textPane.setPreferredSize(new Dimension(500,100));
        textPane.setLocation(150,5);
    /*try {
        byte[] data = str.getBytes("");
        string = new String(str.getBytes("UTF-8"),"Cp866");
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }*/
        textPane.setText(currentComand);
    }

    public void takeAngel(double angel){
        if(angel <= -0.9 && currentComand == seccond) {
            currentComand = third;
            textPane.setText(currentComand);
        }
        if(angel <= 0.1 && angel >= -0.1 && currentComand == third){
            currentComand = fourth;
            textPane.setText(currentComand);
        }
        if(angel >= 0.9 && currentComand == fourth){
            currentComand = null;
            textPane.setText("Complite!!!");
        }

    }
    public void setSnapSwitched(){
        if(currentComand == first)
            if(snapSwitched == false) snapSwitched = true;
            else{ snapSwitched = false; currentComand = seccond;
                textPane.setText(currentComand);

            }
    }

}
