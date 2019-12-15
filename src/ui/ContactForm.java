package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dimension.width/2 - getSize().width/2), (dimension.height/2 - getSize().height/2));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setListener();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        rootPanel = new JPanel();
        textFieldName = new JTextField();
        textFieldTelephone = new JTextField();
        buttonSave = new JButton();
        buttonCancel = new JButton();
    }

    private void setListener(){

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainFrame();
                dispose();
            }
        });

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    }
