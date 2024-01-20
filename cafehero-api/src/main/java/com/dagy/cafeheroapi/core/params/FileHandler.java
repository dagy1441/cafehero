package com.dagy.cafeheroapi.core.params;

import com.dagy.cafeheroapi.core.constants.enums.Template;
import org.springframework.core.io.Resource;

public interface FileHandler <R, I> {
    Resource downloadTemplate(Template template);

    // todo:: Before uploading, perform the following
    //  1. check user plan,
    //  2. count existing entity size
    R uploadTemplate(I input);
}
