package ui;

import controller.ContactController;
import entity.ContactEntity;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainFrame extends JFrame {

    private JPanel mainPanel;
    private JButton buttonNewContact;
    private JButton buttonRemove;
    private JTable tableContacts;
    private JLabel labelContactsCount;

    private ContactController contactController;
    private String name = "";
    private String telephone = "";

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
        tableContacts = new JTable();
        labelContactsCount = new JLabel();
    }

    private void loadContacts(){
        List<ContactEntity> contactList = contactController.getContactList();
        String columnNames[] = {"Name", "Telephone"};
        DefaultTableModel tableModel = new DefaultTableModel(new Object[0][0], columnNames);

        for (ContactEntity i : contactList){

            Object[] rows = new Object[2];
            rows[0] = i.getName();
            rows[1] = i.getTelephone();
            tableModel.addRow(rows);
        }
        tableContacts.clearSelection();
        tableContacts.setModel(tableModel);
        labelContactsCount.setText(contactController.getCountTable());
    }

    private void setListener(){
        buttonNewContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ContactForm();
                dispose();
            }
        });

        tableContacts.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()){
                    if (tableContacts.getSelectedRow() != -1){
                        name = tableContacts.getValueAt(tableContacts.getSelectedRow(), 0).toString();
                        telephone = tableContacts.getValueAt(tableContacts.getSelectedRow(), 1).toString();
                    }
                }
            }
        });

        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    contactController.deleteContact(name, telephone);
                    JOptionPane.showMessageDialog(null, "Contact deleted");
                    loadContacts();
                    cleanDatas();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    private void cleanDatas() {
        name = "";
        telephone = "";
    }
}
