package com.ph34757.sof3011.repositories;

import com.ph34757.sof3011.entities.Size;
import com.ph34757.sof3011.utils.RepositoriesUtils;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class SizeRepo extends RepositoriesUtils<Size, Integer> {
    @Override
    public List<Size> getList() {
        String selectAll = "SELECT s FROM Size s";
        TypedQuery<Size> query = entityManager.createQuery(selectAll, Size.class);
        List<Size> list = query.getResultList();
        return list;
    }

    @Override
    public List<Size> listActive() {
        String selectAll = "SELECT s FROM Size s WHERE s.trangThai = :trangThai";
        TypedQuery<Size> query = entityManager.createQuery(selectAll, Size.class);
        query.setParameter("trangThai","Active");
        List<Size> list = query.getResultList();
        return list;
    }

    @Override
    public Size findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public Class<Size> getEntityClass() {
        return Size.class;
    }

    @Override
    public void insert(Size size) {
        super.insert(size);
    }

    @Override
    public void update(Size size) {
        super.update(size);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

}
