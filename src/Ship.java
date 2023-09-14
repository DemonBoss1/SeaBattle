import java.util.ArrayList;

public class Ship {
    Battlefield battlefield;
    ArrayList<Position> ships;
    int length=0;
    public Ship(Battlefield battlefield, int i, int j){
        this.battlefield=battlefield;
        ships.add(new Position(i, j));
        length++;
    }

}
class Position{
    public int x, y;
    Position(int i, int j){
        x=j;
        y=i;
    }
}
