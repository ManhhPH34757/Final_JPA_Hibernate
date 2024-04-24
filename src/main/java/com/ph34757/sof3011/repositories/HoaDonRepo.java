package com.ph34757.sof3011.repositories;

import com.ph34757.sof3011.entities.Hdct;
import com.ph34757.sof3011.entities.HoaDon;
import com.ph34757.sof3011.utils.RepositoriesUtils;
import jakarta.persistence.TypedQuery;

import java.math.BigDecimal;
import java.util.List;

public class HoaDonRepo extends RepositoriesUtils<HoaDon, Integer> {
    @Override
    public List<HoaDon> getList() {
        return null;
    }

    @Override
    public List<HoaDon> listActive() {
        String billPaids = "SELECT hd FROM HoaDon hd WHERE hd.trangThai = :trangThai";
        TypedQuery<HoaDon> query = entityManager.createQuery(billPaids, HoaDon.class);
        query.setParameter("trangThai","Paid");
        List<HoaDon> list = query.getResultList();
        return list;
    }

    public List<HoaDon> listUnPaid() {
        String billPaids = "SELECT hd FROM HoaDon hd WHERE hd.trangThai = :trangThai";
        TypedQuery<HoaDon> query = entityManager.createQuery(billPaids, HoaDon.class);
        query.setParameter("trangThai","Unpaid");
        List<HoaDon> list = query.getResultList();
        return list;
    }

    @Override
    public HoaDon findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public Class<HoaDon> getEntityClass() {
        return HoaDon.class;
    }

    @Override
    public void insert(HoaDon hoaDon) {
        super.insert(hoaDon);
    }

    @Override
    public void update(HoaDon hoaDon) {
        super.update(hoaDon);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

    public BigDecimal tongTien(int idHD){
        HoaDonChiTietRepo hoaDonChiTietRepo = new HoaDonChiTietRepo();
        List<Hdct> list = hoaDonChiTietRepo.listHDCTByIdHD(idHD);
        BigDecimal tongTien = BigDecimal.ZERO;
        for (Hdct hdct : list) {
            tongTien = tongTien.add(hdct.getTongTien());
        }
        return tongTien;
    }

}
