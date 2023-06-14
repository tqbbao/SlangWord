package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author MSI VN
 */
public class SlangWordView extends JFrame {

    public SlangWordView() {
        this.setTitle("MainFrame");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        createAndShowGUI();

        this.setVisible(true);
    }

    public void createAndShowGUI() {

        JPanel jPanel_top = new JPanel();
        jPanel_top.setLayout(new BorderLayout());
        jPanel_top.setBackground(Color.LIGHT_GRAY);

        JPanel jPanel_center = new JPanel();
        jPanel_center.setLayout(new BorderLayout());
        jPanel_center.setBackground(Color.DARK_GRAY);
        jPanel_center.setBorder(new EmptyBorder(5, 5, 5, 5));

        JButton functionButton01 = new JButton("Find by slang");
        JLabel titleLabel = new JLabel("S L A N G ----- W O R D S", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setTabPlacement(JTabbedPane.LEFT);
        tabbedPane.setFont(new Font("Arial", Font.BOLD, 25));

        //
        JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9, panel10;
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();
        panel8 = new JPanel();
        panel9 = new JPanel();
        panel10 = new JPanel();
        tabbedPane.setBackground(Color.yellow);
        tabbedPane.setForeground(Color.black);
        tabbedPane.addTab("Find by slang", panel1);
        tabbedPane.addTab("Find by definition", panel2);
        tabbedPane.addTab("History", panel3);
        tabbedPane.addTab("Add a slang", panel4);
        tabbedPane.addTab("Edit a slang", panel5);
        tabbedPane.addTab("Delete a slang", panel6);
        tabbedPane.addTab("Reset dictionary", panel7);
        tabbedPane.addTab("On this day slang", panel8);
        tabbedPane.addTab("Guess meaning", panel9);
        tabbedPane.addTab("Guess slang", panel10);
        
        //tabbedPane.setEnabledAt(2, false);
        //tabbedPane.setEnabledAt(5, false);

        //
        jPanel_top.add(titleLabel, BorderLayout.PAGE_START);
        jPanel_center.add(tabbedPane, BorderLayout.CENTER);

        this.add(jPanel_top, BorderLayout.NORTH);
        this.add(jPanel_center, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        new SlangWordView();
    }

}
