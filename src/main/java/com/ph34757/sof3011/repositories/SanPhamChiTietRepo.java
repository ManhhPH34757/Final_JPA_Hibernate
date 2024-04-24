package com.ph34757.sof3011.repositories;

import com.ph34757.sof3011.entities.Ctsp;
import com.ph34757.sof3011.utils.RepositoriesUtils;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class SanPhamChiTietRepo extends RepositoriesUtils<Ctsp, Integer> {
    @Override
    public List<Ctsp> getList() {
        return null;
    }

    @Override
    public List<Ctsp> listActive() {
        String selectAll = "SELECT ctsp FROM Ctsp ctsp WHERE ctsp.trangThai = :trangThai";
        TypedQuery<Ctsp> query = entityManager.createQuery(selectAll, Ctsp.class);
        query.setParameter("trangThai", "Active");
        List<Ctsp> list = query.getResultList();
        return list;
    }

    public List<Ctsp> listActive1(int page) {
        String selectAll = "SELECT ctsp FROM Ctsp ctsp WHERE ctsp.trangThai = :trangThai";
        TypedQuery<Ctsp> query = entityManager.createQuery(selectAll, Ctsp.class);
        query.setParameter("trangThai", "Active");
        int pageSize = 2; // Số lượng bản ghi trên mỗi trang
        // Thiết lập vị trí bắt đầu và số lượng bản ghi tối đa
        query.setFirstResult((page-1) * pageSize);
        query.setMaxResults(pageSize);
        List<Ctsp> list = query.getResultList();
        return list;
    }

    public List<Ctsp> getListCTSP(int idSanPham){
        String selectAll = "SELECT ctsp FROM Ctsp ctsp WHERE ctsp.idSp = :idSanPham";
        TypedQuery<Ctsp> query = entityManager.createQuery(selectAll, Ctsp.class);
        query.setParameter("idSanPham", idSanPham);
        List<Ctsp> list = query.getResultList();
        return list;
    }

    @Override
    public Ctsp findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public Class<Ctsp> getEntityClass() {
        return Ctsp.class;
    }

    @Override
    public void insert(Ctsp ctsp) {
        super.insert(ctsp);
    }

    @Override
    public void update(Ctsp ctsp) {
        super.update(ctsp);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

    public List<Ctsp> findByName(String findTenSP, String findTenDanhMuc, String findTenMau, String findTenSize){
        String filter = "SELECT ctsp FROM Ctsp ctsp WHERE ctsp.sanPhamByIdSp.tenSanPham LIKE :findTenSP AND ctsp.sanPhamByIdSp.danhMucByIdDanhMuc.tenDanhMuc LIKE :findTenDanhMuc AND ctsp.mauSacByIdMauSac.tenMau LIKE :findTenMau AND ctsp.sizeByIdSize.tenSize LIKE :findTenSize AND ctsp.trangThai = :trangThai";
        TypedQuery<Ctsp> query = entityManager.createQuery(filter, Ctsp.class);
        if (findTenSP == null || findTenSP.trim().isEmpty()){
            query.setParameter("findTenSP", "%%");
        }else {
            query.setParameter("findTenSP", "%"+findTenSP+"%");
        }
        if (findTenDanhMuc == null || findTenDanhMuc.trim().isEmpty()){
            query.setParameter("findTenDanhMuc", "%%");
        }else {
            query.setParameter("findTenDanhMuc", findTenDanhMuc);
        }
        if (findTenMau == null || findTenMau.trim().isEmpty()){
            query.setParameter("findTenMau", "%%");
        }else {
            query.setParameter("findTenMau", findTenMau);
        }
        if (findTenSize == null || findTenSize.trim().isEmpty()){
            query.setParameter("findTenSize", "%%");
        }else {
            query.setParameter("findTenSize", findTenSize);
        }
        query.setParameter("trangThai","Active");
        List<Ctsp> list = query.getResultList();
        return list;
    }

}
