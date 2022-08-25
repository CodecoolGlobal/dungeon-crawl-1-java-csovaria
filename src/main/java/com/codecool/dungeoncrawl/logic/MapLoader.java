package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.FireMage;
import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.actors.Skeleton;
import com.codecool.dungeoncrawl.logic.items.*;

import java.io.InputStream;
import java.util.Scanner;

import static com.codecool.dungeoncrawl.Main.monsters;

public class MapLoader {
    public static GameMap loadMap(String currentMap) {
        InputStream is = MapLoader.class.getResourceAsStream(currentMap);
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            monsters.add(new Skeleton(cell));
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell));
                            break;
                        case 'h':
                            cell.setType(CellType.FLOOR);
                            new HealthPotion(cell);
                            break;
                        case 'k':
                            cell.setType(CellType.FLOOR);
                            new Sword(cell);
                            break;
                        case 'r':
                            cell.setType(CellType.FLOOR);
                            new RandomBox(cell);
                            break;
                        case '1':
                            cell.setType(CellType.FLOOR);
                            new RedKey(cell);
                            break;
                        case '2':
                            cell.setType(CellType.WALL);
                            new RedGate(cell);
                            break;
                        case 'f':
                            cell.setType(CellType.FLOOR);
                            new Fire(cell);
                            break;
                        case 'm':
                            cell.setType(CellType.FLOOR);
                            monsters.add(new FireMage(cell));
                            break;
                        case '3':
                            cell.setType(CellType.FLOOR);
                            new YellowKey(cell);
                            break;
                        case '4':
                            cell.setType(CellType.WALL);
                            new YellowGate(cell);
                            break;
                        case 'g':
                            cell.setType(CellType.FLOOR);
                            new LevelGate(cell);
                            break;
                        case 'b':
                            cell.setType(CellType.FLOOR);
                            new BlueItem(cell);
                            break;
                        case 'á':
                            cell.setType(CellType.FLOOR);
                            new GreenItem(cell);
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }

}
