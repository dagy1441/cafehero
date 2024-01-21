package com.dagy.cafeheroapi.core.params.files;

public interface DataExporter<Type, Data> {
    Type export(Data dataToExport);
}