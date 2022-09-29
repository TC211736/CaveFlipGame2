package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;


public class LoginScreen extends ScreenAdapter {
    MyGdxGame game;
    protected Stage stage;
    private TextureAtlas atlas;
    Camera camera;
    SpriteBatch batch;
    Table mainframe;
    Skin skin;

    public LoginScreen(MyGdxGame game) {
        this.game = game;
    }

    public LoginScreen() {
        atlas = new TextureAtlas("uiskin.atlas");
        skin = new Skin();
        skin.addRegions(atlas);

        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        stage = new Stage(new FitViewport(500, 500, camera),batch);

        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();

    }

    @Override
    public void show() {
        game.setScreen(new TitleScreen(game));
        skin = new Skin();
        Gdx.input.setInputProcessor(stage);

        mainframe = new Table();
        mainframe.setFillParent(true);

        mainframe.top();

        TextButton playbutton = new TextButton("Play", skin);
        TextButton optionsButton = new TextButton("Options", skin);
        TextButton exitButton = new TextButton("Exit", skin);
    }
}