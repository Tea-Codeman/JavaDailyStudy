package Java.HuaRongDao.View;

import javax.swing.JFrame;
import javax.swing.JTable;

import Java.HuaRongDao.Model.Board;
import Java.HuaRongDao.Model.Piece;

public class GameFrame extends JFrame{
    private JTable table;
    private Board board;
    private Piece piece;
    public GameFrame(){
        super("HuaRongDao");
        initFrame();
        initModel();
    }
    public void initFrame(){
        //add components to the frame
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //add table to the frame
        table = new JTable();
        this.add(table);
    }
    public void initModel(){
        board = new Board();
        
    }
}
