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

import java.util.Random;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Juego extends BasicGameState {
    private ControladorAlien aliens;
    private ControladorBala balas;
    private Input entrada;
    private Escudo escudo;
    private Image fondo;
    private GestorColision gestor;
    private Nave nave;
    private Random numeros;
    private int relojAlien;
    private Tierra tierra;

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        this.nave = new Nave();
        this.balas = new ControladorBala(this);
        this.aliens = new ControladorAlien(this);
        this.escudo = new Escudo();
        this.tierra = new Tierra();
        this.entrada = container.getInput();
        this.numeros = new Random();
        this.relojAlien = 0;
        this.gestor = new GestorColision();
        this.fondo = new Image("juego1/fondo.png");
        this.gestor.registrarCuerpo(this.nave);
        this.gestor.registrarCuerpo(this.escudo);
        this.gestor.registrarCuerpo(this.tierra);
        this.aliens.add(-1000.0f, this.gestor);
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        this.fondo.draw(0.0f, 0.0f, (float) container.getWidth(), (float) container.getHeight());
        this.nave.draw();
        this.aliens.draw();
        this.balas.draw();
        this.escudo.draw(g);
        g.drawString("Vidas: " + this.nave.getVida(), 30.0f, 10.0f);
        g.drawString("Puntuaci\u00f3n: " + this.nave.getPuntuacion(), 30.0f, 30.0f);
        if (this.tierra.haChocado() || this.nave.getVida() == 0) {
            g.drawString("GAME OVER", 300.0f, 150.0f);
            g.drawString("Pulsa ESC para volver al men\u00fa", 300.0f, 180.0f);
        }
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        if (!this.tierra.haChocado() && this.nave.getVida() > 0) {
            this.gestor.comprobarColisiones();
            this.nave.update(delta, this.entrada);
            this.aliens.update(delta, this.gestor);
            this.balas.update(delta, this.gestor);
            this.escudo.update();
            this.relojAlien += delta;
            if (this.relojAlien > this.numeros.nextInt(2000) + 2000) {
                lanzarAlien();
            }
            if (this.entrada.isKeyPressed(57)) {
                this.balas.add((this.nave.getAreaColision().getY() + (this.nave.getAreaColision().getHeight() / 2.0f)) - 10.0f, this.gestor);
            }
        } else if (this.entrada.isKeyPressed(1)) {
            game.enterState(0);
        }
    }

    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        container.getInput().clearKeyPressedRecord();
        init(container, game);
    }

    public void lanzarAlien() throws SlickException {
        this.aliens.add((float) this.numeros.nextInt(320), this.gestor);
        this.relojAlien = 0;
    }

    public int getID() {
        return 1;
    }

    public Nave getNave() {
        return this.nave;
    }

    public Escudo getEscudo() {
        return this.escudo;
    }
}
