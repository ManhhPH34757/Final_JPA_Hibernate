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
@Table(name = "khach_hang", schema = "dbo", catalog = "java4")
public class KhachHang {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "ho_ten")
    private String hoTen;
    @Basic
    @Column(name = "dia_chi")
    private String diaChi;
    @Basic
    @Column(name = "sdt")
    private String sdt;
    @Basic
    @Column(name = "trang_thai")
    private String trangThai;
    @Basic
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Basic
    @Column(name = "ngay_sua")
    private Date ngaySua;
    @OneToMany(mappedBy = "khachHangByIdKhachHang")
    private Collection<HoaDon> hoaDonsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KhachHang khachHang = (KhachHang) o;

        if (id != khachHang.id) return false;
        if (!Objects.equals(hoTen, khachHang.hoTen)) return false;
        if (!Objects.equals(diaChi, khachHang.diaChi)) return false;
        if (!Objects.equals(sdt, khachHang.sdt)) return false;
        if (!Objects.equals(trangThai, khachHang.trangThai)) return false;
        if (!Objects.equals(ngayTao, khachHang.ngayTao)) return false;
        if (!Objects.equals(ngaySua, khachHang.ngaySua)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (hoTen != null ? hoTen.hashCode() : 0);
        result = 31 * result + (diaChi != null ? diaChi.hashCode() : 0);
        result = 31 * result + (sdt != null ? sdt.hashCode() : 0);
        result = 31 * result + (trangThai != null ? trangThai.hashCode() : 0);
        result = 31 * result + (ngayTao != null ? ngayTao.hashCode() : 0);
        result = 31 * result + (ngaySua != null ? ngaySua.hashCode() : 0);
        return result;
    }

    public Collection<HoaDon> getHoaDonsById() {
        return hoaDonsById;
    }

    public void setHoaDonsById(Collection<HoaDon> hoaDonsById) {
        this.hoaDonsById = hoaDonsById;
    }

    public KhachHang(String hoTen, String diaChi, String sdt, String trangThai, Date ngayTao, Date ngaySua) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }
}
