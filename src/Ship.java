import java.util.ArrayList;

public class Ship {
    Battlefield battlefield;
    ArrayList<Position> ships;

}
class Position{
    public int x, y;
    Position(int i, int j){
        x=j;
        y=i;
    }
}
