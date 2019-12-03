package edu.fiuba.algoChess;

import java.util.ArrayList;

import edu.fiuba.algoChess.Batallones.Batallon;
import edu.fiuba.algoChess.Batallones.BatallonNull;
import edu.fiuba.algoChess.Batallones.BatallonUtil;
import edu.fiuba.algoChess.Rangos.Rango;
import edu.fiuba.algoChess.Rangos.RangoInmediato;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class RangoSoldado extends RangoInmediato implements Rango {

	@Getter
	@Setter
	ArrayList<Pieza> soldadosEquipo;

	@Getter
	@Setter
	ArrayList<Pieza> obstaculos;

	public RangoSoldado(Pieza soldado, Tablero tableroActual){
		super(soldado,tableroActual);
		this.actualizaSoldadosCercanos(soldado);
		this.actualizaObstaculosInmediatos(soldado);
	}

	public void actualizaRango(Soldado soldado, Tablero tablero){
		super.actualizaRangoInmediato(soldado,tablero);
		this.actualizaSoldadosCercanos(soldado);
		this.actualizaObstaculosInmediatos(soldado);
	}

	public void actualizaSoldadosCercanos(Pieza piezaCentral){

		ArrayList<Pieza> piezas = piezaCentral.getRango().getPiezasEnRango();
		ArrayList<Pieza> soldados = new ArrayList<>();
		piezas.forEach(pieza-> pieza.aniadirSoldadoAlStack(soldados));
		this.setSoldadosEquipo(soldados);

	}

	public void actualizaObstaculosInmediatos(Pieza piezaCentral){

		ArrayList<Pieza> piezas = piezaCentral.getRango().getPiezasEnRango();
		ArrayList<Pieza> obstaculos = new ArrayList<>();
		piezas.forEach(pieza-> pieza.aniadirTodoMenosSoldadoAlStack(obstaculos));
		this.setSoldadosEquipo(obstaculos);

	}

	public Batallon darDeAltaBatallon(){
		ArrayList<Pieza> soldadosBatallon = new ArrayList<>();
		this.getPiezasEnRango().forEach(pieza -> {if(pieza.soldadosInmediatosSePuedenUnir()){
			soldadosBatallon.add(this.getPiezasEnRango().get(1));
			soldadosBatallon.add(this.getPiezasEnRango().get(2));
			soldadosBatallon.add(this.getPiezasEnRango().get(3));
		}});

		if (soldadosBatallon.size() >= 1){
			return new BatallonUtil(soldadosBatallon.get(1), soldadosBatallon.get(2), soldadosBatallon.get(3));
		}
		return new BatallonNull();
	}

	@Override
	public ArrayList<Pieza> getPiezasEnRango() {
		return getSoldadosEquipo();
	}

}
