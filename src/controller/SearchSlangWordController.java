package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import view.SearchSlangWordView;
import view.SlangWordView;

/**
 *
 * @author MSI VN
 */
public class SearchSlangWordController implements ActionListener{
    
    public SearchSlangWordView panel;
    public SlangWordView rootPanel;

    public SearchSlangWordController(SearchSlangWordView panel) {
        this.panel = panel;
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        System.out.println(src);
        
        if (src.equals("Find-Button")) {
            timkiem(this.rootPanel.dictionary, this.panel.findTextField.getText());
        }
        
    }
    
    
    public void timkiem(HashMap<String, String> dictionary, String str) {
        String ans = dictionary.get(str);
        this.panel.tuKhoa.setText(ans != null ? str : "Không tìm thấy (slang word)!");
        this.panel.yNghiaTu.setText(ans != null ? "==> " + ans : "Hãy thử tìm kiếm 1 từ khác (slang word)!");
    }
    
}
