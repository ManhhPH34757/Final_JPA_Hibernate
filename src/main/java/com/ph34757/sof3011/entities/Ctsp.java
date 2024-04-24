package com.ph34757.sof3011.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Collection;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ctsp {
          @GeneratedValue(strategy = GenerationType.IDENTITY)
          @Id
          @Column(name = "id")
          private int id;
          @Basic
          @Column(name = "id_sp")
          private Integer idSp;
          @Basic
          @Column(name = "id_mau_sac")
          private Integer idMauSac;
          @Basic
          @Column(name = "id_size")
          private Integer idSize;
          @Basic
          @Column(name = "gia_ban")
          private BigDecimal giaBan;
          @Basic
          @Column(name = "so_luong_ton")
          private Integer soLuongTon;
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
          @JoinColumn(name = "id_sp", referencedColumnName = "id", insertable = false, updatable = false)
          private SanPham sanPhamByIdSp;
          @ManyToOne
          @JoinColumn(name = "id_mau_sac", referencedColumnName = "id", insertable = false, updatable = false)
          private MauSac mauSacByIdMauSac;
          @ManyToOne
          @JoinColumn(name = "id_size", referencedColumnName = "id", insertable = false, updatable = false)
          private Size sizeByIdSize;
          @OneToMany(mappedBy = "ctspByIdCtsp")
          private Collection<Hdct> hdctsById;

          public int getId() {
                    return id;
          }

          public void setId(int id) {
                    this.id = id;
          }

          public Integer getIdSp() {
                    return idSp;
          }

          public void setIdSp(Integer idSp) {
                    this.idSp = idSp;
          }

          public Integer getIdMauSac() {
                    return idMauSac;
          }

          public void setIdMauSac(Integer idMauSac) {
                    this.idMauSac = idMauSac;
          }

          public Integer getIdSize() {
                    return idSize;
          }

          public void setIdSize(Integer idSize) {
                    this.idSize = idSize;
          }

          public BigDecimal getGiaBan() {
                    return giaBan;
          }

          public void setGiaBan(BigDecimal giaBan) {
                    this.giaBan = giaBan;
          }

          public Integer getSoLuongTon() {
                    return soLuongTon;
          }

          public void setSoLuongTon(Integer soLuongTon) {
                    this.soLuongTon = soLuongTon;
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

                    Ctsp ctsp = (Ctsp) o;

                    if (id != ctsp.id)
                              return false;
                    if (!Objects.equals(idSp, ctsp.idSp))
                              return false;
                    if (!Objects.equals(idMauSac, ctsp.idMauSac))
                              return false;
                    if (!Objects.equals(idSize, ctsp.idSize))
                              return false;
                    if (!Objects.equals(giaBan, ctsp.giaBan))
                              return false;
                    if (!Objects.equals(soLuongTon, ctsp.soLuongTon))
                              return false;
                    if (!Objects.equals(trangThai, ctsp.trangThai))
                              return false;
                    if (!Objects.equals(ngayTao, ctsp.ngayTao))
                              return false;
                    if (!Objects.equals(ngaySua, ctsp.ngaySua))
                              return false;

                    return true;
          }

          @Override
          public int hashCode() {
                    int result = id;
                    result = 31 * result + (idSp != null ? idSp.hashCode() : 0);
                    result = 31 * result + (idMauSac != null ? idMauSac.hashCode() : 0);
                    result = 31 * result + (idSize != null ? idSize.hashCode() : 0);
                    result = 31 * result + (giaBan != null ? giaBan.hashCode() : 0);
                    result = 31 * result + (soLuongTon != null ? soLuongTon.hashCode() : 0);
                    result = 31 * result + (trangThai != null ? trangThai.hashCode() : 0);
                    result = 31 * result + (ngayTao != null ? ngayTao.hashCode() : 0);
                    result = 31 * result + (ngaySua != null ? ngaySua.hashCode() : 0);
                    return result;
          }

          public SanPham getSanPhamByIdSp() {
                    return sanPhamByIdSp;
          }

          public void setSanPhamByIdSp(SanPham sanPhamByIdSp) {
                    this.sanPhamByIdSp = sanPhamByIdSp;
          }

          public MauSac getMauSacByIdMauSac() {
                    return mauSacByIdMauSac;
          }

          public void setMauSacByIdMauSac(MauSac mauSacByIdMauSac) {
                    this.mauSacByIdMauSac = mauSacByIdMauSac;
          }

          public Size getSizeByIdSize() {
                    return sizeByIdSize;
          }

          public void setSizeByIdSize(Size sizeByIdSize) {
                    this.sizeByIdSize = sizeByIdSize;
          }

          public Collection<Hdct> getHdctsById() {
                    return hdctsById;
          }

          public void setHdctsById(Collection<Hdct> hdctsById) {
                    this.hdctsById = hdctsById;
          }

          public Ctsp(Integer idSp, Integer idMauSac, Integer idSize, BigDecimal giaBan, Integer soLuongTon, String trangThai, Date ngayTao, Date ngaySua, SanPham sanPhamByIdSp, MauSac mauSacByIdMauSac, Size sizeByIdSize) {
                    this.idSp = idSp;
                    this.idMauSac = idMauSac;
                    this.idSize = idSize;
                    this.giaBan = giaBan;
                    this.soLuongTon = soLuongTon;
                    this.trangThai = trangThai;
                    this.ngayTao = ngayTao;
                    this.ngaySua = ngaySua;
                    this.sanPhamByIdSp = sanPhamByIdSp;
                    this.mauSacByIdMauSac = mauSacByIdMauSac;
                    this.sizeByIdSize = sizeByIdSize;
          }

          public Ctsp(Integer idMauSac, Integer idSize, BigDecimal giaBan, Integer soLuongTon, String trangThai, MauSac mauSacByIdMauSac, Size sizeByIdSize) {
                    this.idMauSac = idMauSac;
                    this.idSize = idSize;
                    this.giaBan = giaBan;
                    this.soLuongTon = soLuongTon;
                    this.trangThai = trangThai;
                    this.mauSacByIdMauSac = mauSacByIdMauSac;
                    this.sizeByIdSize = sizeByIdSize;
          }

          @Override
          public String toString() {
                    return "Ctsp{" + "id=" + id + ", idSp=" + idSp + ", idMauSac=" + idMauSac + ", idSize=" + idSize + ", giaBan=" + giaBan + ", soLuongTon=" + soLuongTon + ", trangThai='" + trangThai + '\'' + ", ngayTao=" + ngayTao + ", ngaySua=" + ngaySua + ", sanPhamByIdSp=" + sanPhamByIdSp + ", mauSacByIdMauSac=" + mauSacByIdMauSac + ", sizeByIdSize=" + sizeByIdSize + ", hdctsById=" + hdctsById + '}';
          }
}
