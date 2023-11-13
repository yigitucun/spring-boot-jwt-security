package com.ali.authenticationservice.business.rules;

import com.ali.authenticationservice.dataAccess.abstracts.IRoleRepository;
import com.ali.authenticationservice.exceptions.businessException.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleBusinessRules {

    private IRoleRepository roleRepository;
    public void checkIfRoleId(int id){
        if (!this.roleRepository.existsById(id)){
            throw new BusinessException("Böyle bir rol bulunamadı.", HttpStatus.BAD_REQUEST);
        }
    }
    public void checkIfRoleRole(String role){
        if (this.roleRepository.existsByRole(role)){
            throw new BusinessException("Bu rol zaten kayıtlı.",HttpStatus.BAD_REQUEST);
        }
    }
}
