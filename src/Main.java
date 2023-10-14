import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Scanner;

public class Main {
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

        JFrame frame = new JFrame("Sea battle");
        JPanel panel = new JPanel();
        JTextArea textArea = new JTextArea("Hello!");
        JButton button = new JButton("Shot");
        JTextField textField = new JTextField();
        JLabel attackPosition = new JLabel("Attack position  ");

        frame.setSize(1000,300);
        textArea.setBackground(new Color(0,0,55));
        textArea.setEnabled(false);

        panel.setLayout(new BorderLayout(0, 0));
        panel.add(BorderLayout.NORTH, new JPanel());
        panel.add(BorderLayout.SOUTH, new JPanel());
        panel.add(BorderLayout.WEST,attackPosition);
        panel.add(BorderLayout.CENTER,textField);
        panel.add(BorderLayout.EAST,button);

        Battlefield battlefield = new Battlefield();
        textArea.setText(battlefield.ShootingMapToString());

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i, j;
                String position = textField.getText();
                textField.setText("");
                try {
                    i = SetIndex(String.valueOf(position.charAt(0)));
                    j = Integer.parseInt(position.substring(1));
                    battlefield.Shot(i, j-1);
                    System.out.println(i+" "+(j-1));
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

        frame.add(BorderLayout.NORTH, new JPanel());
        frame.add(BorderLayout.WEST, new JPanel());
        frame.add(BorderLayout.EAST, new JPanel());
        frame.add(BorderLayout.CENTER,textArea);
        frame.add(BorderLayout.SOUTH, panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

