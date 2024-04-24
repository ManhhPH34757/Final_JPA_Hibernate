package com.ph34757.sof3011.repositories;

import com.ph34757.sof3011.entities.DanhMuc;
import com.ph34757.sof3011.utils.RepositoriesUtils;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DanhMucRepo extends RepositoriesUtils<DanhMuc, Integer> {
    @Override
    public void insert(DanhMuc danhMuc) {
        super.insert(danhMuc);
    }

    @Override
    public void update(DanhMuc danhMuc) {
        super.update(danhMuc);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

    @Override
    public Class<DanhMuc> getEntityClass() {
        return DanhMuc.class;
    }

    @Override
    public List<DanhMuc> getList() {
        String selectAll = "SELECT dm FROM DanhMuc dm";
        TypedQuery<DanhMuc> query = entityManager.createQuery(selectAll, DanhMuc.class);
        List<DanhMuc> list = query.getResultList();
        return list;
    }

    @Override
    public List<DanhMuc> listActive() {
        String selectAll = "SELECT dm FROM DanhMuc dm WHERE dm.trangThai = :trangThai";
        TypedQuery<DanhMuc> query = entityManager.createQuery(selectAll, DanhMuc.class);
        query.setParameter("trangThai","Active");
        List<DanhMuc> list = query.getResultList();
        return list;
    }

    @Override
    public DanhMuc findById(Integer id) {
        return super.findById(id);
    }
}
