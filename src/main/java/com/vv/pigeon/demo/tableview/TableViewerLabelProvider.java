package com.vv.pigeon.demo.tableview;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.vv.pigeon.constant.SystemConstant;

public class TableViewerLabelProvider implements ITableLabelProvider {  
    // 创建几个图像  
    private Image[] images = new Image[] {  
            new Image(null, this.getClass().getResourceAsStream(SystemConstant.logoImage)),  
            new Image(null, this.getClass().getResourceAsStream(SystemConstant.logoImage)),  
            new Image(null, this.getClass().getResourceAsStream(SystemConstant.logoImage)) };  
    // 由此方法决定数据记录在表格的每一列显示什么文字。  
    // element参数是一个实体类对象。col是当前要设置的列的列号，0是第一列。  
    public String getColumnText(Object element, int col) {  
        PeopleEntity o = (PeopleEntity) element; // 类型转换  
        if (col == 0)// 第一列要显示什么数据  
            return o.getId().toString();  
        if (col == 1)  
            return o.getName();  
        if (col == 2)  
            return o.isSex() ? "男" : "女";  
        if (col == 3)  
            return String.valueOf(o.getAge()); // 将int型转为String型  
        if (col == 4)  
            return o.getCreateDate().toString();  
        return null; // 方法可以返回空值  
    }  
    // getColumnText方法用于显示文字，本方法用于显示图片。  
    public Image getColumnImage(Object element, int col) {  
        PeopleEntity o = (PeopleEntity) element;  
        // 只让“陈刚”这条记录显示图片  
        if (o.getName().equals("陈刚") || o.getName().equals("周阅")) {  
            if (col == 0)// 第一列要显示的图片  
                return images[0];  
            if (col == 2)// 根据性别显示不同的图标  
                return o.isSex() ? images[1] : images[2];  
        }  
        return null; // 方法可以返回空值  
    }  
    public void dispose() {  
        // 别忘了SWT组件的原则：自己创建，自释放  
        for (Image image : images) {  
            image.dispose();  
        }  
    }  
    // -------------以下方法很少使用,先不用管，让它们空实现-----------------  
    public boolean isLabelProperty(Object element, String property) {  
        return false;  
    }  
    public void addListener(ILabelProviderListener listener) {  
    }  
    public void removeListener(ILabelProviderListener listener) {  
    }  
} 
