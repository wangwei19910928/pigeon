package com.vv.pigeon.ui.mainwindow;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class MainToolBar {
	
	
	public ToolBar init(Composite shell){
		ToolBar toolBar = new ToolBar(shell, SWT.FLAT);  
        final ToolItem add = new ToolItem(toolBar, SWT.PUSH);  
        add.setText("添加");  
//        add.setImage(new Image(toolBar.getDisplay(), "icons//add.gif"));  
        final ToolItem del = new ToolItem(toolBar, SWT.PUSH);  
        del.setText("删除");  
//        del.setImage(new Image(toolBar.getDisplay(), "icons//delete.gif"));  
        final ToolItem back = new ToolItem(toolBar, SWT.PUSH);  
        back.setText("上移");  
//        back.setImage(new Image(toolBar.getDisplay(), "icons//up.gif"));  
        final ToolItem forward = new ToolItem(toolBar, SWT.PUSH);  
        forward.setText("下移");  
//        forward.setImage(new Image(toolBar.getDisplay(), "icons//down.gif"));  
        final ToolItem save = new ToolItem(toolBar, SWT.PUSH);  
        save.setText("保存");  
//        save.setImage(new Image(toolBar.getDisplay(), "icons//save.gif"));
        
        return toolBar;
	}
}
