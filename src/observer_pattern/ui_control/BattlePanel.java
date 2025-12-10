package observer_pattern.ui_control;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import observer_pattern.ui_objects.BlueDot;
import observer_pattern.ui_objects.Projectile;
import observer_pattern.ui_objects.RedDot;

public class BattlePanel extends JPanel {
    private List<Projectile> projectiles = new ArrayList<>();
    private BlueDot blueDot;
    private RedDot redDot;

    public BattlePanel(BlueDot blueDot, RedDot redDot) {
        this.blueDot = blueDot;
        this.blueDot.setX(getWidth() / 2);
        this.blueDot.setY(getHeight() / 2);
        this.redDot = redDot;
        this.redDot.setBattlePanel(this);
        this.redDot.setX(50);
        this.redDot.setY(50);
        // Timer for projectile movement
        new Timer(10, e -> updateProjectiles()).start();
    }

    // Getters and Setters for BattlePanel's fields representing BlueDot, RedDot and
    // the list of Projectiles
    public BlueDot getBlueDot() {
        return blueDot;
    }

    public void setBlueDot(BlueDot blueDot) {
        this.blueDot = blueDot;
    }

    public RedDot getRedDot() {
        return redDot;
    }

    public void setRedDot(RedDot redDot) {
        this.redDot = redDot;
    }

    public List<Projectile> getProjectilesList() {
        return projectiles;
    }

    public void setProjectilesList(List<Projectile> projectiles) {
        this.projectiles = projectiles;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Clear the panel
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw the red icon (red circle)
        // Draw the blue icon (center)
        redDot.drawRedDot(g);
        blueDot.drawBlueDot(this, g);

        // Draw projectiles
        g.setColor(Color.ORANGE);
        updateProjectiles();
        for (Projectile p : projectiles) {
            g.fillOval(p.getX() - 5, p.getY() - 5, 10, 10);
        }
    }

    public void updateProjectiles() {
        for (Projectile p : projectiles) {
            p.updatePosition();
        }
        projectiles.removeIf(p -> p.getX() < 0 || p.getY() < 0 || p.getX() > getWidth() || p.getY() > getHeight());
    }
}
