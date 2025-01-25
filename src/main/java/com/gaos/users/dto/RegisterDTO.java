package com.gaos.users.dto;

import com.gaos.users.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
