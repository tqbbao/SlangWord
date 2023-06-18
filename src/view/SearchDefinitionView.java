package view;

import controller.SearchDefinitionController;
import controller.SearchSlangWordController;
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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author MSI VN
 */
public class SearchDefinitionView extends JPanel {

    public JLabel tuKhoa;
    public JLabel yNghiaTu;
    public JButton findButton;
    public JTextField findTextField;
    public JList<String> resultList;
    public JScrollPane scrollPane;

    public SearchDefinitionView(HashMap<String, String> dictionary) {
        this.setBackground(new Color(232, 241, 253));
        ActionListener ac = new SearchDefinitionController(this);
        findTextField = new JTextField(25);
        Font fo = new Font("Serif", Font.BOLD, 25);
        // set the font of the textfield
        findTextField.setFont(fo);

        findButton = new JButton("Find");
        findButton.setActionCommand("FindFind");
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

        //Center Panel
        resultList = new JList<>();
        resultList.setFont(new Font("Arial", Font.BOLD, 25));
        scrollPane = new JScrollPane(resultList);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());
        resultPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Kết quả tìm kiếm:"));
        resultPanel.add(scrollPane, BorderLayout.CENTER);

        // Slang Panel
        tuKhoa = new JLabel();
        tuKhoa.setFont(new Font("Arial", Font.PLAIN, 30));
        tuKhoa.setForeground(Color.BLUE);
        tuKhoa.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        yNghiaTu = new JLabel();
        yNghiaTu.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        JPanel center = new JPanel();
        center.setBackground(new Color(184, 217, 208));
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setBorder(new EmptyBorder(5, 5, 5, 5));

        center.add(tuKhoa);
        center.add(yNghiaTu);

        // Settings and Add components to panel
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout());

        this.add(top, BorderLayout.PAGE_START);
        this.add(resultPanel, BorderLayout.CENTER);
        //this.add(center, BorderLayout.PAGE_END);
    }
}
