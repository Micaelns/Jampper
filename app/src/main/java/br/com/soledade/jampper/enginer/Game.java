package br.com.soledade.jampper.enginer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import br.com.soledade.jampper.R;
import br.com.soledade.jampper.elements.Cano;
import br.com.soledade.jampper.elements.Canos;
import br.com.soledade.jampper.elements.Passaro;
import br.com.soledade.jampper.elements.Pontuacao;
import br.com.soledade.jampper.elements.Tela;

/**
 * Created by soledade on 19/06/17.
 */

public class Game extends SurfaceView implements Runnable, View.OnTouchListener {

    private boolean isRunning=true;
    private Canos canos;
    private Passaro passaro;
    private Tela tela;
    private Pontuacao pontuacao;

    final SurfaceHolder holder =getHolder();
    private Bitmap backgroud;

    public Game(Context context) {
        super(context);
        this.tela=new Tela(context);
        inicializaElementos();
        setOnTouchListener(this);
    }

    @Override
    public void run() {
        while(isRunning){
            if(!holder.getSurface().isValid())continue;

            Canvas canvas=holder.lockCanvas();

            canvas.drawBitmap(backgroud,0,0,null);
            passaro.desenhaNo(canvas);
            passaro.cai();
            canos.desenhaNo(canvas);
            pontuacao.desenhaNo(canvas);
            canos.move();
            holder.unlockCanvasAndPost(canvas);
        }
    }

    private void inicializaElementos() {
        this.passaro = new Passaro(this.tela);
        this.pontuacao=new Pontuacao();
        this.canos=new Canos(this.tela, pontuacao);
        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        backgroud = Bitmap.createScaledBitmap(back, this.tela.getLargura(),this.tela.getAltura(),false);
    }

    public void cancela(){
        this.isRunning=false;
    }

    public void inicia() {
        this.isRunning=true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        passaro.pula();
        return false;
    }
}
