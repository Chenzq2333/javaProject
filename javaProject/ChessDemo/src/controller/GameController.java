package controller;

import model.ChessComponent;
import view.Chessboard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameController {
    private Chessboard chessboard;

    public static Integer step=0;
    public static Map<String,ChessComponent[][]> chessBoardStatus=new HashMap<>();


    public GameController(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public List<String> loadGameFromFile(String path) {
//        try {
//            List<String> chessData = Files.readAllLines(Path.of(path));
//            chessboard.loadGame(chessData);
//            return chessData;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return null;
    }

    public void restart(){
        chessboard.restart();
    }

    public void repentance() {
        chessboard.repentance();
    }
}
