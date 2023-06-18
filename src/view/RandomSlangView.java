package view;

import controller.RandomSlangController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.HashMap;
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
public class RandomSlangView extends JPanel {

    public JButton randomButton;
    public JLabel tuKhoa;
    public JLabel yNghiaTu;

    public RandomSlangView(HashMap<String, String> dictionary) {
        this.setBackground(new Color(232, 241, 253));
        ActionListener ac = new RandomSlangController(this);

        //TOP
        JPanel top = new JPanel();
        top.setLayout(new FlowLayout(FlowLayout.RIGHT));
        top.setBackground(new Color(184, 217, 208));
        top.setBorder(new EmptyBorder(5, 10, 5, 10));

        randomButton = new JButton("RANDOM");
        randomButton.setBackground(new Color(60, 115, 99));
        randomButton.setFont(new Font("Arial", Font.BOLD, 25));
        randomButton.setFocusable(false);
        randomButton.setForeground(Color.LIGHT_GRAY);
        randomButton.setActionCommand("random");
        randomButton.addActionListener(ac);

        top.add(randomButton);
        //CENTER
        JPanel center = new JPanel();
        center.setLayout(new BorderLayout());
        center.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Mỗi ngày 1 Slang Word:"));

        JPanel a = new JPanel();
        a.setLayout(new FlowLayout(FlowLayout.CENTER));
        tuKhoa = new JLabel("Slang");
        JPanel b = new JPanel();
        b.setLayout(new FlowLayout(FlowLayout.CENTER));
        yNghiaTu = new JLabel("Meaning");
        tuKhoa.setFont(new Font("Arial", Font.BOLD, 50));
        yNghiaTu.setFont(new Font("Arial", Font.BOLD, 30));
        tuKhoa.setForeground(new Color(60, 115, 99));

        a.add(tuKhoa);
        b.add(yNghiaTu);

        JPanel meaningPanel = new JPanel();
        meaningPanel.setLayout(new BoxLayout(meaningPanel, BoxLayout.Y_AXIS));
        meaningPanel.setBorder(new EmptyBorder(30, 50, 30, 50));

        meaningPanel.add(a);
        meaningPanel.add(Box.createVerticalStrut(15));
        meaningPanel.add(b);

        center.add(meaningPanel, BorderLayout.PAGE_START);

        //ROOT
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout());
        this.add(top, BorderLayout.PAGE_START);
        this.add(center, BorderLayout.CENTER);

    }

}
