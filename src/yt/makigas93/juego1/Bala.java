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

public class Bala implements IColisionable {
    private SpriteMovil bala;
    private Rectangle colision;
    private Juego juego;

    public Bala(Juego juego, float y) throws SlickException {
        this.bala = new SpriteMovil("juego1/bala.png", new Punto(120.0f, y), new Punto(300.0f, 0.0f));
        this.colision = new Rectangle(this.bala.getPosicion().getX(), this.bala.getPosicion().getY(), (float) this.bala.getWidth(), (float) this.bala.getHeight());
        this.juego = juego;
    }

    public void draw() {
        this.bala.draw();
    }

    public void update(int delta) {
        this.bala.update(delta);
        sincronizarArea();
    }

    public Shape getAreaColision() {
        return this.colision;
    }

    public void alColisionar(IColisionable colision) {
        if (colision.getClass().getSimpleName().equals("Alien")) {
            this.bala.getPosicion().setX(60000.0f);
            this.juego.getNave().setPuntuacion(this.juego.getNave().getPuntuacion() + 25);
            if (this.juego.getNave().getPuntuacion() % 500 == 0 && this.juego.getNave().getPuntuacion() > 0) {
                this.juego.getEscudo().setVida(this.juego.getEscudo().getVida() + 1);
            }
            if (this.juego.getNave().getPuntuacion() % 1500 == 0 && this.juego.getNave().getPuntuacion() > 0) {
                this.juego.getNave().setVida(this.juego.getNave().getVida() + 1);
            }
        }
    }

    public void sincronizarArea() {
        this.colision.setX(this.bala.getPosicion().getX());
        this.colision.setY(this.bala.getPosicion().getY());
    }
}
