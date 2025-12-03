package observer_pattern.ui_objects;

import java.util.List;
import observer_pattern.ui_control.BattlePanel;

public class Projectile {
    private int x, y;
    private final double vx, vy;

    public Projectile(int x, int y, double vx, double vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void updatePosition() {
        x += vx;
        y += vy;
    }

    public static void fireProjectile(BattlePanel battlePanel) {
        BlueDot blueDot = battlePanel.getBlueDot();
        int blueDotX = blueDot.getX();
        int blueDotY = blueDot.getY();

        RedDot redDot = battlePanel.getRedDot();

        int dx = redDot.getX() - blueDotX;
        int dy = redDot.getY() - blueDotY;
        double distance = Math.sqrt(dx * dx + dy * dy);
        double speed = 5; // Vector distance of projectile in pixels immediately after firing.
        double vx = (dx / distance) * speed;
        double vy = (dy / distance) * speed;

        List<Projectile> projectiles = battlePanel.getProjectilesList();
        projectiles.add(new Projectile(blueDotX, blueDotY, vx, vy));
        battlePanel.repaint();
    }
}
