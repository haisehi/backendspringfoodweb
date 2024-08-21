package com.example.foodweb.auth;

import com.example.foodweb.Model.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("role")
    private Role role; // Thêm thông tin về vai trò
    @JsonProperty("id_customer")
    private Integer idCustomer; // Thêm thông tin về id customer
}
