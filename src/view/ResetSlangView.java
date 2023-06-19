package view;

import controller.ResetSlangController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author MSI VN
 */
public class ResetSlangView extends JPanel {

    public JButton resetButton;

    public ResetSlangView(HashMap<String, String> dictionary) {
        this.setBackground(new Color(232, 241, 253));
        ActionListener ac = new ResetSlangController(this);

        //===========================
        JPanel a = new JPanel();
        a.setLayout(new FlowLayout(FlowLayout.CENTER));
        a.setBackground(new Color(184, 217, 208));

        JLabel titleLabel = new JLabel("KHÔI PHỤC DỮ LIỆU BAN ĐẦU", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(new Color(60, 115, 99));
        a.add(titleLabel);
        //==================================
        JPanel chinh = new JPanel();
        chinh.setLayout(new BorderLayout());
        chinh.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Bắt đầu dữ liệu mới"));

        JPanel b = new JPanel();

        b.setLayout(new FlowLayout(FlowLayout.RIGHT));
        b.setBorder(new EmptyBorder(20, 20, 0, 20));
        resetButton = new JButton("RESET SLANG");
        resetButton.setBackground(new Color(60, 115, 99));
        resetButton.setFont(new Font("Arial", Font.BOLD, 25));
        resetButton.setFocusable(false);
        resetButton.setForeground(Color.LIGHT_GRAY);
        resetButton.setActionCommand("reset");
        resetButton.addActionListener(ac);
        b.add(resetButton);
        chinh.add(b);

//        JPanel center = new JPanel();
//        center.setLayout(new BorderLayout());
//        center.setBorder(new EmptyBorder(30, 50, 30, 50));
//
//        JPanel tmp = new JPanel();
//        resetButton = new JButton("RESET SLANG");
//        resetButton.setBackground(new Color(60, 115, 99));
//        resetButton.setFont(new Font("Arial", Font.BOLD, 25));
//        resetButton.setFocusable(false);
//        resetButton.setForeground(Color.LIGHT_GRAY);
//        resetButton.setActionCommand("reset");
//        resetButton.addActionListener(ac);
//        tmp.add(resetButton);
//
//        center.add(tmp, BorderLayout.EAST);

        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout());

        this.add(a, BorderLayout.PAGE_START);
        this.add(chinh, BorderLayout.CENTER);

    }

}
