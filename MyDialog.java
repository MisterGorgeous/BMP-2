import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MyDialog extends JPanel {
    private JLabel label;

    public MyDialog() {
        super();
    //"\u041e\u0448\u0438\u0431\u043a\u0430\u002e", true);
        setSize(200, 100);
        setLocation(350, 260);
        setBackground(new Color(0.77254903f, 0.015686275f, 0.12941177f, 1f));
        setVisible(false);//<html><body text="red"><h3><i> </i></h3></body>
        label = new JLabel("\u041d\u0435\u0432\u0435\u0440\u043d\u043e\u0435\u0020\u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0435\u002e");
        label.setSize(200, 40);
        label.setLocation(0,0);
        label.setBackground(new Color(0.77254903f, 0.015686275f, 0.12941177f, 1f));

        MenuButton continuer = new MenuButton("\u041f\u0440\u043e\u0434\u043e\u043b\u0436\u0438\u0442\u044c",2,50,96,40,7f);
        continuer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setVisible(false);
            }
        });

        MenuButton more = new  MenuButton("\u041f\u043e\u0434\u0440\u043e\u0431\u043d\u0435\u0435",102,50,96,40,7f);
        more.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                label.setText("\u041e\u0448\u0438\u0431\u043a\u0430\u002e");
            }
        });

        add(label);
        add(continuer);
        add(more);
    }

}

