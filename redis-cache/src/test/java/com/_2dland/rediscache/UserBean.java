package com._2dland.rediscache;

import lombok.*;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserBean implements Serializable {
    private Long id;
    private String name;
    private Integer age;
}
