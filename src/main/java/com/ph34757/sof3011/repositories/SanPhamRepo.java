package com.ph34757.sof3011.repositories;

import com.ph34757.sof3011.entities.SanPham;
import com.ph34757.sof3011.utils.RepositoriesUtils;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class SanPhamRepo extends RepositoriesUtils<SanPham, Integer> {
    @Override
    public List<SanPham> getList() {
        String selectAll = "SELECT sp FROM SanPham sp";
        TypedQuery<SanPham> query = entityManager.createQuery(selectAll, SanPham.class);
        return query.getResultList();
    }

    @Override
    public List<SanPham> listActive() {
        return null;
    }

    @Override
    public SanPham findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public Class<SanPham> getEntityClass() {
        return SanPham.class;
    }

    @Override
    public void insert(SanPham sanPham) {
        super.insert(sanPham);
    }

    @Override
    public void update(SanPham sanPham) {
        super.update(sanPham);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }
}
