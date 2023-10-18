import javax.swing.*;
import java.awt.*;

public class BattlefieldInterface extends JPanel {
    JPanel leftPanel;
    JPanel battlefieldInterface;
    JButton[][] shootingMap;
    Battlefield battlefield;

    BattlefieldInterface(){
        battlefield = new Battlefield();
        leftPanel = new JPanel(new GridLayout(11,2));
        battlefieldInterface = new JPanel(new GridLayout(11,10));
        shootingMap = new JButton[10][10];

        char[] chars = {'A','B','C','D','E','F','G','H','I','J'};
            for(int j=-1;j<10;j++) {
                if (j == -1) leftPanel.add(new JLabel());
                else leftPanel.add(new JLabel(chars[j] + "", SwingConstants.CENTER));
                leftPanel.add(new JLabel());
            }

        for(int j=-1;j<10;j++)
            for(int i=0;i<10;i++){
                if(j==-1) battlefieldInterface.add(new JLabel(i+"",SwingConstants.CENTER));
                else{
                    shootingMap[i][j] = new JButton("~");
                    battlefieldInterface.add(shootingMap[i][j]);
                    shootingMap[i][j].addActionListener(new BattlefieldCell(this,i,j));
                }
            }

        this.setLayout(new BorderLayout());
        this.add(BorderLayout.WEST, leftPanel);
        this.add(battlefieldInterface);
    }
    public void Shot(int y, int x){
        battlefield.Shot(y, x);
        updateBattlefield();
        if(battlefield.numberFilledCells==0){
            JOptionPane.showMessageDialog(Main.frame, "You win!!!");
        }
    }
    private void updateBattlefield(){
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) {
                char ch =battlefield.getShootingMap(i, j);
                if(ch!='~'){
                    shootingMap[i][j].setBackground(new Color(0,255,255));
                    shootingMap[i][j].setEnabled(false);
                }
                shootingMap[i][j].setText("" + ch);
            }
    }
}
