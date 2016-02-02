
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyButton extends JButton {
    private int xCoordinate;
    private int yCoordinate;
    private Dimension buttonSize;
    private int moveNum;
    private boolean sign;
    private int size;
    private Point startPoint;
    private int x[];
    private int y[];
    private int time = 20;
   private  MyScrollPane pane;
    private Timer animator;

    public MyButton(int xCoordinate,int yCoordinate,int weight,int lenght,int moveNum,MyScrollPane pane){
        super();
        this.pane = pane;
        this.xCoordinate=xCoordinate;
        this.yCoordinate=yCoordinate;
        buttonSize = new Dimension(weight,lenght);
        this.moveNum = moveNum;
        size =10;
        animator = null;
        startPoint = new Point(weight/2 -size,lenght/2 -size);
        setSize(buttonSize);
        setLocation(xCoordinate, yCoordinate);
        setBackground(new Color(0.9137255f, 0.039215688f, 0.07450981f, 1f));
                //setOpaque(true);
                setForeground(Color.MAGENTA);
        setContentAreaFilled(false);
        setBorderPainted(false);

        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent event) {
                setContentAreaFilled(true);
                // setBorderPainted(true);
                sign = true;
                animator = new Timer(time, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (sign) {
                            if (!pane.setScrollBarValue(moveNum))
                                setContentAreaFilled(false);

                            repaint();


                        } else return;
                        time += 20;
                    }
                });
                animator.start();


            }

            public void mouseExited(MouseEvent event) {
                setContentAreaFilled(false);
                //setBorderPainted(false);
                sign = false;
                repaint();
            }
        });

       /* if(startPoint.getX() > size) {
            x[0] = (int) startPoint.getX();
            x[1] = (int) startPoint.getX();
            x[2] = (int) startPoint.getX() + size;
            y[0] = (int) startPoint.getY();
            y[1] = (int) startPoint.getY()+size;
            y[2] = (int) startPoint.getY() + size/2;
        }

      Polygon arrow = new Polygon(x, y, 3);*/

    }

   /* @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2;
        g2 = (Graphics2D) g;

        if(startPoint.getX() > size) {
            x[0] = (int) startPoint.getX();
            x[1] = (int) startPoint.getX();
            x[2] = (int) startPoint.getX() + size;
            y[0] = (int) startPoint.getY();
            y[1] = (int) startPoint.getY()+size;
            y[2] = (int) startPoint.getY() + size/2;
        }
        g2.setPaint(Color.DARK_GRAY);
        g2.fill(new Polygon(x, y, 3));
       /* g2.setPaint(new GradientPaint(new Point((int) startPoint.getX() + size, (int) startPoint.getY() + size), Color.white,
                new Point((int) startPoint.getX() + size, (int) startPoint.getY() + size * 3), Color.cyan));
        g2.setBackground();*/




}

