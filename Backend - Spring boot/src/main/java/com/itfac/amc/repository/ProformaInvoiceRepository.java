package com.itfac.amc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itfac.amc.entity.ProformaInvoice;

@Repository
public interface ProformaInvoiceRepository extends JpaRepository<ProformaInvoice, String> {

}
