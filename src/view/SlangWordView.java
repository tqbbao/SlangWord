package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author MSI VN
 */
public class SlangWordView extends JFrame {

    public static HashMap<String, String> dictionary = new HashMap<String, String>();

    public static Vector<String> historySlangs = new Vector<>();
    //public static final String FILENAME = "slang.txt";
    public static final String FILENAME1 = "slang.txt";
    public static final String FILENAME_TUDIEN = "tudien.dat";
    public static final String FILENAME_LICHSU = "lichsu.dat";

    JLabel slangLabel;

    public void loadData() {

        FileInputStream fin = null;
        ObjectInputStream ois = null;

        try {
            fin = new FileInputStream(FILENAME_TUDIEN);
            ois = new ObjectInputStream(fin);
            dictionary = (HashMap<String, String>) ois.readObject();

        } catch (FileNotFoundException ex) {

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
                }

                //Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex1) {
                Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (IOException ex1) {
                Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex1);
            } finally {
                if (fr != null) {
                    try {
                        fr.close();
                    } catch (IOException ex1) {
                        Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException ex1) {
                        Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("2");
            Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException ex) {
                    Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public void loadHistory() {
        FileInputStream fin = null;
        ObjectInputStream ois = null;
        try {
            fin = new FileInputStream(FILENAME_LICHSU);
            ois = new ObjectInputStream(fin);
            historySlangs = (Vector<String>) ois.readObject();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException ex) {
                    Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public SlangWordView() {
        loadData();
        loadHistory();
//        for (Map.Entry<String, String> s : dictionary.entrySet()) {
                //            System.out.println(s.getKey() + " : " + s.getValue());
                //        }
        this.setTitle("MainFrame");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1100, 600);
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
        titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
        titleLabel.setForeground(new Color(60, 115, 99));

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setTabPlacement(JTabbedPane.LEFT);
        tabbedPane.setFont(new Font("Arial", Font.BOLD, 25));

        //
        SearchSlangWordView p1 = new SearchSlangWordView(dictionary);
        SearchDefinitionView p2 = new SearchDefinitionView(dictionary);
        HistoryView p3 = new HistoryView(historySlangs);
        
        CRUDView p5 = new CRUDView(dictionary);
        ResetSlangView p7 = new ResetSlangView(dictionary);
        QuizzSlangView p9 = new QuizzSlangView(dictionary);
        
        

        JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9, panel10;
        panel1 = new JPanel();
        panel1.setBackground(Color.red);
        panel2 = new JPanel();
        panel2.setBackground(Color.green);
        panel2.setLayout(new BorderLayout());

        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();
        panel8 = new JPanel();
        panel9 = new JPanel();
        panel10 = new JPanel();

        //
        JPanel t = new JPanel();
        JPanel b = new JPanel();
        t.setLayout(new FlowLayout());
        t.setBackground(Color.blue);
        b.setLayout(new BorderLayout());
        b.setBackground(Color.green);
        slangLabel = new JLabel();
        slangLabel.setFont(new Font("Arial", Font.PLAIN, 30));

        JTextField findTextField = new JTextField(30);
        Font fo = new Font("Serif", Font.BOLD, 20);

        // set the font of the textfield
        findTextField.setFont(fo);

        JButton findButton = new JButton("Find");
        findButton.setSize(WIDTH, HEIGHT);
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ans = dictionary.get(findTextField.getText());
                slangLabel.setText(ans);
                System.out.println(ans);
            }

        });

        t.add(findTextField);
        t.add(Box.createHorizontalStrut(5));
        t.add(findButton);
        b.add(slangLabel);

        panel2.add(t, BorderLayout.NORTH);
        panel2.add(b, BorderLayout.CENTER);

        tabbedPane.setBackground(new Color(184, 217, 208));
        tabbedPane.setForeground(new Color(0, 0, 0));
        tabbedPane.addTab("Tìm kiếm theo slangword", p1);
        tabbedPane.addTab("Tìm kiếm theo definition", p2);
        tabbedPane.addTab("Lịch sử tìm kiếm", p3);
        tabbedPane.addTab("--------------", panel4);
        tabbedPane.addTab("Edit-Delete", p5);
        tabbedPane.addTab("Reset Slang", p7);
        tabbedPane.addTab("Ramdom 1 SlangWord", panel7);
        tabbedPane.addTab("Quizz Slang", p9);
        tabbedPane.addTab("--------------", panel9);
        tabbedPane.addTab("--------------", panel10);

        tabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                System.out.println("Tab: " + tabbedPane.getSelectedIndex());
                System.out.println(historySlangs);
            }
        });

        //tabbedPane.setEnabledAt(2, false);
        //tabbedPane.setEnabledAt(5, false);
        //
        jPanel_top.add(titleLabel, BorderLayout.PAGE_START);
        jPanel_center.add(tabbedPane, BorderLayout.CENTER);

        this.add(jPanel_top, BorderLayout.NORTH);
        this.add(jPanel_center, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                windowClosingEventHandler();
            }
        });

    }

    //luu history
    //Khi thoat chuong trinh thi se luu dictionary vao lai file
    public void windowClosingEventHandler() {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try {
            fout = new FileOutputStream(FILENAME_TUDIEN);
            oos = new ObjectOutputStream(fout);

            oos.writeObject(dictionary);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException ex) {
                    Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        //
        FileOutputStream fout_lichsu = null;
        ObjectOutputStream oos_lichsu = null;
        try {
            fout_lichsu = new FileOutputStream(FILENAME_LICHSU);
            oos_lichsu = new ObjectOutputStream(fout_lichsu);

            oos_lichsu.writeObject(historySlangs);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fout_lichsu != null) {
                try {
                    fout_lichsu.close();
                } catch (IOException ex) {
                    Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (oos_lichsu != null) {
                try {
                    oos_lichsu.close();
                } catch (IOException ex) {
                    Logger.getLogger(SlangWordView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public static void main(String[] args) {
        new SlangWordView();
    }

}
