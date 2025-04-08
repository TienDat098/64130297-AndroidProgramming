package com.example.a64130297_thigiuaky;

import java.util.Date;

public class HoatDong {
    String tenHD;
    String   HDImageFileName;
    String thoigian;

    public HoatDong(String tenHD, String HDImageFileName, String thoigian) {
        this.tenHD = tenHD;
        this.HDImageFileName = HDImageFileName;
        this.thoigian = thoigian;
    }

    public String getTenHD() {
        return tenHD;
    }

    public void setTenHD(String tenHD) {
        this.tenHD = tenHD;
    }

    public String getHDImageFileName() {
        return HDImageFileName;
    }

    public void setHDImageFileName(String HDImageFileName) {
        this.HDImageFileName = HDImageFileName;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }
}
