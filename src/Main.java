import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Grid grid = new Grid(new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {3, 1, 2, 8, 4, 5, 0, 6, 7},
                {6, 0, 7, 3, 1, 2, 8, 4, 5},
                {8, 4, 5, 6, 9, 7, 3, 1, 2},
                {2, 3, 1, 0, 7, 4, 6, 9, 8},
                {9, 6, 8, 2, 3, 1, 5, 7, 4},
                {5, 7, 4, 9, 6, 8, 2, 3, 1}
        });
        Scanner in = new Scanner(System.in);

        while(!grid.full()){
            try {
                grid.draw();
                System.out.println("x, y, number (seperate by newline)");
                grid.setNum(in.nextInt(), in.nextInt(), in.nextInt());
            }catch (FullRetardException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("sudoku done");
    }
}
