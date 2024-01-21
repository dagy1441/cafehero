package com.dagy.cafeheroapi.core.params.files;

public interface DataImporter<Type, Data> {
    Type export(Data dataToImport);
}