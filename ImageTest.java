import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.JTextComponent;


public class ImageTest {
    private static double index = 0;
  /*  private static Object menu = new Object(new ImageFrame(true));
    private static Object train = new Object(new ImageFrame());
*/
  private static ImageFrame menu = new ImageFrame(true);
    private static  ImageFrame train = new ImageFrame();


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                menu.setFrame();
                train.setFrame();
                menu.visible(true);
                train.visible(false);


            }
        });
    }
    public static void change(double in){
        index = in;
        //object.interrupt();
        System.out.print(in + "\n");
        if (index == 1) {
            train.visible(true);
            menu.visible(false);

        } else if (index == 2) {
            menu.visible(true);
            train.dispose();
            train = new ImageFrame();
            train.setFrame();
            train.visible(false);
        }
        else if (index == 3) {
            menu.exitAplication();
        }
    }
}


class ImageFrame extends JFrame {
    public ImageFrame() {

        MyDialog dialog = new MyDialog(ImageFrame.this);
        Arrow arrow = new Arrow(10,65,2);
        MyPane area = new MyPane(200,5,400,50);
        Commands commands = new Commands(area,arrow,dialog);
        ImageComponent component = new ImageComponent(commands);
        MyScrollPane scrollPane = new MyScrollPane(component);
        MyButton right = new MyButton(755,0,40,570,8,scrollPane);
        MyButton left = new MyButton(0,0,40,570,-8,scrollPane);


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


        JButton  training = new JButton("\u0422\u0440\u0435\u043d\u0438\u0440\u043e\u0432\u043a\u0430");;
        JButton exit = new JButton("\u0412\u044b\u0445\u043e\u0434");
        MenuComponent menu = new MenuComponent(training,exit);
        JPanel panel = new JPanel();
        menu.setLayout(null);
        //setLayout(null);
        panel.add(training);
        panel.add(exit);
        //add(panel);
        add(panel, BorderLayout.NORTH);
        add(menu, BorderLayout.CENTER);
        //add(panel, BorderLayout.CENTER);



        pack();
    }

    public void setFrame(){
        setTitle("BMP-2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(800, 600);
       setResizable(false);
        //  frame.setVisible(true);
        setLocation(20, 20);
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

    public MenuComponent(JButton training,JButton exit){
        image = new ImageIcon("C:\\Users\\Siarhei\\Desktop\\BMP-2\\BMP.jpg").getImage();
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



class ImageComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 3060;
    private static final int DEFAULT_HEIGHT = 600;
    private Graphics2D g2;
    private Image image;

    private BufferedImage lampLight;
    private BufferedImage back;
    private BufferedImage lever;
    private BufferedImage leveron;
    private BufferedImage leveroff;
    private BufferedImage lever1;
    private BufferedImage no;
    private BufferedImage turnback;
    private BufferedImage turnlever;
    private BufferedImage remote;
    private BufferedImage remoteoff;
    private BufferedImage remlever;
    private BufferedImage bar;
    private BufferedImage flag;
    private BufferedImage reload;
    private BufferedImage reloadlever;
    private ArrayList<Aplience> apliences;
    private Commands commands;


   // com.aspose.imaging.imageoptions.BmpOptions createOptions = new com.aspose.imaging.imageoptions.BmpOptions();

    public ImageComponent(Commands commands) {
       image = new ImageIcon("C:\\Users\\Siarhei\\Desktop\\BMP-2\\BMP-2.jpg").getImage();

        try {
            lampLight = ImageIO.read(new File("C:\\Users\\Siarhei\\Desktop\\BMP-2\\lamplight.jpg"));
            back = ImageIO.read(new File("C:\\Users\\Siarhei\\Desktop\\BMP-2\\lever2on.jpg"));
            lever = ImageIO.read(new File("C:\\Users\\Siarhei\\Desktop\\BMP-2\\lever2.png"));
            leveron = ImageIO.read(new File("C:\\Users\\Siarhei\\Desktop\\BMP-2\\leverfree.jpg"));
            leveroff = ImageIO.read(new File("C:\\Users\\Siarhei\\Desktop\\BMP-2\\leveroff1.jpg"));
            lever1 = ImageIO.read(new File("C:\\Users\\Siarhei\\Desktop\\BMP-2\\revelmp.png"));
            no = ImageIO.read(new File("C:\\Users\\Siarhei\\Desktop\\BMP-2\\leveroff.jpg"));
            turnback = ImageIO.read(new File("C:\\Users\\Siarhei\\Desktop\\BMP-2\\turnap.jpg"));
            turnlever = ImageIO.read(new File("C:\\Users\\Siarhei\\Desktop\\BMP-2\\turnlever.png"));
            remote= ImageIO.read(new File("C:\\Users\\Siarhei\\Desktop\\BMP-2\\remote2.jpg"));
            remoteoff = ImageIO.read(new File("C:\\Users\\Siarhei\\Desktop\\BMP-2\\remote.jpg"));
            remlever = ImageIO.read(new File("C:\\Users\\Siarhei\\Desktop\\BMP-2\\remoteturn.png"));
            bar = ImageIO.read(new File("C:\\Users\\Siarhei\\Desktop\\BMP-2\\remote1.png"));
            flag = ImageIO.read(new File("C:\\Users\\Siarhei\\Desktop\\BMP-2\\flag1.jpg"));
            reload = ImageIO.read(new File("C:\\Users\\Siarhei\\Desktop\\BMP-2\\remote.png"));
            reloadlever = ImageIO.read(new File("C:\\Users\\Siarhei\\Desktop\\BMP-2\\remotelever.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.commands=commands;


        apliences = new ArrayList<Aplience>();
        apliences.add(new Aplience(new Lamp(lampLight, new Dimension(28, 14),0), new Rectangle2D.Double(28, 14, 117, 130)));
        apliences.add(new Aplience(new Lever5(back, lever, new Dimension(279, 334)), new Rectangle2D.Double(300, 334, 58, 115)));
        apliences.add(new Aplience(new Lever4(leveron, leveroff, lever1,no, new Dimension(689, 103)), new Rectangle2D.Double(689, 119, 90, 100)));
        apliences.add(new Aplience(new TurnAp(turnback, turnlever, new Dimension(341, 431)), new Rectangle2D.Double(374, 474, 90, 65)));
        apliences.add(new Aplience(new RemotePush(remote, remoteoff, bar, new Dimension(485, 357)), new Rectangle2D.Double(497, 398, 51, 15)));
        apliences.add(new Aplience(new RemoteTurn(remlever, new Dimension(596, 365)), new Rectangle2D.Double(576,365,64, 134)));
        apliences.add(new Aplience(new Lamp(flag, new Dimension(1322, 144),7), new Rectangle2D.Double(1340, 180, 40, 120)));
        apliences.add(new Aplience(new ReloadLever(reload,reloadlever ,new Dimension(778, 262)), new Rectangle2D.Double(620, 254, 90, 100)));
        //this.setLocation(0, 0);


        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent event) {

                Point p = event.getPoint();
                Aplience aplience;
                ListIterator<Aplience> iter = apliences.listIterator();

                while (iter.hasNext()){
                    aplience = iter.next();
                if (aplience.rectContain(p)) {
                    commands.perfomeCommand(aplience.setPoint(p));
                    repaint();
                }}

            }

            public void mouseReleased(MouseEvent event) {

            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent event) {
                Point p = event.getPoint();
                Aplience aplience;
                ListIterator<Aplience> iter = apliences.listIterator();

                while (iter.hasNext()){
                    aplience = iter.next();
                    if (aplience.rectContain(p)) {
                        commands.perfomeCommand(aplience.setPoint(p));
                        repaint();
                    }}

            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent event) {
                Point p = event.getPoint();
                Aplience aplience;
                ListIterator<Aplience> iter = apliences.listIterator();

                while (iter.hasNext()){
                    aplience = iter.next();
                    if (aplience.rectContain(p)) {
                        commands.perfomeCommand(aplience.crossed(true));
                    }else aplience.crossed(false); }
                repaint();
            }
        });
    }

    public void paintComponent(Graphics g){
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
}
