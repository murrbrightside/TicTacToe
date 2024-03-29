public class PlayingField {

    String [] [] board;
    int movesMade = 0;

    public PlayingField(){
        board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board [i] [j] = "State.Empty";

            }
        }
    }

    //метод проверяющи состояние игры победа игрока или продолжение
    public GameState GameState() {
        int count = 0;
        ///поиск по строке кругов
        for (int i = 0; i < 3; i++) {
            if (board[i][1].equals(board[i][0]) && board[i][1].equals(board[i][2])
            && board[i][1].equals("State.Circle")) {
                return GameState.WinSecond;

            }
        }
        //Поиск по строке крестов
        for (int i = 0; i < 3; i++) {
            if (board[i][1].equals(board[i][0]) && board[i][1].equals(board[i][2])
            && board[i][1].equals("State.Cross")) {
                return GameState.WinFirst;

            }
        }


        //поск по столбцам кругов
        for (int i = 0; i < 3; i++) {
            if (board[1][i].equals(board[0][i]) && board[1][i].equals(board[2][i])
                    && board[i][1].equals("State.Circle")) {
                return GameState.WinSecond;

            }
        }
        //Поиск по столбцу крестов
        for (int i = 0; i < 3; i++) {
            if (board[1][i].equals(board[0][i]) && board[1][i].equals(board[2][i])
                    && board[i][1].equals("State.Cross")) {
                return GameState.WinFirst;

            }
        }
        //диаганоль  налево круги
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) &&
                board[0][0].equals("State.Circle"))
            return GameState.WinSecond;

        //диаганоль налево крестов


        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) &&
                board[0][0].equals("State.Cross"))
            return GameState.WinFirst;


        //диагональ справа круги
        if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) &&
                board[0][2].equals("State.Circle"))
            return GameState.WinSecond;

        //диагональ справа квадрат

        if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) &&
                board[0][2].equals("State.Cross"))
            return GameState.WinFirst;



        //Ничья
        count = 0;
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                if (!board[i][j].equals("State.Empty") ) count++; else break;
                if (count == 9) return  GameState.Draw;
            }
        }
        return GameState.Draw;
    }
    //вспомогательные методы поиска кругов в цикле

    //совершения хода игрока
    public void moveMaker(int walkingPlayer, int positionI, int positionJ){
        if (walkingPlayer == 1 && board[positionI][positionJ].equals("State.Empty") ){
            board[positionI][positionJ] = "State.Cross";
            movesMade++;

        }
        else if (walkingPlayer == 2 && board[positionI][positionJ].equals("State.Empty")){
            board[positionI][positionJ] = "State.Circle";

            movesMade++;

        }

    }
    public void resetPlayingField(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "State.Empty";
            }
        }
    }

}
