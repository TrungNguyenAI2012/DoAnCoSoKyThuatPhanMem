package Dijkstra_Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ThuatToanDijkstra {
	
	  public void xetCanhNganNhat(PriorityQueue<Dinh> hangDoiDinh, Dinh dinhDangXet) {
    	for (Canh canh : dinhDangXet.getDanhSachCanh()) {
            Dinh dinh = canh.getDinhCuoi();
            if (!dinh.getDaXet()) {
                int trongSo = (int) (dinhDangXet.getTongTrongSo() + canh.getTrongSo());
                if (trongSo < dinh.getTongTrongSo()) {
                	hangDoiDinh.remove(dinh);
                    dinh.setTongTrongSo(trongSo);
                    dinh.setDinhKe(dinhDangXet);
                    hangDoiDinh.add(dinh);
                }
            }
        }
    }
	
    public void duongDiNganNhat(Dinh dinhNguon) {
    	dinhNguon.setTongTrongSo(0);
        PriorityQueue<Dinh> hangDoiDinh = new PriorityQueue<>();
        hangDoiDinh.add(dinhNguon);
        dinhNguon.setDaXet(true);
        while (!hangDoiDinh.isEmpty()) {
            Dinh dinhDangXet = hangDoiDinh.poll();
            xetCanhNganNhat(hangDoiDinh, dinhDangXet);
            dinhDangXet.setDaXet(true);
        }
    }
    
    public List<Dinh> layDuongDiNganNhat(Dinh dinhDich) {
        List<Dinh> duongDi = new ArrayList<>();
        for (Dinh dinh = dinhDich; dinh != null; dinh = dinh.getDinhKe())
        	duongDi.add(dinh);
        Collections.reverse(duongDi);
        return duongDi;
    }
}