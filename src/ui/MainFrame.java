package ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JPanel mainPanel;
    private JButton buttonNewContact;
    private JButton buttonRemove;
    private JTable TableContacts;

    public MainFrame(){
        setContentPane(mainPanel);
        setSize(500, 250);
        setVisible(true);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dimension.width/2 - getSize().width/2), (dimension.height/2 - getSize().height/2));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        mainPanel = new JPanel();
        buttonNewContact = new JButton();
        buttonRemove = new JButton();
    }
}
