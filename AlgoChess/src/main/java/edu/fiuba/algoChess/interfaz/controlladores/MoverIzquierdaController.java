package edu.fiuba.algoChess.interfaz.controlladores;

import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.interfaz.vista.VistaTablero;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MoverIzquierdaController {

	private Pieza pieza;
	private Tablero tablero;
	private VistaTablero map;
	private ImageView imagenPieza;

	public MoverIzquierdaController(Pieza pieza, Tablero tablero, VistaTablero map, ImageView imagenPieza) {
		this.pieza = pieza;
		this.tablero = tablero;
		this.map = map;
		this.imagenPieza = imagenPieza;
	}

	public void moverIzquierda(){

		pieza.moverseALaIzquierda(tablero);

		DropShadow rollOverColor = new DropShadow();
		this.imagenPieza.addEventHandler(MouseEvent.MOUSE_ENTERED,
				(event) -> this.imagenPieza.setEffect(rollOverColor));
		this.imagenPieza.addEventHandler(MouseEvent.MOUSE_EXITED,
				(event) -> this.imagenPieza.setEffect(null));

		this.map.addViewOnMap(this.imagenPieza, this.pieza.getUbicacion().getX(), this.pieza.getUbicacion().getY());

	}
}
