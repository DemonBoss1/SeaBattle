import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BattlefieldCell implements ActionListener {
    int x,y;
    BattlefieldInterface battlefieldInterface;
    BattlefieldCell(BattlefieldInterface battlefieldInterface, int i, int j){
        this.battlefieldInterface=battlefieldInterface;
        this.y=i;
        this.x=j;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        battlefieldInterface.Shot(y, x);
    }
}
