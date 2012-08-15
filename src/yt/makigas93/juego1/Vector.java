/*
 * This file is part of Alien Chase.
 * Copyright (C) 2012 Dani Rodríguez.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package yt.makigas93.juego1;

public class Vector {
    private Punto destino;
    private Punto origen;

    public Vector(Punto destino) {
        this(new Punto(0.0f, 0.0f), destino);
    }

    public Vector(Punto origen, Punto destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public Punto getDestino() {
        return this.destino;
    }

    public float getModulo() {
        double x = (double) getX();
        double y = (double) getY();
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public Punto getOrigen() {
        return this.origen;
    }

    public float getX() {
        return this.destino.getX() - this.origen.getX();
    }

    public float getY() {
        return this.destino.getY() - this.origen.getY();
    }

    public void setDestino(Punto destino) {
        this.destino = destino;
    }

    public void setOrigen(Punto origen) {
        this.origen = origen;
    }
}
