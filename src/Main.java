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
        int i, j;
        Scanner in = new Scanner(System.in);
        String position;
        Battlefield battlefield = new Battlefield();

        while(battlefield.numberFilledCells!=0) {
            battlefield.printShootingMap();
            try {
                position = in.next();
                i = SetIndex(position);
                j = in.nextInt();
                battlefield.Shot(i, j-1);
            }catch (Exception e){
                System.out.println("Error");
            }
         }
        battlefield.printBattlefield();
        battlefield.printShootingMap();
        System.out.println("You win!!!");
    }
}

