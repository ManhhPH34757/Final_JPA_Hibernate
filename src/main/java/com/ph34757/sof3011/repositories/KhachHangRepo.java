package com.ph34757.sof3011.repositories;

import com.ph34757.sof3011.entities.KhachHang;
import com.ph34757.sof3011.utils.RepositoriesUtils;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class KhachHangRepo extends RepositoriesUtils<KhachHang, Integer> {
    @Override
    public List<KhachHang> getList() {
        String selectAll = "SELECT kh FROM KhachHang kh ORDER BY kh.ngayTao DESC";
        TypedQuery<KhachHang> query = entityManager.createQuery(selectAll, KhachHang.class);
        List<KhachHang> list = query.getResultList();
        return list;
    }

    @Override
    public List<KhachHang> listActive() {
        return null;
    }

    @Override
    public KhachHang findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public Class<KhachHang> getEntityClass() {
        return KhachHang.class;
    }

    @Override
    public void insert(KhachHang khachHang) {
        super.insert(khachHang);
    }

    @Override
    public void update(KhachHang khachHang) {
        super.update(khachHang);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

    public List<KhachHang> filter(String name, String address, String phone){
        String filter = "SELECT kh FROM KhachHang kh WHERE kh.hoTen LIKE :name AND kh.diaChi LIKE :address AND kh.sdt LIKE :phone";
        TypedQuery<KhachHang> query = entityManager.createQuery(filter, KhachHang.class);
        if (name == null || name.trim().isEmpty()){
            query.setParameter("name", "%%");
        }else {
            query.setParameter("name", "%" + name + "%");
        }
        if (address == null || address.trim().isEmpty()){
            query.setParameter("address", "%%");
        }else {
            query.setParameter("address", "%" + address + "%");
        }
        if (phone == null || phone.trim().isEmpty()){
            query.setParameter("phone", "%%");
        }else {
            query.setParameter("phone",phone + "%");
        }
        List<KhachHang> list = query.getResultList();

        return list;
    }

    public List<KhachHang> findByPhoneNumber(String phoneNumber){
        String filter = "SELECT kh FROM KhachHang kh WHERE ( kh.hoTen LIKE :find OR kh.sdt LIKE :find ) AND kh.trangThai = :trangThai";
        TypedQuery<KhachHang> query = entityManager.createQuery(filter, KhachHang.class);
        if (phoneNumber == null || phoneNumber.trim().isEmpty()){
            query.setParameter("find", "%%");
        }else {
            query.setParameter("find", "%" + phoneNumber + "%");
        }
        query.setParameter("trangThai","Active");
        List<KhachHang> list = query.getResultList();
        return list;
    }

    public KhachHang getKhachHang() {
        String selectAll = "SELECT kh FROM KhachHang kh WHERE kh.trangThai = :trangThai ORDER BY kh.id DESC";
        TypedQuery<KhachHang> query = entityManager.createQuery(selectAll, KhachHang.class);
        query.setParameter("trangThai","Active");
        query.setMaxResults(1);
        KhachHang khachHang = query.getSingleResult();
        return khachHang;
    }

}
