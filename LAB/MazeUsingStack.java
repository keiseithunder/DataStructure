
import java.util.Stack;

public class MazeUsingStack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] maze = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
        {1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1},
        {9, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
        {1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1},
        {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1},
        {1, 0, 1, 2, 1, 0, 1, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        //0=can walk, 1=wall,2=path,3=non-try-block,9=exit
        Position mouse = new Position(8, 3);
        Stack backTrack = new Stack<Position>();
        int count = 0;
        backTrack.push(mouse);
        System.out.println(((Position) backTrack.firstElement()).row + ","
                + ((Position) backTrack.firstElement()).column);
        while (maze[mouse.row][mouse.column] != 9) {
            if (maze[mouse.row - 1][mouse.column] == 0) {//north of mouse
                backTrack.push(new Position(mouse.row - 1, mouse.column));
                maze[mouse.row - 1][mouse.column] = 3;
            }
            if (maze[mouse.row][mouse.column + 1] == 0) {//east of mouse
                backTrack.push(new Position(mouse.row, mouse.column + 1));
                maze[mouse.row  ][mouse.column+1] = 3;
            }
            if (maze[mouse.row + 1][mouse.column] == 0) {//south of mouse
                backTrack.push(new Position(mouse.row + 1, mouse.column));
                maze[mouse.row + 1][mouse.column] = 3;
            }
            if (maze[mouse.row][mouse.column - 1] == 0) {//west of mouse
                backTrack.push(new Position(mouse.row, mouse.column - 1));
                maze[mouse.row ][mouse.column-1] = 3;
            }
            Position out = (Position) backTrack.pop();
            mouse.row = out.row;
            mouse.column = out.column;
            count++;
            maze[mouse.row][mouse.column] = 2;
            printMaze(maze);
            if (maze[mouse.row - 1][mouse.column] == 9) {//north of mouse
                System.out.println("Exit is at [" + (mouse.row - 1) + "," + mouse.column + "]");
                break;
            } else if (maze[mouse.row][mouse.column + 1] == 9) {//east of mouse
                System.out.println("Exit is at [" + (mouse.row) + "," + (mouse.column + 1) + "]");
                break;
            } else if (maze[mouse.row + 1][mouse.column] == 9) {//south of mouse
                System.out.println("Exit is at [" + (mouse.row + 1) + "," + (mouse.column) + "]");
                break;
            } else if (maze[mouse.row][mouse.column - 1] == 9) {//west of mouse
                System.out.println("Exit is at [" + (mouse.row) + "," + (mouse.column - 1) + "]");
                break;
            }

        }
        System.out.println("Number of step : "+count);

    }

    public static void printMaze(int[][] maze) {
        for (int[] x : maze) {
            for (int i : x) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
        System.out.println("-----------------------");
    }
}
