package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author MSI VN
 */
public class HistoryView extends JPanel {

    public JLabel tuKhoa;
    public JLabel yNghiaTu;
    public static JList<String> historyList;
    public JScrollPane scrollPane;

    public HistoryView(Vector<String> historySlangs) {
        this.setBackground(new Color(232, 241, 253));

        tuKhoa = new JLabel("sdfsdfsdfsfsdfsdfsdf");
        tuKhoa.setFont(new Font("Arial", Font.PLAIN, 30));
        tuKhoa.setForeground(Color.BLUE);
        tuKhoa.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        yNghiaTu = new JLabel("Safsdfsdfsdfsadfsdfsdf");
        yNghiaTu.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        JPanel top = new JPanel();
        top.setBackground(new Color(184, 217, 208));
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        top.setBorder(new EmptyBorder(5, 5, 5, 5));

        top.add(tuKhoa);
        top.add(yNghiaTu);

        //
        JPanel center = new JPanel();
        center.setLayout(new BorderLayout());
        center.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Những từ bạn đã tìm kiếm:"));

        historyList = new JList<>(historySlangs);
        historyList.setFont(new Font("Arial", Font.BOLD, 25));

        scrollPane = new JScrollPane(historyList);

        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        scrollPane.setBackground(new Color(184, 217, 208));
        center.add(scrollPane, BorderLayout.CENTER);
        center.setBackground(new Color(184, 217, 208));
        ///////////////////////////////////////////////////////////////
        JLabel khoiPhuc = new JLabel("LỊCH SỬ TÌM KIẾM");
        khoiPhuc.setFont(new Font("Arial", Font.BOLD, 30));
        khoiPhuc.setForeground(new Color(60, 115, 99));
        JPanel a = new JPanel();
        a.setLayout(new FlowLayout(FlowLayout.CENTER));
        a.setBackground(new Color(184, 217, 208));
        a.setFont(new Font("Arial", Font.BOLD, 25));
        a.setBorder(new EmptyBorder(5, 10, 5, 10));
        a.add(khoiPhuc);
        ////////////////////////////////////////////////////////////
        JPanel b = new JPanel();
        b.setLayout(new BorderLayout());
        b.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Những từ bạn đã tìm kiếm:"));
        historyList = new JList<>(historySlangs);
        historyList.setFont(new Font("Arial", Font.BOLD, 25));

        scrollPane = new JScrollPane(historyList);

        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        b.add(scrollPane, BorderLayout.CENTER);
        
        
        

        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setLayout(new BorderLayout());

        this.add(a, BorderLayout.PAGE_START);
        //this.add(center, BorderLayout.CENTER);
        this.add(b, BorderLayout.CENTER);

    }

}
