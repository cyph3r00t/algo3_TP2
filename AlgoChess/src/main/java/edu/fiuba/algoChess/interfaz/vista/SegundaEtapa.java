package edu.fiuba.algoChess.interfaz.vista;

import edu.fiuba.algoChess.Modelo.bandos.BandoJugador1;
import edu.fiuba.algoChess.Modelo.bandos.BandoJugador2;
import edu.fiuba.algoChess.Modelo.juego.Juego;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;

public class SegundaEtapa extends HBox {

	private final HashMap<String, Class> listaPiezas;
	private Stage stage;
	private PieceView pieceView;
	private MapView mapView;
	private PlayerView player1;
	private PlayerView player2;
	private PlayerView turn;
	private HashMap<String,String> listaImage;
	private Juego juego;
	private FinDeJuego finDeJuego;
	private HBox head ;

	public SegundaEtapa(Juego juego, String jugador1, String jugador2, Stage stage, PieceView pieceView,
						MapView mapView, PlayerView turn) {

		this.juego = juego;
		this.stage = stage;
		this.pieceView = pieceView;
		this.mapView = mapView;
		this.listaPiezas = new HashMap<>();
		this.turn = turn;
		this.player1 =  new PlayerView(juego.getJugador1());
	 	this.player2 =  new PlayerView(juego.getJugador2());

		this.finDeJuego = new FinDeJuego(juego,jugador1,jugador2, stage, pieceView, mapView);
	}

	public void iniciarFase(){
		this.stage.setTitle("AlgoChess");
		VBox vbox = new VBox();
		HBox hbox = new HBox();
		vbox.getChildren().add(head());

		player1.viewPlayer(hbox);
		hbox.getChildren().add(mapView);
		player2.viewPlayer(hbox);

		vbox.getChildren().add(hbox);

		Scene theScene = new Scene(vbox);
		theScene.getStylesheets().add("css/estilo.css");
		this.stage.setScene(theScene);
		this.stage.show();
	}

	public HBox head() {
		HBox head = new HBox();
		head.setId("head");
		terminarJuego(head,juego);
		turnOf(head,turn);
		this.head = head;
		return head;
	}

	public void cambioTurno() {

		head.getChildren().remove(6);
		if(this.turn == player1) {
			turnOf(head,player2);
			this.juego.pasarTurno();
		}
		else {
			turnOf(head,player1);
			this.juego.pasarTurno();
		}
	}

	public void turnOf(HBox head,PlayerView player){
		this.turn = player;
		Button button = new Button("TURNO DE: "+this.turn.getName());
		button.setStyle("-fx-background-color:#F7CF32");
		head.getChildren().add(button);
	}

	public void terminarJuego(HBox head,Juego juego) {

		Button button = new Button("Terminar Partida");
		button.setStyle("-fx-background-color:#F7CF32");
		button.addEventHandler(MouseEvent.MOUSE_PRESSED,
				(event) -> finalizar());
		head.getChildren().add(button);
	}

	public void finalizar(){
		this.juego.terminarJuego();
		this.finDeJuego.iniciarFase();
	}

}
