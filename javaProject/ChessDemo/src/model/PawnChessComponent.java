package model;

import view.ChessboardPoint;
import controller.ClickController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

//兵
public class PawnChessComponent extends ChessComponent{

    //显示兵的图片
    private static Image PAWN_WHITE;
    private static Image PAWN_BLACK;
    private Image pawnImage;

    /**
     * 读取加载兵棋子的图片
     *
     * @throws IOException
     */
    public void loadResource() throws IOException {
        if (PAWN_WHITE == null) {
            PAWN_WHITE = ImageIO.read(new File("ChessDemo/images/pawn-white.png"));
        }

        if (PAWN_BLACK == null) {
            PAWN_BLACK = ImageIO.read(new File("ChessDemo/images/pawn-black.png"));
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
                pawnImage = PAWN_WHITE;
            } else if (color == ChessColor.BLACK) {
                pawnImage = PAWN_BLACK;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PawnChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor color, ClickController listener, int size) {
        super(chessboardPoint, location, color, listener, size);
        initiateRookImage(color);
    }


    /**
     * 兵棋子的移动规则
     *
     * @param chessboard 棋盘
     * @param destination     目标位置，如(0, 0), (0, 7)等等
     * @return 棋子移动的合法性
     */
    @Override
    public boolean canMoveTo(ChessComponent[][] chessboard, ChessboardPoint destination) {
        // 原位置
        ChessboardPoint source = getChessboardPoint();
        int x1 = source.getX();
        int y1 = source.getY();
        // 新位置
        int x2 = destination.getX();
        int y2 = destination.getY();
        if(getChessColor()==ChessColor.BLACK){
            // 上面黑棋
            System.out.println(getChessColor());
            // 只能向前,不能越过棋子
            // 第一步可以走两格
            if((x2-x1==1 || ((x2-x1==2) && (x1==1))) && Math.abs(y2-y1)==0 && (chessboard[x1+1][y1] instanceof EmptySlotComponent)){
                //
                System.out.println("可以移动");
                return true;
            }
            // 横的是y,竖的是x
            // 吃过路棋
            // 斜吃
            if((x2-x1==1) && Math.abs(y2-y1)==1){
                // 斜棋
                ChessComponent chess1 = chessboard[x2][y2];
                if(chess1.chessColor == ChessColor.WHITE){
                    return true;
                }
                // 过路棋
                ChessComponent chess2 = chessboard[x1][y2];
                System.out.println(chess2);
                if(chess2.chessColor == ChessColor.WHITE && chess2 instanceof PawnChessComponent){


//                    remove(chessboard[chess2.getX()][chess2.getY()]);
//                    System.out.println(x1+","+y2);
//                    chessboard[x1][y2] = new EmptySlotComponent(chessboard[x1][y2].getChessboardPoint(), chessboard[x1][y2].getLocation(), getClickController(), 8));
                    return true;
                }
            }
        }else if(getChessColor()==ChessColor.WHITE){
            //下面白棋
            if((x1-x2==1 || ((x1-x2==2) && (x1==6)))&& Math.abs(y2-y1)==0 && (chessboard[x1-1][y1] instanceof EmptySlotComponent)){
                //
                System.out.println("可以移动");
                return true;
            }
            if((x1-x2==1) && Math.abs(y2-y1)==1){
                // 斜棋
                ChessComponent chess1 = chessboard[x2][y2];
                if(chess1.chessColor == ChessColor.BLACK){
                    return true;
                }
                // 过路棋
                ChessComponent chess2 = chessboard[x1][y2];
                System.out.println(chess2);
                if(chess2.chessColor == ChessColor.BLACK && chess2 instanceof PawnChessComponent){
//                    remove(chessboard[x1][y2]);
//                    System.out.println(x1+","+y2);
//                    add(chessboard[x1][y2] = new EmptySlotComponent(chessboard[x1][y2].getChessboardPoint(), chessboard[x1][y2].getLocation(), getClickController(), 8));
//                    System.out.println(chessboard[x1][y2]);
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 注意这个方法，每当窗体受到了形状的变化，或者是通知要进行绘图的时候，就会调用这个方法进行画图。
     *
     * @param g 可以类比于画笔
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.drawImage(rookImage, 0, 0, getWidth() - 13, getHeight() - 20, this);
        g.drawImage(pawnImage, 0, 0, getWidth() , getHeight(), this);
        g.setColor(Color.BLACK);
        if (isSelected()) { // Highlights the model if selected.
            g.setColor(Color.RED);
            g.drawOval(0, 0, getWidth() , getHeight());
        }
    }
}
