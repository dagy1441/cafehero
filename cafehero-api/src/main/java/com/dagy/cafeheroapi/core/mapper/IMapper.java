package com.dagy.cafeheroapi.core.mapper;

public interface IMapper<RES,REQ, M> {
    // R -> RequestObject, M -> Model Object

    REQ toRequest(M model);
    RES toResponse(REQ request);
    M toModel(REQ request);

}
