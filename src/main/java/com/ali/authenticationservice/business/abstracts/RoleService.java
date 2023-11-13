package com.ali.authenticationservice.business.abstracts;

import com.ali.authenticationservice.dto.requests.AddRoleRequest;
import com.ali.authenticationservice.dto.requests.AddRoleToUserRequest;

public interface RoleService {
    AddRoleRequest add(AddRoleRequest request);
    AddRoleToUserRequest addRoleToUser(AddRoleToUserRequest request);
}
