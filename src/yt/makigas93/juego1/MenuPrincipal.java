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

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MenuPrincipal extends BasicGameState {
    private static final Punto JUGAR;
    private static final Punto SALIR;
    private Sprite botonJugar;
    private Sprite botonSalir;
    private Image fondo;
    private int indicador;
    private Sprite puntero;

    static {
        JUGAR = new Punto(275.0f, 125.0f);
        SALIR = new Punto(275.0f, 200.0f);
    }

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        this.fondo = new Image("juego1/menu.png");
        this.botonJugar = new Sprite("juego1/jugar.png", new Punto(400.0f, 150.0f));
        this.botonSalir = new Sprite("juego1/salir.png", new Punto(400.0f, 225.0f));
        this.puntero = new Sprite("juego1/cohete.png", JUGAR);
        this.indicador = 0;
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        this.fondo.draw();
        this.botonJugar.draw();
        this.botonSalir.draw();
        this.puntero.draw();
        g.drawString("Copyright (C) Dani Rodr\u00edguez - www.danirod.tk", 10.0f, 330.0f);
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Input entrada = container.getInput();
        if (entrada.isKeyPressed(200)) {
            this.indicador = 0;
            this.puntero.setPosicion(JUGAR);
        } else if (entrada.isKeyPressed(208)) {
            this.indicador = 1;
            this.puntero.setPosicion(SALIR);
        } else if (!entrada.isKeyPressed(28)) {
        } else {
            if (this.indicador == 0) {
                game.enterState(1);
            } else {
                System.exit(0);
            }
        }
    }

    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        container.getInput().clearKeyPressedRecord();
        init(container, game);
    }

    public int getID() {
        return 0;
    }
}
