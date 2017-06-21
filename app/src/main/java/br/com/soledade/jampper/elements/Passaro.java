package br.com.soledade.jampper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;


/**
 * Created by soledade on 20/06/17.
 */

public class Passaro {
    private static final int X=100;
    private static final int RAIO=50;

    private static final Paint vermelho =Cores.getCorDoPassaro();
    private Tela tela;

    private int altura;

    public Passaro(Tela tela){
        this.tela=tela;
        this.altura=100;
    }

    public void desenhaNo(Canvas canvas){
        canvas.drawCircle(X,altura,RAIO, vermelho);
    }

    public void cai() {
        boolean chegouNoChao = this.altura + RAIO > tela.getAltura();

        if (!chegouNoChao){
            this.altura += 5;
        }
    }

    public void pula() {
        //por definição o topo da tela vale 0
        if(altura - RAIO > 0) {
            this.altura -= 150;
        }
    }
}
