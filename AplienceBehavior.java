import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by Siarhei on 30.12.2015.
 */
public interface AplienceBehavior {
    public boolean pressedBehavior(Point p,Rectangle2D rect);
}

/*class Pressed implements AplienceBehavior{

    @Override
    public boolean pressedBehavior(Point p,Rectangle2D rect){
        if(rect.contains(p)) return true;
        return false;

    }
}
*/