package com.dagy.cafeheroapi.features.auth.data.service.abstracts;

import com.dagy.cafeheroapi.core.params.pages.PageSearchRequest;
import com.dagy.cafeheroapi.core.params.pages.PageSearchResult;
import com.dagy.cafeheroapi.features.auth.data.dto.response.AccountResponse;
import com.dagy.cafeheroapi.features.auth.data.dto.resquest.AccountRequest;
import com.dagy.cafeheroapi.features.auth.data.dto.resquest.CompanyEmployeeSearchRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAccountService {
    ResponseEntity<PageSearchResult<List<AccountResponse>>> search(PageSearchRequest<CompanyEmployeeSearchRequest> request);

    ResponseEntity<Boolean> updateExpiryDate(Long userId, AccountRequest request);

    ResponseEntity<Boolean> updateRoles(Long userId, AccountRequest request);

    ResponseEntity<Boolean> updatePassword(Long userId, AccountRequest request);

    ResponseEntity<Boolean> toggleStatus(Long userId);
}
