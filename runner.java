// Zakwan Ashfaq Zian - zazian
// 201950250

import javax.swing.*;
import java.awt.*;

public class runner {
    // main method
    public static void main(String[] args) {
        backend b = new backend();
        gui g = new gui();
        g.initGui();
        g.newGameButton.addActionListener(s -> {
            g.progressBar1.setValue(0);
            guiReset(b, g);
            g.guiUpdate(b.score, b.state(), b.score);
        });
        for (int i = 0; i < 25; i++) {
            int finalI = i;
            g.buttonArr[i].addActionListener(s -> {
                g.buttonArr[finalI].setEnabled(false);
                if (b.state == true) g.buttonArr[finalI].setBackground(new Color(230, 203, 181));
                else g.buttonArr[finalI].setBackground(new Color(195, 235, 192));
                g.guiUpdate(b.score, b.state(), b.score);
                if (b.check(finalI)) {
                    g.progressBar1.setValue(b.score);
                    g.scoreCountBottomRight.setText("Current: " + b.score);
                } else {
                    g.guiUpdate(b.score, b.state(), b.score);
                    g.scoreCountBottomRight.setText("Current: " + b.score);
                    JFrame f = new JFrame();
                    if (b.state == true) {
                        JOptionPane.showMessageDialog(f, "Player 1 won the game. Press \"New Game\" to start another round.");
                        g.commentary.setText("Player 1 won the game. Press \"New Game\"");
                    } else {
                        JOptionPane.showMessageDialog(f, "Player 2 won the game. Press \"New Game\" to start another round.");
                        g.commentary.setText("Player 2 won the game. Press \"New Game\"");
                    }
                    g.progressBar1.setValue(0);
                    for (JButton button : g.buttonArr) {
                        button.setEnabled(false);
                    }
                }
            });
        }
    }

    // resets gui to initial position with updated values
    private static void guiReset(backend b, gui g) {
        b.reset();
        g.updateButtons(b.intArr);
        g.scoreCountBottomRight.setText("Current: " + b.score);
        for (JButton button : g.buttonArr) {
            button.setEnabled(true);
            button.setBackground(new Color(-1));
        }
        System.out.println("Game was successfully reset.");
    }
}
