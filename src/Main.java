import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String position;
        Battlefield battlefield = new Battlefield();
        battlefield.createBattlefield();

        battlefield.printBattlefield();

    }
}

