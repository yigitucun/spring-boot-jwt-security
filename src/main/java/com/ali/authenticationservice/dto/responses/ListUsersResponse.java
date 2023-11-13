package com.ali.authenticationservice.dto.responses;

import com.ali.authenticationservice.entities.concretes.Role;
import com.ali.authenticationservice.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListUsersResponse {

    private int id;
    private String name;
    private String username;
    private List<Role> roles;
    public static List<ListUsersResponse> toEntity(List<User> users){
        List<ListUsersResponse> responses = new ArrayList<>();
        for (User user:users){
            ListUsersResponse response = new ListUsersResponse();
            response.setId(user.getId());
            response.setName(user.getName());
            response.setRoles(user.getRoles());
            response.setUsername(user.getUsername());
            responses.add(response);
        }
        return responses;
    }

}
