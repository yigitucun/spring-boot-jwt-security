package com.ali.authenticationservice.business.concretes;

import com.ali.authenticationservice.business.abstracts.RoleService;
import com.ali.authenticationservice.business.rules.RoleBusinessRules;
import com.ali.authenticationservice.business.rules.UserBusinessRules;
import com.ali.authenticationservice.dataAccess.abstracts.IRoleRepository;
import com.ali.authenticationservice.dataAccess.abstracts.IUserRepository;
import com.ali.authenticationservice.dto.requests.AddRoleRequest;
import com.ali.authenticationservice.dto.requests.AddRoleToUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleManager implements RoleService {
    private IRoleRepository roleRepository;
    private IUserRepository userRepository;
    private UserBusinessRules userBusinessRules;
    private RoleBusinessRules roleBusinessRules;

    @Override
    public AddRoleRequest add(AddRoleRequest request) {
        this.roleBusinessRules.checkIfRoleRole(request.getRole());
        this.roleRepository.save(request.toEntity(request));
        return request;
    }

    @Override
    public AddRoleToUserRequest addRoleToUser(AddRoleToUserRequest request) {
        return null;
    }
}
