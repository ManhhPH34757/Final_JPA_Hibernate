package com.ph34757.sof3011.repositories;

import com.ph34757.sof3011.entities.MauSac;
import com.ph34757.sof3011.utils.RepositoriesUtils;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class MauSacRepo extends RepositoriesUtils<MauSac, Integer> {
    @Override
    public List<MauSac> getList() {
        String selectAll = "SELECT ms FROM MauSac ms";
        TypedQuery<MauSac> query = entityManager.createQuery(selectAll, MauSac.class);
        List<MauSac> list = query.getResultList();
        return list;
    }

    @Override
    public List<MauSac> listActive() {
        String selectAll = "SELECT ms FROM MauSac ms WHERE ms.trangThai = :trangThai";
        TypedQuery<MauSac> query = entityManager.createQuery(selectAll, MauSac.class);
        query.setParameter("trangThai","Active");
        List<MauSac> list = query.getResultList();
        return list;
    }

    @Override
    public MauSac findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public Class<MauSac> getEntityClass() {
        return MauSac.class;
    }

    @Override
    public void insert(MauSac mauSac) {
        super.insert(mauSac);
    }

    @Override
    public void update(MauSac mauSac) {
        super.update(mauSac);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }
}
