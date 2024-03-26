import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private JButton[][] buttons;
    private boolean isXTurn = true;
    PlayingField playingField = new PlayingField();
    public Main() {


        setTitle("Let's play game in TicTacToe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel gamePanel = new JPanel(new GridLayout(3, 3));
        buttons = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].addActionListener(this);
                buttons[i][j].setBackground(new Color(230,230,250));
                buttons[i][j].setOpaque(true);
                gamePanel.add(buttons[i][j]);
            }
        }

        JButton buttonR = new JButton("reset");
        buttonR.addActionListener(this);

        add(gamePanel, BorderLayout.CENTER);
        add(buttonR, BorderLayout.SOUTH);

        setSize(300, 350); // увеличил высоту для умещения кнопки "reset"
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        int row = -1;
        int col = -1;

        // Находим индексы строки и столбца кнопки
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (button == buttons[i][j]) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        if (row != -1 && col != -1) {
            if (button.getText().equals("")) {
                if (isXTurn) {
                    button.setText("X");
                    playingField.moveMaker(1, row, col); // Передача индексов строки и столбца
                    playingField.GameState(1);
                    if (playingField.GameState(1) == GameState.WinFirst) {
                        setTitle("CROSS WON");
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                buttons[i][j].setEnabled(false);
                            }
                        }
                    } if(playingField.GameState(1) == GameState.Draw){
                        setTitle("DRAW"); //ничья
                    }

                } else {
                    button.setText("O");
                    playingField.moveMaker(2, row, col); // Передача индексов строки и столбца
                    if(playingField.GameState(2) == GameState.WinSecond){
                        setTitle("CIRCLE WON");
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                buttons[i][j].setEnabled(false);
                            }
                        }}
                    //остановить прослушивание


                }
                isXTurn = !isXTurn;

            }

        }if (button.getText().equals("reset")) {
            playingField.resetPlayingField();
            isXTurn = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    buttons[i][j].setText("");
                    buttons[i][j].setEnabled(true);
                    setTitle("Let's play game in TicTacToe");
                    //
                }

            }
        }
    }





    public static void main(String[] args) {

        new Main();

    }
}