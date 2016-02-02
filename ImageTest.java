import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.JTextComponent;


public class ImageTest {
    private static double index = 0;
    private static ImageFrame menu = new ImageFrame(true);
    //private static  ImageFrame train = new ImageFrame();
    private static ImageFrame by = new ImageFrame(true,true);


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                menu.setFrame();
                //train.setFrame();
                by.setFrame();
                menu.visible(true);
               // train.visible(true);
                by.setVisible(true);


            }
        });
    }

    public static void change(double in){
        index = in;

        if (index == 1) {
            by.visible(true);
            menu.visible(false);

        } else if (index == 2) {
            menu.visible(true);
           // train.dispose();
           // train = new ImageFrame();
            //train.visible(false);
        }
        else if (index == 3) {
            menu.exitAplication();
        }
    }
}


class ImageFrame extends JFrame {
    private MyDialog dialog;
    private Arrow arrow;
    private MyPane area;
    private Commands commands;

    public ImageFrame() {

        setFeatures();
        ImageComponent component = new ImageComponent(commands);
        MyScrollPane scrollPane = new MyScrollPane(component);
        MyButton right = new MyButton(760,0,40,640,8,scrollPane);
        MyButton left = new MyButton(0,0,40,640,-8,scrollPane);


        setLayout(null);
        add(right);
        add(left);
        add(area);
        add(scrollPane);

        component.setLayout(null);
        component.add(arrow);

        pack();
    }
    public ImageFrame(boolean index){

        MenuButton  training = new MenuButton("\u0422\u0440\u0435\u043d\u0438\u0440\u043e\u0432\u043a\u0430",300,150,250,40);;
        MenuButton exit = new MenuButton("\u0412\u044b\u0445\u043e\u0434",300,250,250,40);
        MenuComponent menu = new MenuComponent(training,exit);
      /*  JPanel panel = new JPanel();
        panel.setSize(100,300);
        panel.setLocation(350,150);*/
       // menu.setLayout(null);

        setLayout(null);
        add(training);
        add(exit);
       // add(panel, BorderLayout.NORTH);
        add(menu);

        pack();
    }
    public ImageFrame(boolean index,boolean index1) {

        setFeatures();
        ImageComponent component = new ImageComponent(commands,true);

        setLayout(null);
        add(area);
        component.setLayout(null);
        component.add(arrow);
        add(component);

        pack();
    }

    public void setFrame(){
        setTitle("BMP-2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(810, 630);
       setResizable(false);
        //  frame.setVisible(true);
        setLocation(20, 20);
    }

    private void setFeatures(){
        if(commands != null) return;
       dialog = new MyDialog(ImageFrame.this);
       arrow = new Arrow(10,65,2);
        area = new MyPane(200,5,400,50);
       commands = new Commands(area,arrow,dialog);
    }

    public void visible(boolean index){
      setVisible(index);
    }

    public void exitAplication() {
        System.exit(0);
    }
}

class MenuComponent extends JComponent{
    private static final int DEFAULT_WIDTH = 1000;
    private static final int DEFAULT_HEIGHT = 501;
    private Image image;

    public MenuComponent(MenuButton training,MenuButton exit){
        URL imageURL = getClass().getResource("BMP.jpg");
        image = new ImageIcon(imageURL).getImage();
        setSize(800,600);
        setLocation(0,0);
        training.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ImageTest.change(1);
            }
        });
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ImageTest.change(3);
            }
        });

    }

    public void paintComponent(Graphics g) {
        if (image == null) {
            System.out.print("Couldn't paint Background!!!");
            return;
        }
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;

        //g2.drawImage(button, 109, 284, null);
        g2.drawImage(image, 0, 0, null);

    }
    public Dimension getPreferredSize(){return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);}
}



class ImageComponent extends JComponent implements MouseMotionListener,MouseListener {
    private int DEFAULT_WIDTH;
    private int DEFAULT_HEIGHT;
    private Graphics2D g2;
    private Image image;
    private ArrayList<Aplience> apliences;
    private Commands commands;


    public ImageComponent(Commands commands) {
      /*  URL imageURL = getClass().getResource("BMP-2.jpg");
       image = new ImageIcon(imageURL).getImage();*/
        //image = new ImageIcon("BMP-2.jpg").getImage();
        DEFAULT_WIDTH = 3060;
        DEFAULT_HEIGHT = 600;
        this.commands=commands;

        image = readImage("BMP-2.jpg");
        apliences = new ArrayList<Aplience>();
        apliences.add(new Aplience(new Lamp(readImage("lamplight.jpg"), new Dimension(28, 14),0), new Rectangle2D.Double(28, 14, 117, 130)));
        apliences.add(new Aplience(new Lever5(readImage("lever2on.jpg"), readImage("lever2.png"), new Dimension(279, 334)), new Rectangle2D.Double(300, 334, 58, 115)));
        apliences.add(new Aplience(new Lever4(readImage("leverfree.jpg"), readImage("leveroff1.jpg"), readImage("revelmp.png"),readImage("leveroff.jpg"), new Dimension(689, 103)), new Rectangle2D.Double(689, 119, 90, 100)));
        apliences.add(new Aplience(new TurnAp(readImage("turnap.jpg"), readImage("turnlever.png"), new Dimension(341, 431)), new Rectangle2D.Double(374, 474, 90, 65)));
        apliences.add(new Aplience(new RemotePush(readImage("remote2.jpg"), readImage("remote.jpg"),readImage("remote1.png"), new Dimension(485, 357)), new Rectangle2D.Double(497, 398, 51, 15)));
        apliences.add(new Aplience(new RemoteTurn(readImage("remoteturn.png"), new Dimension(596, 365)), new Rectangle2D.Double(576,365,64, 134)));
        apliences.add(new Aplience(new Lamp(readImage("flag1.jpg"), new Dimension(1322, 144),7), new Rectangle2D.Double(1340, 180, 40, 120)));
        apliences.add(new Aplience(new ReloadLever(readImage("remote.png"),readImage("remotelever.png") ,new Dimension(778, 262)), new Rectangle2D.Double(620, 254, 90, 100)));

        addMouseMotionListener(this);
        addMouseListener(this);
    }

    public ImageComponent(Commands commands,boolean index) {
      /*  URL imageURL = getClass().getResource("BMP-2.jpg");
       image = new ImageIcon(imageURL).getImage();*/
        //image = new ImageIcon("BMP-2.jpg").getImage();
        DEFAULT_WIDTH = 810;
        DEFAULT_HEIGHT = 630;
        this.commands = commands;
        setSize(810,630);
        setLocation(0,0);
        image = readImage("box.jpg");
        apliences = new ArrayList<Aplience>();
        apliences.add(new Aplience(new BYAz(), new Rectangle2D.Double(460, 265, 40, 30)));
        apliences.add(new Aplience(new BYSnap(readImage("snap.jpg"), readImage("light.jpg"), readImage("light1.jpg"),new Dimension(252,358)), new Rectangle2D.Double(244, 355, 25, 45)));
        apliences.add(new Aplience(new BYSwitch(readImage("switch.png"), new Dimension(0, 0)), new Rectangle2D.Double(170, 316, 60, 66)));

        addMouseMotionListener(this);
        addMouseListener(this);
    }


    public  BufferedImage readImage(String path){
        URL imageURL = getClass().getResource(path);
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(imageURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedImage;
    }

    public  void paintComponent(Graphics g){
        if (image == null) {
            System.out.print("Couldn't paint Background!!!");
            return;
        }
        super.paintComponent(g);
        g2 = (Graphics2D) g;

        //g2.drawImage(button, 109, 284, null);
        g2.drawImage(image, 0, 0, null);

        ListIterator<Aplience> iter = apliences.listIterator();
        while (iter.hasNext())
            iter.next().paintAplience(g2);

        commands.repaintPane();
    }



    public Dimension getPreferredSize(){return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);}

    @Override
    public void mouseDragged(MouseEvent e) {
        Point p = e.getPoint();
        Aplience aplience;
        ListIterator<Aplience> iter = apliences.listIterator();

        while (iter.hasNext()){
            aplience = iter.next();
            if (aplience.rectContain(p)) {
                commands.perfomeCommand(aplience.setPoint(p));
                repaint();
            }}

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point p = e.getPoint();
        Aplience aplience;
        ListIterator<Aplience> iter = apliences.listIterator();

        while (iter.hasNext()){
            aplience = iter.next();
            if (aplience.rectContain(p)) {
                commands.perfomeCommand(aplience.crossed(true));
            }else aplience.crossed(false); }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point p = e.getPoint();
        Aplience aplience;
        ListIterator<Aplience> iter = apliences.listIterator();

        while (iter.hasNext()) {
            aplience = iter.next();
            if (aplience.rectContain(p)) {
                commands.perfomeCommand(aplience.setPoint(p));
                repaint();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}






