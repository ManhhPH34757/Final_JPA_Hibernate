package com.ph34757.sof3011.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Collection;
import java.util.Objects;
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Size {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "ma_size")
    private String maSize;
    @Basic
    @Column(name = "ten_size")
    private String tenSize;
    @Basic
    @Column(name = "trang_thai")
    private String trangThai;
    @Basic
    @Column(name = "ngay_sua")
    private Date ngaySua;
    @Basic
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @OneToMany(mappedBy = "sizeByIdSize")
    private Collection<Ctsp> ctspsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSize() {
        return maSize;
    }

    public void setMaSize(String maSize) {
        this.maSize = maSize;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Size size = (Size) o;

        if (id != size.id) return false;
        if (!Objects.equals(maSize, size.maSize)) return false;
        if (!Objects.equals(tenSize, size.tenSize)) return false;
        if (!Objects.equals(trangThai, size.trangThai)) return false;
        if (!Objects.equals(ngaySua, size.ngaySua)) return false;
        if (!Objects.equals(ngayTao, size.ngayTao)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (maSize != null ? maSize.hashCode() : 0);
        result = 31 * result + (tenSize != null ? tenSize.hashCode() : 0);
        result = 31 * result + (trangThai != null ? trangThai.hashCode() : 0);
        result = 31 * result + (ngaySua != null ? ngaySua.hashCode() : 0);
        result = 31 * result + (ngayTao != null ? ngayTao.hashCode() : 0);
        return result;
    }

    public Collection<Ctsp> getCtspsById() {
        return ctspsById;
    }

    public void setCtspsById(Collection<Ctsp> ctspsById) {
        this.ctspsById = ctspsById;
    }

    public Size(String maSize, String tenSize, String trangThai, Date ngaySua, Date ngayTao) {
        this.maSize = maSize;
        this.tenSize = tenSize;
        this.trangThai = trangThai;
        this.ngaySua = ngaySua;
        this.ngayTao = ngayTao;
    }

}
