import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Siarhei on 01.02.2016.
 */
public class MenuButton extends JButton {
    private int weight;
    private int lenght;
    private int xCoordinate;
    private int yCoordinate;
    private AnimatedLabel label;

    public MenuButton(String text,int xCoordinate,int yCoordinate,int weight,int lenght){
        super();
        this.xCoordinate=xCoordinate;
        this.yCoordinate=yCoordinate;
        this.weight = weight;
        this.lenght = lenght;
        setOpaque(false);
        setBackground(new Color(0.9137255f, 0.039215688f, 0.07450981f, 0.0f));
        setSize(weight, lenght);
        setLocation(xCoordinate, yCoordinate);
        label = new AnimatedLabel(text,lenght);
        add(label);

        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent event) {
                label.startAnimation();
            }

            public void mouseExited(MouseEvent event) {
                setContentAreaFilled(false);

            }
        });


    }


}

class AnimatedLabel extends JLabel {
    private Timer animator;
    private boolean animating;
    private int animationX;
    private int animationLength;
    private final float[] fractions = {0f, 1f};
    private final Color[] colors = new Color[]{new Color(200, 200, 200), new Color(0, 0, 0)};

    public AnimatedLabel(String text,int animationLength) {
        super(text);
        this.animationLength = animationLength;
        animator = null;
        animating = false;
        animationX = 0;
        setOpaque(false);
        setFont(getFont().deriveFont(Font.BOLD).deriveFont(30f));
    }




   public void startAnimation() {
        if (animator != null && animator.isRunning())
            return;
       animating = true;
        // Начинаем анимацию  animating = true;     animationX = 0;
        animator = new Timer(1000 / 48, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Увеличиваем координату вплоть до достижения ею конца компонента
                if (animationX < getWidth() + animationLength) {
                    animationX += 10;
                    repaint();
                   // AnimatedButton.this.repaint();
                } else {
                    animator.stop();
                    animating = false;
                    animationX = 0;
                }
            }
        });

        animator.start();
    }

    protected void paintComponent(Graphics g) {//
        //Создаём изображение, на котором будет отрисован только лишь текст без фона
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bi.createGraphics();
        g2d.setFont(g.getFont());   // Отрисовываем текст
        super.paintComponent(g2d);
        // При действующей анимации рисуем блик
        if (animating) {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN));
            g2d.setPaint(new RadialGradientPaint
                    (animationX - animationLength / 2, getHeight() / 2, animationLength / 2, fractions, colors));
            g2d.fillRect(animationX - animationLength, 0, animationLength, getHeight());
        }
        // Переносим полученное изображение на исходный компонент
        g2d.dispose();
        g.drawImage(bi, 0, 0, null);
    }
}