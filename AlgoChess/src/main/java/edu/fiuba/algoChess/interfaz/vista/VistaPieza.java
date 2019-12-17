package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.modelo.bandos.BandoJugador1;
import edu.fiuba.algoChess.modelo.entidades.Pieza;
import edu.fiuba.algoChess.modelo.entidades.PiezaNull;
import edu.fiuba.algoChess.modelo.entorno.Tablero;
import edu.fiuba.algoChess.modelo.entorno.Ubicacion;
import edu.fiuba.algoChess.modelo.juego.Juego;
import edu.fiuba.algoChess.interfaz.controlladores.CrearPiezaHandler;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.util.Map;


public class VistaPieza {
	static private Map<String,String> diccionarioImagenes = Map.of(
		"Soldado", "imagenes/soldado.jpeg",
		"Jinete", "imagenes/jinete.jpeg",
		"Curandero", "imagenes/curandero.jpeg",
    	"Catapulta", "imagenes/catapulta.jpeg");


	private double piezaEscala = 1;
    private Tablero tablero;
    private Juego juego;
    private PantallaPrincipal pantallaPrincipal;

    Pieza pieza;
	public VistaPieza(Pieza pieza, Juego juego, PantallaPrincipal pantallaPrincipal) {
		this.pieza = pieza;
		this.juego = juego;
		this.pantallaPrincipal = pantallaPrincipal;
	}

	public Node crearNodo() {
		ImageView pieceImage = getImageViewMin(pieza.getClass().getSimpleName());
		DropShadow rollOverColor = new DropShadow();

		pieceImage.addEventHandler(MouseEvent.MOUSE_ENTERED,
				(event) -> pieceImage.setEffect(rollOverColor));
		pieceImage.addEventHandler(MouseEvent.MOUSE_EXITED,
				(event) -> pieceImage.setEffect(null));
		pieceImage.addEventHandler(MouseEvent.MOUSE_PRESSED,
				(event) -> comportamientoAlTocarPieza());

		HBox hbox = new HBox();
		hbox.setStyle("-fx-border-width: 2; -fx-border-color: " + (pieza.getBando().getNombre() == "jugador1" ? "#FF0000" : "#0000FF") + "; -fx-margin: -2");
		hbox.getChildren().add(pieceImage);
		return hbox;
	}

 	public void ejecutarAccionSegundaEtapa(){
		MenuPieza menuPieza = new MenuPieza(this.juego, this.pieza, this.pantallaPrincipal.getSegundaEtapa());
		menuPieza.menuPopUp();
	}

    public ImageView getImageViewMin(String piece) {
    	ImageView pieceImage = new ImageView(new Image(searchImage(piece)));
        pieceImage.setScaleX(piezaEscala);
        pieceImage.setScaleY(piezaEscala);
        pieceImage.setFitHeight(28);
        pieceImage.setFitWidth(28);

        return pieceImage;
    }

    public ImageView getImageViewMax(String piece) {
    	ImageView pieceImage = new ImageView(new Image(searchImage(piece),90,100,false,false));
        return pieceImage;
    }

    public String searchImage(String piece) {
    		return diccionarioImagenes.get(piece);
    }

	public void mostrarDatosPiezaActual() {
		Ubicacion u = pieza.getUbicacion();
		int x = u.getCoordenadaX();
		int y = u.getCoordenadaY();

    	if(pieza.getBando().equals(new BandoJugador1())) {
			DialogoAlerta.Alerta("Datos Pieza","Pieza: "+
					pieza.getClass().getSimpleName() +   "\nUbicacion: x=" + x + " y=" + y +
					"\nBando: "+ juego.getJugador1().getNombre(), 2);
    	}
		else {
			DialogoAlerta.Alerta("Datos Pieza","Pieza: "+
					pieza.getClass().getSimpleName() +   "\nUbicacion: x=" + x + " y=" + y +
					"\nBando: "+ juego.getJugador2().getNombre(), 2);
		}
    }

	public void comportamientoAlTocarPieza(){
    	if (this.juego.getSegundaEtapa()){
			if(juego.getJugadorActivo().getBando() == pieza.getBando())
    			ejecutarAccionSegundaEtapa();
		}
    	else {
			mostrarDatosPiezaActual();
		}
	}
}

