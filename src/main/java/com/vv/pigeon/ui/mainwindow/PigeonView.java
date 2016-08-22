package com.vv.pigeon.ui.mainwindow;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class PigeonView {
	
	
	public Table init(Composite composite){
		int COLUMNS_CNT = 8;  
	     int ROWS_CNT = 900;
	     GridData griddata = new GridData(SWT.FILL,SWT.FILL,true,true,1,1);
		Table table = new Table(composite, SWT.FULL_SELECTION|SWT.MULTI|SWT.V_SCROLL|SWT.H_SCROLL|SWT.BORDER);  
     table.setHeaderVisible(true);  
     table.setLayoutData(griddata);
     table.setLinesVisible(true);   
     // step2: add columns  
     for (int i = 0; i < COLUMNS_CNT; i++)  
     {  
         new TableColumn(table, SWT.CENTER).setText("表头" + (i + 1)); 
         table.getColumn(i).setWidth(100);
//         table.getColumn(i).pack();  
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
