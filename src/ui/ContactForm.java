package ui;

import javax.swing.*;

public class ContactForm extends JFrame{
    private JPanel rootPanel;
    private JTextField textFieldName;
    private JTextField textFieldTelephone;
    private JButton buttonSave;
    private JButton buttonCancel;

    public ContactForm(){
        setContentPane(rootPanel);
        setSize(500, 250);
        setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        rootPanel = new JPanel();
    }
}
