package controller;


import model.ChessComponent;
import view.Chessboard;

import java.util.HashMap;
import java.util.Map;


public class ClickController {
    private final Chessboard chessboard;
    private ChessComponent first;
    public ClickController(Chessboard chessboard) {
        this.chessboard = chessboard;
    }



    public void onClick(ChessComponent chessComponent) {
        if (first == null) {
            if (handleFirst(chessComponent)) {
                chessComponent.setSelected(true);
                first = chessComponent;
                first.repaint();
            }
        } else {
            if (first == chessComponent) { // 再次点击取消选取
                chessComponent.setSelected(false);
                ChessComponent recordFirst = first;
                first = null;
                recordFirst.repaint();
            } else if (handleSecond(chessComponent)) {
                //repaint in swap chess method.
                chessboard.swapChessComponents(first, chessComponent);
                chessboard.swapColor();
                first.setSelected(false);
                // 保存这一步的状态
                GameController.step+=1;
                int step=GameController.step;
                System.out.println(step);
                //
                ChessComponent[][] chessBoardStatus=chessboard.getNewChessComponents();
                GameController.chessBoardStatus.put(String.format("%d",step),chessBoardStatus);
                System.out.println("size==="+GameController.chessBoardStatus.size());

                first = null;
            }
        }
    }

    /**
     * @param chessComponent 目标选取的棋子
     * @return 目标选取的棋子是否与棋盘记录的当前行棋方颜色相同
     */

    private boolean handleFirst(ChessComponent chessComponent) {
        return chessComponent.getChessColor() == chessboard.getCurrentColor();
    }

    /**
     * @param chessComponent first棋子目标移动到的棋子second
     * @return first棋子是否能够移动到second棋子位置
     */

    private boolean handleSecond(ChessComponent chessComponent) {
        return chessComponent.getChessColor() != chessboard.getCurrentColor() &&
                first.canMoveTo(chessboard.getChessComponents(), chessComponent.getChessboardPoint());
    }
}
