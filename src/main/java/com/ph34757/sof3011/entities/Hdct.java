package com.ph34757.sof3011.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hdct", schema = "dbo", catalog = "java4")
public class Hdct {
          @GeneratedValue(strategy = GenerationType.IDENTITY)
          @Id
          @Column(name = "id")
          private int id;
          @Basic
          @Column(name = "id_hoa_don")
          private Integer idHoaDon;
          @Basic
          @Column(name = "id_ctsp")
          private Integer idCtsp;
          @Basic
          @Column(name = "so_luong_mua")
          private Integer soLuongMua;
          @Basic
          @Column(name = "gia_ban")
          private BigDecimal giaBan;
          @Basic
          @Column(name = "tong_tien")
          private BigDecimal tongTien;
          @Basic
          @Column(name = "trang_thai")
          private String trangThai;
          @Basic
          @Column(name = "ngay_tao")
          private Date ngayTao;
          @Basic
          @Column(name = "ngay_sua")
          private Date ngaySua;
          @ManyToOne
          @JoinColumn(name = "id_hoa_don", referencedColumnName = "id", insertable = false, updatable = false)
          private HoaDon hoaDonByIdHoaDon;
          @ManyToOne
          @JoinColumn(name = "id_ctsp", referencedColumnName = "id", insertable = false, updatable = false)
          private Ctsp ctspByIdCtsp;

          public int getId() {
                    return id;
          }

          public void setId(int id) {
                    this.id = id;
          }

          public Integer getIdHoaDon() {
                    return idHoaDon;
          }

          public void setIdHoaDon(Integer idHoaDon) {
                    this.idHoaDon = idHoaDon;
          }

          public Integer getIdCtsp() {
                    return idCtsp;
          }

          public void setIdCtsp(Integer idCtsp) {
                    this.idCtsp = idCtsp;
          }

          public Integer getSoLuongMua() {
                    return soLuongMua;
          }

          public void setSoLuongMua(Integer soLuongMua) {
                    this.soLuongMua = soLuongMua;
          }

          public BigDecimal getGiaBan() {
                    return giaBan;
          }

          public void setGiaBan(BigDecimal giaBan) {
                    this.giaBan = giaBan;
          }

          public BigDecimal getTongTien() {
                    return tongTien;
          }

          public void setTongTien(BigDecimal tongTien) {
                    this.tongTien = tongTien;
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
                    if (this == o)
                              return true;
                    if (o == null || getClass() != o.getClass())
                              return false;

                    Hdct that = (Hdct) o;

                    if (id != that.id)
                              return false;
                    if (!Objects.equals(idHoaDon, that.idHoaDon))
                              return false;
                    if (!Objects.equals(idCtsp, that.idCtsp))
                              return false;
                    if (!Objects.equals(soLuongMua, that.soLuongMua))
                              return false;
                    if (!Objects.equals(giaBan, that.giaBan))
                              return false;
                    if (!Objects.equals(tongTien, that.tongTien))
                              return false;
                    if (!Objects.equals(trangThai, that.trangThai))
                              return false;
                    if (!Objects.equals(ngayTao, that.ngayTao))
                              return false;
                    if (!Objects.equals(ngaySua, that.ngaySua))
                              return false;

                    return true;
          }

          @Override
          public int hashCode() {
                    int result = id;
                    result = 31 * result + (idHoaDon != null ? idHoaDon.hashCode() : 0);
                    result = 31 * result + (idCtsp != null ? idCtsp.hashCode() : 0);
                    result = 31 * result + (soLuongMua != null ? soLuongMua.hashCode() : 0);
                    result = 31 * result + (giaBan != null ? giaBan.hashCode() : 0);
                    result = 31 * result + (tongTien != null ? tongTien.hashCode() : 0);
                    result = 31 * result + (trangThai != null ? trangThai.hashCode() : 0);
                    result = 31 * result + (ngayTao != null ? ngayTao.hashCode() : 0);
                    result = 31 * result + (ngaySua != null ? ngaySua.hashCode() : 0);
                    return result;
          }

          public HoaDon getHoaDonByIdHoaDon() {
                    return hoaDonByIdHoaDon;
          }

          public void setHoaDonByIdHoaDon(HoaDon hoaDonByIdHoaDon) {
                    this.hoaDonByIdHoaDon = hoaDonByIdHoaDon;
          }

          public Ctsp getCtspByIdCtsp() {
                    return ctspByIdCtsp;
          }

          public void setCtspByIdCtsp(Ctsp ctspByIdCtsp) {
                    this.ctspByIdCtsp = ctspByIdCtsp;
          }

          public Hdct(Integer idHoaDon, Integer idCtsp, Integer soLuongMua, BigDecimal giaBan, BigDecimal tongTien, String trangThai, Date ngayTao, Date ngaySua, HoaDon hoaDonByIdHoaDon, Ctsp ctspByIdCtsp) {
                    this.idHoaDon = idHoaDon;
                    this.idCtsp = idCtsp;
                    this.soLuongMua = soLuongMua;
                    this.giaBan = giaBan;
                    this.tongTien = tongTien;
                    this.trangThai = trangThai;
                    this.ngayTao = ngayTao;
                    this.ngaySua = ngaySua;
                    this.hoaDonByIdHoaDon = hoaDonByIdHoaDon;
                    this.ctspByIdCtsp = ctspByIdCtsp;
          }
}
