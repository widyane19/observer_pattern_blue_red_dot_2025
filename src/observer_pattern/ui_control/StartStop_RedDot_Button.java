package observer_pattern.ui_control;

import javax.swing.*;

import observer_pattern.listeners.RedDot_TimerListener;
import observer_pattern.ui_objects.RedDot;

public class StartStop_RedDot_Button {
    private final JToggleButton button;

    public StartStop_RedDot_Button(RedDot redDot) {
        this.button = new JToggleButton("Start RedDot");

        this.button.setFocusable(false);

        // Add action listener for the button
        this.button.addActionListener(new RedDot_TimerListener(redDot, button));
    }

    public JToggleButton getButton() {
        return button;
    }
}
