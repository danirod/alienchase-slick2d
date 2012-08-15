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

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Nave implements IColisionable {
    public static final int VELOCIDAD = 300;
    public static final int VIDA_INICIAL = 3;
    private Rectangle colision;
    private SpriteMovil nave;
    private long puntuacion;
    private int vida;

    public Nave() throws SlickException {
        this.nave = new SpriteMovil("juego1/cohete.png", new Punto(40.0f, 120.0f), new Punto(0.0f, 0.0f));
        this.colision = new Rectangle(this.nave.getPosicion().getX(), this.nave.getPosicion().getY(), (float) this.nave.getWidth(), (float) this.nave.getHeight());
        this.vida = VIDA_INICIAL;
        this.puntuacion = 0;
    }

    public void draw() {
        this.nave.draw();
    }

    public void update(int delta, Input entrada) throws SlickException {
        this.nave.update(delta);
        comprobarPosicionNave();
        actualizarTeclado(entrada);
        sincronizarArea();
    }

    private void comprobarPosicionNave() {
        if (this.nave.getPosicion().getY() < 0.0f) {
            this.nave.getPosicion().setY(0.0f);
        }
        if (this.nave.getPosicion().getY() + ((float) this.nave.getHeight()) > 360.0f) {
            this.nave.getPosicion().setY((float) (360 - this.nave.getHeight()));
        }
    }

    private void actualizarTeclado(Input entrada) throws SlickException {
        if (entrada.isKeyDown(200)) {
            this.nave.setVelocidad(new Punto(0.0f, -300.0f));
        } else if (entrada.isKeyDown(208)) {
            this.nave.setVelocidad(new Punto(0.0f, 300.0f));
        } else {
            this.nave.setVelocidad(new Punto(0.0f, 0.0f));
        }
    }

    public Shape getAreaColision() {
        return this.colision;
    }

    public void alColisionar(IColisionable colision) {
        if (colision.getClass().getSimpleName().equals("Alien")) {
            this.vida--;
            this.nave.getPosicion().setY(120.0f);
        }
    }

    public void sincronizarArea() {
        this.colision.setX(this.nave.getPosicion().getX());
        this.colision.setY(this.nave.getPosicion().getY());
    }

    public int getVida() {
        return this.vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public long getPuntuacion() {
        return this.puntuacion;
    }

    public void setPuntuacion(long puntuacion) {
        this.puntuacion = puntuacion;
    }
}
