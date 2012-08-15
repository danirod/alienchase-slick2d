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

public class GestorColision {
    private ArrayList<IColisionable> lista;

    public GestorColision() {
        this.lista = new ArrayList();
    }

    public void registrarCuerpo(IColisionable cuerpo) {
        if (!this.lista.contains(cuerpo)) {
            this.lista.add(cuerpo);
        }
    }

    public void anularCuerpo(IColisionable cuerpo) {
        this.lista.remove(cuerpo);
    }

    public void comprobarColisiones() {
        for (int i = 0; i < this.lista.size(); i++) {
            for (int j = 0; j < this.lista.size(); j++) {
                if (i != j) {
                    buscarColision(i, j);
                }
            }
        }
    }

    private void buscarColision(int i, int j) {
        if (((IColisionable) this.lista.get(i)).getAreaColision().intersects(((IColisionable) this.lista.get(j)).getAreaColision())) {
            ((IColisionable) this.lista.get(i)).alColisionar((IColisionable) this.lista.get(j));
        }
    }
}
