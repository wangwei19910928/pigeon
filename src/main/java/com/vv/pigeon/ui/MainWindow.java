package com.vv.pigeon.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;

import com.vv.pigeon.constant.SystemConstant;
import com.vv.pigeon.ui.mainwindow.MainMenu;
import com.vv.pigeon.ui.mainwindow.MainToolBar;

public class MainWindow {
	
	
	private void init(){
		//初始化主页面
		final Display display = Display.getDefault();
		final Shell shell = new Shell(display);
        shell.setLayout(new GridLayout());
        shell.setBounds(Display.getDefault().getPrimaryMonitor().getClientArea());
        Image image = new Image(display, this.getClass().getResourceAsStream(SystemConstant.logoImage));
        shell.setText(SystemConstant.logoText);
        shell.setImage(image);
        //初始化快捷工具条
        MainToolBar mainToolBar = new MainToolBar();
        ToolBar toolBar = mainToolBar.init(shell);
        toolBar.pack();
        //公共的显示panel
        ViewForm viewForm = new ViewForm(shell, SWT.NONE);
        viewForm.setSize(500, 100);
        //初始化菜单
        MainMenu mainMenu = new MainMenu(viewForm);
        shell.setMenuBar(mainMenu.init(shell));
        
        
        
        
        
        //退出事件的确认
        shell.addShellListener(new ShellAdapter() {
            public void shellClosed(final ShellEvent e) {
                MessageBox messageBox = new MessageBox(shell,
                        SWT.ICON_WARNING | SWT.OK | SWT.CANCEL);
                messageBox.setText("确定");
                messageBox.setMessage("你确定要退出吗？");
                int rc = messageBox.open();
                if (rc == SWT.CANCEL) {
                    e.doit = false;
                }
            }
        });
        shell.open();
//        shell.layout();
        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
                display.sleep();
        }
	}
	
	
	public static void main(String[] args) {
		MainWindow m = new MainWindow();
		m.init();
	}
}
