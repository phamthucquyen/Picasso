package picasso.view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import picasso.parser.IdentifierAnalyzer;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Creates the variable list.
 * 
 * @author Alexandra Thorpe
 */
public class VariableDisplay {

	public VariableDisplay() {
		//list of map keys
		List<String> kList = new ArrayList<>();
		//list of map variables (expressions)
		List<String> vList = new ArrayList<>();
	
		//get the map of variables to their expressions
		Map<String, ExpressionTreeNode> map = IdentifierAnalyzer.getMapping();
		//get the set of keys from the map
		Set<String> keySet = map.keySet();
		
		
		//clear both lists every time the variable display is called to avoid duplicates
		//replace in IdentifierAnalyzer will handle the one-to-one mapping
		kList.clear();
		vList.clear();
			
		for (String key:keySet) {
				
			// ?? : assumption that x and y can't be a variable?
			if(!key.toString().equals("x")& !key.toString().equals("y")){
				//add the key to kList and it's mapped var to vList
					kList.add(key.toString());
					vList.add(map.get(key).toString());
			}
		}
		//System.out.println("keys: " + kList);
		//System.out.println("values: " + vList);	
	
		//get the lists to display
			
		//need to open a new window that can be closed
		JFrame frame1 = new JFrame("Variable List");
	 
	    // Initializing the JTable with a default table that has 
		// a number of rows equal to the number of keys
	    DefaultTableModel model = new DefaultTableModel(kList.size(), 0);
	    JTable table = new JTable(model);
	    
	    

	        
	    //Column Names
	  
	    
	    String[] columns = new String[] {"Variable", "Expression"};
	    
	    
	    model.setColumnIdentifiers(columns);
	    
	    JTableHeader jTableHeader = table.getTableHeader();
	    
	    Font font = new Font("Verdana", Font.BOLD, 12);
	    jTableHeader.setFont(font);
	    
	    table.setBackground(Color.darkGray);
	    table.setForeground(Color.white);

	    //add keys row by row to first column
	    int i=0;
	    for (String k:kList) {
	    	table.setValueAt(k, i, 0);
	        i+=1;
	        }
			
		//add expressions row by row to second column
		int n=0;
		for (String v:vList) {
	        table.setValueAt(v, n, 1);
	        n+=1;
	        }
	       
	    table.setBounds(30, 40, 200, 300);
	 
	    // adding it to JScrollPane
	    JScrollPane sp = new JScrollPane(table);
	    
	
	    frame1.add(sp);
	      
	    // Frame Size
	    frame1.setSize(500, 200);
			
	    frame1.setVisible(true);
			
		}

}
