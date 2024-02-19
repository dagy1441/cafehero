package com.dagy.cafeheroapi.features.auth.presenter.controller;

import com.dagy.cafeheroapi.core.params.pages.PageSearchRequest;
import com.dagy.cafeheroapi.core.params.pages.PageSearchResult;
import com.dagy.cafeheroapi.features.auth.data.dto.resquest.AccountRequest;
import com.dagy.cafeheroapi.features.auth.data.dto.resquest.CompanyEmployeeSearchRequest;
import com.dagy.cafeheroapi.features.auth.data.service.abstracts.IAccountService;
import com.dagy.cafeheroapi.features.auth.presenter.api.AccountApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController implements AccountApi {
    private final IAccountService accountService;
    @Override
    public ResponseEntity<PageSearchResult<List<AccountRequest>>>
    searchForUsersAccountInPages(PageSearchRequest<CompanyEmployeeSearchRequest> request) {
        return  null ;//accountService.search(request);
    }

    @Override
    public ResponseEntity<Boolean> updateExpiryDate(Long userId, AccountRequest request) {
        return accountService.updateExpiryDate(userId, request);
    }

    @Override
    public ResponseEntity<Boolean> updateRole(Long userId, AccountRequest request) {
        return accountService.updateRoles(userId, request);
    }

    @Override
    public ResponseEntity<Boolean> updatePassword(Long userId, AccountRequest request) {
        return accountService.updatePassword(userId, request);
    }

    @Override
    public ResponseEntity<Boolean> toggleStatus(Long userId) {
        return accountService.toggleStatus(userId);
    }
}
