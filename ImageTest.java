import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.imageio.ImageIO;
import javax.swing.*;


public class ImageTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new ImageFrame();
                frame.setTitle("BMP-2");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setResizable(false);
                frame.setVisible(true);
                frame.setLocation(20,20);

            }
        });
    }
}

/**
 * A frame with an image component
 */
class ImageFrame extends JFrame {
    public ImageFrame() {
       // JLabel area = new JLabel();


        //MyScrollBar bar = new MyScrollBar();
        // area.addFocusListener(null);

       /* Arrow arrow = new Arrow(10,243,210);
        Commands commands = new Commands(area);*/
        //Image  image = new ImageIcon("C:\\Users\\Siarhei\\Desktop\\BMP-2\\futurama.jpeg").getImage();
        ImageComponent component = new ImageComponent();
        MyScrollPane scrollPane = new MyScrollPane(component);

        MyButton right = new MyButton(755,0,40,570,8,scrollPane);
        MyButton left = new MyButton(0,0,40,570,-8,scrollPane);

        add(right);
        add(left);
        add(scrollPane, BorderLayout.CENTER);
        Arrow arrow = new Arrow(10,500,210);

        component.setLayout(null);
       //add(component, BorderLayout.CENTER);
      // this.add(area,BorderLayout.NORTH);
        component.add(arrow);
        // component.setLayout(null);
        // add(component,BorderLayout.CENTER);
       /* add(area, BorderLayout.NORTH);
        component.add(arrow);*/
        pack();
    }
}

/**
 * A component that displays a tiled image
 */
class ImageComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 3060;
    private static final int DEFAULT_HEIGHT = 600;
    private Graphics2D g2;
    private Image image;

    private BufferedImage lamp;
    private BufferedImage lampLight;
    private BufferedImage back;
    private BufferedImage lever;
    private BufferedImage leveron;
    private BufferedImage leveroff;
    private BufferedImage lever1;
    private BufferedImage no;
    private ArrayList<Aplience> apliences;

   // com.aspose.imaging.imageoptions.BmpOptions createOptions = new com.aspose.imaging.imageoptions.BmpOptions();

    public ImageComponent() {

        image = new ImageIcon("C:\\Users\\Siarhei\\Desktop\\BMP-2\\BMP-2.jpg").getImage();

        try {
            lamp = ImageIO.read(new File("C:\\Users\\Siarhei\\Desktop\\BMP-2\\lamp.jpg"));
            lampLight = ImageIO.read(new File("C:\\Users\\Siarhei\\Desktop\\BMP-2\\lamplight.jpg"));
            back = ImageIO.read(new File("C:\\Users\\Siarhei\\Desktop\\BMP-2\\lever2on.jpg"));
            lever = ImageIO.read(new File("C:\\Users\\Siarhei\\Desktop\\BMP-2\\lever2.png"));
            leveron = ImageIO.read(new File("C:\\Users\\Siarhei\\Desktop\\BMP-2\\leverfree.jpg"));
            leveroff = ImageIO.read(new File("C:\\Users\\Siarhei\\Desktop\\BMP-2\\leveroff1.jpg"));
            lever1 = ImageIO.read(new File("C:\\Users\\Siarhei\\Desktop\\BMP-2\\revelmp.png"));
            no = ImageIO.read(new File("C:\\Users\\Siarhei\\Desktop\\BMP-2\\leveroff.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        apliences = new ArrayList<Aplience>();
        apliences.add(new Aplience(new Lamp(lampLight, lamp, new Dimension(28, 14)), new Rectangle2D.Double(28, 14, 117, 130)));
        apliences.add(new Aplience(new Lever5(back, lever, new Dimension(279, 334)), new Rectangle2D.Double(300, 334, 58, 115)));
        apliences.add(new Aplience(new Lever4(leveron, leveroff, lever1,no, new Dimension(689, 103)), new Rectangle2D.Double(689, 119, 90, 100)));
        //this.setLocation(0, 0);


        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent event) {
                Point p = event.getPoint();
                Aplience aplience;
                ListIterator<Aplience> iter = apliences.listIterator();

                while (iter.hasNext()){
                    aplience = iter.next();
                if (aplience.rectContain(p)) {
                    //  arrow = new Arrow(10,243,210);
                    aplience.setPoint(p);
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
                        //  arrow = new Arrow(10,243,210);
                        aplience.setPoint(p);
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
                        //  arrow = new Arrow(10,243,210);
                        aplience.crossed(true);
                    }else aplience.crossed(false); }
                repaint();
            }
        });

    }

    public void paintComponent(Graphics g) {
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


    }


    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}