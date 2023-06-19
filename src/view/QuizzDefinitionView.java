package view;

import controller.QuizzDefinitionController;
import controller.QuizzSlangController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author MSI VN
 */
public class QuizzDefinitionView extends JPanel {
public JButton ansA;
    public JButton ansB;
    public JButton ansC;
    public JButton ansD;
    public JLabel questionLabel;
    public JButton beginButton;
    public int traLoi;

    public QuizzDefinitionView(HashMap<String, String> dictionary) {
        this.setBackground(new Color(232, 241, 253));
        ActionListener ac = new QuizzDefinitionController(this);
        //===============================================================
        JPanel a = new JPanel();
        a.setLayout(new FlowLayout(FlowLayout.RIGHT));
        a.setBackground(new Color(184, 217, 208));
        a.setBorder(new EmptyBorder(5, 10, 5, 10));
        beginButton = new JButton("BEGIN QUIZZ");
        beginButton.setBackground(new Color(60, 115, 99));
        beginButton.setFont(new Font("Arial", Font.BOLD, 25));
        beginButton.setFocusable(false);
        beginButton.setForeground(Color.LIGHT_GRAY);
        beginButton.setActionCommand("beginQuizz");
        beginButton.addActionListener(ac);
        a.add(beginButton);
        //=================================================================
        JPanel chinh = new JPanel();
        chinh.setLayout(new BorderLayout());
        chinh.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Trò chơi đoán Definition"));
        JPanel c = new JPanel();
        c.setLayout(new FlowLayout(FlowLayout.CENTER));
        c.setBorder(new EmptyBorder(10, 10, 0, 10));
        questionLabel = new JLabel("NHẤN BEGIN ĐỂ BẮT ĐẦU", JLabel.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 50));
        questionLabel.setForeground(new Color(60, 115, 99));
        c.add(questionLabel);

        JPanel bot = new JPanel();
        bot.setLayout(new GridLayout(2, 2, 10, 10));
        bot.setBorder(new EmptyBorder(20, 20, 20, 20));

        ansA = new JButton("");
        ansB = new JButton("");
        ansC = new JButton("");
        ansD = new JButton("");
        ansA.setPreferredSize(new Dimension(40, 100));
        ansB.setPreferredSize(new Dimension(40, 100));
        ansC.setPreferredSize(new Dimension(40, 100));
        ansD.setPreferredSize(new Dimension(40, 100));
        ansA.setBackground(Color.lightGray);
        ansB.setBackground(Color.lightGray);
        ansC.setBackground(Color.lightGray);
        ansD.setBackground(Color.lightGray);
        ansA.setFocusable(false);
        ansB.setFocusable(false);
        ansC.setFocusable(false);
        ansD.setFocusable(false);
        ansA.setFont(new Font("Arial", Font.BOLD, 15));
        ansB.setFont(new Font("Arial", Font.BOLD, 15));
        ansC.setFont(new Font("Arial", Font.BOLD, 15));
        ansD.setFont(new Font("Arial", Font.BOLD, 15));

        ansA.setActionCommand("Ans_A");
        ansA.addActionListener(ac);
        ansB.setActionCommand("Ans_B");
        ansB.addActionListener(ac);
        ansC.setActionCommand("Ans_C");
        ansC.addActionListener(ac);
        ansD.setActionCommand("Ans_D");
        ansD.addActionListener(ac);
        bot.add(ansA);
        bot.add(ansB);
        bot.add(ansC);
        bot.add(ansD);
        
        
        
        
        
        JPanel meaningPanel = new JPanel();
        meaningPanel.setLayout(new BoxLayout(meaningPanel, BoxLayout.Y_AXIS));
        meaningPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        meaningPanel.add(c);
        meaningPanel.add(Box.createVerticalStrut(15));
        meaningPanel.add(bot);
        chinh.add(meaningPanel, BorderLayout.PAGE_START);


        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout());
        this.add(a, BorderLayout.PAGE_START);
        this.add(chinh, BorderLayout.CENTER);
    }

}
