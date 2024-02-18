package com.dagy.cafeheroapi.features.auth.data.service.implementation;

import com.dagy.cafeheroapi.core.params.pages.PageSearchRequest;
import com.dagy.cafeheroapi.core.params.pages.PageSearchResult;
import com.dagy.cafeheroapi.features.auth.data.dto.response.AccountResponse;
import com.dagy.cafeheroapi.features.auth.data.dto.response.RoleResponse;
import com.dagy.cafeheroapi.features.auth.data.dto.resquest.AccountRequest;
import com.dagy.cafeheroapi.features.auth.data.dto.resquest.CompanyEmployeeSearchRequest;
import com.dagy.cafeheroapi.features.auth.data.dto.resquest.RoleRequest;
import com.dagy.cafeheroapi.features.auth.data.service.abstracts.IAccountService;
import com.dagy.cafeheroapi.features.auth.domaine.usecase.IUserUsecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.dagy.cafeheroapi.core.utils.AppUtils.parseToLocalDate;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {
    //private final ICompanyEmployeeUsecase employeeUsecase;
    private  final IUserUsecase userUsecase;
    @Override
    public ResponseEntity<PageSearchResult<List<AccountResponse>>>
    search(PageSearchRequest<CompanyEmployeeSearchRequest> request) {
//        Page<CompanyEmployee> page = this.employeeUsecase.findMany(companyEmployeeSpecification(request.getSearchRequest()), request.getPage().toPageable());
//        List<AccountRequest> requests = page.getContent().stream().map(this::mapEmployeeToAccountRequest).collect(Collectors.toList());
//        return ok().body(toPageSearchResult(requests, page));
        return null;
    }

    @Override
    public ResponseEntity<Boolean>
    updateExpiryDate(Long userId, AccountRequest request) {
        if (!isEmpty(request.getExpiryDate())) {
            Boolean updated = this.userUsecase.updateExpiryDate(userId, parseToLocalDate(request.getExpiryDate()));
            return ok().body(updated);
        }
        return ok().body(false);
    }

    @Override
    public ResponseEntity<Boolean>
    updateRoles(Long userId, AccountRequest request) {
        if (!isEmpty(request.getRoles())) {
            List<Long> rolesId = request.getRoles()
                    .stream().map(RoleRequest::getId)
                    .collect(Collectors.toList());
            Boolean updated = this.userUsecase.updateRoles(userId, rolesId);
            return ok().body(updated);
        }
        return ok().body(false);
    }

    @Override
    public ResponseEntity<Boolean>
    updatePassword(Long userId, AccountRequest request) {
        if (!isEmpty(request.getPassword())) {
            Boolean updated = this.userUsecase.updatePassword(userId, request.getPassword());
            return ok().body(updated);
        }
        return ok().body(false);
    }

    @Override
    public ResponseEntity<Boolean> toggleStatus(Long userId) {
        Optional<Boolean> optional = this.userUsecase.toggleActiveStatus(userId);
        return ok().body(optional.orElse(false));
    }

//    private AccountRequest mapEmployeeToAccountRequest(CompanyEmployee employee) {
//        User user = employee.getAccountDetail();
//
//        AccountRequest request = new AccountRequest();
//        request.setId(user.getId());
//        request.setEmployeeId(employee.getId());
//        request.setUserId(user.getId());
//        request.setName(employee.getPersonalDetail().getEmployeeFullName());
//        request.setUsername(user.getUsername());
//        request.setRoles(user.getRoles().stream().map(RoleRequest::toPartialRequest).collect(Collectors.toList()));
//        request.setPhone(employee.getPersonalDetail().getEmployeePhone());
//        request.setIsActiveStatus(user.getIsActiveStatus());
//        request.setExpiryDate(Util.formatDate(user.getExpirationDate()));
//        return request;
//    }
}
