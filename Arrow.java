/**
 * Created by Siarhei on 26.12.2015.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



class Arrow extends  JPanel {
    private Point startPoint;
    private int size;
    private int x[];
    private int y[];
    private int animationLength;
    private int ycordinate;
    private boolean parametr;

    public Arrow(int size,int x,int y){
        this.size = size;
        startPoint = new Point(size+1, 0);
        animationLength = size *3;
        ycordinate =(int) startPoint.getY();
        this.x = new int[3];
        this.y = new int[3];
        parametr = true;
        this.setOpaque(false);
        this.setLocation(x-size,y);
        this.setSize(4 * size + 2, 10 * size);
        this.moveArrow();
    }

    public void setXY(int x,int y){
        if(x == 0 && y == 0)
            this.setLocation(2,2000);
        else
            this.setLocation(x-size,y);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2;
        g2 = (Graphics2D) g;

        if(startPoint.getX() > size) {
            x[0] = (int) startPoint.getX() - size;
            x[1] = (int) startPoint.getX() + 3 * size;
            x[2] = (int) startPoint.getX() + size;
            y[0] = (int) startPoint.getY() + size * 4;
            y[1] = (int) startPoint.getY() + size * 4;
            y[2] = (int) startPoint.getY() + size * 7;
        }

        g2.setPaint(new GradientPaint(new Point((int) startPoint.getX() + size, (int) startPoint.getY() + size), new Color(0.105882354f, 0.3882353f, 0.28235295f, 1f),
                new Point((int) startPoint.getX() + size, (int) startPoint.getY() + size * 3), Color.red));

        g2.fill(new Rectangle((int) startPoint.getX(), (int) startPoint.getY(), size * 2, size * 4));
        g2.fill(new Polygon(x, y, 3));

    }

    public void moveArrow(){
        ActionListener action =  new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if(parametr)
                    startPoint = new Point((int) startPoint.getX(), (int) startPoint.getY()+2);
                else
                    startPoint = new Point((int) startPoint.getX(), (int) startPoint.getY()-2);
                repaint();

                if (animationLength + ycordinate == startPoint.getY()) parametr= false;

                if(startPoint.getY() == ycordinate)  parametr = true;



            }
        };
        int delay = 20;
        new Timer(delay,action).start();
    }


}