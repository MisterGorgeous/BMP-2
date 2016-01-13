import javax.swing.*;
import java.awt.*;

/**
 * Created by Siarhei on 11.01.2016.
 */
public class MyPane extends JTextPane {
    private int xCoordinate;
    private int yCoordinate;
    private Dimension buttonSize;
    private boolean sign;
    private int size;
    private Point startPoint;
    private int x[];
    private int y[];
    private int time = 20;

    public MyPane(int xCoordinate,int yCoordinate,int weight,int lenght){
        super();
        this.xCoordinate=xCoordinate;
        this.yCoordinate=yCoordinate;
        buttonSize = new Dimension(weight,lenght);

        size =10;
        startPoint = new Point(weight/2 -size,lenght/2 -size);
        setSize(buttonSize);
        setLocation(xCoordinate, yCoordinate);
    }

}
