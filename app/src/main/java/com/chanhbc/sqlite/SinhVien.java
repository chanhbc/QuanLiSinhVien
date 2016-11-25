package com.chanhbc.sqlite;

public class SinhVien {
    private String id;
    private String name;
    private int toan;
    private int li;
    private int hoa;
    private int tong;

    public SinhVien(String id, String name, int toan, int li, int hoa) {
        this.id = id;
        this.name = name;
        this.toan = toan;
        this.li = li;
        this.hoa = hoa;
        tong = toan + li + hoa;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getToan() {
        return toan;
    }

    public int getLi() {
        return li;
    }

    public int getHoa() {
        return hoa;
    }

    public int getTong() {
        return tong;
    }
}
