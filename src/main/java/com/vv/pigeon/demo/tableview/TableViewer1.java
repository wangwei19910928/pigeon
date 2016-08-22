package com.vv.pigeon.demo.tableview;


import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class TableViewer1 {
	
	
	public static void main(String[] args) {  
        new TableViewer1().open();  
    }  
    public void open() {  
        final Display display = new Display();  
        final Shell shell = new Shell();  
        shell.setSize(300, 650);  
        // ------------------------------------------  
        shell.setLayout(new GridLayout());  
        // 第一步：创建一个TableViewer对象。式样：MULTI可多选、H_SCROLL有水平滚动条、V_SCROLL有垂直滚动条、BORDER有边框、FULL_SELECTION整行选择  
        TableViewer tv = new TableViewer(shell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
        // 第二步：通过表格内含的Table对象设置布局方式  
        Table table = tv.getTable();  
        table.setHeaderVisible(true); // 显示表头  
        table.setLinesVisible(true); // 显示表格线  
        final GridData gdTable = new GridData(0, 110);// 为了固定table的高度为110(正好5行)  
        gdTable.horizontalAlignment = GridData.FILL;  
        gdTable.grabExcessHorizontalSpace = true;// 横向充满  
        table.setLayoutData(gdTable);
        // 第三步：用TableColumn类创建表格列  
        final TableColumn newColumnTableColumn = new TableColumn(table, SWT.NONE);
        newColumnTableColumn.setWidth(39);
        newColumnTableColumn.setText("ID");

        final TableColumn newColumnTableColumn_1 = new TableColumn(table, SWT.NONE);
        newColumnTableColumn_1.setWidth(85);
        newColumnTableColumn_1.setText("姓名");
        
        final TableColumn newColumnTableColumn_2 = new TableColumn(table, SWT.NONE);
        newColumnTableColumn_2.setWidth(41);
        newColumnTableColumn_2.setText("性别");

        final TableColumn newColumnTableColumn_3 = new TableColumn(table, SWT.NONE);
        newColumnTableColumn_3.setWidth(43);
        newColumnTableColumn_3.setText("年龄");

        final TableColumn newColumnTableColumn_4 = new TableColumn(table, SWT.NONE);
        newColumnTableColumn_4.setWidth(126);
        newColumnTableColumn_4.setText("创建日期"); 
        // 第四步：设置内容器和标签器  
        tv.setContentProvider(new TableViewerContentProvider());  
        tv.setLabelProvider(new TableViewerLabelProvider());  
        // 第五步：用TableViewer的setInput方法将数据输入到表格  
        Object data = PeopleFactory.getPeoples();  
        tv.setInput(data);  
        // ------------------------------------------ 
        
        shell.open();  
        while (!shell.isDisposed()) {  
            if (!display.readAndDispatch())  
                display.sleep();  
        }  
        display.dispose();  
    }
}
