// Zakwan Ashfaq Zian - zazian
// 201950250

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class gui {
    // initializing components
    JFrame frame;
    JPanel mainPanel;
    JPanel centrPanel;
    JButton newGameButton;
    JPanel bottomLeftFlowPanel;
    JPanel bottomRightFlowPanel;
    JPanel bottomCentreGridBag;
    JLabel commentary;
    JLabel scoreCountBottomRight;
    JPanel bottomPanel;
    JButton button1 = null, button2 = null, button3 = null, button4 = null, button5 = null, button6 = null,
            button7 = null, button8 = null, button9 = null, button10 = null, button11 = null, button12 = null,
            button13 = null, button14 = null, button15 = null, button16 = null, button17 = null, button18 = null,
            button19 = null, button20 = null, button21 = null, button22 = null, button23 = null, button24 = null,
            button25 = null;
    JProgressBar progressBar1;
    JButton buttonArr[];
    // builds the gui
    public void initGui() {
        // initializing button array
        buttonArr = new JButton[]{button1, button2, button3, button4, button5, button6, button7, button8, button9,
                button10, button11, button12, button13, button14, button15, button16, button17, button18, button19,
                button20, button21, button22, button23, button24, button25};
        // initializing main panel
        mainPanel = new JPanel();
        frame = new JFrame("test");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setLayout(new BorderLayout(5, 5));
        centrPanel = new JPanel();
        centrPanel.setLayout(new GridBagLayout());
        centrPanel.setBackground(new Color(-9344109));
        mainPanel.add(centrPanel, BorderLayout.CENTER);
        // nested loop to put buttons in grid layout
        int buttonCount = 0;
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                buttonArr[buttonCount] = new JButton();
                buttonArr[buttonCount].setBackground(new Color(-1));
                buttonArr[buttonCount].setText("  ");
                buttonArr[buttonCount].setEnabled(false);
                GridBagConstraints gridLayout;
                gridLayout = new GridBagConstraints();
                gridLayout.gridx = i;
                gridLayout.gridy = j;
                gridLayout.fill = GridBagConstraints.HORIZONTAL;
                gridLayout.ipady = 50;
                gridLayout.ipadx = 50;
                gridLayout.insets = new Insets(2, 2, 2, 2);
                centrPanel.add(buttonArr[buttonCount], gridLayout);
                buttonCount++;
            }
        }
        //progressbar
        GridBagConstraints gridLayout;
        progressBar1 = new JProgressBar();
        Font progressBar1Font= new gui().getFont(null, -1, 20, progressBar1.getFont());
        if (progressBar1Font != null) progressBar1.setFont(progressBar1Font);
        progressBar1.setString("PONTOON GAME");
        progressBar1.setStringPainted(true);
        progressBar1.setValue(0);
        progressBar1.setMaximum(21);
        gridLayout = new GridBagConstraints();
        gridLayout.gridx = 0;
        gridLayout.gridy = 0;
        gridLayout.gridwidth = 6;
        gridLayout.fill = GridBagConstraints.BOTH;
        gridLayout.insets = new Insets(5, 5, 4, 5);
        centrPanel.add(progressBar1, gridLayout);
        // instructions
        JPanel instructionPanel = new JPanel(new FlowLayout());
        JLabel instructionLabel= new JLabel("Player that crosses 21 first looses the game" +
                ". Click New Game to begin.");
        instructionPanel.add(instructionLabel);
        gridLayout = new GridBagConstraints();
        gridLayout.gridx = 0;
        gridLayout.gridy = 6;
        gridLayout.gridwidth = 6;
        gridLayout.fill = GridBagConstraints.BOTH;
        gridLayout.insets = new Insets(5, 5, 4, 5);
        centrPanel.add(instructionPanel, gridLayout);
        // bottomPanel
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout(0, 0));
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        bottomLeftFlowPanel = new JPanel();
        bottomLeftFlowPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        bottomPanel.add(bottomLeftFlowPanel, BorderLayout.WEST);
        // bottom button
        newGameButton = new JButton();
        newGameButton.setHorizontalAlignment(0);
        newGameButton.setText("New Game");
        bottomLeftFlowPanel.add(newGameButton);
        bottomRightFlowPanel = new JPanel();
        bottomRightFlowPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        bottomPanel.add(bottomRightFlowPanel, BorderLayout.EAST);
        // botttom right score
        this.scoreCountBottomRight = new JLabel();
        scoreCountBottomRight.setText("Current : 0");
        scoreCountBottomRight.setVerticalAlignment(3);
        scoreCountBottomRight.setVerticalTextPosition(3);
        bottomRightFlowPanel.add(scoreCountBottomRight);
        bottomCentreGridBag = new JPanel();
        bottomCentreGridBag.setLayout(new GridBagLayout());
        bottomCentreGridBag.setBackground(new Color(-9344109));
        bottomCentreGridBag.setEnabled(false);
        bottomCentreGridBag.setForeground(new Color(-4722433));
        bottomPanel.add(bottomCentreGridBag, BorderLayout.CENTER);
        // commentary
        commentary = new JLabel();
        commentary.setForeground(new Color(-1));
        commentary.setText("Player 1`s term");
        gridLayout = new GridBagConstraints();
        gridLayout.gridx = 0;
        gridLayout.gridy = 0;
        gridLayout.anchor = GridBagConstraints.WEST;
        bottomCentreGridBag.add(commentary, gridLayout);
        //putting frame in the middle of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((dim.width/2-frame.getSize().width/2)-207, (dim.height/2-frame.getSize().height/2)-250);
        // packing frame, setting size and setting it visible
        frame.setMinimumSize(new Dimension(515,565));
        frame.pack();
        frame.setVisible(true);

    }
    // updates components
    public void guiUpdate(int val, String move, int score){
        progressBar1.setValue(val);
        commentary.setText(move);
        scoreCountBottomRight.setText(score+"");
    }
    // change button variables
    public void updateButtons(int num[]){
        for (int i = 0; i<25; i++) {
            buttonArr[i].setText(num[i]+"");
        }
    }
    // font in the progressbar
    private Font getFont(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }
    // Test Code
    public static void main(String[] args) {
        gui g = new gui();
        g.initGui();
        g.buttonArr[0].setText("75");
        g.buttonArr[0].addActionListener(s -> System.out.println("Button 0 pressed"));
        g.buttonArr[5].addActionListener(s ->{
            System.out.println("Button 5 pressed");
        });
        g.buttonArr[24].addActionListener(s ->{
            System.out.println("Button 24 pressed");
        });
        g.progressBar1.setValue(20);
        g.commentary.setText("Changed Text");
    }
}
