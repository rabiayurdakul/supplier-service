package com.eleiatech.supplierservice.repository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "supplier",schema = "stock_management")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "supplier_id")
    private long supplierId;

    @Column(name = "company_id")
    private long companyId;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "supplier_address")
    private String supplierAddress;

    @Column(name = "supplier_town")
    private String supplierTown;

    @Column(name = "supplier_county")
    private String supplierCounty;

    @Column(name = "supplier_city")
    private String supplierCity;

    @Column(name = "supplier_country")
    private String supplierCountry;

    @Column(name = "supplier_post_code")
    private String supplierPostCode;

    @Column(name = "supplier_phone")
    private String supplierPhone;

    @Column(name = "supplier_phone_second")
    private String supplierPhoneSecond;

    @Column(name = "supplier_email")
    private String supplierEmail;

    @Column(name = "supplier_fax")
    private String supplierFax;

    @Builder.Default
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdDate = new Date();

    @Builder.Default
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatedDate = new Date();

    @Column(name = "is_deleted")
    private boolean deleted;
}
