package org.example.first2dgame;

import com.almasb.fxgl.entity.SpawnData;
import javafx.geometry.Point2D;
import com.almasb.fxgl.entity.component.Component;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

public class PlayerComponent extends Component {
    private static final double ROTATION_CHANGE = 0.01;
    private Point2D direction = new Point2D(1, 1);

    @Override
    public void onUpdate(double tpf) {
        entity.translate(direction.multiply(1));
        checkForBounds();
    }

    private void checkForBounds() {
        if (entity.getX() < 0) {
            die();
        }
        if (entity.getX() >= getAppWidth()) {
            die();
        }
        if (entity.getY() < 0) {
            die();
        }
        if (entity.getY() >= getAppHeight()) {
            die();
        }
    }

    public void shoot() {
        spawn("bullet", new SpawnData(
                getEntity().getPosition().getX() + 20,
                getEntity().getPosition().getY() - 5)
                .put("direction", direction));
    }

    public void die() {
        inc("lives", -1);

        if (geti("lives") <= 0) {
            getDialogService().showMessageBox("Game Over",
                    () -> getGameController().startNewGame());
            return;
        }

        entity.setPosition(0, 0);
        direction = new Point2D(1, 1);
        right();
    }

    public void up() {
        if (direction.getY() > -1) {
            direction = new Point2D(direction.getX(), direction.getY() - ROTATION_CHANGE);
        }
    }

    public void down() {
        if (direction.getY() < 1) {
            direction = new Point2D(direction.getX(), direction.getY() + ROTATION_CHANGE);
        }
    }

    public void left() {
        if (direction.getX() > -1) {
            direction = new Point2D(direction.getX() - ROTATION_CHANGE, direction.getY());
        }
    }

    public void right() {
        if (direction.getX() < 1) {
            direction = new Point2D(direction.getX() + ROTATION_CHANGE, direction.getY());
        }
    }
}
