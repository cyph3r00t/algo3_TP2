package edu.fiuba.algoChess.modelo.bandos;

import edu.fiuba.algoChess.modelo.comportamientos.Ataque;
import edu.fiuba.algoChess.modelo.comportamientos.Curacion;
import edu.fiuba.algoChess.modelo.entidades.Jinete;
import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entorno.Celda;
import edu.fiuba.algoChess.modelo.excepciones.InteraccionInvalidaException;
import edu.fiuba.algoChess.modelo.excepciones.UbicacionEnSectorInvalidoException;
import edu.fiuba.algoChess.modelo.salud.Herible;
import edu.fiuba.algoChess.modelo.salud.Salud;

import java.util.ArrayList;

public class    BandoJugador2 extends Bando {

    @Override
    public void atacar(Pieza pieza, Ataque ataque, Bando bando){
        bando.atacar(pieza, ataque, this);
    }

    @Override
    public void atacar(Pieza pieza, Ataque ataque, BandoJugador1 bandojugador1){
        pieza.recibirAtaque(ataque);
    }

    @Override
    public void atacar(Pieza pieza, Ataque ataque, BandoJugador2 bandojugador2){
        throw new InteraccionInvalidaException("No se puede atacar un aliado");
    }

    @Override
    public void curar(Pieza pieza, Curacion curacion, Bando bando){
        bando.curar(pieza, curacion, this);
    }

    @Override
    public void curar(Pieza pieza, Curacion curacion, BandoJugador1 bandojugador1){
        throw new InteraccionInvalidaException("No se puede curar un enemigo");
    }

    @Override
    public void curar(Pieza pieza, Curacion curacion, BandoJugador2 bandojugador2){
        curacion.curar(pieza);
    }

    @Override
    public Salud recibirAtaque(Herible herible, Ataque ataque, Bando bando) {
        return bando.recibirAtaque(herible, ataque, this);
    }

    @Override
    public Salud recibirAtaque(Herible herible, Ataque ataque, BandoJugador1 bandoJugador1) {
        return ataque.hacerDanioSectorEnemigo(herible);
    }

    @Override
    public Salud recibirAtaque(Herible herible, Ataque ataque, BandoJugador2 bandoJugador2) {
        return ataque.hacerDanioSectorAliado(herible);
    }

    @Override
    public String getNombre() {
        return "jugador2";
    }

    @Override
    public ArrayList<Pieza> aniadirSoldadoAliadoAlStack(Pieza piezaPeriferia, ArrayList<Pieza> stack, Bando bandoSoldadoPeriferia) {
        return bandoSoldadoPeriferia.aniadirSoldadoAliadoAlStack(piezaPeriferia, stack, this);
    }

    public ArrayList<Pieza> aniadirSoldadoAliadoAlStack(Pieza piezaPeriferia, ArrayList<Pieza> stack, BandoJugador1 bandoSoldadoPeriferia){
        return stack;
    }

    public ArrayList<Pieza> aniadirSoldadoAliadoAlStack(Pieza piezaPeriferia, ArrayList<Pieza> stack, BandoJugador2 bandoSoldadoPeriferia){
        try {
            stack.add(piezaPeriferia);
        } catch(NullPointerException ex){
            stack = new ArrayList<>();
            stack.add(piezaPeriferia);
        }

        return stack;
    }

    @Override
    public void pisarSiBandoCorrecto(Celda celdaPorRemplazar, Pieza piezaPorGuardar, Bando bando) {
         bando.pisarSiBandoCorrecto(celdaPorRemplazar, piezaPorGuardar,this);
    }

    @Override
    public void pisarSiBandoCorrecto(Celda celdaPorRemplazar, Pieza piezaPorGuardar, BandoJugador1 bandoJugador1) {
        throw new UbicacionEnSectorInvalidoException("No se puede ubicar esta pieza en el sector rival");
    }

    @Override
    public void pisarSiBandoCorrecto(Celda celdaPorRemplazar, Pieza piezaPorGuardar, BandoJugador2 bandoJugador2) {
        celdaPorRemplazar.getPiezaActual().pisar(celdaPorRemplazar, piezaPorGuardar);
    }

    @Override
    public void jineteReconocerEnemigoParaAtacarADistanciaMedia(Jinete jinete, Bando bando) {
        bando.jineteReconocerEnemigoParaAtacarADistanciaMedia(jinete, this);
    }

    @Override
    public void jineteReconocerEnemigoParaAtacarADistanciaMedia(Jinete jinete, BandoJugador1 bandoJugador1) {
        jinete.ataqueMedioInvalido();
    }

    @Override
    public void jineteReconocerEnemigoParaAtacarADistanciaMedia(Jinete jinete, BandoJugador2 bandoJugador2) {
    }

    @Override
    public void jineteReconocerAliadoParaAtacarADistanciaMedia(Jinete jinete, Bando bando) {
        bando.jineteReconocerAliadoParaAtacarADistanciaMedia(jinete, this);
    }

    @Override
    public void jineteReconocerAliadoParaAtacarADistanciaMedia(Jinete jinete, BandoJugador1 bandoJugador1) {
    }

    @Override
    public void jineteReconocerAliadoParaAtacarADistanciaMedia(Jinete jinete, BandoJugador2 bandoJugador2) {
        jinete.ataqueMedioValido();
    }

}
