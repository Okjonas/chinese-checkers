public class Main {

    final int boardWidth = 13;
    final int boardHeight = 17;
    final int[] widthPerRow = {1, 2, 3, 4, 13, 12, 11, 10, 9, 10, 11, 12, 13, 4, 3, 2, 1};
    final int[] illegalFieldsAtRow = {6, 5, 5, 4, 0, 0, 1, 1, 2, 1, 1, 0, 0, 4, 5, 5, 6};
    int row = 0;
    int numberOfSpaces = 0;

    String[][] boardMatrix = new String [boardWidth][boardHeight];

    public static void main(String[] args) {

        Main main = new Main();
        main.drawBoard();

        main.createBoard2();
        System.out.println();

        main.drawBoard2();
    }

    private void drawBoard2() {

        for(int i = 0; i < boardHeight; i++) {
            for(int j = 0; j < boardWidth; j++) {
                System.out.print(boardMatrix[j][i] + " ");
            }
            System.out.println();
        }
    }

    /*
    public void createBoard()
    {
        for (int i = 0; i < boardHeight; i++)
        {
                numberOfSpaces = (boardWidth - widthPerRow[i]) / 2;
                int rowBuffer = 0;
                for (int k = 0; k < boardWidth; k++) {

                    if (rowBuffer > numberOfSpaces) {
                        boardMatrix[k][i] = 1;
                        rowBuffer = rowBuffer + 1;
                    }
                    else if (rowBuffer == numberOfSpaces) {
                        boardMatrix[k][i] = 0;
                        rowBuffer = rowBuffer + 1;
                    }
                    else {
                        boardMatrix[k][i] = 1;
                        rowBuffer = rowBuffer + 1;
                    }
                }
            }
    }
    */

    public void createBoard2()
    {
        int rowBuffer = 0;
        int row = 0;

        for (int i = 0; i < boardHeight; i++)
        {
            for (int j = 0; j < boardWidth; j++)
            {
                for (int k = 0; k < illegalFieldsAtRow[i]; k++)
                {
                    boardMatrix[k][i] = "-";
                    rowBuffer++;
                }

                for (int k = 0; k < widthPerRow[i]; k++)
                {
                    boardMatrix[rowBuffer][i] = "O";
                    rowBuffer++;
                }
                for (int k = 0; k < illegalFieldsAtRow[i]; k ++)
                {
                    boardMatrix[rowBuffer][i] = "-";
                    rowBuffer++;
                }
                rowBuffer = 0;
            }
            if (i % 2 != 0)
                boardMatrix[boardWidth - 1][i] = "-";
        }
    }

    public void drawBoard() {


        System.out.println("\nChinese Checkers Board:");

        for (int i = 0; i < boardHeight; i++)
        {
            if (row % 2 == 0) {

                numberOfSpaces = ( boardWidth - widthPerRow[i] ) / 2;

                for (int k = 0; k < numberOfSpaces; k++)
                {
                    printIllegalField();
                    sleep();
                }

                for (int k = 0; k < widthPerRow[i]; k ++)
                {
                    printEmptyField();
                    sleep();
                }

                for (int k = 0; k < numberOfSpaces; k++)
                {
                    printIllegalField();
                    sleep();
                }
                System.out.println();
            }


            if (row % 2 != 0)
            {
                System.out.print(" ");

                numberOfSpaces = ( boardWidth - widthPerRow[i] ) / 2;

                for (int k = 0; k < numberOfSpaces; k++)
                {
                    printIllegalField();
                    sleep();
                }

                for (int k = 0; k < widthPerRow[i]; k ++)
                {
                    printEmptyField();
                    sleep();
                }

                for (int k = 0; k < numberOfSpaces; k++)
                {
                    printIllegalField();
                    sleep();
                }
                System.out.println("");
            }
            row += 1;
        }
    }

    public void printEmptyField()
    {
        System.out.print("O ");
    }

    public void printIllegalField()
    {
        System.out.print("- ");
    }

    public void sleep() {
        try
        {
            Thread.sleep(10);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }}
