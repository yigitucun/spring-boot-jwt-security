package com.ali.authenticationservice.dto.requests;

import lombok.Data;

@Data
public class AddRoleToUserRequest {
    private int userId;
    private int roleId;
}
