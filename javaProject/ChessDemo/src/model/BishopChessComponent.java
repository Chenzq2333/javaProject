package model;

import view.ChessboardPoint;
import controller.ClickController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

//兵
public class BishopChessComponent extends ChessComponent{

    //显示象的图片
    private static Image BISHOP_WHITE;
    private static Image BISHOP_BLACK;
    private Image bishopImage;

    /**
     * 读取加载象棋子的图片
     *
     * @throws IOException
     */
    public void loadResource() throws IOException {
        if (BISHOP_WHITE == null) {
            BISHOP_WHITE = ImageIO.read(new File("ChessDemo/images/bishop-white.png"));
        }

        if (BISHOP_BLACK == null) {
            BISHOP_BLACK = ImageIO.read(new File("ChessDemo/images/bishop-black.png"));
        }
    }


    /**
     * 在构造棋子对象的时候，调用此方法以根据颜色确定rookImage的图片是哪一种
     *
     * @param color 棋子颜色
     */

    private void initiateRookImage(ChessColor color) {
        try {
            loadResource();
            if (color == ChessColor.WHITE) {
                bishopImage = BISHOP_WHITE;
            } else if (color == ChessColor.BLACK) {
                bishopImage = BISHOP_BLACK;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BishopChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor color, ClickController listener, int size) {
        super(chessboardPoint, location, color, listener, size);
        initiateRookImage(color);
    }

    /**
     * 象棋子的移动规则
     *
     * @param chessComponents 棋盘
     * @param destination     目标位置，如(0, 0), (0, 7)等等
     * @return 车棋子移动的合法性
     */

//    @Override
//    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
//        ChessboardPoint source = getChessboardPoint();
//        if (source.getX() == destination.getX()) {
//            int row = source.getX();
//            for (int col = Math.min(source.getY(), destination.getY()) + 1;
//                 col < Math.max(source.getY(), destination.getY()); col++) {
//                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
//                    return false;
//                }
//            }
//        } else if (source.getY() == destination.getY()) {
//            int col = source.getY();
//            for (int row = Math.min(source.getX(), destination.getX()) + 1;
//                 row < Math.max(source.getX(), destination.getX()); row++) {
//                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
//                    return false;
//                }
//            }
//        } else { // Not on the same row or the same column.
//            return false;
//        }
//        return true;
//    }

    /**
     * 注意这个方法，每当窗体受到了形状的变化，或者是通知要进行绘图的时候，就会调用这个方法进行画图。
     *
     * @param g 可以类比于画笔
     */
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
////        g.drawImage(rookImage, 0, 0, getWidth() - 13, getHeight() - 20, this);
//        g.drawImage(rookImage, 0, 0, getWidth() , getHeight(), this);
//        g.setColor(Color.BLACK);
//        if (isSelected()) { // Highlights the model if selected.
//            g.setColor(Color.RED);
//            g.drawOval(0, 0, getWidth() , getHeight());
//        }
//    }
}

//修改成功了吗
