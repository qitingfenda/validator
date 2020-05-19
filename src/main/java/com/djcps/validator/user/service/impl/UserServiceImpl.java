package com.djcps.validator.user.service.impl;

import com.djcps.validator.common.base.BaseService;
import com.djcps.validator.common.entity.MsgStyle;
import com.djcps.validator.common.entity.MsgViewTime;
import com.djcps.validator.user.model.AddUserModel;
import com.djcps.validator.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author yhc
 * @create 2020-05-06 20:23
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Override
    public boolean addUser(AddUserModel model) {
        String msgStyleId = "625839201e48441087e5af16cf9389e5";
        MsgStyle msgStyleInfo = getBaseModelById(msgStyleId, MsgStyle.class);
        String msgViewTimeId = "1bcabbde8f4411ea86bde28508164813";
        MsgViewTime msgViewTimeInfo = getBaseModelById(msgViewTimeId, MsgViewTime.class);
        return true;
    }
}
