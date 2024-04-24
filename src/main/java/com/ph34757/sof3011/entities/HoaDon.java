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
@Table(name = "hoa_don", schema = "dbo", catalog = "java4")
public class HoaDon {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_khach_hang")
    private Integer idKhachHang;
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
    @Column(name = "dia_chi")
    private String diaChi;
    @Basic
    @Column(name = "so_dien_thoai")
    private String soDienThoai;
    @OneToMany(mappedBy = "hoaDonByIdHoaDon")
    private Collection<Hdct> hdctsById;
    @ManyToOne
    @JoinColumn(name = "id_khach_hang", referencedColumnName = "id",insertable=false, updatable=false)
    private KhachHang khachHangByIdKhachHang;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(Integer idKhachHang) {
        this.idKhachHang = idKhachHang;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HoaDon hoaDon = (HoaDon) o;

        if (id != hoaDon.id) return false;
        if (!Objects.equals(idKhachHang, hoaDon.idKhachHang)) return false;
        if (!Objects.equals(trangThai, hoaDon.trangThai)) return false;
        if (!Objects.equals(ngayTao, hoaDon.ngayTao)) return false;
        if (!Objects.equals(ngaySua, hoaDon.ngaySua)) return false;
        if (!Objects.equals(diaChi, hoaDon.diaChi)) return false;
        if (!Objects.equals(soDienThoai, hoaDon.soDienThoai)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idKhachHang != null ? idKhachHang.hashCode() : 0);
        result = 31 * result + (trangThai != null ? trangThai.hashCode() : 0);
        result = 31 * result + (ngayTao != null ? ngayTao.hashCode() : 0);
        result = 31 * result + (ngaySua != null ? ngaySua.hashCode() : 0);
        result = 31 * result + (diaChi != null ? diaChi.hashCode() : 0);
        result = 31 * result + (soDienThoai != null ? soDienThoai.hashCode() : 0);
        return result;
    }

    public Collection<Hdct> getHdctsById() {
        return hdctsById;
    }

    public void setHdctsById(Collection<Hdct> hdctsById) {
        this.hdctsById = hdctsById;
    }

    public KhachHang getKhachHangByIdKhachHang() {
        return khachHangByIdKhachHang;
    }

    public void setKhachHangByIdKhachHang(KhachHang khachHangByIdKhachHang) {
        this.khachHangByIdKhachHang = khachHangByIdKhachHang;
    }

    public HoaDon(Integer idKhachHang, String trangThai, Date ngayTao, Date ngaySua, String diaChi, String soDienThoai, KhachHang khachHangByIdKhachHang) {
        this.idKhachHang = idKhachHang;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.khachHangByIdKhachHang = khachHangByIdKhachHang;
    }
}
