package site.nomoreparties.stellarburgers;

public class EnvConfig {
    public static final int IMPLICIT_WAIT = 5;
    public static final int EXPLICIT_WAIT = 10;

    // креды от постоянного тестового пользователя
    public static final String email = "test-user-for-diplom3@gmail.com";
    public static final String password = "test-user-for-diplom3";
    public static final String name = "test-user-for-diplom3";

    // урлы
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    public static final String REGISTER_URL = "https://stellarburgers.nomoreparties.site/register";
    public static final String RESET_PASSWORD_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    public static final String PROFILE_URL = "https://stellarburgers.nomoreparties.site/account/profile";


    // ручки апи
    public static final String REGISTER_API = "/api/auth/register";
    public static final String AUTH_API = "/api/auth/user";
    public static final String LOGIN_API = "/api/auth/login";

}
