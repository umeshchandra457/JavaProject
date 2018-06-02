package collegeprojectJF;

import collegeproject.Results;
import collegeproject.Allcomponents;
import java.awt.Container;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

public class InfoExam extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel pageTitleLabel = null;
    DefaultListModel<String> list = new DefaultListModel<String>();
    Allcomponents manager = new Allcomponents();

    InfoExam(String title) {
        this.setBounds(10, 10, 810, 510);
        container.setLayout(null);
        List<Results> tests = manager.getAllTests();
        for (Results t : tests) {
            list.addElement(t.toString());
        }
        JList<String> testsList = new JList<String>(list);
        pageTitleLabel = new JLabel(title);
        pageTitleLabel.setBounds(20, 10, 500, 50);
        testsList.setBounds(20, 50, 600, 300);
        container.add(pageTitleLabel);
        container.add(testsList);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
