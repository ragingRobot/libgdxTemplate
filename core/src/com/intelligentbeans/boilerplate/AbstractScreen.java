package com.intelligentbeans.boilerplate;

import com.badlogic.gdx.Screen;

/**
 * @author Mats Svensson
 */
public abstract class AbstractScreen implements Screen {

    protected IntelligentGame game;

    public AbstractScreen(IntelligentGame game) {
        this.game = game;
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}
