package com.testing.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Resource {
    private String id;
    private String name;
    private boolean isActive;
    private String createdAt;
    private String updatedAt;
}

