package ui;

import controller.ContactController;
import entity.ContactEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainFrame extends JFrame {

    private JPanel mainPanel;
    private JButton buttonNewContact;
    private JButton buttonRemove;
    private JTable TableContacts;
    private ContactController contactController;

    public MainFrame(){
        contactController = new ContactController();
        loadContacts();
        setContentPane(mainPanel);
        setSize(500, 250);
        setVisible(true);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dimension.width/2 - getSize().width/2), (dimension.height/2 - getSize().height/2));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setListener();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        mainPanel = new JPanel();
        buttonNewContact = new JButton();
        buttonRemove = new JButton();
        TableContacts = new JTable();
    }

    private void loadContacts(){
        List<ContactEntity> contactList = contactController.getContactList();
    }

    private void setListener(){
        buttonNewContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ContactForm();
                dispose();
            }
        });

        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
