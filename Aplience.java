import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * Created by Siarhei on 28.12.2015.
 */
public class Aplience {
    private ApliencePaint appaint;
   // private AplienceBehavior apbeh;
    private Rectangle2D rect;

    public Aplience(ApliencePaint paint,Rectangle2D rect){
        appaint = paint;
        this.rect = rect;
    }


    public boolean rectContain(Point p){
        if(rect.contains(p))
            return  true;
        return false;
    }

    public int setPoint(Point p){
            return appaint.setPoint(p);
    }

    public int crossed(boolean value){
        return appaint.crossed(value);
    }

    public void paintAplience(Graphics2D g2){appaint.behavior(g2);}

}
