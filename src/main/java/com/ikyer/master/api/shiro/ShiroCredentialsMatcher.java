package com.ikyer.master.api.shiro;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.ByteSource;

/**
 * 自定义密码匹配规则<br>
 * 限制用户登录次数
 * 
 * @author larry.qi
 */
public class ShiroCredentialsMatcher extends SimpleCredentialsMatcher {

  private Cache<String, AtomicInteger> passwordRetryCache;

  /**
   * 参考EhCache.xml配置参数
   * 
   * @param cacheManager
   */
  public ShiroCredentialsMatcher(CacheManager cacheManager) {
    passwordRetryCache = cacheManager.getCache("shiro.passwordRetryCache");
  }

  @Override
  public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
    // 用户登录次数限制：retry count + 1
    String username = (String) token.getPrincipal();
    AtomicInteger retryCount = passwordRetryCache.get(username);

    if (retryCount == null) {
      retryCount = new AtomicInteger(0);
      passwordRetryCache.put(username, retryCount);
    }

    // incrementAndGet获取当前值并自增
    if (retryCount.incrementAndGet() > 5) {
      throw new ExcessiveAttemptsException("登录次数过多");
    }

    UsernamePasswordToken authToken = (UsernamePasswordToken) token;
    SimpleAuthenticationInfo authInfo = (SimpleAuthenticationInfo) info;
    String passwd = String.valueOf(authToken.getPassword()); // 用户登录时输入的密码
    ByteSource salt = authInfo.getCredentialsSalt(); // SHIRO登录校验时设置的salt值
    String password = EncryptHelper.encrypt(passwd, salt); // 加密处理后的密码
    Object dbPasswd = getCredentials(info); // 数据库中存储的密码

    // 密码匹配，成功则移除缓存数据并返回true
    boolean matches = super.equals(dbPasswd, password);

    if (matches) {
      passwordRetryCache.remove(username);
    }

    return matches;
  }

}
