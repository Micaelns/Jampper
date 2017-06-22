package br.com.soledade.jampper.enginer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import br.com.soledade.jampper.elements.Cores;
import br.com.soledade.jampper.elements.Tela;

/**
 * Created by micael on 21/06/17.
 */

public class GameOver {

    private final Tela tela;
    private static final Paint VERMELHO = Cores.getCorDoGameOver();

    public GameOver(Tela tela) {
        this.tela = tela;
    }

    public void desenhaNo(Canvas canvas) {
        String gameOver = "Game Over";
        canvas.drawText(gameOver, centralizaTexto(gameOver), tela.getAltura()/2, VERMELHO);
    }

    private int centralizaTexto(String texto) {
        Rect limiteDoTexto = new Rect();
        VERMELHO.getTextBounds(texto, 0, texto.length(), limiteDoTexto);

        int centroHorizontal = tela.getLargura()/2 - (limiteDoTexto.right - limiteDoTexto.left)/2;

        return centroHorizontal;
    }

}
