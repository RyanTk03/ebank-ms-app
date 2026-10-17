package tech.tokorayane.ebankservice.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    private Long id;

    private String name;

    private String email;
}
