package observer_pattern.ui_objects;

import observer_pattern.interfaces.BattlePanelOps;
import observer_pattern.ui_control.BattlePanel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.awt.Graphics;
import java.awt.Color;

public class RedDot implements BattlePanelOps {
    private int x;
    private int y;
    private BattlePanel battlePanel;
    // Here we add one kind of property that can be observed (ie listened to)
    // That property is 'position'
    // We can create more properties to listen to (if you want)
    private PropertyChangeSupport position;

    public RedDot() {
        position = new PropertyChangeSupport(this);
    }

    // Here is where we would add an observer ... in our case the "Blue Dot"
    public void addPropertyChangeListener(PropertyChangeListener observer) {
        position.addPropertyChangeListener(observer);
    }

    public void removePropertyChangeListener(PropertyChangeListener observer) {
        position.removePropertyChangeListener(observer);
    }

    public void setX(int x) {
        position.firePropertyChange("xCoordinate", this.x, x);
        this.x = x;
    }

    public void setY(int y) {
        position.firePropertyChange("yCoordinate", this.y, y);
        this.y = y;

    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    // Implement the BattlePanelOps interface
    // Implement the BattlePanelOps interface
    @Override
    public BattlePanel getBattlePanel() {
        return battlePanel;
    }

    @Override
    public void setBattlePanel(BattlePanel battlePanel) {
        this.battlePanel = battlePanel;
    }

    public void drawRedDot(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(this.x - 10, this.y - 10, 20, 20);

    }

}
