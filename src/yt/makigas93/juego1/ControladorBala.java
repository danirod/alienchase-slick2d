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

import java.util.ArrayList;
import org.newdawn.slick.SlickException;

public class ControladorBala implements IControlador {
    private ArrayList<Bala> balas;
    private Juego juego;

    public ControladorBala(Juego juego) {
        this.balas = new ArrayList();
        this.juego = juego;
    }

    public void add(float y, GestorColision gestor) throws SlickException {
        Bala bala = new Bala(this.juego, y);
        this.balas.add(bala);
        gestor.registrarCuerpo(bala);
    }

    public void draw() {
        for (int i = 0; i < this.balas.size(); i++) {
            ((Bala) this.balas.get(i)).draw();
        }
    }

    public void update(int delta, GestorColision gestor) {
        for (int i = 0; i < this.balas.size(); i++) {
            ((Bala) this.balas.get(i)).update(delta);
        }
        delete(gestor);
    }

    public void delete(GestorColision gestor) {
        for (int i = 0; i < this.balas.size(); i++) {
            if (((Bala) this.balas.get(i)).getAreaColision().getX() > 640.0f) {
                gestor.anularCuerpo((IColisionable) this.balas.get(i));
                this.balas.remove(i);
            }
        }
    }
}
