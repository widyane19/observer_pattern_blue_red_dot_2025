package observer_pattern;

import javax.swing.*;
import observer_pattern.ui_control.TopLevel_UI;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TopLevel_UI ui = new TopLevel_UI();
            ui.setFocusable(true);
            ui.setVisible(true);
        });
    }
}
