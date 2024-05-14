package Dijkstra_Algorithm;



public class Canh {
	
    private int trongSo;
    private Dinh dinhDau;
    private Dinh dinhCuoi;

// Khởi tạo
    public Canh(int trongSo, Dinh dinhDau, Dinh dinhCuoi) {
        this.trongSo = trongSo;
        this.dinhDau = dinhDau;
        this.dinhCuoi = dinhCuoi;
    }
// Khởi tạo
    
// Getter & Setter
    public double getTrongSo() {
        return trongSo;
    }

    public void setTrongSo(int trongSo) {
        this.trongSo = trongSo;
    }

    public Dinh getDinhDau() {
        return dinhDau;
    }

    public void setDinhDau(Dinh dinhDau) {
        this.dinhDau = dinhDau;
    }

    public Dinh getDinhCuoi() {
        return dinhCuoi;
    }

    public void setDinhCuoi(Dinh dinhCuoi) {
        this.dinhCuoi = dinhCuoi;
    }
// Getter & Setter
}