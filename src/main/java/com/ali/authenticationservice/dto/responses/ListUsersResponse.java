package com.ali.authenticationservice.dto.responses;

import com.ali.authenticationservice.entities.concretes.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListUsersResponse {

    private int id;
    private String name;
    private String username;
    public static List<ListUsersResponse> toEntity(List<User> users){
        List<ListUsersResponse> responses = new ArrayList<>();
        for (User user:users){
            ListUsersResponse response = new ListUsersResponse();
            response.setId(user.getId());
            response.setName(user.getName());
            response.setUsername(user.getName());
            responses.add(response);
        }
        return responses;
    }

}
