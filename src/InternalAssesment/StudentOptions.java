package InternalAssesment;

import InternalAssesment.Activities.Activity;
import InternalAssesment.Activities.Creativity;
import InternalAssesment.Activities.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class StudentOptions extends JFrame implements ActionListener {

    private JFrame frame = new JFrame("Choose an option");
    private JButton creativityButton = new JButton("Creativity");
    private JButton activityButton = new JButton("Activity");
    private JButton serviceButton = new JButton("Service");

    // Constants for layout
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 250;
    private static final int BUTTON_WIDTH = 120;
    private static final int BUTTON_HEIGHT = 30;

    public StudentOptions() {
        setupFrame();
        setupLabels();
        setupButtons();
    }

    private void setupFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 350, FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.WHITE);
    }

    private void setupLabels() {
        frame.add(createImageLabel("resources/creativity.jpg", 20, 20, 150, 100));
        frame.add(createImageLabel("resources/activity.jpg", 180, 40, 135, 75));
        frame.add(createImageLabel("resources/service.jpg", 310, 40, 140, 85));
    }

    private JLabel createImageLabel(String resourcePath, int x, int y, int width, int height) {
        URL path = getClass().getResource(resourcePath);
        ImageIcon imgIcon = new ImageIcon(path);
        JLabel imgLabel = new JLabel(imgIcon);
        imgLabel.setBounds(x, y, width, height);
        return imgLabel;
    }

    private void setupButtons() {
        configureButton(creativityButton, 40, 150, e -> openCreativityWindow());
        configureButton(activityButton, 180, 150, e -> openActivityWindow());
        configureButton(serviceButton, 330, 150, e -> openServiceWindow());
    }

    private void configureButton(JButton button, int x, int y, ActionListener action) {
        button.setBounds(x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
        button.setFocusable(false);
        button.addActionListener(action);
        frame.add(button);
    }

    private void openCreativityWindow() {
        frame.dispose();
        new Creativity();
    }

    private void openActivityWindow() {
        frame.dispose();
        new Activity();
    }

    private void openServiceWindow() {
        frame.dispose();
        new Service();
    }
    public JFrame getFrame() {
        return frame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // No need for this method since actions are handled directly in button configuration
    }
}
