package org.openapitools.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CredentialsDB {
    private String login;

    private String password;
}
