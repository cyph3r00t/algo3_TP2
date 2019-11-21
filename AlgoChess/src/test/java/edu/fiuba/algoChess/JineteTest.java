package edu.fiuba.algoChess;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class JineteTest {

    @Test
    public void test01JineteReconoceAPiezaAliadaEnTerrenoCercanoCeldaContigua(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tableroTest = new Tablero(jugador1, jugador2);
        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();
        jinete.setJugador(jugador1);
        curandero.setJugador(jugador1);
        Ubicacion ubicacionJinete = new Ubicacion(5,5);
        Ubicacion ubicacionCurandero = new Ubicacion(5,4);
        tableroTest.ubicarEnCelda(jinete,ubicacionJinete);
        tableroTest.ubicarEnCelda(curandero,ubicacionCurandero);
        jinete.reconocerTerreno(tableroTest);
        assertTrue(jinete.getPiezaAliadaCercana());
    }


    @Test
    public void test02JineteReconoceAPiezaAliadaEnTerrenoCercanoAdistancia2(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tableroTest = new Tablero(jugador1, jugador2);
        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();
        jinete.setJugador(jugador1);
        curandero.setJugador(jugador1);
        Ubicacion ubicacionJinete = new Ubicacion(5,5);
        Ubicacion ubicacionCurandero = new Ubicacion(5,3);
        tableroTest.ubicarEnCelda(jinete,ubicacionJinete);
        tableroTest.ubicarEnCelda(curandero,ubicacionCurandero);
        jinete.reconocerTerreno(tableroTest);
        assertTrue(jinete.getPiezaAliadaCercana());
    }

    @Test
    public void test03JineteNoReconoceEnTerrenoCercanoAPiezaAliadaAdistancia3(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tableroTest = new Tablero(jugador1, jugador2);
        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();
        jinete.setJugador(jugador1);
        curandero.setJugador(jugador1);
        Ubicacion ubicacionJinete = new Ubicacion(5,5);
        Ubicacion ubicacionCurandero = new Ubicacion(5,2);
        tableroTest.ubicarEnCelda(jinete,ubicacionJinete);
        tableroTest.ubicarEnCelda(curandero,ubicacionCurandero);
        jinete.reconocerTerreno(tableroTest);
        assertFalse(jinete.getPiezaAliadaCercana());
    }


    @Test
    public void test04JineteReconoceAPiezaEnemigaEnTerrenoCercanoCeldaContigua(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tableroTest = new Tablero(jugador1, jugador2);
        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();
        jinete.setJugador(jugador1);
        curandero.setJugador(jugador2);
        Ubicacion ubicacionJinete = new Ubicacion(10,5);
        Ubicacion ubicacionCurandero = new Ubicacion(11,4);
        tableroTest.ubicarEnCelda(jinete,ubicacionJinete);
        tableroTest.ubicarEnCelda(curandero,ubicacionCurandero);
        jinete.reconocerTerreno(tableroTest);
        assertTrue(jinete.getPiezaEnemigaCercana());
    }


    @Test
    public void test05jineteReconoceAPiezaAliadaEnTerrenoCercanoAdistancia2(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tableroTest = new Tablero(jugador1, jugador2);
        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();
        jinete.setJugador(jugador1);
        curandero.setJugador(jugador2);
        Ubicacion ubicacionJinete = new Ubicacion(10,5);
        Ubicacion ubicacionCurandero = new Ubicacion(12,5);
        tableroTest.ubicarEnCelda(jinete,ubicacionJinete);
        tableroTest.ubicarEnCelda(curandero,ubicacionCurandero);
        jinete.reconocerTerreno(tableroTest);
        assertTrue(jinete.getPiezaEnemigaCercana());
    }

    @Test
    public void test06jineteNoReconoceEnTerrenoCercanoAPiezaAliadaAdistancia3(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tableroTest = new Tablero(jugador1, jugador2);
        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();
        jinete.setJugador(jugador1);
        curandero.setJugador(jugador2);
        Ubicacion ubicacionJinete = new Ubicacion(10,5);
        Ubicacion ubicacionCurandero = new Ubicacion(13,4);
        tableroTest.ubicarEnCelda(jinete,ubicacionJinete);
        tableroTest.ubicarEnCelda(curandero,ubicacionCurandero);
        jinete.reconocerTerreno(tableroTest);
        assertFalse(jinete.getPiezaEnemigaCercana());
    }

    @Test
    public void test07jineteReconoceAPiezaAliadaYPiezaEnemigaEnTerrenoCercanoAdistancia2(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Tablero tableroTest = new Tablero(jugador1, jugador2);
        Jinete jineteJugador1 = new Jinete();
        Curandero curanderoJugador1 = new Curandero();
        Curandero curanderoJugador2 = new Curandero();
        jineteJugador1.setJugador(jugador1);
        curanderoJugador1.setJugador(jugador1);
        curanderoJugador2.setJugador(jugador2);
        Ubicacion ubicacionJineteJugador1 = new Ubicacion(10,5);
        Ubicacion ubicacionCuranderoJugador1 = new Ubicacion(10,4);
        Ubicacion ubicacionCuranderoJugador2 = new Ubicacion(12,5);
        tableroTest.ubicarEnCelda(jineteJugador1,ubicacionJineteJugador1);
        tableroTest.ubicarEnCelda(curanderoJugador1,ubicacionCuranderoJugador1);
        tableroTest.ubicarEnCelda(curanderoJugador2,ubicacionCuranderoJugador2);
        jineteJugador1.reconocerTerreno(tableroTest);
        assertTrue((jineteJugador1.getPiezaAliadaCercana() && jineteJugador1.getPiezaEnemigaCercana()));
    };

    @Test
    public void test08JineteAtacaAEnemigoEnDistanciaMediaCuandoHayUnSoldadoAliadoCerca(){
        Jugador enemigo = new Jugador();
        Jugador aliado = new Jugador();
        Tablero tablero = new Tablero(enemigo,aliado);

        Soldado soldadoEnemigo = new Soldado();
        Ubicacion ubicacionSoldadoEnemigo = new Ubicacion(8,1);
        soldadoEnemigo.setJugador(enemigo);

        Soldado soldadoAliado = new Soldado();
        Ubicacion ubicacionSoldadoAliado = new Ubicacion(11,2);
        soldadoAliado.setJugador(aliado);

        Jinete jineteAliado = new Jinete();
        Ubicacion ubicacionJineteAliado = new Ubicacion(11,1);
        jineteAliado.setJugador(aliado);

        tablero.ubicarEnCelda(soldadoEnemigo, ubicacionSoldadoEnemigo);
        tablero.ubicarEnCelda(soldadoAliado,ubicacionSoldadoAliado);
        tablero.ubicarEnCelda(jineteAliado,ubicacionJineteAliado);
        jineteAliado.reconocerTerreno(tablero);

        DistanciaRelativa distanciaSoldadoEnemigoAJineteAliado = jineteAliado.getDistanciaRelativa(soldadoEnemigo);
        //assertTrue(distanciaSoldadoAJinete instanceof DistanciaRelativa);
        int vidaTrasAtaque = soldadoEnemigo.getVida() - jineteAliado.getAtaqueMedio();
        jineteAliado.ejecutarComportamiento(distanciaSoldadoEnemigoAJineteAliado,soldadoEnemigo);
        assertEquals(vidaTrasAtaque,soldadoEnemigo.getVida());

    };

    @Test
    public void test09JineteNoPuedeAtacarConAtaqueMedioAEnemigoEnDistanciaCortaAunCuandoHayUnSoldadoAliadoCerca(){
        Jugador enemigo = new Jugador();
        Jugador aliado = new Jugador();
        Tablero tablero = new Tablero(enemigo,aliado);

        Soldado soldadoEnemigo = new Soldado();
        Ubicacion ubicacionSoldadoEnemigo = new Ubicacion(10,1);
        soldadoEnemigo.setJugador(enemigo);

        Soldado soldadoAliado = new Soldado();
        Ubicacion ubicacionSoldadoAliado = new Ubicacion(11,2);
        soldadoAliado.setJugador(aliado);

        Jinete jineteAliado = new Jinete();
        Ubicacion ubicacionJineteAliado = new Ubicacion(11,1);
        jineteAliado.setJugador(aliado);

        tablero.ubicarEnCelda(soldadoEnemigo, ubicacionSoldadoEnemigo);
        tablero.ubicarEnCelda(soldadoAliado,ubicacionSoldadoAliado);
        tablero.ubicarEnCelda(jineteAliado,ubicacionJineteAliado);
        jineteAliado.reconocerTerreno(tablero);

        DistanciaRelativa distanciaSoldadoEnemigoAJineteAliado = jineteAliado.getDistanciaRelativa(soldadoEnemigo);
        //assertTrue(distanciaSoldadoAJinete instanceof DistanciaRelativa);
        int vidaTrasAtaque = soldadoEnemigo.getVida();
        jineteAliado.ejecutarComportamiento(distanciaSoldadoEnemigoAJineteAliado,soldadoEnemigo);
        assertEquals(vidaTrasAtaque,soldadoEnemigo.getVida());

    };

    @Test
    public void test10JineteAtacaConAtaqueCercanoAEnemigoEnDistanciaCortaCuandoNoHayUnSoldadoAliadoCerca(){
        Jugador enemigo = new Jugador();
        Jugador aliado = new Jugador();
        Tablero tablero = new Tablero(enemigo,aliado);

        Soldado soldadoEnemigo = new Soldado();
        Ubicacion ubicacionSoldadoEnemigo = new Ubicacion(10,1);
        soldadoEnemigo.setJugador(enemigo);

        Soldado soldadoAliado = new Soldado();
        Ubicacion ubicacionSoldadoAliado = new Ubicacion(15,2);
        soldadoAliado.setJugador(aliado);

        Jinete jineteAliado = new Jinete();
        Ubicacion ubicacionJineteAliado = new Ubicacion(11,1);
        jineteAliado.setJugador(aliado);

        tablero.ubicarEnCelda(soldadoEnemigo, ubicacionSoldadoEnemigo);
        tablero.ubicarEnCelda(soldadoAliado,ubicacionSoldadoAliado);
        tablero.ubicarEnCelda(jineteAliado,ubicacionJineteAliado);
        jineteAliado.reconocerTerreno(tablero);

        DistanciaRelativa distanciaSoldadoEnemigoAJineteAliado = jineteAliado.getDistanciaRelativa(soldadoEnemigo);
        //assertTrue(distanciaSoldadoAJinete instanceof DistanciaRelativa);
        int vidaTrasAtaque = soldadoEnemigo.getVida() - jineteAliado.getAtaqueCercano();
        jineteAliado.ejecutarComportamiento(distanciaSoldadoEnemigoAJineteAliado,soldadoEnemigo);
        assertEquals(vidaTrasAtaque,soldadoEnemigo.getVida());

    };

    @Test
    public void test11JineteNoPuedeAtacarConAtaqueCercanoAEnemigoEnDistanciaCortaCuandoHayUnSoldadoAliadoCerca(){
        Jugador enemigo = new Jugador();
        Jugador aliado = new Jugador();
        Tablero tablero = new Tablero(enemigo,aliado);

        Soldado soldadoEnemigo = new Soldado();
        Ubicacion ubicacionSoldadoEnemigo = new Ubicacion(10,1);
        soldadoEnemigo.setJugador(enemigo);

        Soldado soldadoAliado = new Soldado();
        Ubicacion ubicacionSoldadoAliado = new Ubicacion(11,2);
        soldadoAliado.setJugador(aliado);

        Jinete jineteAliado = new Jinete();
        Ubicacion ubicacionJineteAliado = new Ubicacion(11,1);
        jineteAliado.setJugador(aliado);

        tablero.ubicarEnCelda(soldadoEnemigo, ubicacionSoldadoEnemigo);
        tablero.ubicarEnCelda(soldadoAliado,ubicacionSoldadoAliado);
        tablero.ubicarEnCelda(jineteAliado,ubicacionJineteAliado);
        jineteAliado.reconocerTerreno(tablero);

        DistanciaRelativa distanciaSoldadoEnemigoAJineteAliado = jineteAliado.getDistanciaRelativa(soldadoEnemigo);
        //assertTrue(distanciaSoldadoAJinete instanceof DistanciaRelativa);
        int vidaTrasAtaque = soldadoEnemigo.getVida();
        jineteAliado.ejecutarComportamiento(distanciaSoldadoEnemigoAJineteAliado,soldadoEnemigo);
        assertEquals(vidaTrasAtaque,soldadoEnemigo.getVida());

    };

    @Test

    public void test12JineteAtacaSoldadoCercano(){
        Soldado soldado = new Soldado();
        Ubicacion ubicacionSoldado = new Ubicacion(1,1);
        soldado.setUbicacion(ubicacionSoldado);
        Jinete jinete = new Jinete();
        Ubicacion ubicacionJinete = new Ubicacion(1,2);
        jinete.setUbicacion(ubicacionJinete);
        DistanciaRelativa distanciaSoldadoAJinete = jinete.getDistanciaRelativa(soldado);
        //assertTrue(distanciaSoldadoAJinete instanceof DistanciaRelativa);
        int vidaTrasAtaque = soldado.getVida() - jinete.getAtaqueCercano();
        jinete.ejecutarComportamiento(distanciaSoldadoAJinete,soldado);
        Assert.assertEquals(vidaTrasAtaque,soldado.getVida());
    };

    @Test
    public void test13JineteAtacaSoldadoADistanciaMedia(){
        Soldado soldado = new Soldado();
        Ubicacion ubicacionSoldado = new Ubicacion(4,2);
        soldado.setUbicacion(ubicacionSoldado);
        Jinete jinete = new Jinete();
        Ubicacion ubicacionJinete = new Ubicacion(1,2);
        jinete.setUbicacion(ubicacionJinete);
        DistanciaRelativa distanciaSoldadoAJinete = jinete.getDistanciaRelativa(soldado);
        //assertTrue(distanciaSoldadoAJinete instanceof DistanciaRelativa);
        int vidaTrasAtaque = soldado.getVida() - jinete.getAtaqueMedio();
        jinete.ejecutarComportamiento(distanciaSoldadoAJinete,soldado);
        Assert.assertEquals(vidaTrasAtaque,soldado.getVida());
    };

    @Test
    public void test14JineteAtacaSoldadoLejanoYNoSeDescuentaVidaDelSoldado(){
        Soldado soldado = new Soldado();
        Ubicacion ubicacionSoldado = new Ubicacion(10,10);
        soldado.setUbicacion(ubicacionSoldado);
        Jinete jinete = new Jinete();
        Ubicacion ubicacionJinete = new Ubicacion(1,2);
        jinete.setUbicacion(ubicacionJinete);
        DistanciaRelativa distanciaSoldadoAJinete = jinete.getDistanciaRelativa(soldado);
        //assertTrue(distanciaSoldadoAJinete instanceof DistanciaRelativa);
        int vidaTrasAtaque = soldado.getVida() - jinete.getAtaqueLejano();
        jinete.ejecutarComportamiento(distanciaSoldadoAJinete,soldado);
        Assert.assertEquals(vidaTrasAtaque,soldado.getVida());
    };

}

