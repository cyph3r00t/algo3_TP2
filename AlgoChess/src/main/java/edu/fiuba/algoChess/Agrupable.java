package edu.fiuba.algoChess;

import java.util.Collection;

public abstract class Agrupable extends Rango {

	public abstract Agrupable agrupar(Pieza pieza1, Pieza pieza2, Pieza pieza3);
	public abstract Collection<Pieza> desagrupar(Agrupable grupo);

}
