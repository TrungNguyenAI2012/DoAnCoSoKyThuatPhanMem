package Dijkstra_Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Dinh implements Comparable<Dinh> {

	private String ten;
    private List<Canh> danhSachCanh;
    private boolean daXet;
    private int tongTrongSo = Integer.MAX_VALUE;
    private Dinh dinhKe;

// Khởi tạo
    public Dinh(String ten) {
        this.ten = ten;
        this.danhSachCanh = new ArrayList<>();
    }
// Khởi tạo
    
// Getter & Setter
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    
    public List<Canh> getDanhSachCanh() {
        return danhSachCanh;
    }

    public void setDanhSachCanh(List<Canh> danhSachCanh) {
        this.danhSachCanh = danhSachCanh;
    }

    public boolean getDaXet() {
        return daXet;
    }
    
    public void setDaXet(boolean daXet) {
        this.daXet = daXet;
    }

    public double getTongTrongSo() {
        return tongTrongSo;
    }

    public void setTongTrongSo(int tongTrongSo) {
        this.tongTrongSo = tongTrongSo;
    }
    
    public Dinh getDinhKe() {
        return dinhKe;
    }

    public void setDinhKe(Dinh dinhKe) {
        this.dinhKe = dinhKe;
    }
// Getter & Setter
    
    // Thêm cạnh vào danh sách cạnh
    public void themCanh(Canh canh) {
        this.danhSachCanh.add(canh);
    }
    
    @Override
    public String toString() {
        return this.ten;
    }

    @Override
    public int compareTo(Dinh dinhKhac) {
        return Double.compare(this.tongTrongSo, dinhKhac.getTongTrongSo());
    }
}