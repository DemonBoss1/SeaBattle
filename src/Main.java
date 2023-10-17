import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static JFrame frame = new JFrame("Sea battle");

    static int SetIndex(String position){
        if(Objects.equals(position, "A")||Objects.equals(position, "a")) return 0;
        if(Objects.equals(position, "B")||Objects.equals(position, "b")) return 1;
        if(Objects.equals(position, "C")||Objects.equals(position, "c")) return 2;
        if(Objects.equals(position, "D")||Objects.equals(position, "d")) return 3;
        if(Objects.equals(position, "E")||Objects.equals(position, "e")) return 4;
        if(Objects.equals(position, "F")||Objects.equals(position, "f")) return 5;
        if(Objects.equals(position, "G")||Objects.equals(position, "g")) return 6;
        if(Objects.equals(position, "H")||Objects.equals(position, "h")) return 7;
        if(Objects.equals(position, "I")||Objects.equals(position, "i")) return 8;
        if(Objects.equals(position, "J")||Objects.equals(position, "j")) return 9;
        return -1;
    }
    public static void main(String[] args) {

        JTextArea textArea = new JTextArea("Hello!");

        JPanel battlefieldInterface = new JPanel();
        JButton[][] shootingMap = new JButton[10][10];

        JPanel shotPanel = new JPanel();
        JButton shotButton = new JButton("Shot");
        JTextField positionField = new JTextField();
        JLabel attackPosition = new JLabel("Attack position  ");

        frame.setSize(500,400);

        textArea.setBackground(new Color(0,0,55));
        textArea.setEnabled(false);

        Battlefield battlefield = new Battlefield();
        textArea.setText(battlefield.ShootingMapToString());

        shotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i, j;
                String position = positionField.getText();
                positionField.setText("");
                try {
                    i = SetIndex(String.valueOf(position.charAt(0)));
                    j = Integer.parseInt(position.substring(1));
                    battlefield.Shot(i, j-1);
                }catch (Exception exception){
                    textArea.setText("Error");
                }
                String str = battlefield.ShootingMapToString();
                textArea.setText(str);
                if(battlefield.numberFilledCells==0){
                    JOptionPane.showMessageDialog(frame, "You win!!!");
                }
            }
        });
        battlefield.printBattlefield();
        battlefield.printShootingMap();

        battlefieldInterface.setLayout(new GridLayout(11,11));
        char[] chars = {'A','B','C','D','E','F','G','H','I','J'};
        for(int i=-1;i<10;i++)
            for(int j=-1;j<10;j++) {
                if(i==-1){
                    if(j==-1) battlefieldInterface.add(new JLabel());
                    else battlefieldInterface.add(new JLabel(chars[j]+"", SwingConstants.CENTER));
                }
                else
                if(j==-1) battlefieldInterface.add(new JLabel(i+"",SwingConstants.CENTER));
                else{
                    shootingMap[i][j] = new JButton("~");
                    battlefieldInterface.add(shootingMap[i][j]);
                    shootingMap[i][j].addActionListener(new BattlefieldCell(battlefield,shootingMap,i,j));
                }
            }

        shotPanel.setLayout(new BorderLayout(0, 0));
        shotPanel.add(BorderLayout.NORTH, new JPanel());
        shotPanel.add(BorderLayout.SOUTH, new JPanel());
        shotPanel.add(BorderLayout.WEST,attackPosition);
        shotPanel.add(BorderLayout.CENTER,positionField);
        shotPanel.add(BorderLayout.EAST,shotButton);

        frame.add(BorderLayout.NORTH, new JPanel());
        frame.add(BorderLayout.WEST, new JPanel());
        frame.add(BorderLayout.EAST, new JPanel());
        frame.add(BorderLayout.CENTER,battlefieldInterface);
        frame.add(BorderLayout.SOUTH, shotPanel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

