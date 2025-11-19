package com.opus.budget.service;

import com.opus.budget.model.Account;
import com.opus.budget.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(String id) {
        return accountRepository.findById(id);
    }

    public List<Account> getAccountsByUserId(String userId) {
        return accountRepository.findByUserId(userId);
    }

    public List<Account> getActiveAccountsByUserId(String userId) {
        return accountRepository.findByUserIdAndActive(userId, true);
    }

    public List<Account> getAccountsByUserIdAndType(String userId, String type) {
        return accountRepository.findByUserIdAndType(userId, type);
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account updateAccount(String id, Account accountDetails) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found with id: " + id));

        account.setName(accountDetails.getName());
        account.setType(accountDetails.getType());
        account.setInstitutionName(accountDetails.getInstitutionName());
        account.setBalance(accountDetails.getBalance());
        account.setCurrency(accountDetails.getCurrency());
        account.setActive(accountDetails.isActive());
        account.setSynced(accountDetails.isSynced());

        return accountRepository.save(account);
    }

    public void deleteAccount(String id) {
        accountRepository.deleteById(id);
    }
}
