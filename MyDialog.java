/**
 * Created by Siarhei on 27.01.2016.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MyDialog extends JDialog
{
    private JFrame owner;
    public MyDialog(JFrame owner)
    {
        super(owner, "\u041e\u0448\u0438\u0431\u043a\u0430\u002e", true);
        // add HTML label to center
        this.owner = owner;

        add(
                new JLabel(
                        "<html><body text=\"green\"><h3><i>\u041d\u0435\u0432\u0435\u0440\u043d\u043e\u0435\u0020\u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0435\u002e</i></h3></body>"),
                BorderLayout.CENTER);

        // OK button closes the dialog


        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                setVisible(false);
            }
        });

        // add OK button to southern border

        JPanel panel = new JPanel();
        panel.add(ok);
        add(panel, BorderLayout.SOUTH);

        pack();
    }

    public void locate(){
        setLocation((int) (owner.getX() + owner.getSize().getWidth()/2.5), (int) (owner.getY()  + owner.getSize().getHeight()/2.5));

    }
}

