package com.example.msrelations.registration;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tokens")
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "token_id")
    Long tokenId;

    @Column(name = "confirmation_token")
    String confirmationToken;

    @Temporal(TemporalType.TIMESTAMP)
    Date createdDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    Registration userEntity;

    public ConfirmationToken(Registration user) {
        this.confirmationToken = generateConfirmationToken();
        this.userEntity = user;
    }

    public String generateConfirmationToken(){
        return UUID.randomUUID().toString();
    }
}
