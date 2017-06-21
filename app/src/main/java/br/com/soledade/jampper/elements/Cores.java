package br.com.soledade.jampper.elements;

import android.graphics.Paint;

/**
 * Created by soledade on 20/06/17.
 */

public class Cores {

    public static Paint getCorDoPassaro() {
        Paint vermelho = new Paint();
        vermelho.setColor(0XFFFF0000);
        return vermelho;
    }

    public static Paint getCorDoCano() {
        Paint verde = new Paint();
        verde.setColor(0XFF00FF00);
        return verde;
    }
}
