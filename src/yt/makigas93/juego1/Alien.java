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

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Alien implements IColisionable {
    public static final int VELOCIDAD = 250;
    private SpriteMovil alien;
    private Rectangle colision;

    public Alien(Juego juego, float y) throws SlickException {
        this.alien = new SpriteMovil("juego1/alien.gif", new Punto(600.0f, y), new Punto(-250.0f, 0.0f));
        this.colision = new Rectangle(this.alien.getPosicion().getX(), this.alien.getPosicion().getY(), (float) this.alien.getWidth(), (float) this.alien.getHeight());
    }

    public void draw() {
        this.alien.draw();
    }

    public void update(int delta) {
        this.alien.update(delta);
        sincronizarArea();
    }

    public Shape getAreaColision() {
        return this.colision;
    }

    public void alColisionar(IColisionable colision) {
        String clase = colision.getClass().getSimpleName();
        if (clase.equals("Bala") || clase.equals("Nave") || clase.equals("Escudo")) {
            this.alien.getPosicion().setX(-1000.0f);
        }
    }

    public void sincronizarArea() {
        this.colision.setX(this.alien.getPosicion().getX());
        this.colision.setY(this.alien.getPosicion().getY());
    }
}
