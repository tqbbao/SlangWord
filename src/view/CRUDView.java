package view;

import controller.CRUDController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author MSI VN
 */
public class CRUDView extends JPanel {

    public JButton findButton;
    public JTextField findTextField;
    public JTextField slangTextField;
    public JTextField meaningTextField;
    public JButton editButton;
    public JButton deleteButton;

    public CRUDView(HashMap<String, String> dictionary) {
        this.setBackground(new Color(232, 241, 253));
        ActionListener ac = new CRUDController(this);
        findTextField = new JTextField(25);
        Font fo = new Font("Serif", Font.BOLD, 25);
        // set the font of the textfield
        findTextField.setFont(fo);

        findButton = new JButton("TÌM KIẾM");
        findButton.setActionCommand("Find");
        findButton.addActionListener(ac);
        findButton.setBackground(new Color(60, 115, 99));
        findButton.setFont(new Font("Arial", Font.BOLD, 25));
        findButton.setFocusable(false);
        findButton.setForeground(Color.LIGHT_GRAY);

        JPanel top = new JPanel();
        top.setLayout(new FlowLayout());
        top.setBackground(new Color(184, 217, 208));

        top.add(findTextField);
        top.add(Box.createHorizontalStrut(5));
        top.add(findButton);

        JPanel center = new JPanel();
        center.setLayout(new BorderLayout());
        center.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Cập nhật hoặc Xóa:"));

        //
        JLabel label_tuKhoa = new JLabel("Slang: ");
        JLabel label_yNghia = new JLabel("Meaning: ");
        label_tuKhoa.setFont(new Font("Arial", Font.BOLD, 25));
        label_yNghia.setFont(new Font("Arial", Font.BOLD, 25));

        slangTextField = new JTextField("");
        slangTextField.setEditable(false);
        slangTextField.setFont(fo);
        JPanel slangPanel = new JPanel();
        slangPanel.setLayout(new BoxLayout(slangPanel, BoxLayout.X_AXIS));
        slangPanel.add(label_tuKhoa);
        slangPanel.add(Box.createHorizontalStrut(38));
        slangPanel.add(slangTextField);

        meaningTextField = new JTextField();
        meaningTextField.setFont(fo);
        JPanel meaningPanel = new JPanel();
        meaningPanel.setLayout(new BoxLayout(meaningPanel, BoxLayout.X_AXIS));
        meaningPanel.add(label_yNghia);
        meaningPanel.add(Box.createHorizontalStrut(5));
        meaningPanel.add(meaningTextField);

        editButton = new JButton("CẬP NHẬT");
        editButton.setBackground(new Color(60, 115, 99));
        editButton.setFont(new Font("Arial", Font.BOLD, 25));
        editButton.setFocusable(false);
        editButton.setForeground(Color.LIGHT_GRAY);
        editButton.setActionCommand("edit");
        editButton.addActionListener(ac);
        deleteButton = new JButton("XÓA");
        deleteButton.setBackground(new Color(60, 115, 99));
        deleteButton.setFont(new Font("Arial", Font.BOLD, 25));
        deleteButton.setFocusable(false);
        deleteButton.setForeground(Color.LIGHT_GRAY);
        deleteButton.setActionCommand("delete");
        deleteButton.addActionListener(ac);

        JPanel buttonPanel = new JPanel();
        //buttonPanel.setBackground(Color.yellow);

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setBorder(new EmptyBorder(10, 50, 10, 50));

        buttonPanel.add(editButton);
        buttonPanel.add(Box.createHorizontalStrut(20));
        buttonPanel.add(deleteButton);

        JPanel tmp = new JPanel();
        tmp.setLayout(new BorderLayout());
        tmp.add(buttonPanel, BorderLayout.PAGE_START);

        JPanel informationPanel = new JPanel();
        //informationPanel.setBackground(Color.BLUE);
        informationPanel.setLayout(new BoxLayout(informationPanel, BoxLayout.Y_AXIS));
        informationPanel.setBorder(new EmptyBorder(30, 50, 30, 50));
        informationPanel.add(slangPanel);
        informationPanel.add(Box.createVerticalStrut(10));
        informationPanel.add(meaningPanel);

        center.add(informationPanel, BorderLayout.PAGE_START);
        center.add(tmp, BorderLayout.EAST);

        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout());

        this.add(top, BorderLayout.PAGE_START);
        this.add(center, BorderLayout.CENTER);

    }

}
