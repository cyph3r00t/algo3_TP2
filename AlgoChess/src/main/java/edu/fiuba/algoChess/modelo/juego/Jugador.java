package edu.fiuba.algoChess.modelo.juego;

import lombok.Getter;
import lombok.Setter;


import edu.fiuba.algoChess.modelo.bandos.Bando;
import edu.fiuba.algoChess.modelo.entidades.Pieza;


import java.util.ArrayList;

public class Jugador {

	@Getter
	private String nombre;
	@Getter
	private int puntaje;
	@Getter
	private int creditos;
	@Getter
	private Bando bando;
	private ArrayList<Pieza> piezas;
	private Turno turno;


	public Jugador() {
		this.nombre = "";
		this.puntaje = 0;
		this.creditos = 20;
		this.piezas = new ArrayList<>();
	}

	public Jugador(String unNombre, Bando bando) {
		this.puntaje = 0;
		this.nombre = unNombre;
		this.bando = bando;
		this.creditos = 20;
		this.piezas = new ArrayList<>();
	}

	public void sumarPuntaje(int unPuntaje){this.puntaje += unPuntaje;}

	public String nombre() {
		return this.nombre;
	}

	public int puntaje() {
		return this.puntaje;
	}

	public void adquirirPieza(Pieza pieza){
		if(pieza.getCosto() <= this.creditos){
			this.creditos = this.creditos - pieza.getCosto();
			this.piezas.add(pieza);
		}else{
			//excepcion
		}
	}

}
