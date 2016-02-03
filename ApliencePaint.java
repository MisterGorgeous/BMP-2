import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 * Created by Siarhei on 28.12.2015.
 */
public interface ApliencePaint {
    public void behavior(Graphics2D g2);
    public int setPoint(Point p);
    public int crossed(boolean value);
}

class Lamp implements ApliencePaint{
    private BufferedImage on;
    private boolean inFocus;
    private Dimension dim;
    private int comIndex;


    public Lamp(BufferedImage on,Dimension dim,int index){
            this.on = on;
            inFocus = false;
            this.dim = dim;
            comIndex = index;
        }
    @Override
    public void behavior(Graphics2D g2) {
        if(inFocus) g2.drawImage(on,dim.width,dim.height,null);
    }

    @Override
    public int setPoint(Point p) {
        if(inFocus)
            inFocus = false;
        else inFocus = true;
        return comIndex;
    }

    @Override
    public int crossed(boolean value) {
        return -1;
    }


}

class BYAz implements ApliencePaint{

    public BYAz(){


    }
    @Override
    public void behavior(Graphics2D g2) {

    }

    @Override
    public int setPoint(Point p) {
        return 1;
    }

    @Override
    public int crossed(boolean value) { return  -1;
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
        AffineTransform transform = new AffineTransform();
        //commands.takeAngel(currentAngel);
        transform.translate(302, 334);
        transform.rotate(currentAngel, 6, 56);
        g2.drawImage(lever, transform, null);
    }

    @Override
    public int setPoint(Point p) {
        this.currentPoint =p;
        double lenghta = Math.sqrt(Math.pow(currentPoint.getX() - 302, 2) + Math.pow(currentPoint.getY(), 2));
        double lenghtb = Math.sqrt(Math.pow(currentPoint.getX() - 302, 2) + Math.pow(currentPoint.getY()-390, 2));

        double angel = Math.acos((390 * 390 + Math.pow(lenghtb, 2) - Math.pow(lenghta, 2)) / (2 * lenghtb * 390));
        //if (angel > 0 && angel < 1) {
         /* if (currentPoint.getX() < 200)
                angel = -angel;*/
        currentAngel = angel;
        if(currentAngel <= 0.05)
            return 4;
        return -1;
    }

    @Override
    public int crossed(boolean value) {
        return -1;
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
        currentAngel = 0;
        inFocus = false;
        switched = false;
    }
    @Override
    public void behavior(Graphics2D g2) {
        if (inFocus) {
            g2.drawImage(on, dim.width, dim.height, null);

            if (currentAngel < -1.4) {
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
    public int setPoint(Point p) {
        this.currentPoint = p;
        if(inFocus) {
            double lenghta = Math.sqrt(Math.pow(currentPoint.getX() - 778, 2) + Math.pow(currentPoint.getY(), 2));
            double lenghtb = Math.sqrt(Math.pow(currentPoint.getX() - 778, 2) + Math.pow(currentPoint.getY() - 119, 2));

            double angel = Math.acos((119 * 119 + Math.pow(lenghtb, 2) - Math.pow(lenghta, 2)) / (2 * lenghtb * 119));
            //if (angel > 0 && angel < 1) {
         /* if (currentPoint.getX() < 200)
                angel = -angel;*/
            currentAngel = Math.PI / 2 - angel;


            if (currentAngel < -1.4)
                return 3;

        }
        return -1;
    }

    @Override
    public int crossed(boolean value) {
        inFocus = value;
        return  -1;
    }
}

class TurnAp implements ApliencePaint{
    private BufferedImage Background;
    private BufferedImage lever;
    private Dimension dim;
    private Point currentPoint;
    private Point center;
    private double currentAngel;
    private double x;
    private double y;


    public TurnAp(BufferedImage on,BufferedImage off,Dimension dim){
        Background = on;
        lever = off;
        this.dim = dim;
        currentPoint = new Point(374,474);
        center = new Point(410,372);
        x =348;
        y=469;

        currentAngel = 1.5;
    }
    @Override
    public void behavior(Graphics2D g2) {
        g2.drawImage(Background,dim.width,dim.height,null);
        AffineTransform transform = new AffineTransform();
        //commands.takeAngel(currentAngel);
        transform.translate(x, y);
        g2.drawImage(lever, transform, null);
    }

    @Override
    public int setPoint(Point p) {
        this.currentPoint =p;
        currentAngel = Math.atan(currentPoint.getX()-center.getX()/currentPoint.getY()-center.getY());
         x = 397 - Math.cos(currentAngel)*(74);
         y = 380 +  Math.sin(currentAngel+Math.PI/8)*(95);
        if(x >= 395) return 5;
        return  -1;
    }

    @Override
    public int crossed(boolean value) { return  -1;

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
        g2.drawImage(pain,485,357,null);
        if(!value) g2.drawImage(bar,497,398,null);

    }

    @Override
    public int setPoint(Point p) {
        this.currentPoint =p;

        Rectangle rec = new Rectangle(530,400,15,15);

        if(rec.contains(currentPoint)) {
            currentPoint = new Point(0,0);
            if (inFocus) {
                pain = Background;
                inFocus = false;
                return 8;
            } else {
                pain = Backgroundoff;
                inFocus = true;
                return 10;
            }

        } return  -1;
    }

    @Override
    public int crossed(boolean value) {
        this.value = value; return  -1;
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

        AffineTransform transform = new AffineTransform();
        //commands.takeAngel(currentAngel);
        transform.translate(dim.getWidth(), dim.getHeight());
        if(currentAngel<0.5 && currentAngel > -0.5)
            transform.rotate(currentAngel, 32, 55);
        g2.drawImage(lever, transform, null);
    }
    @Override
    public int setPoint(Point p) {
        this.currentPoint = p;
        currentAngel = Math.atan((currentPoint.getX()-center.getX())/(currentPoint.getY()-center.getY()));
        if(currentAngel >= 0.45) return 9;
        return  -1;
    }
    @Override
    public int crossed(boolean value) { return  -1;
    }
}



class ReloadLever implements ApliencePaint{

    private BufferedImage reload;
    private BufferedImage lever;
    private Dimension dim;
    private Point currentPoint;
    private boolean reached;


    public ReloadLever(BufferedImage reload,BufferedImage lever,Dimension dim){
        this.reload = reload;
        this.lever=lever;
        this.dim = dim;
        currentPoint = new Point(710,254);
        reached = false;

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
    public int setPoint(Point p) {
        this.currentPoint = p;
        if(currentPoint.getX() <= 630){reached = true; return 18;
        }
        if(currentPoint.getX() >= 700 && reached){  return 19;
        }
        return  -1;
    }

    @Override
    public int crossed(boolean value) { return  -1;
    }
}



class BYSnap implements ApliencePaint{

    private BufferedImage snap;
    private BufferedImage light;
    private BufferedImage light1;
    private Dimension dim;
    private boolean snapSwitched;


    public BYSnap(BufferedImage snap,BufferedImage light,BufferedImage light1,Dimension dim){
        this.snap = snap;
        this.light=light;
        this.light1=light1;
        this.dim = dim;
        snapSwitched = false;

    }
    @Override
    public void behavior(Graphics2D g2) {
        AffineTransform transform = new AffineTransform();
        transform.translate(dim.getWidth(), dim.getHeight());

            if (snapSwitched) {
                transform.rotate(-3, 6, 22);
                g2.drawImage(light,162,230,null);
                g2.drawImage(light1,156,377,null);

            } else
                transform.rotate(0, 6, 22);

        g2.drawImage(snap, transform, null);
    }

    @Override
    public int setPoint(Point p) {
        if (!snapSwitched) {
            snapSwitched = true;
            return 12;
        }
        snapSwitched = false;
        return -1;
    }

    @Override
    public int crossed(boolean value) { return  -1;
    }
}

class BYSwitch implements ApliencePaint{

    private BufferedImage snap;
    private Dimension dim;
    private Point currentPoint;
    private boolean snapSwitched;
    private double currentAngel;


    public BYSwitch(BufferedImage snap,Dimension dim){
        this.snap = snap;
        this.dim = dim;
        currentPoint = new Point(710,254);
        snapSwitched = false;
        currentAngel=0;


    }
    @Override
    public void behavior(Graphics2D g2) {
        AffineTransform transform = new AffineTransform();
        transform.translate(180, 320);
        transform.rotate(currentAngel, 21, 27);
        g2.drawImage(snap, transform, null);

    }

    @Override
    public int setPoint(Point p) {
        this.currentPoint =p;
        double lenghta = Math.sqrt(Math.pow(currentPoint.getX() - 200, 2) + Math.pow(currentPoint.getY(), 2));
        double lenghtb = Math.sqrt(Math.pow(currentPoint.getX() - 200, 2) + Math.pow(currentPoint.getY()-347, 2));

        double angel = Math.acos((347 * 347 + Math.pow(lenghtb, 2) - Math.pow(lenghta, 2)) / (2 * lenghtb * 200));
        //if (angel > 0 && angel < 1) {
         /* if (currentPoint.getX() < 200)
                angel = -angel;*/
        if (angel > -1 && angel < 1) {
            if (currentPoint.getX() < 200)
                angel = -angel;
            currentAngel = angel;
        }

        if(currentAngel <= -0.9)
            return 13 ;
        else if(currentAngel >= -0.2 && currentAngel <= 0.2)
            return 14 ;
        else if(currentAngel >= 0.9)
            return 15 ;
        else return  -1;
    }

    @Override
    public int crossed(boolean value) { return  -1;
    }
}