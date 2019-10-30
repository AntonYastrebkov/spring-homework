package com.epam.security;


public class SecurityService {

  public boolean isAdmin(String role) {
    if ("ADMIN_USER".equals(role)) {
      return true;
    } else {
      return false;
    }
  }
}
