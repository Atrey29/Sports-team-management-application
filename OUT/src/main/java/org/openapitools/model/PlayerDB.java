package org.openapitools.model;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDB {

    private UUID id;

    private String firstName;

    private String lastName;

    private Integer age;

    private Integer height;

    private String nationality;

    private String position;

    private Integer goalsCount;

    private Integer assistCount;

    private Integer yellowCardCount;

    private Integer redCardCount;

    private UUID teamId;
}
