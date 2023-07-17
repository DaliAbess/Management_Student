package com.abess.prj.Service;

import com.abess.prj.Entity.user;

public interface userService {
 user registerUser(String login, String password );
 user authentificate(String login, String password );
}
