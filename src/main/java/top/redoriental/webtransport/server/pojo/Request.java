package top.redoriental.webtransport.server.pojo;

import java.util.HashMap;

public class Request {
  protected String remoteAddress;

  protected String route;

  protected String authority;

  protected HashMap<String,String> requestHeaders = new HashMap<>();
  
  protected Request() {
  }

  public String getAuthority() {
    return authority;
  }

  public String getRoute() {
    return route;
  }

  public String getRemoteAddress() {
    return remoteAddress;
  }

  public HashMap getHeaders() {
    return requestHeaders;
  }

  @Override
  public String toString() {
    return "Request{" +
            "remoteAddress='" + remoteAddress + '\'' +
            ", route='" + route + '\'' +
            ", authority='" + authority + '\'' +
            ", requestHeaders=" + requestHeaders +
            '}';
  }
}
