package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author MSI VN
 */
public class SlangWordView extends JFrame {

    Map<String, String> dictionary = new TreeMap<String, String>();
    public static final String FILENAME = "slang.txt";
    public static final String FILENAME1 = "slang1.txt";

    public void loadData() {
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(FILENAME1);
            br = new BufferedReader(fr);
            System.out.println(br.readLine());
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                String[] tmp = line.split("`");
                if (tmp.length == 2) {
                    dictionary.put(tmp[0], tmp[1]);
                }
                //System.out.println(line);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ex) {
                    Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public SlangWordView() {
        loadData();
        
        for (Map.Entry<String, String> s : dictionary.entrySet()){
            System.out.println(s.getKey() + " : " + s.getValue()); 
            //System.out.print(s.getValue()); 
        }
        
        
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
        jPanel_center.setBackground(Color.LIGHT_GRAY);
        jPanel_center.setBorder(new EmptyBorder(5, 5, 5, 5));

        JButton functionButton01 = new JButton("Find by slang");
        JLabel titleLabel = new JLabel("S L A N G       W O R D S", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setTabPlacement(JTabbedPane.LEFT);
        tabbedPane.setFont(new Font("Arial", Font.BOLD, 25));

        //
        JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9, panel10;
        panel1 = new JPanel();
        panel1.setBackground(Color.red);
        panel2 = new JPanel();
        panel2.setBackground(Color.green);
        panel2.setLayout(new FlowLayout());

        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();
        panel8 = new JPanel();
        panel9 = new JPanel();
        panel10 = new JPanel();

        //
        JTextField findTextField = new JTextField(30);
        Font fo = new Font("Serif", Font.BOLD, 20);

        // set the font of the textfield
        findTextField.setFont(fo);

        JButton findButton = new JButton("Find");
        findButton.setSize(WIDTH, HEIGHT);

        panel2.add(findTextField);
        panel2.add(Box.createHorizontalStrut(5));

        panel2.add(findButton);

        tabbedPane.setBackground(Color.LIGHT_GRAY);
        tabbedPane.setForeground(Color.black);
        tabbedPane.addTab("Tìm kiếm theo slangword", panel1);
        tabbedPane.addTab("Tìm kiếm theo definition", panel2);
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
