
import javax.swing.*;
import java.awt.*;
import java.io.UnsupportedEncodingException;


public class Commands{
    private String currentComand;
    private JTextPane textPane;
    private int comCounter;
    private Arrow arrow;
    private MyDialog dialog;
    private String commands[] = {//"Switch the lamp.","Turn the handle of the ax down until it locks.","Stall tower."};
            "\u0412\u043a\u043b\u044e\u0447\u0438\u0442\u044c\u0020\u0432\u044b\u043a\u043b\u044e\u0447\u0430\u0442\u0435\u043b\u044c\u0020\u043f\u043b\u0430\u0444\u043e\u043d\u0430\u0020\u043e\u0441\u0432\u0435\u0449\u0435\u043d\u0438\u044f\u002e",
    "\u0420\u0430\u0441\u0442\u043e\u043f\u043e\u0440\u0438\u0442\u044c\u0020\u043f\u0443\u0448\u043a\u0443\u002e"
    ,"\u0421\u043d\u044f\u0442\u044c\u0020\u0431\u0430\u0448\u043d\u044e\u0020\u0441\u043e\u0020\u0441\u0442\u043e\u043f\u043e\u0440\u0430\u002e"
   ,"\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c\u0020\u0440\u0430\u0431\u043e\u0442\u0443\u0020\u043f\u043e\u0434\u044a\u0435\u043c\u043d\u043e\u0433\u043e\u0020\u043c\u0435\u0445\u0430\u043d\u0438\u0437\u043c\u0430\u002e"
    ,"\u0412\u043a\u043b\u044e\u0447\u0430\u0435\u0442\u0020\u0441\u0442\u0430\u0431\u0438\u043b\u0438\u0437\u0430\u0442\u043e\u0440\u002e"
    ,"\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c\u0020\u0440\u0430\u0431\u043e\u0442\u0443\u0020\u0441\u0442\u0430\u0431\u0438\u043b\u0438\u0437\u0430\u0442\u043e\u0440\u0430\u002e"
    ,"\u0412\u044b\u043a\u043b\u044e\u0447\u0438\u0442\u044c\u0020\u0441\u0442\u0430\u0431\u0438\u043b\u0438\u0437\u0430\u0442\u043e\u0440\u002e"
            ,"\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c\u0020\u0440\u0430\u0431\u043e\u0442\u0443\u0020\u043f\u0435\u0440\u0435\u043a\u043b\u044e\u0447\u0430\u0442\u0435\u043b\u044f\u0020\u0442\u0438\u043f\u0430\u0020\u0431\u043e\u0435\u043f\u0440\u0438\u043f\u0430\u0441\u043e\u0432\u0020\u043a\u0020\u043f\u0443\u0448\u043a\u0435\u002e"
    ,"\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c\u0020\u0440\u0430\u0431\u043e\u0442\u0443\u0020\u044d\u043b\u0435\u043a\u0442\u0440\u043e\u0441\u043f\u0443\u0441\u043a\u0430\u0020\u0438\u0020\u043f\u043e\u0434\u0432\u0438\u0436\u043d\u044b\u0445\u0020\u0447\u0430\u0441\u0442\u0435\u0439\u0020\u043f\u0443\u043b\u0435\u043c\u0435\u0442\u0430\u002e"
    ,"\u0414\u043e\u043b\u043e\u0436\u0438\u0442\u044c\u0020\u043a\u043e\u043c\u0430\u043d\u0434\u0438\u0440\u0443\u0020\u043e\u0020\u0433\u043e\u0442\u043e\u0432\u043d\u043e\u0441\u0442\u0438\u002e"
};
    private int arrowX[] ={750,295,375,530,610,530,1370,715,0

 };
    private int arrowY[] ={
35,275,395,330,330,330,80,195,0
    };


    public Commands(JTextPane textPane,Arrow arrow,MyDialog dialog){
        this.textPane = textPane;
       currentComand = commands[0];
        comCounter = 0;
        this.arrow = arrow;
        this.dialog = dialog;
// Преобразуем из Unicode в UnicodeLittleUnmarked
       /* try {
            byte[] data = currentComand.getBytes("UTF-8");
            currentComand = new String(data);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
       /* System.setProperty("file.encoding", "Cp866");
        System.out.println("file.encoding before=" + System.getProperty("file.encoding"));

        System.setProperty("console.encoding", "Cp866");
        String string ="Проверить работу подъемного механизма.";
        System.out.printf(string);*/


        //textPane.setHorizontalAlignment(JLabel.CENTER);
       /*textPane.setPreferredSize(new Dimension(300,30));
        textPane.setLocation(150,5);*/
    /*try {
        byte[] data = str.getBytes("");
        string = new String(str.getBytes("UTF-8"),"Cp866");
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }*/

        textPane.setText(currentComand);
    }

    public void errorMessege(boolean madeCommand){
        if(!madeCommand){
            dialog.locate();
            dialog.setVisible(true);
        }else
            dialog.setVisible(false);
    }

    public boolean perfomeCommand(int comIndex){
        if(comCounter == comIndex){
            arrow.setXY(arrowX[comCounter],arrowY[comCounter]);
            ++comCounter;
            currentComand = commands[comCounter];
            textPane.setText(currentComand);
            errorMessege(true);
            if(comIndex == 8)
                ImageTest.change(2);
            return true;
        }
     /*   else if(comIndex >= 0)
            errorMessege(false);
*/

        return false;
    }

    public void repaintPane(){
        textPane.repaint();
    }

}
