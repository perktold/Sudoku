public class Grid {
    private int [][] gridArray;

    public Grid(){
        //fill with zeros
        this.gridArray = new int[9][9];
    }

    public Grid(int [][] gridArray){
        this.gridArray = gridArray; //just gonna assume gridArray is the right size and stuff lol
    }

    public void setNum(int x, int y, int num) throws FullRetardException {
        vibeCheck(x);
        vibeCheck(y);
        vibeCheck(num);

        x--;
        y--;

        if(this.gridArray[y][x] != 0) throw new FullRetardException("invalid move (cell full)");

        for(int i = 0; i < 9; i++){
            if(this.gridArray[i][x] == num) throw new FullRetardException("invalid move (column)");
            if(this.gridArray[y][i] == num) throw new FullRetardException("invalid move (row)");
        }

        int regionX = (int) (x)/3;
        int regionY = (int) (y)/3;

        for(int ix = regionX*3; ix < (regionX+1)*3; ix++){
            for(int iy = regionY*3; iy < (regionY+1)*3; iy++){
                if(this.gridArray[iy][ix] == num) throw new FullRetardException("invalid move (region)");
            }
        }
        this.gridArray[y][x] = num;
    }

    public int getNum(int x, int y) throws FullRetardException {
        vibeCheck(x);
        vibeCheck(y);
        return this.gridArray[y-1][x-1];
    }

    public void draw(){
        for(int y = 0; y < 9; y++){
            for(int x = 0; x < 9; x++){
                System.out.print(gridArray[y][x] + " ");
                if((1+x) % 3 == 0) System.out.print(" ");
            }
            System.out.println();
            if((1+y) % 3 == 0) System.out.println();
        }
    }

    public boolean full() {
        for(int x = 0; x < 9; x++){
            for(int y = 0; y < 9; y++){
                if(gridArray[y][x] == 0) return false;
            }
        }
        return true;
    }

    private void vibeCheck(int n) throws FullRetardException {
        if (1 > n || n > 9){
           throw new FullRetardException("you been caught lackin");
        }
    }

}
