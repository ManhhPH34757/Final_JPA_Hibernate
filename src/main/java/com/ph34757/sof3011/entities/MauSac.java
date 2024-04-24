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
@Table(name = "mau_sac", schema = "dbo", catalog = "java4")
public class MauSac {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "ma_mau")
    private String maMau;
    @Basic
    @Column(name = "ten_mau")
    private String tenMau;
    @Basic
    @Column(name = "trang_thai")
    private String trangThai;
    @Basic
    @Column(name = "ngay_sua")
    private Date ngaySua;
    @Basic
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @OneToMany(mappedBy = "mauSacByIdMauSac")
    private Collection<Ctsp> ctspsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaMau() {
        return maMau;
    }

    public void setMaMau(String maMau) {
        this.maMau = maMau;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
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

        MauSac mauSac = (MauSac) o;

        if (id != mauSac.id) return false;
        if (!Objects.equals(maMau, mauSac.maMau)) return false;
        if (!Objects.equals(tenMau, mauSac.tenMau)) return false;
        if (!Objects.equals(trangThai, mauSac.trangThai)) return false;
        if (!Objects.equals(ngaySua, mauSac.ngaySua)) return false;
        if (!Objects.equals(ngayTao, mauSac.ngayTao)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (maMau != null ? maMau.hashCode() : 0);
        result = 31 * result + (tenMau != null ? tenMau.hashCode() : 0);
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

    public MauSac(String maMau, String tenMau, String trangThai, Date ngaySua, Date ngayTao) {
        this.maMau = maMau;
        this.tenMau = tenMau;
        this.trangThai = trangThai;
        this.ngaySua = ngaySua;
        this.ngayTao = ngayTao;
    }
}
