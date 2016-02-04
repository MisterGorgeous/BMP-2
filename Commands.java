import javax.swing.*;
import java.awt.*;
import java.io.UnsupportedEncodingException;


public class Commands{
    private JTextPane area;
    private JTextPane areaB;
    private int comCounter;
    private Arrow arrow;
    private Arrow arrowB;
    private MyDialog dialog;
    private MyDialog dialogB;
    private Mark mark;
    private Mark markTest;

    private String commands[] = {
    "\u0412\u043a\u043b\u044e\u0447\u0438\u0442\u044c\u0020\u0432\u044b\u043a\u043b\u044e\u0447\u0430\u0442\u0435\u043b\u044c\u0020\u043f\u043b\u0430\u0444\u043e\u043d\u0430\u0020\u043e\u0441\u0432\u0435\u0449\u0435\u043d\u0438\u044f\u002e",
            "\u0412\u043a\u043b\u044e\u0447\u0438\u0442\u044c\u0020\u0432\u044b\u043a\u043b\u044e\u0447\u0430\u0442\u0435\u043b\u044c\u0020\u043e\u0441\u0432\u0435\u0449\u0435\u043d\u0438\u044f\u0020\u0430\u0437\u0438\u043c\u0443\u0442\u0430\u043b\u044c\u043d\u043e\u0433\u043e\u0020\u0443\u043a\u0430\u0437\u0430\u0442\u0435\u043b\u044f\u002e"
            ,"\u0417\u0430\u043f\u0438\u0440\u0435\u0442\u044c\u0020\u043a\u0440\u044b\u0448\u043a\u0443\u0020\u043b\u044e\u043a\u0430\u002e"
    ,"\u0420\u0430\u0441\u0442\u043e\u043f\u043e\u0440\u0438\u0442\u044c\u0020\u043f\u0443\u0448\u043a\u0443\u002e"
    ,"\u0421\u043d\u044f\u0442\u044c\u0020\u0431\u0430\u0448\u043d\u044e\u0020\u0441\u043e\u0020\u0441\u0442\u043e\u043f\u043e\u0440\u0430\u002e"
   ,"\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c\u0020\u0440\u0430\u0431\u043e\u0442\u0443\u0020\u043f\u043e\u0434\u044a\u0435\u043c\u043d\u043e\u0433\u043e\u0020\u043c\u0435\u0445\u0430\u043d\u0438\u0437\u043c\u0430\u002e"
            ,"\u041e\u0442\u043a\u0440\u044b\u0442\u044c\u0020\u0437\u0430\u0441\u043b\u043e\u043d\u043a\u0443\u0020\u043a\u043e\u0436\u0443\u0445\u0430\u0020\u043f\u0440\u0438\u0431\u043e\u0440\u0430\u0020\u0422\u041d\u041f\u0422\u002d\u0031\u002e"
            , "\u0412\u043a\u043b\u044e\u0447\u0438\u0442\u044c\u0020\u043e\u0431\u043e\u0433\u0440\u0435\u0432\u0020\u043f\u0440\u0438\u0446\u0435\u043b\u0430\u0020\u0411\u041f\u041a\u002d\u0031\u002d\u0034\u0032\u002e"
  ,"\u0412\u043a\u043b\u044e\u0447\u0430\u0435\u0442\u0020\u0441\u0442\u0430\u0431\u0438\u043b\u0438\u0437\u0430\u0442\u043e\u0440\u002e"
    ,"\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c\u0020\u0440\u0430\u0431\u043e\u0442\u0443\u0020\u0441\u0442\u0430\u0431\u0438\u043b\u0438\u0437\u0430\u0442\u043e\u0440\u0430\u002e"
    ,"\u0412\u044b\u043a\u043b\u044e\u0447\u0438\u0442\u044c\u0020\u0441\u0442\u0430\u0431\u0438\u043b\u0438\u0437\u0430\u0442\u043e\u0440\u002e"
            ,"\u041e\u0442\u043a\u0440\u044b\u0442\u044c\u0020\u043a\u043b\u0430\u043f\u0430\u043d\u0020\u0432\u044b\u0442\u044f\u0436\u043d\u043e\u0433\u043e\u0020\u0432\u0435\u043d\u0442\u0438\u043b\u044f\u0442\u043e\u0440\u0430\u002e"
             ,"\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c\u0020\u0440\u0430\u0431\u043e\u0442\u0443\u0020\u044d\u043b\u0435\u043a\u0442\u0440\u043e\u0441\u043f\u0443\u0441\u043a\u043e\u0432\u0020\u043f\u0443\u0448\u043a\u0438\u0020\u0438\u0020\u0432\u044b\u0442\u044f\u0436\u043d\u043e\u0433\u043e\u0020\u0432\u0435\u043d\u0442\u0438\u043b\u044f\u0442\u043e\u0440\u0430\u002e"
             ,"\u041f\u0435\u0440\u0435\u0432\u0435\u0441\u0442\u0438\u0020\u043f\u0435\u0440\u0435\u043a\u043b\u044e\u0447\u0430\u0442\u0435\u043b\u044c\u0020\u0440\u0435\u0436\u0438\u043c\u0430\u0020\u00441\u0442\u0440\u0435\u043b\u044c\u0431\u044b\u0020\u0432\u0020\u043f\u043e\u043b\u043e\u0436\u0435\u043d\u0438\u044f\u0020\u041e"
             ,"\u041f\u0435\u0440\u0435\u0432\u0435\u0441\u0442\u0438\u0020\u043f\u0435\u0440\u0435\u043a\u043b\u044e\u0447\u0430\u0442\u0435\u043b\u044c\u0020\u0440\u0435\u0436\u0438\u043c\u0430\u0020\u0441\u0442\u0440\u0435\u043b\u044c\u0431\u044b\u0020\u0432\u0020\u043f\u043e\u043b\u043e\u0436\u0435\u043d\u0438\u044f\u0020\u041c"
             ,"\u041f\u0435\u0440\u0435\u0432\u0435\u0441\u0442\u0438\u0020\u043f\u0435\u0440\u0435\u043a\u043b\u044e\u0447\u0430\u0442\u0435\u043b\u044c\u0020\u0440\u0435\u0436\u0438\u043c\u0430\u0020\u0441\u0442\u0440\u0435\u043b\u044c\u0431\u044b\u0020\u0432\u0020\u043f\u043e\u043b\u043e\u0436\u0435\u043d\u0438\u044f\u0020\u0411"
    ,"\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c\u0020\u0440\u0430\u0431\u043e\u0442\u0443\u0020\u043f\u0435\u0440\u0435\u043a\u043b\u044e\u0447\u0430\u0442\u0435\u043b\u044f\u0020\u0442\u0438\u043f\u0430\u0020\u0431\u043e\u0435\u043f\u0440\u0438\u043f\u0430\u0441\u043e\u0432\u0020\u043a\u0020\u043f\u0443\u0448\u043a\u0435\u002e"
            ,"\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c\u0020\u0440\u0430\u0431\u043e\u0442\u0443\u0020\u043f\u043e\u0434\u0432\u0438\u0436\u043d\u044b\u0445\u0020\u0447\u0430\u0441\u0442\u0435\u0439\u002c\u0020\u043f\u0440\u0435\u0434\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u0435\u043b\u044f\u002e"
    ,"\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c\u0020\u0440\u0430\u0431\u043e\u0442\u0443\u0020\u044d\u043b\u0435\u043a\u0442\u0440\u043e\u0441\u043f\u0443\u0441\u043a\u0430\u0020\u0438\u0020\u043f\u043e\u0434\u0432\u0438\u0436\u043d\u044b\u0445\u0020\u0447\u0430\u0441\u0442\u0435\u0439\u0020\u043f\u0443\u043b\u0435\u043c\u0435\u0442\u0430\u002e"
    ,"\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c\u0020\u0440\u0430\u0431\u043e\u0442\u0443\u0020\u044d\u043b\u0435\u043a\u0442\u0440\u043e\u0441\u043f\u0443\u0441\u043a\u0430\u0020\u0438\u0020\u043f\u043e\u0434\u0432\u0438\u0436\u043d\u044b\u0445\u0020\u0447\u0430\u0441\u0442\u0435\u0439\u0020\u043f\u0443\u043b\u0435\u043c\u0435\u0442\u0430\u002e"
   ,"\u0414\u043e\u043b\u043e\u0436\u0438\u0442\u044c\u0020\u043a\u043e\u043c\u0430\u043d\u0434\u0438\u0440\u0443\u0020\u043e\u0020\u0433\u043e\u0442\u043e\u0432\u043d\u043e\u0441\u0442\u0438\u002e"
};
    private int arrowX[] ={65,0,405,750,295,375,1593,11,530,610,530,2130,0,0,0,0,1370,1245, 715,0,0};
    private int arrowY[] ={2,0,42, 42,260,390,280,90,330,330,330  ,42,0,0,0,0,   80,140,  195,0,0};

    private int arrowBX[] ={0,475,0,0,0,0,0,0,0,0,0,0,240,165,165,165,0,0,0,0,0};
    private int arrowBY[] ={0,190,0,0,0,0,0,0,0,0,0,0,280,240,240,240,0,0,0,0,0};


    public Commands(JTextPane textPane,JTextPane textPane1,Arrow arrow,Arrow arrow1,MyDialog dialog,MyDialog dialogB,Mark mark,Mark markTest){
        area = textPane;
        areaB = textPane1;
        this.arrow = arrow;
        this.arrowB = arrow1;
        this.dialog = dialog;
        this.dialogB = dialogB;
        this.mark = mark;
        this.markTest = markTest;
        comCounter = -1;
        perfomeCommand(comCounter);

// ����������� �� Unicode � UnicodeLittleUnmarked
       /* try {
            byte[] data = currentComand.getBytes("UTF-8");
            currentComand = new String(data);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
       /* System.setProperty("file.encoding", "Cp866");
        System.out.println("file.encoding before=" + System.getProperty("file.encoding"));

        System.setProperty("console.encoding", "Cp866");
        String string ="��������� ������ ���������� ���������.";
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


    }

    public void startCommands(){
        comCounter = -1;
        mark.setMistake();
        markTest.setMistake();

        perfomeCommand(comCounter);
    }

    public void errorMessege(boolean madeCommand){
        if(madeCommand){
            dialog.setVisible(true);
            dialogB.setVisible(true);
        }else {
            dialog.setVisible(false);
            dialogB.setVisible(false);
        }
    }

    public boolean perfomeCommand(int comIndex){
        if(comCounter == comIndex){
            ++comCounter;
            arrow.setXY(arrowX[comCounter],arrowY[comCounter]);
            arrowB.setXY(arrowBX[comCounter], arrowBY[comCounter]);
            area.setText(commands[comCounter]);
            areaB.setText(commands[comCounter]);
            errorMessege(false);
            if(comCounter == 20){
                mark.showScore();
                markTest.showScore();
            }
            return true;
        }
        else if(comIndex == comCounter -1)
            errorMessege(false);
        else if(comIndex >= 0) {
            errorMessege(true);
            mark.plussMistake();
            markTest.plussMistake();
        }

        else errorMessege(false);

        return false;
    }


    public void repaintPane(){
        area.repaint();
        areaB.repaint();
    }

}
