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

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Sprite extends Image {
    protected Punto posicion;

    public Sprite(String ruta) throws SlickException {
        this(ruta, new Punto(0.0f, 0.0f));
    }

    public Sprite(String ruta, float x, float y) throws SlickException {
        this(ruta, new Punto(x, y));
    }

    public Sprite(String ruta, Punto posicion) throws SlickException {
        super(ruta);
        this.posicion = posicion;
    }

    public void draw() {
        super.draw(this.posicion.getX(), this.posicion.getY());
    }

    public Punto getPosicion() {
        return this.posicion;
    }

    public void setPosicion(float x, float y) {
        this.posicion = new Punto(x, y);
    }

    public void setPosicion(Punto posicion) {
        this.posicion = posicion;
    }
}
