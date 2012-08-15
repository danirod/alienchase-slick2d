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

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Escudo implements IColisionable {
    public static final int INICIAL = 5;
    public static final int MAX_VIDA = 10;
    private Rectangle colision;
    private int vida;

    public Escudo() {
        this.vida = INICIAL;
        this.colision = new Rectangle(10.0f, 0.0f, (float) (this.vida * 2), 360.0f);
    }

    public int getVida() {
        return this.vida;
    }

    public void setVida(int vida) {
        if (vida < 0) {
            vida = 0;
        }
        if (vida > MAX_VIDA) {
            vida = MAX_VIDA;
        }
        this.vida = vida;
    }

    public void draw(Graphics g) {
        g.fillRect(10.0f, 0.0f, (float) (this.vida * 2), 360.0f);
    }

    public void update() {
        sincronizarArea();
    }

    public Shape getAreaColision() {
        return this.colision;
    }

    public void alColisionar(IColisionable colision) {
        if (colision.getClass().getSimpleName().equals("Alien")) {
            this.vida--;
            if (this.vida < 0) {
                this.vida = 0;
            }
        }
    }

    public void sincronizarArea() {
        if (this.vida == 0) {
            this.colision = new Rectangle(-500.0f, -300.0f, 1.0f, 1.0f);
        } else {
            this.colision = new Rectangle(10.0f, 0.0f, (float) (this.vida * 2), 360.0f);
        }
    }
}
