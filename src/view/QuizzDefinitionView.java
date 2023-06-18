package view;

import controller.QuizzDefinitionController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author MSI VN
 */
public class QuizzDefinitionView extends JPanel {
public  JButton ansA;
    public  JButton ansB;
    public  JButton ansC;
    public  JButton ansD;
    public JLabel questionLabel;
    public JButton beginButton;
    public int traLoi;

    public QuizzDefinitionView(HashMap<String, String> dictionary) {
        this.setBackground(new Color(232, 241, 253));
        ActionListener ac = new QuizzDefinitionController(this);

        //TOP
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());

        JPanel sample = new JPanel();
        sample.setLayout(new BorderLayout());
        //sample.setBackground(Color.BLUE);
        //sample.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel tmp = new JPanel();
        beginButton = new JButton("BEGIN QUIZZ");
        beginButton.setBackground(new Color(60, 115, 99));
        beginButton.setFont(new Font("Arial", Font.BOLD, 25));
        beginButton.setFocusable(false);
        beginButton.setForeground(Color.LIGHT_GRAY);
        beginButton.setActionCommand("beginQuizz");
        beginButton.addActionListener(ac);
        tmp.add(beginButton);

        sample.add(tmp, BorderLayout.EAST);

        JPanel center = new JPanel();
        center.setLayout(new BorderLayout());
        center.setBorder(new EmptyBorder(10, 10, 10, 10));
        center.setBackground(new Color(184, 217, 208));

        questionLabel = new JLabel("NHẤN BEGIN ĐỂ BẮT ĐẦU", JLabel.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 40));
        questionLabel.setForeground(Color.BLUE);
        center.add(questionLabel, BorderLayout.CENTER);

        top.add(sample, BorderLayout.PAGE_START);
        top.add(center, BorderLayout.CENTER);

        //BOTs
        JPanel bot = new JPanel();
        bot.setLayout(new GridLayout(2, 2, 10, 10));
        bot.setBorder(new EmptyBorder(20, 20, 20, 20));

        ansA = new JButton("");
        ansB = new JButton("");
        ansC = new JButton("");
        ansD = new JButton("");
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

        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout());
        this.add(top, BorderLayout.PAGE_START);
        this.add(bot, BorderLayout.CENTER);
        khoiTaoGiaTriChoButton(dictionary);
    }

    public void khoiTaoGiaTriChoButton(HashMap<String, String> dictionary) {
        Random random = new Random();
        int answer = random.nextInt(0, 4);
        System.out.println("random: " + answer);

//            Set<String> keySet = this.rootPanel.dictionary.keySet();
//            for (String i : keySet) {
//                System.out.println(i + " : " + this.rootPanel.dictionary.get(i));
//            }
        int index = random.nextInt(dictionary.size());
        System.out.println(index);

    }
}

