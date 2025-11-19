package com.opus.budget.controller;

import com.opus.budget.model.Account;
import com.opus.budget.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable String id) {
        return accountService.getAccountById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Account>> getAccountsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(accountService.getAccountsByUserId(userId));
    }

    @GetMapping("/user/{userId}/active")
    public ResponseEntity<List<Account>> getActiveAccountsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(accountService.getActiveAccountsByUserId(userId));
    }

    @GetMapping("/user/{userId}/type/{type}")
    public ResponseEntity<List<Account>> getAccountsByUserIdAndType(
            @PathVariable String userId,
            @PathVariable String type) {
        return ResponseEntity.ok(accountService.getAccountsByUserIdAndType(userId, type));
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable String id, @Valid @RequestBody Account accountDetails) {
        try {
            Account updatedAccount = accountService.updateAccount(id, accountDetails);
            return ResponseEntity.ok(updatedAccount);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
}
