package com.realm.cognitioncommon.exception.file;

import com.realm.cognitioncommon.exception.base.BaseException;

/**
 * 文件信息异常类
 * 
 * @author 1122
 */
public class FileException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}
