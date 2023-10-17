import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BattlefieldCell implements ActionListener {
    Battlefield battlefield;
    JButton[][] shootingMap;
    int x,y;
    BattlefieldCell(Battlefield battlefield, JButton[][] shootingMap, int i, int j){
        this.battlefield=battlefield;
        this.shootingMap=shootingMap;
        this.y=i;
        this.x=j;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        battlefield.Shot(y, x);
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) {
                char ch =battlefield.getShootingMap(i, j);
                if(ch!='~')shootingMap[i][j].setBackground(new Color(0,255,255));
                shootingMap[i][j].setText("" + ch);
            }
        if(battlefield.numberFilledCells==0){
            JOptionPane.showMessageDialog(Main.frame, "You win!!!");
        }
    }
}
