package edu.fiuba.algoChess;

import edu.fiuba.algoChess.Salud.Salud;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CuranderoTest {


//     @Test
//     public void test001CuranderoPuedeCurarSoldadoAliadoCercano(){
//         BandoJugador1 bandoJugador1 = new BandoJugador1();
//         Ubicacion ubicacionSoldado = new Ubicacion(1,3);
//         Soldado soldado = new Soldado(ubicacionSoldado,bandoJugador1);
//         Ubicacion ubicacionCurandero = new Ubicacion(1,2);
//         Curandero curandero = new Curandero(ubicacionCurandero,bandoJugador1);

//         Comportamiento comportamiento = new AtaqueMedioJinete(15);
//         soldado.recibirAtaque(comportamiento);
//         int vidaSoldadoCurado = soldado.getVida() + curandero.getCuracion().getValorComportamiento();
//         curandero.curar(soldado);
//         assertEquals(vidaSoldadoCurado,soldado.getVida());

//         DistanciaRelativa distanciaSoldadoACurandero = curandero.getDistanciaRelativa(soldado);
//         Salud vidaTrasCuracion = soldado.getVida();
//         curandero.curar(distanciaSoldadoACurandero,soldado);

//         assertEquals(vidaTrasCuracion,soldado.getVida());
//     };

//     @Test (expected = NoSePuedeCurarUnaUnidadEnemigaException.class)
//     public void test002SeLanzaExceptionCuandoCuranderoIntentaCurarSoldadoEnemigoCercano(){
//         BandoJugador1 bandoJugador1 = new BandoJugador1();
//         BandoJugador2 bandoJugador2 = new BandoJugador2();
//         Ubicacion ubicacionSoldado = new Ubicacion(1,3);
//         Soldado soldado = new Soldado(ubicacionSoldado,bandoJugador1);
//         Ubicacion ubicacionCurandero = new Ubicacion(1,2);
//         Curandero curandero = new Curandero(ubicacionCurandero,bandoJugador2);
//         Comportamiento comportamiento = new AtaqueMedioJinete(15);
//         soldado.recibirAtaque(comportamiento);
//         curandero.curar(soldado);
//     };


//     @Test (expected = FueraDeRangoParaEjecutarComportamientoException.class)
//     public void test03SeLanzaExceptionCuandoCuranderoIntentaCurarSoldadoAliadoLejano(){
//         BandoJugador1 bandoJugador1 = new BandoJugador1();
//         Ubicacion ubicacionSoldado = new Ubicacion(1,8);
//         Soldado soldado = new Soldado(ubicacionSoldado,bandoJugador1);
//         Ubicacion ubicacionCurandero = new Ubicacion(1,2);
//         Curandero curandero = new Curandero(ubicacionCurandero,bandoJugador1);
//         Comportamiento comportamiento = new AtaqueMedioJinete(15);
//         soldado.recibirAtaque(comportamiento);
//         curandero.curar(soldado);
//     };
  
//     @Test (expected = NoSePuedeCurarUnaCatapultaException.class)
//     public void test04SeLanzaExceptionCuandoCuranderoIntentaCurarUnaCatapulta(){
//         BandoJugador1 bandoJugador1 = new BandoJugador1();
//         Ubicacion ubicacionCatapulta = new Ubicacion(1,3);
//         Catapulta catapulta = new Catapulta(ubicacionCatapulta,bandoJugador1);
//         Ubicacion ubicacionCurandero = new Ubicacion(1,2);
//         Curandero curandero = new Curandero(ubicacionCurandero,bandoJugador1);
//         Comportamiento comportamiento = new AtaqueMedioJinete(15);
//         catapulta.recibirAtaque(comportamiento);
//         curandero.curar(catapulta);
//     };



}
