package observer_pattern.ui_objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.Timer;
import observer_pattern.interfaces.BattlePanelOps;
import observer_pattern.listeners.*;
import observer_pattern.ui_control.BattlePanel;

public class BlueDot implements BattlePanelOps {
    private int x;
    private int y;
    private int redDotX, redDotY;
    private RedDot_PropertyListener redDotObserver;
    private BattlePanel battlePanel;
    private final Random random = new Random();
    private Timer moveTimer;
    private boolean randomMotion = true;

    public BlueDot() {
    }

    public void setX(float x) {
        this.x = (int) x;
    }

    public void setY(float y) {
        this.y = (int) y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    // Implement the BattlePanelOps interface
    @Override
    public BattlePanel getBattlePanel() {
        return battlePanel;
    }

    @Override
    public void setBattlePanel(BattlePanel battlePanel) {
        this.battlePanel = battlePanel;
    }

    public int getRedDotX() {
        return redDotX;
    }

    public void setRedDotX(int newValue) {
        redDotX = newValue;
    }

    public int getRedDotY() {
        return redDotY;
    }

    public void setRedDotY(int newValue) {
        redDotY = newValue;
    }

    // Make the blueDot the observer of the redDot's position
    public void setRedDotPropertyListener(RedDot redDot) {
        redDotObserver = new RedDot_PropertyListener(this);
        redDot.addPropertyChangeListener(redDotObserver);

    }

    public void drawBlueDot(BattlePanel panel, Graphics g) {
        //setX(panel.getWidth() / 2);
        //setY(panel.getHeight() / 2);
        g.setColor(Color.BLUE);
        g.fillOval(this.x - 15, this.y - 15, 30, 30);

    }
    public void setKeyboardMode(boolean enabled) {
        this.randomMotion = !enabled;
    }
    public void startRandomMotion() {
        //if (battlePanel == null) return;
        moveTimer = new Timer(100, e -> {
            if (!randomMotion) return; // skip random movement if in keyboard mode
            int dx = random.nextInt(11) - 5; // -5 to +5
            int dy = random.nextInt(11) - 5; // -5 to +5
            int newX = Math.max(0, Math.min(getBattlePanel().getWidth(), x + dx));
            int newY = Math.max(0, Math.min(getBattlePanel().getHeight(), y + dy));
            setX(newX);
            setY(newY);
            battlePanel.repaint();
        });
        moveTimer.start();
    }

}
