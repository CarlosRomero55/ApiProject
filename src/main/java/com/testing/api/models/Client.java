package com.testing.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private String id;
    private String name;
    private String phone;
    private String email;
    private String createdAt;
    private String updatedAt;
}
