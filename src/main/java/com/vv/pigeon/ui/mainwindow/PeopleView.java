package com.vv.pigeon.ui.mainwindow;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class PeopleView {
	
	
	public Table init(Composite composite){
		 int COLUMNS_CNT = 3;  
	     int ROWS_CNT = 3;
		Table table = new Table(composite, SWT.None);  
        
      table.setHeaderVisible(true);  
      table.setLinesVisible(true);   
        
      // step2: add columns  
      for (int i = 0; i < COLUMNS_CNT; i++)  
      {  
          new TableColumn(table, SWT.CENTER).setText("TableColumn" + (i + 1));  
          table.getColumn(i).pack();  
      }  
        
      TableItem item = null;  
        
      // step3: add rows  
      for (int row = 0; row < ROWS_CNT; row++)  
      {  
          item = new TableItem(table, SWT.NONE);  
          for (int col = 0; col < COLUMNS_CNT; col++)  
          {  
              item.setText(col, "TableItem-" + (row + 1) + "-" + (col + 1));  
          }  
      } 
        
		return table;
	}
}
