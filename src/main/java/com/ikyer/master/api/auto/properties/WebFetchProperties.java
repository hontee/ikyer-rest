package com.ikyer.master.api.auto.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 抓取配置
 * @author larry.qi
 */
@Configuration
@ConfigurationProperties(prefix = "web.fetch")
public class WebFetchProperties {
  
  private String userAgent;
  private int timeout;
  private boolean followRedirects;
  private boolean ignoreContentType;
  private boolean ignoreHttpErrors;
  
  public WebFetchProperties() {}

  public String getUserAgent() {
    return userAgent;
  }

  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }

  public int getTimeout() {
    return timeout;
  }

  public void setTimeout(int timeout) {
    this.timeout = timeout;
  }

  public boolean isFollowRedirects() {
    return followRedirects;
  }

  public void setFollowRedirects(boolean followRedirects) {
    this.followRedirects = followRedirects;
  }

  public boolean isIgnoreContentType() {
    return ignoreContentType;
  }

  public void setIgnoreContentType(boolean ignoreContentType) {
    this.ignoreContentType = ignoreContentType;
  }

  public boolean isIgnoreHttpErrors() {
    return ignoreHttpErrors;
  }

  public void setIgnoreHttpErrors(boolean ignoreHttpErrors) {
    this.ignoreHttpErrors = ignoreHttpErrors;
  }

}
