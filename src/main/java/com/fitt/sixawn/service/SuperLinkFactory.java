/*
 * Copyright (c) 2020 by FITT.inc All rights reserved
 */
package com.fitt.sixawn.service;

import com.fitt.sixawn.entity.SuperLink;

/**
 * <p>@description TODO </p>
 * <p>@author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since 2020-03-24 </p>
 * <p>@version 1.0.0 </p>
 */
public abstract class SuperLinkFactory {

    /**
     * <p>短链工厂</p>
     * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
     * <p>@date 2020/3/24</p>
     * <p>@param superLink </p>
     * <p>@return {@link String}</p>
     * <p>@throws</p>
     */
    public String genShortLink(SuperLink superLink) {

        return null;
    }

    abstract boolean validate(SuperLink superLink);
}
