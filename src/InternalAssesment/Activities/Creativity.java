package InternalAssesment.Activities;

import InternalAssesment.StudentOptions;
import InternalAssesment.UserDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Creativity extends JFrame implements ActionListener {

    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 230;
    private static final int LABEL_X = 20;
    private static final int LABEL_Y_OFFSET = 40;
    private static final int COMBOBOX_X = 250;
    private static final int COMPONENT_WIDTH = 120;
    private static final int COMPONENT_HEIGHT = 30;

    private JFrame frame;
    private JLabel lblCreativityOptions;
    private JButton back;
    private JComboBox<String> newspaperComboBox;
    private JComboBox<String> debateComboBox;
    private JComboBox<String> tripComboBox;

    private String[] userProgress = {"Done", "Doing", "To do", "Not selected"};

    public Creativity() {
        setupFrame();
        addLabels();
        setupComboBoxes();
        initializeComboBoxes();
        setupBackButton();
    }

    private void setupFrame() {
        frame = new JFrame("Choose user");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 350, FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.WHITE);
    }

    private void addLabels() {
        lblCreativityOptions = createLabel("Creativity options:", 135, 10);
        frame.add(lblCreativityOptions);

        frame.add(createLabel("School newspaper", LABEL_X, LABEL_Y_OFFSET));
        frame.add(createLabel("How to debate brochure", LABEL_X, LABEL_Y_OFFSET + 40));
        frame.add(createLabel("Organize a trip", LABEL_X, LABEL_Y_OFFSET + 80));
    }

    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 400, COMPONENT_HEIGHT);
        return label;
    }

    private void setupComboBoxes() {
        newspaperComboBox = configureComboBox(COMBOBOX_X, LABEL_Y_OFFSET, e -> updateProgress(UserDB.getLoggedUser().newspaperCreativityIndex, newspaperComboBox));
        debateComboBox = configureComboBox(COMBOBOX_X, LABEL_Y_OFFSET + 40, e -> updateProgress(UserDB.getLoggedUser().debateCreativityIndex, debateComboBox));
        tripComboBox = configureComboBox(COMBOBOX_X, LABEL_Y_OFFSET + 80, e -> updateProgress(UserDB.getLoggedUser().tripCreativityIndex, tripComboBox));
    }

    private JComboBox<String> configureComboBox(int x, int y, ActionListener actionListener) {
        JComboBox<String> comboBox = new JComboBox<>(userProgress);
        comboBox.setBounds(x, y, COMPONENT_WIDTH, COMPONENT_HEIGHT);
        comboBox.setFocusable(false);
        comboBox.addActionListener(actionListener);
        frame.add(comboBox);
        return comboBox;
    }

    private void updateProgress(int index, JComboBox<String> comboBox) {
        UserDB.getLoggedUser().progress[index] = String.valueOf(comboBox.getSelectedItem());
    }

    private void initializeComboBoxes() {
        setComboBoxSelection(newspaperComboBox, UserDB.getLoggedUser().newspaperCreativityIndex);
        setComboBoxSelection(debateComboBox, UserDB.getLoggedUser().debateCreativityIndex);
        setComboBoxSelection(tripComboBox, UserDB.getLoggedUser().tripCreativityIndex);
    }

    private void setComboBoxSelection(JComboBox<String> comboBox, int index) {
        int selectedIndex = UserDB.indexOf(userProgress, UserDB.getLoggedUser().progress[index]);
        if (selectedIndex >= 0) {
            comboBox.setSelectedIndex(selectedIndex);
        }
    }

    private void setupBackButton() {
        back = new JButton("Back");
        back.setBounds(COMBOBOX_X, LABEL_Y_OFFSET + 120, COMPONENT_WIDTH, COMPONENT_HEIGHT);
        back.setFocusable(false);
        back.addActionListener(this);
        frame.add(back);
    }

    public JFrame getFrame() {
        return frame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            UserDB.Save();
            frame.dispose();
            new StudentOptions();
        }
    }
}
