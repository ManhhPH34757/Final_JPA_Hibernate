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
@Table(name = "san_pham", schema = "dbo", catalog = "java4")
public class SanPham {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "ma_san_pham")
    private String maSanPham;
    @Basic
    @Column(name = "ten_san_pham")
    private String tenSanPham;
    @Basic
    @Column(name = "trang_thai")
    private String trangThai;
    @Basic
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Basic
    @Column(name = "ngay_sua")
    private Date ngaySua;
    @Basic
    @Column(name = "id_danh_muc")
    private Integer idDanhMuc;
    @OneToMany(mappedBy = "sanPhamByIdSp")
    private Collection<Ctsp> ctspsById;
    @ManyToOne
    @JoinColumn(name = "id_danh_muc", referencedColumnName = "id", insertable=false, updatable=false)
    private DanhMuc danhMucByIdDanhMuc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public Integer getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(Integer idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SanPham sanPham = (SanPham) o;

        if (id != sanPham.id) return false;
        if (!Objects.equals(maSanPham, sanPham.maSanPham)) return false;
        if (!Objects.equals(tenSanPham, sanPham.tenSanPham)) return false;
        if (!Objects.equals(trangThai, sanPham.trangThai)) return false;
        if (!Objects.equals(ngayTao, sanPham.ngayTao)) return false;
        if (!Objects.equals(ngaySua, sanPham.ngaySua)) return false;
        if (!Objects.equals(idDanhMuc, sanPham.idDanhMuc)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (maSanPham != null ? maSanPham.hashCode() : 0);
        result = 31 * result + (tenSanPham != null ? tenSanPham.hashCode() : 0);
        result = 31 * result + (trangThai != null ? trangThai.hashCode() : 0);
        result = 31 * result + (ngayTao != null ? ngayTao.hashCode() : 0);
        result = 31 * result + (ngaySua != null ? ngaySua.hashCode() : 0);
        result = 31 * result + (idDanhMuc != null ? idDanhMuc.hashCode() : 0);
        return result;
    }

    public Collection<Ctsp> getCtspsById() {
        return ctspsById;
    }

    public void setCtspsById(Collection<Ctsp> ctspsById) {
        this.ctspsById = ctspsById;
    }

    public DanhMuc getDanhMucByIdDanhMuc() {
        return danhMucByIdDanhMuc;
    }

    public void setDanhMucByIdDanhMuc(DanhMuc danhMucByIdDanhMuc) {
        this.danhMucByIdDanhMuc = danhMucByIdDanhMuc;
    }

    public SanPham(String maSanPham, String tenSanPham, String trangThai, Date ngayTao, Date ngaySua, Integer idDanhMuc, DanhMuc danhMucByIdDanhMuc) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.idDanhMuc = idDanhMuc;
        this.danhMucByIdDanhMuc = danhMucByIdDanhMuc;
    }
}
