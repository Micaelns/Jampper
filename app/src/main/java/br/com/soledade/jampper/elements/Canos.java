package br.com.soledade.jampper.elements;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by soledade on 21/06/17.
 */

public class Canos {

    private final List<Cano> canos= new ArrayList<Cano>();
    private static final int DISTACIA_ENTRE_CANOS=200;
    private static final int QUANTIDADE_CANOS=5;
    private Pontuacao pontuacao;
    private Tela tela;

    public Canos(Tela tela,Pontuacao pontuacao){
        int posicao=400;
        this.tela=tela;
        this.pontuacao=pontuacao;

        for (int i = 0; i<QUANTIDADE_CANOS; i++){
            posicao+=DISTACIA_ENTRE_CANOS;
            Cano cano =new Cano(tela,posicao);
            canos.add(cano);
        }
    }

    public void desenhaNo(Canvas canvas) {
        for (Cano cano : this.canos) {
            cano.desenhaNo(canvas);
        }
    }

    public void move() {
        ListIterator<Cano> iterator =canos.listIterator();
        while(iterator.hasNext()){
            Cano cano=iterator.next();
            cano.move();
            if(cano.saiuDaTela()){
                this.pontuacao.aumenta();
                iterator.remove();
                Cano outroCano= new Cano(this.tela,getMaximo()+DISTACIA_ENTRE_CANOS);
                iterator.add(outroCano);
            }

        }
    }

    public int getMaximo() {
        int maximo=0;
        for (Cano cano : this.canos) {
            maximo=Math.max(cano.getPosicao(),maximo);
        }
        return maximo;
    }
}
