import java.util.ArrayList;

public class Ship {
    Battlefield battlefield;
    ArrayList<Position> ships = new ArrayList<Position>();
    int length=0;
    public Ship(Battlefield battlefield, int i, int j){
        this.battlefield=battlefield;
        ships.add(new Position(i, j));
        length++;
    }
    public void lengthIncrease(int i, int j){
        ships.add(new Position(i, j));
        length++;
    }
    public void lengthReduction(int i, int j){
        for(int k=0; k<ships.size(); k++)
            if(ships.get(k).x==j&&ships.get(k).y==i) {
                ships.remove(k);
                length--;
                if(length==0)System.out.println("Потопил");
            }
    }

}
class Position{
    public int x, y;
    public Position(int i, int j){
        x=j;
        y=i;
    }
}
