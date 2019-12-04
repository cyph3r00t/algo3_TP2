package edu.fiuba.algoChess.interfaz.vista;


import java.util.HashMap;

//import fiuba.algo3.AlgoChess.entidades.Unidad;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//import main.java.com.fiuba.algo3.modelo.Observer;
//import main.java.com.fiuba.algo3.modelo.Player;
//import fiuba.algo3.AlgoChess.vista.MapView;

public class PieceView{
    private double piezaEscala = 1;
    //private Tablero tablero;
    private HashMap<String,String> listaImage;

    private int lastXPosition;

    public PieceView() {
    	listaView();
    }
    
    public void setPieceMap(MapView map,String piece,int x, int y) {
    	//guarda en el tablero
    	
        ImageView pieceImage = getImageViewMin(piece);
        map.addViewOnMap(pieceImage, x, y);
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
    
    private void listaView() {
    	this.listaImage = new HashMap<String,String>();
    	this.listaImage.put("soldado", "imagenes/soldado.jpg"); //aca se remplaza el nombre de la pieza con Soldado.geteclass() para linkear
    	this.listaImage.put("jinete", "imagenes/jinete.jpg");
    	this.listaImage.put("curandero", "imagenes/curandero.jpg");
    	this.listaImage.put("catapulta", "imagenes/catapulta.jpg");
   }
   
    public String searchImage(String piece) {
    	
    		return this.listaImage.get(piece);
    	
    }
    
    

}