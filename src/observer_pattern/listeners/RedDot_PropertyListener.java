package observer_pattern.listeners;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import observer_pattern.ui_objects.BlueDot;

public class RedDot_PropertyListener implements PropertyChangeListener {
    private BlueDot blueDot;

    public RedDot_PropertyListener(BlueDot blueDot) {
        this.blueDot = blueDot;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        Integer tempInteger = (Integer) evt.getNewValue();
        int newValue = tempInteger.intValue();

        // Update blueDot's knowledge of red dot's position
        if ("xCoordinate".equals(propertyName)) {
            blueDot.setRedDotX(newValue);
        } else if ("yCoordinate".equals(propertyName)) {
            blueDot.setRedDotY(newValue);
        }
        blueDot.getBattlePanel().repaint(); // Repaint the panel to update the icon's position

    }
}
