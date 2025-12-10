package observer_pattern.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import observer_pattern.ui_objects.RedDot;

public class RedDot_TimerListener implements ActionListener {
    private Timer timer;
    private final Random random;
    private final int[] direction;
    private final RedDot redDot;
    private final JToggleButton button;

    public RedDot_TimerListener(RedDot redDot, JToggleButton button) {
        this.timer = null; // Initialize as null
        this.random = new Random();
        this.direction = new int[] { 1, 1 }; // direction[0] for X, direction[1] for Y (1: increasing, -1: decreasing)
        this.redDot = redDot;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (button.isSelected()) {
            button.setText("Stop RedDot");

            // Create a new Timer instance when starting
            timer = new Timer();

            // Schedule random coordinate updates
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    int currentX = (int) redDot.getX();
                    int currentY = (int) redDot.getY();

                    // Update X coordinate
                    int deltaX = random.nextInt(10) + 1; // Random step between 1 and 10
                    int panelWidth = redDot.getBattlePanel().getWidth();
                    int panelHeight = redDot.getBattlePanel().getHeight();

                    if (currentX + deltaX * direction[0] > panelWidth || currentX + deltaX * direction[0] < 0) {
                        direction[0] *= -1; // Reverse direction
                    }
                    redDot.setX(currentX + deltaX * direction[0]);

                    // Update Y coordinate
                    int deltaY = random.nextInt(10) + 1; // Random step between 1 and 10
                    // 343 is chosen because that is what size where red dot may go off default
                    // screen
                    if (currentY + deltaY * direction[1] > panelHeight || currentY + deltaY * direction[1] < 0) {
                        direction[1] *= -1; // Reverse direction
                    }
                    redDot.setY(currentY + deltaY * direction[1]);
                }
            }, 0, 100); // Update every 100ms
        } else {
            button.setText("Start Red Dot");

            // Stop random updates
            if (timer != null) {
                timer.cancel();
                timer.purge();
                timer = null; // Clear the reference to allow creating a new Timer
            }
        }
    }
}
