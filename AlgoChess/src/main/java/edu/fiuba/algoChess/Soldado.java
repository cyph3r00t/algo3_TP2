package edu.fiuba.algoChess;

import edu.fiuba.algoChess.Batallones.Batallon;
import edu.fiuba.algoChess.Batallones.BatallonNull;
import edu.fiuba.algoChess.Batallones.Batalloneable;
import edu.fiuba.algoChess.Rangos.Rango;
import edu.fiuba.algoChess.Rangos.RangoInmediato;
import edu.fiuba.algoChess.Rangos.RangoSoldado;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
public class Soldado extends Pieza implements Movible {

	@Getter
	@Setter
	private Ataque ataque;

	/*@Getter
	@Setter
	private RangoSoldado rango;*/

	@Getter
	@Setter
	private int danioCercano;

	public Soldado(Ubicacion ubicacion, int costo, int vida, Bando bando) {

		super(costo,vida,ubicacion,bando);
	}

	public Soldado(Ubicacion ubicacion, Bando bando, Tablero tablero){
		super(2,75,ubicacion,bando);
		this.danioCercano = 10;
		this.ataque = new AtaqueCercano(danioCercano);
		this.rango = new RangoSoldado(this, tablero);
		tablero.ubicarEnCelda(this, ubicacion);
	}

	public Soldado(Ubicacion ubicacion, Tablero tablero) {
		//this.setVida(new SaludLlena());
		super(ubicacion);
		this.rango = new RangoSoldado(this, tablero);
	}

	public Rango actualizaRango(Tablero tablero) {
		this.getRango().actualizaRangoSoldado(this,tablero);
		return this.getRango();
	}

	@Override
	public Rango getRango() {
		return this.rango;
	}

	@Override
	public ArrayList<Pieza> unirABatallonDeSoldado(ArrayList<Pieza> stackDeUnion) {
		/*if (stackDeUnion == null){
			ArrayList<Pieza> nuevoStackDeUnion = new ArrayList<>();
			nuevoStackDeUnion.add(this);
			return nuevoStackDeUnion;
		} */
		stackDeUnion.add(this);
		return stackDeUnion;
	}

	@Override
	public ArrayList<Pieza> aniadirPiezaAlStack(ArrayList<Pieza> stack) {

		if (stack == null){
			ArrayList<Pieza> nuevoStack = new ArrayList<>();
			nuevoStack.add(this);
			return  nuevoStack;
		}

		stack.add(this);
		return stack;
	}

	@Override
	public ArrayList<Pieza> aniadirSoldadoAlStack(ArrayList<Pieza> stack) {

		if (stack == null){
			ArrayList<Pieza> nuevoStack = new ArrayList<>();
			nuevoStack.add(this);
			return  nuevoStack;
		}

		stack.add(this);
		return stack;
	}

	@Override
	public ArrayList<Pieza> aniadirTodoMenosSoldadoAlStack(ArrayList<Pieza> stack) {
		if (stack == null) return new ArrayList<>();
		return stack;
	}

	public void atacar(DistanciaRelativa distancia, Pieza atacado){
		this.getBando().atacar(atacado, this.getAtaque(), atacado.getBando());
	}

	public Batalloneable verificaBatallonONull() {
		return this.getRango().darDeAltaBatallon();
	}

	public void setRango(Rango rango) {
		super.setRango(rango);
	}

	@Override
	public ArrayList<Pieza> getSoldadosContiguos(){
		return this.getRango().getSoldadosEquipo();
	}

	@Override
	public boolean soldadosInmediatosSePuedenUnir() {
		return this.getRango().getSoldadosEquipo().size() == 3;
	}

	@Override
	public Batalloneable moverBatallonDerecha(Tablero campoDeBatalla) {
		return new BatallonNull();
	}

	@Override
	public Batalloneable moverBatallonIzquierda(Tablero campoDeBatalla) {
		return new BatallonNull();
	}

	@Override
	public Batalloneable moverBatallonArriba(Tablero campoDeBatalla) {
		return new BatallonNull();
	}

	@Override
	public Batalloneable moverBatallonAbajo(Tablero campoDeBatalla) {
		return new BatallonNull();
	}

	@Override
	public Batalloneable moverBatallon(Tablero campoDeBatalla, Ubicacion ubicacion1, Ubicacion ubicacion2, Ubicacion ubicacion3) {
		return new BatallonNull();
	}

	public Soldado(Ubicacion ubicacion,Bando bando){

		super(2,75,ubicacion,bando);
		danioCercano = 10;
		this.ataque = new AtaqueCercano(danioCercano);
	}

	Batallon unirSoldados(){
		return (Batallon) this.getRango().darDeAltaBatallon();
	}

	@Override
	public void moverPiezaDeBatallon(Tablero campoDeBatalla, Ubicacion ubicacion) {

	}
}
