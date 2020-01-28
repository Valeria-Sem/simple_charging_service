
import {Router} from "@angular/router";
import {UserService} from "./user.service";

export function initApp(userService: UserService) {
  return () => {
    return new Promise((resolve) => {
      const user = JSON.parse(localStorage.getItem("user"));
      if (user) {
        userService.setUser(user);
      } else {
        // router.navigate(['/']);
      }
      resolve();
    });
  };
}
