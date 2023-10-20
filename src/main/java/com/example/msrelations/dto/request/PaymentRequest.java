package com.example.msrelations.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentRequest {

    Double paymentAmount;

    String paymentMethod;

    String paymentDate;
}
