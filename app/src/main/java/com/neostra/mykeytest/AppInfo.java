package com.neostra.mykeytest;

import android.graphics.drawable.Drawable;

public class AppInfo {
    private Drawable icon;// 应用图标
    private String appName;// 应用名称
    private String packageName;// 包名
    private boolean isChecked;

    public AppInfo(Drawable icon, String appName, String packageName) {
        super();
        this.icon = icon;
        this.appName = appName;
        this.packageName = packageName;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public boolean isChecked() {
        return isChecked;
    }
    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    @Override
    public String toString() {
        return "AppInfo [icon=" + icon + ", appName=" + appName
                + ", packageName=" + packageName + "]";
    }
}
