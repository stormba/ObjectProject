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
    private JButton increaseBetButton;
    private JButton newGameButton;
    private JLabel playerLabel;
    private JLabel dealerLabel;
    private JLabel statusLabel;
    private JLabel balanceLabel;
    private JLabel betAmountLabel;
    private double playerBalance;
    

    

    private Game game;

    public GameGUI() {
        initializeGUI();
        addListeners();
        deactivateButtons();
        this.playerBalance = game.getPlayer().getBalance();
    }

    // public GameGUI(Player existingPlayer) {
    //     this.player = existingPlayer;
    //     initializeGUI();
    //     addListeners();
        
    // }
    private void initializeGUI() {
        frame = new JFrame("Blackjack");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,400);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        playerLabel = new JLabel("Spillerens hånd:");
        dealerLabel = new JLabel("Dealers hånd:");
        statusLabel = new JLabel("Velkommen til Blackjack!");
        balanceLabel = new JLabel("Saldo: ");
        hitButton = new JButton("Trekk");
        standButton = new JButton("Stå");
        splitButton = new JButton("Splitt");
        doubleButton = new JButton("Doble innsats");
        newGameButton = new JButton("Ny runde!");
        increaseBetButton = new JButton("Øk innsatsen med 10.");
        betAmountLabel = new JLabel("Innsats");

        //legger til komponentene
        mainPanel.add(playerLabel);
        mainPanel.add(dealerLabel);
        mainPanel.add(statusLabel);
        mainPanel.add(balanceLabel);
        mainPanel.add(hitButton);
        mainPanel.add(standButton);
        mainPanel.add(splitButton);
        mainPanel.add(doubleButton);
        mainPanel.add(newGameButton);
        mainPanel.add(increaseBetButton);
        mainPanel.add(betAmountLabel);

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);

        //deactivateButtons();
    }

    private void deactivateButtons(){
        //funksjon for å enkelt kunne eaktivere knapper etter endt runde.
        hitButton.setEnabled(false);
        standButton.setEnabled(false);
        doubleButton.setEnabled(false);
        splitButton.setEnabled(false);
    }

    private void reactivateButtons(){
        //funksjon for å enkelt kunne deaktivere knapper etter endt runde.
        hitButton.setEnabled(true);
        standButton.setEnabled(true);
        doubleButton.setEnabled(true);
        splitButton.setEnabled(true);
    }

    private void updateUI(){
        playerLabel.setText("Spillerens hånd: " + game.getPlayer().getHandValue()+ ".");
        dealerLabel.setText("Dealerens hånd: " + game.getDealer().getHandValue()+ ".");
        betAmountLabel.setText("Innsats: " +game.getBet());
        balanceLabel.setText("Saldo: " +this.playerBalance);

    }

    private void addListeners(){
        //new game 
        newGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                game = new Game();
                
                balanceLabel.setText("Saldo: "+game.getPlayer().getBalance());
                game.getPlayer().addCard(game.getDeck().drawCard());
                game.getDealer().addCard(game.getDeck().drawCard());
                game.getPlayer().addCard(game.getDeck().drawCard());
                
                //sjekker BJ
                if (game.getPlayer().getHandValue() == 21) {
                    statusLabel.setText("Gratulerer, du fikk Blackjack!");

                    //legger til vunnet innsats
                    double won = game.bet * 2.5;
                    game.getPlayer().addBalance(won);
                    updateUI();
                    deactivateButtons();
                    return;
                }

                reactivateButtons();
                updateUI();
                statusLabel.setText("Ny runde startet!");
                
            }
        });
        //trekk
        hitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                statusLabel.setText("Du trekker!");
                game.getPlayer().addCard(game.getDeck().drawCard());
                updateUI();
                
                if (game.getPlayer().isBusted()) {
                    statusLabel.setText("Du fikk over 21. Dealer vinner!");
                    //deaktiverer div knapper da runden er over.
                    deactivateButtons();
                }
            }

        });
        //stå
        standButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                statusLabel.setText("Du står. Dealer sin tur.");
                game.getDealer().playTurn(game.getDeck());
                updateUI();

                int playerScore = game.getPlayer().getHandValue();
                int dealerScore = game.getDealer().getHandValue();

                //finner vinner

                if (game.getDealer().isBusted()) {
                    statusLabel.setText("Dealer busta! Du vinner!");
                    //legger til vunnet innsats
                    double won = game.bet * 2;
                    game.getPlayer().addBalance(won);
                } else if (dealerScore > playerScore) {
                    statusLabel.setText("Dealer vinner med " + dealerScore + " mot " + playerScore+ "!");
                } else if (playerScore == dealerScore) {
                    statusLabel.setText("Uavgjort! Begge har " + playerScore + "!");
                    game.getPlayer().addBalance(game.bet);
                } else {
                    statusLabel.setText("Gratuler! Spiller vinner med " +playerScore+ "!");
                }
                updateUI();
                //deaktiverer knapper
                deactivateButtons();
            }
        });
        //øk innsats
        increaseBetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (game == null) {
                    return;
                }
                game.bet += 10;
                game.getPlayer().removeBalance(10);
                updateUI();
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameGUI());
    }

}

