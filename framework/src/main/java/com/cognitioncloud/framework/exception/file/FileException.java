package com.cognitioncloud.framework.exception.file;

import com.cognitioncloud.framework.exception.base.BaseException;

/**
 * 文件信息异常类
 *
 * @author 1122
 */
public class FileException extends BaseException {
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args) {
        super("file", code, args, null);
    }

}
