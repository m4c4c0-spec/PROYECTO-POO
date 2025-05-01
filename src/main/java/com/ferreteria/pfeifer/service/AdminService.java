package com.ferreteria.pfeifer.service;

import com.ferreteria.pfeifer.repository.AdminRepository;

public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

}
