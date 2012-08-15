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

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Principal extends StateBasedGame {
    public Principal() {
        super("ALIEN");
    }

    public void initStatesList(GameContainer container) throws SlickException {
        addState(new MenuPrincipal());
        addState(new Juego());
    }

    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(new Principal());
            app.setDisplayMode(640, 360, false);
            app.setShowFPS(false);
            app.start();
        } catch (SlickException slick) {
            slick.printStackTrace();
        }
    }
}
