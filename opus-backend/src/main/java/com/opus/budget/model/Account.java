package com.opus.budget.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "accounts")
public class Account {

    @Id
    private String id;

    @NotBlank(message = "User ID is required")
    private String userId;

    @NotBlank(message = "Account name is required")
    private String name;

    @NotBlank(message = "Account type is required")
    private String type; // CHECKING, SAVINGS, CREDIT_CARD, INVESTMENT, etc.

    private String institutionName;
    private String plaidAccountId;
    private String plaidAccessToken;

    @NotNull(message = "Balance is required")
    private BigDecimal balance = BigDecimal.ZERO;

    private String currency = "USD";

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private boolean active = true;
    private boolean synced = false;
}
