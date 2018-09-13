package com.pingan.vprcengine.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * TODO
 * /**
 * 因为Spring boot 2.0.3引用的security依赖是 spring security 5.X版本，
 * 此版本需要提供一个PasswordEncorder的实例，否则后台会报错误：
 * java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
 * 并且页面毫无响应。
 * @return
 * @author ThinkPad
 * @date 2018/9/7 13:40
 * @return
 */

@Component
public class EnginePasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
