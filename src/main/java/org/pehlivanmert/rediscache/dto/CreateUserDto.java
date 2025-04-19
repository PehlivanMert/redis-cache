package org.pehlivanmert.rediscache.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pehlivanmert.rediscache.modal.User;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {
    private String username;
    private String password;

    public User toEntity(CreateUserDto createUserDto) {
        return User.builder()
                .username(createUserDto.getUsername())
                .password(createUserDto.getPassword())
                .build();
    }
}
