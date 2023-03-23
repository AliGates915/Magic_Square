package AliGates;
import java.util.Random;
public class Magic_Square
{
    private static int[][] num = {{1,2,3},{4,5,6},{7,8,9}};
    private static Random rand = new Random();
    private static void DisplayBoard()
    {
        for(int r = 0; r<3; r++)
        {
            for(int c = 0; c<3; c++)
            {
                System.out.print(num[r][c] + " ");
            }
            System.out.println("");
        }
    }
    private static boolean IsMagicSquare()
    {
        int temp_sum = num[0][0] + num[0][1] + num[0][2];
        // Compare Rows ; Start from row 1 because temp_sum already hold the sum for row 0.
        for (int i = 1; i<3; i++)
        {
            if(num[i][0] + num[i][1] + num[i][2] != temp_sum)
            {
                return false;
            }
        }
        for (int i = 0; i<3; i++)
        {
            if(num[0][i] + num[1][i] + num[2][i] != temp_sum)
            {
                return false;
            }
        }
        // Diagonal Sum
        return num[0][0] + num[1][1] + num[2][2] == temp_sum &&
                num[0][2] + num[1][1] + num[2][0] == temp_sum;
    }
    private static void SwitchCells()
    {
        int[]   num1 = new int[2];
        int[]   num2 = new int[2];

        num1[0] = rand.nextInt(3);
        num1[1] = rand.nextInt(3);
        num2[0] = rand.nextInt(3);
        num2[1] = rand.nextInt(3);
        int temp = num[num1[0]][num1[1]];
        num[num1[0]][num2[1]] = num[num2[0]][num2[1]];
        num[num2[0]][num2[1]]= temp;

    }
    public static void main(String[] args)
    {
        int counter = 0;
        do
        {
            counter++;
            System.out.println(counter);
            SwitchCells();
        }while (!(IsMagicSquare()));
        DisplayBoard();
        System.out.println("It took " + counter + " Tries");
    }
}