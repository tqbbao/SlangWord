package view;

import controller.AddSlangController;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author MSI VN
 */
public class AddSlangView extends JPanel {

    public JTextField slangTextField;
    public JTextField meaningTextField;
    public JButton addButton;

    public AddSlangView(HashMap<String, String> dictionary) {
        this.setBackground(new Color(232, 241, 253));
        Font fo = new Font("Serif", Font.BOLD, 25);
        ActionListener ac = new AddSlangController(this);
        JPanel center = new JPanel();
        center.setLayout(new BorderLayout());
        center.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Thêm từ mới:"));

        JLabel label_tuKhoa = new JLabel("Slang: ");
        JLabel label_yNghia = new JLabel("Meaning: ");
        label_tuKhoa.setFont(new Font("Arial", Font.BOLD, 25));
        label_yNghia.setFont(new Font("Arial", Font.BOLD, 25));
        slangTextField = new JTextField("");
        //slangTextField.setEditable(false);
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

        JPanel informationPanel = new JPanel();
        informationPanel.setLayout(new BoxLayout(informationPanel, BoxLayout.Y_AXIS));
        informationPanel.setBorder(new EmptyBorder(30, 50, 30, 50));
        informationPanel.add(slangPanel);
        informationPanel.add(Box.createVerticalStrut(10));
        informationPanel.add(meaningPanel);

        JPanel a = new JPanel();
        a.setLayout(new FlowLayout(FlowLayout.RIGHT));
        a.setBorder(new EmptyBorder(5, 10, 5, 10));
        addButton = new JButton("THÊM");
        addButton.setBackground(new Color(60, 115, 99));
        addButton.setFont(new Font("Arial", Font.BOLD, 25));
        addButton.setFocusable(false);
        addButton.setForeground(Color.LIGHT_GRAY);
        addButton.setActionCommand("add");
        addButton.addActionListener(ac);

        a.add(addButton);

        JPanel chinh = new JPanel();
        chinh.setLayout(new BoxLayout(chinh, BoxLayout.Y_AXIS));
        chinh.setBorder(new EmptyBorder(10, 50, 10, 50));

        chinh.add(informationPanel);
        chinh.add(Box.createVerticalStrut(10));
        chinh.add(a);

        center.add(chinh, BorderLayout.PAGE_START);

        //
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout());

        this.add(center, BorderLayout.CENTER);

    }

}
