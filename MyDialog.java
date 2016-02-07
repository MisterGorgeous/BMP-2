import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MyDialog extends JPanel {
    private JTextPane label;
    private String text;

    public MyDialog() {
        super();
        //"\u041e\u0448\u0438\u0431\u043a\u0430\u002e", true);
        setSize(200, 100);
        setLocation(350, 260);
        setBackground(new Color(0.77254903f, 0.015686275f, 0.12941177f, 1f));
        setVisible(false);//<html><body text="red"><h3><i> </i></h3></body>
        label = new JTextPane();
        label.setSize(196, 70);
        label.setLocation(2, 2);
        label.setBackground(new Color(0.77254903f, 0.015686275f, 0.12941177f, 1f));
        label.setFont(new Font("Serif", Font.PLAIN, 16));
        text = new String("");

        MenuButton continuer = new MenuButton("\u041f\u0440\u043e\u0434\u043e\u043b\u0436\u0438\u0442\u044c", 2, 75, 96, 20, 7f);
        continuer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setVisible(false);
            }
        });

        MenuButton more = new MenuButton("\u041f\u043e\u0434\u0440\u043e\u0431\u043d\u0435\u0435", 102, 75, 96, 20, 7f);
        more.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                label.setText(text);
            }
        });
        setLayout(null);
        add(label);
        add(continuer);
        add(more);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void visible(boolean index){
        setVisible(index);
        label.setText("\u041d\u0435\u0432\u0435\u0440\u043d\u043e\u0435\u0020\u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0435\u002e");
    }

}


