package observer_pattern.listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import observer_pattern.ui_objects.BlueDot;

public class BlueDot_KeyListener extends KeyAdapter {
    private final BlueDot blueDot;
    private final int step = 10;

    public BlueDot_KeyListener(BlueDot blueDot) {
        this.blueDot = blueDot;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        blueDot.setKeyboardMode(true); // switch to keyboard mode
        int newX = blueDot.getX();
        int newY = blueDot.getY();

        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> newX -= step;
            case KeyEvent.VK_RIGHT -> newX += step;
            case KeyEvent.VK_UP -> newY -= step;
            case KeyEvent.VK_DOWN -> newY += step;
        }

        // Keep inside panel bounds
        newX = Math.max(0, Math.min(blueDot.getBattlePanel().getWidth(), newX));
        newY = Math.max(0, Math.min(blueDot.getBattlePanel().getHeight(), newY));

        blueDot.setX(newX);
        blueDot.setY(newY);
        blueDot.getBattlePanel().repaint();
    }
}
