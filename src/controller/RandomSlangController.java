package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import view.RandomSlangView;
import view.SlangWordView;

/**
 *
 * @author MSI VN
 */
public class RandomSlangController implements ActionListener {

    public SlangWordView rootPanel;
    public RandomSlangView panel;

    public RandomSlangController(RandomSlangView panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("random")) {
            randomSlang();
        }
    }

    public void randomSlang() {
        Random random = new Random();
        Set<String> keySet = this.rootPanel.dictionary.keySet();
        List<String> keyList = new ArrayList<>(keySet);
        int size = keyList.size();
        int randIdx = new Random().nextInt(size);
        String randomKey = keyList.get(randIdx);
        String randomValue = this.rootPanel.dictionary.get(randomKey);
        this.panel.yNghiaTu.setText(randomValue);
        this.panel.tuKhoa.setText(randomKey);
    }

}
