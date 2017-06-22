package br.com.soledade.jampper.enginer;

import br.com.soledade.jampper.elements.Canos;
import br.com.soledade.jampper.elements.Passaro;

/**
 * Created by micael on 21/06/17.
 */

public class VerificadorDeColisao {

    private Passaro passaro;
    private Canos canos;

    public VerificadorDeColisao(Passaro passaro, Canos canos) {
        this.passaro = passaro;
        this.canos = canos;

    }

    public boolean temColisao() {
        return canos.temColisaoCom(passaro);
    }

}
