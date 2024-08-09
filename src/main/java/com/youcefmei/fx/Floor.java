package com.youcefmei.fx;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import lombok.Getter;
import lombok.Setter;

public class Floor {
    @Getter @Setter
    private int level ;

    @Getter @Setter
    private Rectangle rect;

    public Floor(int level) {
        this.level = level;
        this.rect = new Rectangle();

        this.rect.setFill(Color.web("#1e90ff"));
        this.rect.setHeight(21);
        this.rect.setWidth(280 - 30 * level);
        this.rect.setStroke(Color.BLACK);
//        this.rect.setStroke(Color.BLACK);

    }
}
