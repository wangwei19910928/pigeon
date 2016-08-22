package com.vv.pigeon.ui.mainwindow;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

public class MainMenu {
	
	private ViewForm viewForm;
	
	public MainMenu(ViewForm composite){
		this.viewForm = composite;
	}
	
	public Menu init(Shell shell){
		// 通过shell对象和SWT.BAR样式值来创建一个菜单条  
        Menu menu = new Menu(shell, SWT.BAR); 
        
        // 在菜单条的基础之上创建一个File的菜单  
        MenuItem file = new MenuItem(menu, SWT.CASCADE);  
        file.setText("&File");  
        // 先在Shell上创建一个下拉框，然后将下拉框添加到File菜单上  
        Menu filemenu = new Menu(shell, SWT.DROP_DOWN);  
        file.setMenu(filemenu); 
        // 在下拉框上创建菜单项Open  
        final MenuItem openItem = new MenuItem(filemenu, SWT.CASCADE);  
        openItem.setText("&Open");
        openItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(null != viewForm.getContent()){
					viewForm.getContent().dispose();
				}
//				 //添加数据表
		        PeopleView peopleView = new PeopleView();
		        Table table = peopleView.init(viewForm);
		        viewForm.setContent(table);
		        viewForm.pack();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
			}
		});
        // 在下拉框上创建菜单项Exit  
        MenuItem exitItem = new MenuItem(filemenu, SWT.PUSH);  
        exitItem.setText("&Exit");
        
        
        // 设置edit菜单  
        MenuItem edit = new MenuItem(menu, SWT.CASCADE);  
        edit.setText("&Edit");  
        Menu editmenu = new Menu(shell, SWT.DROP_DOWN);  
        edit.setMenu(editmenu);  
        MenuItem cutItem = new MenuItem(editmenu, SWT.PUSH);  
        cutItem.setText("&Cut\tCTRL+X");  
        // 设置快捷键  
        cutItem.setAccelerator(SWT.CTRL + 'X'); 
        cutItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				if(null != viewForm.getContent()){
					viewForm.getContent().dispose();
				}
//				 //添加数据表
		        PigeonView peopleView = new PigeonView();
		        Table table = peopleView.init(viewForm);
		        viewForm.setContent(table);
		        viewForm.pack();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        // 在菜单项之间创建一个分隔符  
        new MenuItem(editmenu, SWT.SEPARATOR);  
        MenuItem copyItem = new MenuItem(editmenu, SWT.PUSH);  
        copyItem.setText("&Copy\tCTRL+C");  
        // 设置快捷键  
        copyItem.setAccelerator(SWT.CTRL + 'C');  
        // 在菜单项之间创建一个分隔符  
        new MenuItem(editmenu, SWT.SEPARATOR);  
        MenuItem pasteItem = new MenuItem(editmenu, SWT.PUSH);  
        pasteItem.setText("&Paste\tCTRL+V");  
        // 设置快捷键  
        pasteItem.setAccelerator(SWT.CTRL + 'V');
        
        
        // 设置window菜单  
        MenuItem window = new MenuItem(menu, SWT.CASCADE);  
        window.setText("&Window");  
        Menu windowmenu = new Menu(shell, SWT.DROP_DOWN);  
        window.setMenu(windowmenu);  
        final MenuItem maxItem = new MenuItem(windowmenu, SWT.PUSH);  
        maxItem.setText("&Max");  
        // 在菜单项之间创建一个分隔符  
        new MenuItem(windowmenu, SWT.SEPARATOR);  
        MenuItem minItem = new MenuItem(windowmenu, SWT.PUSH);  
        minItem.setText("&Min");  
  
        // 设置help菜单  
        MenuItem help = new MenuItem(menu, SWT.CASCADE);  
        help.setText("&Help");  
        Menu helpmenu = new Menu(shell, SWT.DROP_DOWN);  
        help.setMenu(helpmenu);  
        MenuItem aboutItem = new MenuItem(helpmenu, SWT.PUSH);  
        aboutItem.setText("&About");
        
        
        return menu;
	}
}
