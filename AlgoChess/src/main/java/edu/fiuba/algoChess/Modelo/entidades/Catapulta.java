package edu.fiuba.algoChess.Modelo.entidades;
import edu.fiuba.algoChess.Modelo.entorno.*;
import edu.fiuba.algoChess.Modelo.bandos.Bando;
import edu.fiuba.algoChess.Modelo.batallones.Batalloneable;
import edu.fiuba.algoChess.Modelo.comportamientos.AtaqueLejanoCatapulta;
import edu.fiuba.algoChess.Modelo.comportamientos.Comportamiento;
import edu.fiuba.algoChess.Modelo.entorno.*;
import edu.fiuba.algoChess.Modelo.excepciones.FueraDeRangoParaEjecutarComportamientoException;
import edu.fiuba.algoChess.Modelo.excepciones.NoHayBatallonFormadoException;
import edu.fiuba.algoChess.Modelo.excepciones.OperacionInvalidaException;
import edu.fiuba.algoChess.Modelo.excepciones.PiezaActualNoFormaBatallonDeSoldadosException;
import edu.fiuba.algoChess.Modelo.rangos.Rango;
import edu.fiuba.algoChess.Modelo.salud.Salud;

import java.util.ArrayList;

public class Catapulta extends Pieza {

	private Comportamiento ataque;
	private int danio = 20;
	public int costo = 5;
	private Salud vida;

	public Catapulta(Ubicacion ubicacion, Bando bando){

		super(5,50,ubicacion,bando);
		ataque = new AtaqueLejanoCatapulta(20);
	}

	public Catapulta(Ubicacion ubicacion, Bando bando, Tablero tablero){
		super(5,50,ubicacion,bando);
		tablero.ubicarEnCelda(this, ubicacion);
		ataque = new AtaqueLejanoCatapulta(20);
	}

	public Catapulta(){
		super(5,50);
		ataque = new AtaqueLejanoCatapulta(20);
	}

	public Catapulta(int costo, int vida) {
		super(costo,vida);
	}

	@Override
	public Batalloneable moverBatallonDerecha(Tablero campoDeBatalla) {
		throw new NoHayBatallonFormadoException("No hay un batallon definido");
	}

	@Override
	public Batalloneable moverBatallonIzquierda(Tablero campoDeBatalla) {
		throw new NoHayBatallonFormadoException("No hay un batallon definido");
	}

	@Override
	public Batalloneable moverBatallonArriba(Tablero campoDeBatalla) {
		throw new NoHayBatallonFormadoException("No hay un batallon definido");
	}

	@Override
	public Batalloneable moverBatallonAbajo(Tablero campoDeBatalla) {
		throw new NoHayBatallonFormadoException("No hay un batallon definido");
	}

	@Override
	public Batalloneable moverBatallon(Tablero campoDeBatalla, Ubicacion ubicacion1, Ubicacion ubicacion2, Ubicacion ubicacion3) {
		throw new NoHayBatallonFormadoException("No hay un batallon definido");
	}

	@Override
	public void moverPiezaDeBatallon(Tablero campoDeBatalla, Ubicacion ubicacion) {
		throw new NoHayBatallonFormadoException("No hay un batallon definido");
	}

	@Override
	public Rango actualizaRango(Tablero tablero) {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public Rango getRango() {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public ArrayList<Pieza> unirABatallonDeSoldado(ArrayList<Pieza> stackDeUnion) {
		throw new PiezaActualNoFormaBatallonDeSoldadosException("Una catapulta no puede formar un batallon de soldados");
	}

	@Override
	public ArrayList<Pieza> aniadirPiezaAlStack(ArrayList<Pieza> stack) {
		stack.add(this);
		return stack;
	}

	@Override
	public ArrayList<Pieza> aniadirSoldadoAlStack(ArrayList<Pieza> stack, Pieza pieza) {
		return stack;
	}

	@Override
	public ArrayList<Pieza> aniadirTodoMenosSoldadoAlStack(ArrayList<Pieza> stack) {
		stack.add(this);
		return stack;
	}

	@Override
	public ArrayList<Pieza> getSoldadosContiguos() {
		throw new OperacionInvalidaException("Operacion invalida");
	}

	@Override
	public boolean soldadosInmediatosSePuedenUnir() {
		throw new PiezaActualNoFormaBatallonDeSoldadosException("Una catapulta no se puede unir a un soldado");
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaCercana distancia, Pieza pieza) {
		throw new FueraDeRangoParaEjecutarComportamientoException("Pieza fuera de rango");
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaMedia distancia, Pieza pieza) {
		this.bando.atacar(pieza, this.ataque, pieza.getBando());
	}

	@Override
	public void ejecutarComportamientoPorDistancia(DistanciaLejana distancia, Pieza pieza) {
		throw new FueraDeRangoParaEjecutarComportamientoException("Pieza fuera de rango");
	}

	@Override
	public void curar(Pieza curado) {

	}

}
