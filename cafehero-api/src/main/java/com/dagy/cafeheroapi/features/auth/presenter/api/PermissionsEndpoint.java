package com.dagy.cafeheroapi.features.auth.presenter.api;

import org.springframework.web.bind.annotation.RequestMapping;

import static com.dagy.cafeheroapi.core.constants.GlobalConstant.API_PREFIX;

@RequestMapping(value = API_PREFIX + "/auth/permission")
public interface PermissionsEndpoint {
}
