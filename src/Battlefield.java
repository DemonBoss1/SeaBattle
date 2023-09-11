import java.lang.reflect.Constructor;

public class Battlefield {
    public int[][] battlefield = new int[10][10];
    public char[][] shootingMap = new char[10][10];
    public int numberFilledCells=0;
    Battlefield() {
        createBattlefield();
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                shootingMap[i][j] = '~';
    }
    public void createBattlefield(){
        createChip(1, 4);
        createChip(2, 3);
        createChip(3, 2);
        createChip(4, 1);
    }
    boolean possibilityParking(int i, int j){
        int i_1,i_2;
        int j_1,j_2;
        if(i==0) i_1=i; else i_1=i-1;
        if(i==9) i_2=i; else i_2=i+1;
        if(j==0) j_1=j; else j_1=j-1;
        if(j==9) j_2=j; else j_2=j+1;
        if ((battlefield[i_1][j_1]==0) && (battlefield[i][j_1]==0) && (battlefield[i_2][j_1]==0) &&
                (battlefield[i_1][j]==0) && (battlefield[i_2][j]==0) &&
                (battlefield[i_1][j_2]==0) && (battlefield[i][j_2]==0) && (battlefield[i_2][j_2]==0))
            return true;
        return false;

    }
    boolean createSizeChip(int sizeChip, boolean vertical, int i, int j){
        if(sizeChip==0) return true;
        if(vertical){
            if(i==9) return false;
            i++;
            if (possibilityParking(i,j))
                if(createSizeChip(sizeChip-1, vertical, i, j)) {
                    battlefield[i][j] = 1;
                    numberFilledCells++;
                    return true;
                }
        }
        else{
            if(j==9) return false;
            j++;
            if (possibilityParking(i,j))
                if(createSizeChip(sizeChip-1, vertical, i, j)) {
                    battlefield[i][j] = 1;
                    numberFilledCells++;
                    return true;
                }
        }
        return false;
    }
    public void createChip(int countNavy, int sizeChip){
        double direction;
        boolean vertical = false;
        while(countNavy!=0){
            if(sizeChip>1) {
                direction = Math.random();
                vertical= direction>0.5;
            }
            int i = (int) (Math.random() * 10);
            int j = (int) (Math.random() * 10);
            if (possibilityParking(i,j))
                if(createSizeChip(sizeChip-1, vertical, i, j)) {
                    battlefield[i][j] = 1;
                    numberFilledCells++;
                    countNavy--;
                }
        }
    }
    public void Shot(int i, int j){
        if(i==-1||j==-1) return;
        if(battlefield[i][j]==1){
            numberFilledCells--;
            shootingMap[i][j]='X';
        }
        else shootingMap[i][j]='O';
    }
    public void printBattlefield(){
        for(int i=0;i<10;i++) {
            for (int j = 0; j < 10; j++)
                System.out.print(battlefield[i][j] + "\t");
            System.out.println();
        }
    }
    public void printShootingMap(){
        char[] words = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        for(int i=-1;i<10;i++) {
            for (int j = -1; j < 10; j++)
                if(i==-1){
                    if(j==-1)System.out.print(" \t");
                    else System.out.print(j + "\t");
                }
            else {
                if(j==-1) System.out.print(words[i] + "\t");
                else System.out.print(shootingMap[i][j] + "\t");
                }
            System.out.println();
        }
    }
}
