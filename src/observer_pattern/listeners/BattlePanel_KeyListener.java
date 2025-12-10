package observer_pattern.listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import observer_pattern.ui_control.BattlePanel;
import observer_pattern.ui_objects.*;;

public class BattlePanel_KeyListener extends KeyAdapter {
    private final BattlePanel battlePanel;
    private Timer fireTimer;

    public BattlePanel_KeyListener(BattlePanel battlePanel) {
        this.battlePanel = battlePanel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && (fireTimer == null || !fireTimer.isRunning())) {
            fireTimer = new Timer(3, event -> Projectile.fireProjectile(battlePanel));
            fireTimer.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && fireTimer != null) {
            fireTimer.stop();
        }
    }
}
