package com.Certificates;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificateService {

    private final CertificateRepository certificateRepository;

    public CertificateService(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    // Fetch all certificates
    public List<CertificateBean> getAllCertificates() {
        return certificateRepository.findAll();
    }

    // Fetch certificate by ID
    public CertificateBean getCertificateById(String certificateId) {
        Optional<CertificateBean> certificateOptional = certificateRepository.findById(certificateId);
        return certificateOptional.orElse(null); // Return null if not found
    }
}
