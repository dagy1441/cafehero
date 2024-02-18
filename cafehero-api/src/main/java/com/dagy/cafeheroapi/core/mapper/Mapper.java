package com.dagy.cafeheroapi.core.mapper;

public interface Mapper<R, M> {
    // R -> RequestObject, M -> Model Object

    R toRequest(M model);

    M toModel(R request);

}

