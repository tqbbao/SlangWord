package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;
import view.SearchDefinitionView;
import view.SlangWordView;

/**
 *
 * @author MSI VN
 */
public class SearchDefinitionController implements ActionListener{
    public SearchDefinitionView panel;
    public SlangWordView rootPanel;

    public SearchDefinitionController(SearchDefinitionView panel) {
        this.panel = panel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        System.out.println(src);
        timkiemdefinition(this.rootPanel.dictionary, this.panel.findTextField.getText());
    }
    
    public void timkiemdefinition(HashMap<String, String> dictionary, String str){
        Vector<String> results = new Vector<>();

        dictionary.forEach((slang, meaning) -> {
            if (meaning.contains(str))
                results.add(slang);
        });

        if (results.isEmpty()) {
            this.panel.tuKhoa.setText("No slang!");
            this.panel.yNghiaTu.setText("Try another slang!");
        } else{
            System.out.println("List dang co gia tri");
            System.out.println(results);
            this.panel.resultList.setListData(results);
        }
        
        
    }
    
}
