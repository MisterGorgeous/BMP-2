import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Siarhei on 04.02.2016.
 */
public class Mark extends JPanel {
    private JLabel text;
    private JLabel score;
    private int num;

    public Mark() {
        super();
        //"\u041e\u0448\u0438\u0431\u043a\u0430\u002e", true);
        setSize(200, 100);
        setLocation(300, 200);
        setBackground(new Color(0.77254903f, 0.015686275f, 0.12941177f, 1f));

        setVisible(false);//<html><body text="red"><h3><i> </i></h3></body>

        text = new JLabel();
       /* text.setSize(200, 80);
        text.setLocation(0, 0);*/
        text.setBackground(new Color(0.77254903f, 0.015686275f, 0.12941177f, 1f));
        text.setForeground(new Color(0.105882354f, 0.3882353f, 0.28235295f, 1f));
        text.setFont(new Font("Serif", Font.PLAIN, 20));

        score = new JLabel();
       /* score.setSize(200,100);
        score.setLocation(0, 100);*/
        score.setBackground(new Color(0.77254903f, 0.015686275f, 0.12941177f, 1f));
        score.setForeground(new Color(0.105882354f, 0.3882353f, 0.28235295f, 1f));
        score.setFont(new Font("Serif", Font.PLAIN, 40));

        num = 0;
        add(text);
        add(score);

    }

    public void plussMistake(){
        ++num;
    }
    public void setMistake(){
        num =0;
    }

    public void showScore(){
        if(100 - num*5 <0)
            score.setText(0+ "%");
            else
        score.setText(100 - num*5 + "%");
        text.setText("\u0412\u0430\u0448\u0020\u0440\u0435\u0437\u0443\u043b\u044c\u0442\u0430\u0442\u003a");
        setVisible(true);
    }

}
