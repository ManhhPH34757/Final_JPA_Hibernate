package com.ph34757.sof3011.repositories;

import com.ph34757.sof3011.entities.Hdct;
import com.ph34757.sof3011.utils.RepositoriesUtils;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class HoaDonChiTietRepo extends RepositoriesUtils<Hdct, Integer> {
    @Override
    public List<Hdct> getList() {
        return null;
    }

    public List<Hdct> listHDCTByIdHD(int idHD) {
        String selectAll = "SELECT hdct FROM Hdct hdct WHERE hdct.idHoaDon = :idHD";
        TypedQuery<Hdct> query = entityManager.createQuery(selectAll, Hdct.class);
        query.setParameter("idHD", idHD);
        List<Hdct> list = query.getResultList();
        return list;
    }

    @Override
    public List<Hdct> listActive() {
        return null;
    }

    @Override
    public Hdct findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public Class<Hdct> getEntityClass() {
        return Hdct.class;
    }

    @Override
    public void insert(Hdct hdct) {
        super.insert(hdct);
    }

    @Override
    public void update(Hdct hdct) {
        super.update(hdct);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }


}
