package com.example.android.computerstoreapp.bo;

import com.example.android.computerstoreapp.R;

import java.util.HashMap;

/**
 * Created by android on 2017-10-27.
 */

public class MenuBO {

    private static HashMap<Integer,String> menuList ;
    private final static String KeyboardClassName = "KeyboardView";
    private final static String CPUClassName = "CPUView";
    private final static String MemoryClassName = "MemoryView";
    private final static String MonitorClassName = "MonitorView";
    private final static String NotebookClassName = "NotebookView";
    private final static String DesktopClassName = "DesktopView";
    private final static String MouseClassName="MouseView";


    public MenuBO() {
        menuList= new HashMap<>();
        intiMenuMap();
    }

    private void intiMenuMap(){
        menuList.put(R.id.menu_desktop,DesktopClassName);
        menuList.put(R.id.menu_cpu,CPUClassName);
        menuList.put(R.id.menu_keyboard,KeyboardClassName);
        menuList.put(R.id.menu_memory,MemoryClassName);
        menuList.put(R.id.menu_monitor,MonitorClassName);
        menuList.put(R.id.menu_notebook,NotebookClassName);
        menuList.put(R.id.menu_mouse,MouseClassName);
    }

    public  String getMenuName(int id){

        return menuList.get(id);
    }

}
