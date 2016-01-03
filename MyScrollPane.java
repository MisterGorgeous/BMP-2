import javax.swing.*;

public class MyScrollPane extends JScrollPane {
    MyHorizontallBar bar;
    public MyScrollPane(JComponent component){
        super(component);
        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        //scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        bar = new MyHorizontallBar();
        setHorizontalScrollBar(bar);
        setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);


    }

    public boolean setScrollBarValue(int value){
        //System.out.print(bar.getValue() + "\n");
        bar.setValue(bar.getValue() + value);
        if((bar.getValue() + value > 0) && (bar.getValue() + value < 2269))
            return true;
        else
            return  false;

    }
}

class MyHorizontallBar extends JScrollBar {

    public MyHorizontallBar(){
        this.setOrientation(HORIZONTAL);

        //this.setSize(800,200);

       /* this.setFocusable(true);*/
        //this.setVisible(false);

    }

}