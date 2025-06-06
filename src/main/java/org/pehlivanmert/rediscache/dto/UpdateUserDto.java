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
public class UpdateUserDto {
    private Long id;
    private String password;

    public User toEntity(UpdateUserDto updateUserDto) {
        return User.builder()
                .id(updateUserDto.getId())
                .password(updateUserDto.getPassword())
                .build();
    }
}