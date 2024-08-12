import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MouserArray extends Pointer {

    int[] x = new int[100];
    int[] y = new int[100];

    public MouserArray () {
        for (int i = 0; i < x.length; i++) {
            x[i] = MouseInfo.getPointerInfo().getLocation().x;
        }

        for (int j = 0; j < y.length; j++) {
            y[j] = MouseInfo.getPointerInfo().getLocation().y;
        }
    }

}