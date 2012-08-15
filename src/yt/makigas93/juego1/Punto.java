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

public class Punto {
    private float f0x;
    private float f1y;

    public Punto(float x, float y) {
        this.f0x = x;
        this.f1y = y;
    }

    public float getX() {
        return this.f0x;
    }

    public float getY() {
        return this.f1y;
    }

    public void setX(float x) {
        this.f0x = x;
    }

    public void setY(float y) {
        this.f1y = y;
    }
}
