import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 * Created by Siarhei on 28.12.2015.
 */
public interface ApliencePaint {
    public void behavior(Graphics2D g2);
    public void setPoint(Point p);
    public void crossed(boolean value);
}

class Lamp implements ApliencePaint{
    private BufferedImage on;
    private boolean inFocus;
    private Dimension dim;


    public Lamp(BufferedImage on,Dimension dim){
            this.on = on;
            inFocus = false;
            this.dim = dim;
        }
    @Override
    public void behavior(Graphics2D g2) {
        if(inFocus)
            g2.drawImage(on,dim.width,dim.height,null);
    }

    @Override
    public void setPoint(Point p) {
        if(inFocus) inFocus = false;
        else inFocus = true;
    }

    @Override
    public void crossed(boolean value) {

    }
}

class Lever5 implements ApliencePaint{
    private BufferedImage Background;
    private BufferedImage lever;
    private Dimension dim;
    private Point currentPoint;
    private double currentAngel;


    public Lever5(BufferedImage on,BufferedImage off,Dimension dim){
        Background = on;
        lever = off;
        this.dim = dim;
        currentPoint = new Point(303,445);
        currentAngel = 3;
    }
    @Override
    public void behavior(Graphics2D g2) {
        g2.drawImage(Background,dim.width,dim.height,null);

        double lenghta = Math.sqrt(Math.pow(currentPoint.getX() - 302, 2) + Math.pow(currentPoint.getY(), 2));
        double lenghtb = Math.sqrt(Math.pow(currentPoint.getX() - 302, 2) + Math.pow(currentPoint.getY()-390, 2));

        double angel = Math.acos((390 * 390 + Math.pow(lenghtb, 2) - Math.pow(lenghta, 2)) / (2 * lenghtb * 390));
        //if (angel > 0 && angel < 1) {
         /* if (currentPoint.getX() < 200)
                angel = -angel;*/
            currentAngel = angel;

        //}

        AffineTransform transform = new AffineTransform();
        //commands.takeAngel(currentAngel);
        transform.translate(302, 334);
        transform.rotate(currentAngel, 6, 56);
        g2.drawImage(lever, transform, null);
    }

    @Override
    public void setPoint(Point p) {
        this.currentPoint =p;
    }

    @Override
    public void crossed(boolean value) {

    }
}

class Lever4 implements ApliencePaint{
    private BufferedImage on;
    private BufferedImage off;
    private BufferedImage lever;
    private BufferedImage no;
    private Dimension dim;
    private Point currentPoint;
    private double currentAngel;
    private boolean inFocus;
    private boolean switched;


    public Lever4(BufferedImage on,BufferedImage off,BufferedImage lever,BufferedImage no,Dimension dim){
        this.on = on;
        this.off = off;
        this.lever = lever;
        this.no = no;
        this.dim = dim;
        currentPoint = new Point(697,119);
        currentAngel = 1.57;
        inFocus = false;
        switched = false;
    }
    @Override
    public void behavior(Graphics2D g2) {
        if (inFocus) {
            g2.drawImage(on, dim.width, dim.height, null);

            double lenghta = Math.sqrt(Math.pow(currentPoint.getX() - 778, 2) + Math.pow(currentPoint.getY(), 2));
            double lenghtb = Math.sqrt(Math.pow(currentPoint.getX() - 778, 2) + Math.pow(currentPoint.getY() - 119, 2));

            double angel = Math.acos((119 * 119 + Math.pow(lenghtb, 2) - Math.pow(lenghta, 2)) / (2 * lenghtb * 119));
            //if (angel > 0 && angel < 1) {
         /* if (currentPoint.getX() < 200)
                angel = -angel;*/
            currentAngel = Math.PI/2 -angel ;



         if(currentAngel < -1.4){
                switched = true;
            } else switched = false;
            AffineTransform transform = new AffineTransform();
            //commands.takeAngel(currentAngel);
            transform.translate(697, 119);
            transform.rotate(currentAngel, 81, 0);
            g2.drawImage(lever, transform, null);

        }
        else if(switched)
            g2.drawImage(off, dim.width, dim.height, null);

        else g2.drawImage(no, dim.width, dim.height, null);

    }

    @Override
    public void setPoint(Point p) {
        this.currentPoint = p;
    }

    @Override
    public void crossed(boolean value) {
        inFocus = value;
    }
}

class TurnAp implements ApliencePaint{
    private BufferedImage Background;
    private BufferedImage lever;
    private Dimension dim;
    private Point currentPoint;
    private Point center;
    private double currentAngel;


    public TurnAp(BufferedImage on,BufferedImage off,Dimension dim){
        Background = on;
        lever = off;
        this.dim = dim;
        currentPoint = new Point(374,474);
        center = new Point(410,372);

        currentAngel = 1.5;
    }
    @Override
    public void behavior(Graphics2D g2) {
        g2.drawImage(Background,dim.width,dim.height,null);

        currentAngel = Math.atan(currentPoint.getX()-center.getX()/currentPoint.getY()-center.getY());
        double x = 397 - Math.cos(currentAngel)*(74);
        double y = 380 +  Math.sin(currentAngel+Math.PI/8)*(95);

        AffineTransform transform = new AffineTransform();
        //commands.takeAngel(currentAngel);
        transform.translate(x, y);
        g2.drawImage(lever, transform, null);
    }

    @Override
    public void setPoint(Point p) {
        this.currentPoint =p;
    }

    @Override
    public void crossed(boolean value) {

    }
}

class RemotePush implements ApliencePaint{
    private BufferedImage Background;
    private BufferedImage Backgroundoff;
    private BufferedImage bar;
    private Dimension dim;
    private Point currentPoint;
    private boolean value;
    private boolean inFocus;
    private BufferedImage pain;

    public RemotePush(BufferedImage on,BufferedImage off,BufferedImage bar,Dimension dim){
        Background= on;
        Backgroundoff = off;
        this.bar=bar;
        this.dim = dim;
        currentPoint = new Point(0,0);
        this.value =false;
        inFocus =true;
        pain = Backgroundoff;
    }
    @Override
    public void behavior(Graphics2D g2) {



        Rectangle rec = new Rectangle(530,400,15,15);

        if(rec.contains(currentPoint)) {
            if (inFocus) {
                pain = Background;
                inFocus = false;
            } else {
                pain = Backgroundoff;
                inFocus = true;
            }
            currentPoint = new Point(0,0);
        }
        g2.drawImage(pain,485,357,null);
        if(!value) g2.drawImage(bar,497,398,null);

    }

    @Override
    public void setPoint(Point p) {
        this.currentPoint =p;
    }

    @Override
    public void crossed(boolean value) {
        this.value = value;
    }
}

class RemoteTurn implements ApliencePaint{

    private BufferedImage lever;
    private Dimension dim;
    private Point currentPoint;
    private Point center;
    private double currentAngel;


    public RemoteTurn(BufferedImage lever,Dimension dim){
        this.lever=lever;
        this.dim = dim;
        currentPoint = new Point(808,20);
        center= new Point(596,300);
        currentAngel = 0;
    }
    @Override
    public void behavior(Graphics2D g2) {

        currentAngel = Math.atan((currentPoint.getX()-center.getX())/(currentPoint.getY()-center.getY()));
        AffineTransform transform = new AffineTransform();
        //commands.takeAngel(currentAngel);
        transform.translate(dim.getWidth(), dim.getHeight());
        if(currentAngel<0.5 && currentAngel > -0.5)
        transform.rotate(currentAngel, 32, 55);
        g2.drawImage(lever, transform, null);
    }

    @Override
    public void setPoint(Point p) {
        this.currentPoint = p;

    }

    @Override
    public void crossed(boolean value) {
    }
}

class Flag implements ApliencePaint{
    private BufferedImage on;
    private BufferedImage off;
    private boolean inFocus;
    private Dimension dim;


    public Flag(BufferedImage on,BufferedImage off,Dimension dim){
        this.on = on;
        this.off = off;
        inFocus = false;
        this.dim = dim;
    }
    @Override
    public void behavior(Graphics2D g2) {
        if(inFocus)
            g2.drawImage(on,dim.width,dim.height,null);
        else
            g2.drawImage(off,dim.width,dim.height,null);
    }

    @Override
    public void setPoint(Point p) {
        if(inFocus) inFocus = false;
        else inFocus = true;
    }

    @Override
    public void crossed(boolean value) {

    }
}

class ReloadLever implements ApliencePaint{

    private BufferedImage reload;
    private BufferedImage lever;
    private Dimension dim;
    private Point currentPoint;



    public ReloadLever(BufferedImage reload,BufferedImage lever,Dimension dim){
        this.reload = reload;
        this.lever=lever;
        this.dim = dim;
        currentPoint = new Point(710,254);

    }
    @Override
    public void behavior(Graphics2D g2) {

        AffineTransform transform = new AffineTransform();
        //commands.takeAngel(currentAngel);
        transform.translate(currentPoint.getX(),254);
        g2.drawImage(lever, transform, null);
        g2.drawImage(reload,dim.width,dim.height,null);
    }

    @Override
    public void setPoint(Point p) {
        this.currentPoint = p;

    }

    @Override
    public void crossed(boolean value) {
    }
}