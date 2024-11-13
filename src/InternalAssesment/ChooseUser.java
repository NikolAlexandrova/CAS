package InternalAssesment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ChooseUser extends JFrame implements ActionListener {

    private JFrame frame = new JFrame("Choose user");
    private JButton teacherBtn = new JButton("Teacher");
    private JButton studentBtn = new JButton("Student");
    private JLabel positionLbl = new JLabel("What is your position in the school?");
    private URL path = getClass().getResource("resources/newhello.jpg");
    private ImageIcon imgIcon = new ImageIcon(path);
    private JLabel imgLbl = new JLabel(imgIcon);

    ChooseUser(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 350, 400,200 );
        frame.setLayout(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setVisible(true);

        imgLbl.setBounds(150, 20, 100, 60);
        frame.add(imgLbl);

        teacherBtn.setBounds(40, 120, 120, 30);
        teacherBtn.setFocusable(false);
        teacherBtn.addActionListener(this);
        frame.add(teacherBtn);

        studentBtn.setBounds(220, 120, 120, 30);
        studentBtn.setFocusable(false);
        studentBtn.addActionListener(this);
        frame.add(studentBtn);

        positionLbl.setBounds(70, 80, 400, 30);
        frame.add(positionLbl);

    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == teacherBtn){
            frame.dispose();
            LogInTeacher myWindow = new LogInTeacher();
        }
        if (e.getSource() == studentBtn){
            frame.dispose();
            Student myWindow = new Student();
        }
    }
}
