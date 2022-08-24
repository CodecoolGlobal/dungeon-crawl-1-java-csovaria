package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.MapLoader;
import com.codecool.dungeoncrawl.logic.actors.Actor;
import com.codecool.dungeoncrawl.logic.actors.Player;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;


public class Main extends Application {
//    This is the width and height of the visible area in terms of tiles
    public static int VISIBLE_TILES_SIZE = 10;
    GameMap map = MapLoader.loadMap();
    Canvas canvas = new Canvas(
            VISIBLE_TILES_SIZE * Tiles.TILE_WIDTH,
            VISIBLE_TILES_SIZE * Tiles.TILE_WIDTH);
    GraphicsContext context = canvas.getGraphicsContext2D();
    Label healthLabel = new Label();
    Label pickUpItem = new Label();
    Label inventory = new Label();

    int delay = 400;
    Timeline timeLine = new Timeline();

    public static List<Actor> monsters = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane ui = new GridPane();
        ui.setPrefWidth(200);
        ui.setPadding(new Insets(10));

        ui.add(new Label("Health: "), 0, 0);
        ui.add(healthLabel, 1, 0);

        ui.add(new Label(""), 0 , 0);
        ui.add(pickUpItem, 0, 1);

        ui.add(new Label("Inventory"), 0 , 9);
        ui.add(inventory, 0, 10);

        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(canvas);
        borderPane.setRight(ui);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);

        primaryStage.setTitle("Dungeon Crawl");
        primaryStage.show();

        KeyFrame keyFrame = new KeyFrame(Duration.millis(delay),
                event -> Platform.runLater(this::moveMonsters
                )
        );
        timeLine.getKeyFrames().add(keyFrame);
        timeLine.setCycleCount(100);
        timeLine.play();
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP:
                map.getPlayer().move(0, -1);
                refresh();
                break;
            case DOWN:
                map.getPlayer().move(0, 1);
                refresh();
                break;
            case LEFT:
                map.getPlayer().move(-1, 0);
                refresh();
                break;
            case RIGHT:
                map.getPlayer().move(1,0);
                refresh();
                break;
            case ENTER:
                pickUpWithEnter();
                break;
        }
    }

    private void moveMonsters() {
        for (Actor monster: monsters) {
            monster.monsterMove();
            refresh();
        }

    }

    private void refresh() {
//        Get the location of the player
        Player player = map.getPlayer();
        int playerX = player.getX();
        int playerY = player.getY();
//        Color the whole canvas
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

//        Fill the visible part of the canvas
        for (int x = 0; x < VISIBLE_TILES_SIZE; x++) {
            for (int y = 0; y < VISIBLE_TILES_SIZE; y++) {
//                Create new variable, we need this, because the player will not be centered when on the edge
                int middleX = playerX;
                int middleY = playerY;
//                Check if the player is close to the edge, in this case the center will not be the player's coordinates
                if (playerX - VISIBLE_TILES_SIZE / 2 < 0) {
                    middleX = VISIBLE_TILES_SIZE / 2;
                } else if (playerX + VISIBLE_TILES_SIZE / 2 > map.getWidth()) {
                    middleX = map.getWidth() - VISIBLE_TILES_SIZE / 2;
                }
                if (playerY - VISIBLE_TILES_SIZE / 2 < 0) {
                    middleY = VISIBLE_TILES_SIZE / 2;
                } else if (playerY + VISIBLE_TILES_SIZE / 2 > map.getHeight()) {
                    middleY = map.getHeight() - VISIBLE_TILES_SIZE / 2;
                }

//                Read cell value from map at the generated coordinates and draw Tiles on the canvas
                Cell cell = map.getCell(middleX - (VISIBLE_TILES_SIZE/2) + x, middleY - (VISIBLE_TILES_SIZE/2) + y);
                if (cell.getActor() != null) {
                    Tiles.drawTile(context, cell.getActor(), x, y);
                } else if (cell.getItem() != null) {
                    Tiles.drawTile(context, cell.getItem(), x, y);
                    if (map.getPlayer().getCell().getItem() != null) {
                        pickUpAnActiveItem();
                    } else {
                        pickUpItem.setText("");
                    }
                } else {
                    Tiles.drawTile(context, cell, x, y);
                }
            }
        }
        healthLabel.setText("" + map.getPlayer().getHealth());
        inventory.setText("" + map.getPlayer().getInventory());
    }

    private void pickUpAnActiveItem() {
                pickUpItem.setText("Click or hit Enter\n to Pick up item: " + map.getPlayer().getCell().getItem());
                pickUpItem.setOnMouseClicked(this::pickUp);
    }

    private void pickUp(MouseEvent mouseEvent) {
        map.getPlayer().getCell().getItem().interact(map.getPlayer());
        refresh();
    }

    private void pickUpWithEnter() {
        if (map.getPlayer().getCell().getItem() != null){
            map.getPlayer().getCell().getItem().interact(map.getPlayer());
            refresh();
        }
    }
}
