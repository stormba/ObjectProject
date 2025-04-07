import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameGUI {
    
    private JFrame frame;
    private JPanel mainPanel;
    private JButton hitButton;
    private JButton standButton;
    private JButton splitButton;
    private JButton doubleButton;
    private JButton newGameButton;
    private JLabel playerLabel;
    private JLabel dealerLabel;
    private JLabel statusLabel;

    private Game game;

    public GameGUI() {
        initializeGUI();
        addListeners();
    }

    private void initializeGUI() {
        
    }


}
