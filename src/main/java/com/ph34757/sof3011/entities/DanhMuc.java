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
@Table(name = "danh_muc", schema = "dbo", catalog = "java4")
public class DanhMuc {
          @GeneratedValue(strategy = GenerationType.IDENTITY)
          @Id
          @Column(name = "id")
          private int id;
          @Basic
          @Column(name = "ma_danh_muc")
          private String maDanhMuc;
          @Basic
          @Column(name = "ten_danh_muc")
          private String tenDanhMuc;
          @Basic
          @Column(name = "trang_thai")
          private String trangThai;
          @Basic
          @Column(name = "ngay_tao")
          private Date ngayTao;
          @Basic
          @Column(name = "ngay_sua")
          private Date ngaySua;
          @OneToMany(mappedBy = "danhMucByIdDanhMuc")
          private Collection<SanPham> sanPhamsById;

          public int getId() {
                    return id;
          }

          public void setId(int id) {
                    this.id = id;
          }

          public String getMaDanhMuc() {
                    return maDanhMuc;
          }

          public void setMaDanhMuc(String maDanhMuc) {
                    this.maDanhMuc = maDanhMuc;
          }

          public String getTenDanhMuc() {
                    return tenDanhMuc;
          }

          public void setTenDanhMuc(String tenDanhMuc) {
                    this.tenDanhMuc = tenDanhMuc;
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

                    DanhMuc danhMuc = (DanhMuc) o;

                    if (id != danhMuc.id)
                              return false;
                    if (!Objects.equals(maDanhMuc, danhMuc.maDanhMuc))
                              return false;
                    if (!Objects.equals(tenDanhMuc, danhMuc.tenDanhMuc))
                              return false;
                    if (!Objects.equals(trangThai, danhMuc.trangThai))
                              return false;
                    if (!Objects.equals(ngayTao, danhMuc.ngayTao))
                              return false;
                    if (!Objects.equals(ngaySua, danhMuc.ngaySua))
                              return false;

                    return true;
          }

          @Override
          public int hashCode() {
                    int result = id;
                    result = 31 * result + (maDanhMuc != null ? maDanhMuc.hashCode() : 0);
                    result = 31 * result + (tenDanhMuc != null ? tenDanhMuc.hashCode() : 0);
                    result = 31 * result + (trangThai != null ? trangThai.hashCode() : 0);
                    result = 31 * result + (ngayTao != null ? ngayTao.hashCode() : 0);
                    result = 31 * result + (ngaySua != null ? ngaySua.hashCode() : 0);
                    return result;
          }

          public Collection<SanPham> getSanPhamsById() {
                    return sanPhamsById;
          }

          public void setSanPhamsById(Collection<SanPham> sanPhamsById) {
                    this.sanPhamsById = sanPhamsById;
          }

          public DanhMuc(String maDanhMuc, String tenDanhMuc, String trangThai, Date ngayTao, Date ngaySua) {
                    this.maDanhMuc = maDanhMuc;
                    this.tenDanhMuc = tenDanhMuc;
                    this.trangThai = trangThai;
                    this.ngayTao = ngayTao;
                    this.ngaySua = ngaySua;
          }
}
