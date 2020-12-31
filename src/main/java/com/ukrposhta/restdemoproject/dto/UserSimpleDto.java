package com.ukrposhta.restdemoproject.dto;

import lombok.Data;

@Data
public class UserSimpleDto {
    private Long id;
    private String nickName;
    private Double money;
}
