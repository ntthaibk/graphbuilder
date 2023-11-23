package mdaq;

import lombok.extern.slf4j.Slf4j;
import mdaq.google.Coordinator;
import mdaq.google.DistancePair;
import mdaq.google.GoogleApiRequestSender;
import mdaq.google.PlusCodeJunction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        GoogleApiRequestSender googleApiRequestSender = new GoogleApiRequestSender();

        var bachKhoa = new PlusCodeJunction("BK", "7P28QMC5+R5");
        var THTxLyThuongKiet = new PlusCodeJunction("THTxLyThuongKiet", "7P28QMC5+67");
        var ltkx3t2 = new PlusCodeJunction("LTKx3/2", "7P28QM75+GX");
        var thanhthaixngogiatu = new PlusCodeJunction("ThanhThaixNgoGiaTu", "7P28QM59+XH");
        var lehongphongxlythaito = new PlusCodeJunction("LeHongPhongxLyThaiTo", "7P28QM9F+3Q");
        var dbpxcmt8 = new PlusCodeJunction("DBPxCMT8", "7P28QMGM+MF");
        var ntmkxcmt8 = new PlusCodeJunction("NTMKxCMT8", "7P28QMFQ+CQ");
        var thtxthanhthai = new PlusCodeJunction("THTxThanhThai", "7P28QMG7+HC");
        var thanhthaix3t2 = new PlusCodeJunction("ThanhThaix3/2", "7P28QM98+4R");
        var cmt8x3t2 = new PlusCodeJunction("CMT8x3/2", "7P28QMHJ+3PH");
        var thtxcmt8 = new PlusCodeJunction("THTxCMT8", "7P28QMMC+5R");
        var thtxsuvanhanh = new PlusCodeJunction("THTxSuVanHanh", "7P28QMH8+567");
        var suvanhanhx3t2 = new PlusCodeJunction("SuVanHanhx3/2", "7P28QM9C+V85");
        var lehongphongx3t2 = new PlusCodeJunction("3/2xLeHongPhong", "7P28QMCF+96");
        var lythaitoxntmk = new PlusCodeJunction("LyThaiToxNTMK", "7P28QM8J+5M");
        var cmt8xlytutrong = new PlusCodeJunction("CMT8xLyTuTrong", "7P28QMCV+H9");
        var lytutrongxnguyentrungtruc = new PlusCodeJunction("LyTuTrongxNguyenTrungTruc", "7P28QMFX+W7");
        var nguyentrungtrucxleloi = new PlusCodeJunction("NguyenTrungTrucxLeLoi", "7P28QMFX+8WG");
        var leloixphanboichau = new PlusCodeJunction("LeLoixPhanBoiChau", "7P28QMCX+WG8");
        var lytutrongxthukhoahuan = new PlusCodeJunction("LyTuTrongxThuKhoaHuan", "7P28QMFW+HRX");
        var thukhoahuanxlethanhton = new PlusCodeJunction("ThuKhoaHuanxLeThanhTon", "7P28QMFX+732");
        var truongdinhxlytutrong = new PlusCodeJunction("TruongDinhxLyTuTrong", "7P28QMFW+45P");
        var chobenthanh = new PlusCodeJunction("ChoBenThanh", "7P28QMCX+Q8X");

        List<DistancePair> distancePair = new ArrayList<>();

        distancePair.add(new DistancePair(thtxthanhthai, thtxsuvanhanh));
        distancePair.add(new DistancePair(thtxsuvanhanh, thtxcmt8));
        distancePair.add(new DistancePair(thtxcmt8, cmt8x3t2));
        distancePair.add(new DistancePair(thtxsuvanhanh, suvanhanhx3t2));
        distancePair.add(new DistancePair(lehongphongx3t2, suvanhanhx3t2));
        distancePair.add(new DistancePair(suvanhanhx3t2, cmt8x3t2));
        distancePair.add(new DistancePair(cmt8x3t2, dbpxcmt8));
//        distancePair.add(new DistancePair(bachKhoa, THTxLyThuongKiet)); //BK -> THTxLyThuongKiet
//        distancePair.add(new DistancePair(THTxLyThuongKiet, ltkx3t2)); //BK -> LTKx3/2
//        distancePair.add(new DistancePair(ltkx3t2, thanhthaix3t2)); //LTKx3/2 -> ThanhThaix3/2
//        distancePair.add(new DistancePair(thanhthaix3t2, thanhthaixngogiatu)); //ThanhThaix3/2 -> ThanhThaixNgoGiaTu
//        distancePair.add(new DistancePair(thanhthaixngogiatu, lehongphongxlythaito)); //ThanhThaixNgoGiaTu -> LeHongPhongxLyThaiTo
//        distancePair.add(new DistancePair(lehongphongxlythaito, dbpxcmt8)); //LeHongPhongxLyThaiTo -> DBPxCMT8
//        distancePair.add(new DistancePair(dbpxcmt8, ntmkxcmt8)); //DBPxCMT8 -> NTMKxCMT8
//        distancePair.add(new DistancePair(THTxLyThuongKiet, thtxthanhthai)); // THTxLyThuongKiet -> THTxThanhThai
//        distancePair.add(new DistancePair(thtxthanhthai, thanhthaix3t2)); // THTxThanhThai -> ThanhThaix3/2
//        distancePair.add(new DistancePair(thanhthaix3t2, lehongphongx3t2)); // ThanhThaix3/2 -> 3/2xLeHongPhong
//        distancePair.add(new DistancePair(lehongphongx3t2, lehongphongxlythaito)); // 3/2xLeHongPhong -> LeHongPhongxLyThaiTo
//        distancePair.add(new DistancePair(lehongphongxlythaito, lythaitoxntmk)); // LeHongPhongxLyThaiTo -> LyThaiToxNTMK
//        distancePair.add(new DistancePair(lythaitoxntmk, ntmkxcmt8)); // LyThaiToxNTMK -> NTMKxCMT8
//        distancePair.add(new DistancePair(ntmkxcmt8, cmt8xlytutrong));// NTMKxCMT8 -> CMT8xLyTuTrong
//        distancePair.add(new DistancePair(lytutrongxthukhoahuan, lytutrongxnguyentrungtruc)); // LyTuTrongxThuKhoaHUan -> LyTuTrongxNguyenTrungTruc
//        distancePair.add(new DistancePair(lytutrongxnguyentrungtruc, nguyentrungtrucxleloi)); // LyTuTrongxNguyenTrungTruc -> NguyenTrungTrucxLeLoi
//        distancePair.add(new DistancePair(nguyentrungtrucxleloi, leloixphanboichau)); // NguyenTrungTrucxLeLoi -> LeLoixPhanBoiChau
//        distancePair.add(new DistancePair(lytutrongxthukhoahuan, thukhoahuanxlethanhton)); // LyTuTrongxThuKhoaHuan -> ThuKhoaHuanxLeThanhTon
//        distancePair.add(new DistancePair(cmt8xlytutrong, truongdinhxlytutrong));
//        distancePair.add(new DistancePair(truongdinhxlytutrong, lytutrongxthukhoahuan));
//        distancePair.add(new DistancePair(leloixphanboichau, chobenthanh)); // LeLoixPhanBoiChau -> ChoBenThanh


        List<Coordinator> coordinators = new ArrayList<>();

        distancePair.forEach(
                pair -> {
                    try {
                        coordinators.add(googleApiRequestSender.getDistanceBetweenCoordinators(pair));
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }

        );

        coordinators.forEach(coordinator -> log.info("Distance between origin {}-{} and destination {}-{} is [{}]", coordinator.getOrigin().getJunctionName(), coordinator.getOrigin().getPlusCode(), coordinator.getDestination().getJunctionName(), coordinator.getDestination().getPlusCode(), coordinator.getDistance()));


    }
}