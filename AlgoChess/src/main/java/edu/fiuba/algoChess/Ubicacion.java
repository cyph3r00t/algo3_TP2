package edu.fiuba.algoChess;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class Ubicacion {
	@Getter
	@Setter
	private final int x;

	@Getter
	@Setter
	private final int y;

	public Ubicacion(int x, int y) {
		this.x = x;
		this.y = y;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ubicacion ubicacion = (Ubicacion) o;
        return x == ubicacion.x && y == ubicacion.y;
    }

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	public Ubicacion getUbicacionDerecha() {
		return new Ubicacion(this.x+1, this.y);
	}
	public Ubicacion getUbicacionIzquierda() {
		return new Ubicacion(this.x-1, this.y);
	}
	public Ubicacion getUbicacionArriba() { return new Ubicacion(this.x, this.y+1);}
	public Ubicacion getUbicacionAbajo() { return new Ubicacion(this.x, this.y-1);}

	public int getCoordenadaX(){
		return this.x;
	};

	public int getCoordenadaY(){
		return this.y;
	};

}
