package com.devfolio.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.devfolio.backend.entity.Certificate;
import com.devfolio.backend.repository.CertificateRepository;

@RestController
@RequestMapping("/api/certificates")
@CrossOrigin(origins = "*")
public class CertificateController {

    @Autowired
    private CertificateRepository certificateRepository;

    // Get All Certificates
    @GetMapping
    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }

    // Add Certificate
    @PostMapping
    public Certificate addCertificate(@RequestBody Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    // Get Certificate By Id
    @GetMapping("/{id}")
    public Certificate getCertificateById(@PathVariable Long id) {
        return certificateRepository.findById(id).orElse(null);
    }

    // Update Certificate
    @PutMapping("/{id}")
    public Certificate updateCertificate(
            @PathVariable Long id,
            @RequestBody Certificate certificate) {

        Certificate existing = certificateRepository.findById(id)
                .orElseThrow();

        existing.setTitle(certificate.getTitle());
        existing.setIssuer(certificate.getIssuer());
        existing.setYear(certificate.getYear());

        // NEW
        existing.setImage(certificate.getImage());

        // PDF Link
        existing.setCertificateLink(certificate.getCertificateLink());

        return certificateRepository.save(existing);
    }

    // Delete Certificate
    @DeleteMapping("/{id}")
    public String deleteCertificate(@PathVariable Long id) {

        certificateRepository.deleteById(id);

        return "Certificate Deleted Successfully";
    }

}
