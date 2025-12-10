package observer_pattern.ui_control;

import java.awt.*;
import javax.swing.*;
import observer_pattern.listeners.*;
import observer_pattern.ui_objects.*;

public class TopLevel_UI extends JFrame {
    private final BattlePanel battlePanel;
    private final RedDot redDot;
    private final BlueDot blueDot;
    // private final ClonePositionChangeListener positionChangeListener;

    public TopLevel_UI() {
        setTitle("Red Dot Position Tracker");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the good guy and the bad guy
        blueDot = new BlueDot();
        redDot = new RedDot();
        // Create the battle panel
        battlePanel = new BattlePanel(blueDot, redDot);
        blueDot.setBattlePanel(battlePanel);
        blueDot.setRedDotPropertyListener(redDot);
        blueDot.setX(battlePanel.getWidth() / 2);
        blueDot.setY(battlePanel.getHeight() / 2);
        blueDot.startRandomMotion();
        // Create the start/stop button
        StartStop_RedDot_Button startStopButton = new StartStop_RedDot_Button(redDot);

        // Add the toggle start/stop button and then battle panel
        add(startStopButton.getButton(), BorderLayout.NORTH);
        add(battlePanel, BorderLayout.CENTER);

        // create and add listeners for the space key
        addKeyListener(new BattlePanel_KeyListener(battlePanel));
        addKeyListener(new BlueDot_KeyListener(blueDot));
    }
}
