public class PlayingField {

    State [] [] board;
    int movesMade = 0;

    public PlayingField(){
        board = new State[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board [i] [j] = State.Empty;

            }
        }
    }

    //метод проверяющи состояние игры победа игрока или продолжение
    public GameState GameState() {
        int count = 0;
        ///поиск по строке кругов
        for (int i = 0; i < 3; i++) {
            count = 0;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == State.Circle) {
                    count++;
                    if (count == 3) return GameState.WinSecond;
                } else count--;
            }
        }
        //Поиск по строке крестов
        for (int i = 0; i < 3; i++) {
            count = 0;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == State.Cross) {
                    count++;
                    if (count == 3) return GameState.WinFirst;
                } else count--;
            }
        }


        //поск по столбцам кругов
        for (int i = 0; i < 3; i++) {
            count = 0;
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == State.Circle) {
                    count++;
                    if (count == 3) return GameState.WinSecond;
                } else count--;
            }
        }
        //Поиск по столбцу крестов
        for (int i = 0; i < 3; i++) {
            count = 0;
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == State.Cross) {
                    count++;
                    if (count == 3) return GameState.WinFirst;
                } else count--;
            }
        }
        //диаганоль  налево круги
        count = 0;
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                if (i == j && board[i][j] == State.Circle) {
                    count++;

                    if (count == 3) return GameState.WinSecond;
                }
            }
        }
        //диаганоль налево крестов
        count = 0;
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                if (i == j && board[i][j] == State.Cross) {
                    count++;
                    if (count == 3 ) return GameState.WinFirst;

                }

            }
        }


        //диагональ справа круги
        count = 0;
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                if (i == 0 && j == 2 && board[i][j] == State.Circle) {
                    count++;


                }

                if (i == 1 && j == 1 && board[i][j] == State.Circle) {
                    count++;
                }
                if (i == 2 && j == 0 && board[i][j] == State.Circle) {
                    count++;
                }

            }

            if (count == 3) return GameState.WinSecond;

        }
        //диагональ справа квадрат
        count = 0;
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                if (i == 0 && j == 2 && board[i][j] == State.Cross) {
                    count++;


                }

                if (i == 1 && j == 1 && board[i][j] == State.Cross) {
                    count++;
                }
                if (i == 2 && j == 0 && board[i][j] == State.Cross) {
                    count++;
                }

            }

            if (count == 3) return GameState.WinFirst;

        }

        //Ничья
        count = 0;
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                if (board[i][j] != State.Empty) count++; else break;
                if (count == 9) return  GameState.Draw;
            }
        }
        return GameState.Draw;
    }
    //вспомогательные методы поиска кругов в цикле

    //совершения хода игрока
    public void moveMaker(int walkingPlayer, int positionI, int positionJ){
        if (walkingPlayer == 1 && board[positionI][positionJ] == State.Empty){
            board[positionI][positionJ] = State.Cross;
            movesMade++;

        }
        else if (walkingPlayer == 2 && board[positionI][positionJ] == State.Empty){
            board[positionI][positionJ] = State.Circle;
            movesMade++;

        }

    }
    public void resetPlayingField(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = State.Empty;
            }
        }
    }

}
