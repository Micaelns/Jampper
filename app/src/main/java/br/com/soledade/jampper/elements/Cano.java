package br.com.soledade.jampper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by soledade on 21/06/17.
 */

public class Cano {

    private int alturaDoCanoSuperior;
    private int alturaDoCanoInferior;
    private int posicao;
    private Tela tela;
    private  static final int TAMANHO_DO_CANO =250;
    private  static final int LARGURA_DO_CANO=70;
    private static final Paint VERDE =Cores.getCorDoCano();

    public Cano(Tela tela,int posicao){
        this.tela=tela;
        this.posicao=posicao;
        alturaDoCanoInferior=tela.getAltura()- TAMANHO_DO_CANO - calorAleatorio();
        alturaDoCanoSuperior=TAMANHO_DO_CANO + calorAleatorio();
    }

    private int calorAleatorio() {
       return (int)(Math.random()*150);
    }

    public void desenhaNo(Canvas canvas) {
        desenhaCanoInferior(canvas);
        desenhaCanoSuperior(canvas);
    }

    private void desenhaCanoInferior(Canvas canvas) {
        canvas.drawRect(this.posicao,alturaDoCanoInferior,this.posicao+LARGURA_DO_CANO,tela.getAltura(),VERDE);
    }

    private void desenhaCanoSuperior(Canvas canvas) {
        canvas.drawRect(this.posicao,0,this.posicao+LARGURA_DO_CANO,alturaDoCanoSuperior,VERDE);
    }

    public void move() {
        this.posicao-=5;
    }

    public boolean saiuDaTela(){
        return posicao+LARGURA_DO_CANO<0;
    }

    public int getPosicao() {
        return posicao;
    }
}
