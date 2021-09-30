package com.ruoyi.common.constant;

/**
 * 通用常量信息
 *
 * @author ruoyi
 */
public class Constants
{
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";

    /**
     * http请求
     */
    public static final String HTTP = "http://";

    /**
     * https请求
     */
    public static final String HTTPS = "https://";

    /**
     * 通用成功标识
     */
    public static final String SUCCESS = "0";

    /**
     * 通用失败标识
     */
    public static final String FAIL = "1";

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 登录用户 redis key
     */
    public static final String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * 防重提交 redis key
     */
    public static final String REPEAT_SUBMIT_KEY = "repeat_submit:";

    /**
     * 验证码有效期（分钟）
     */
    public static final Integer CAPTCHA_EXPIRATION = 2;

    /**
     * 令牌
     */
    public static final String TOKEN = "token";

    /**
     * 令牌前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 令牌前缀
     */
    public static final String LOGIN_USER_KEY = "login_user_key";

    /**
     * 用户ID
     */
    public static final String JWT_USERID = "userid";

    /**
     * 用户名称
     */
    public static final String JWT_USERNAME = "sub";

    /**
     * 用户头像
     */
    public static final String JWT_AVATAR = "avatar";

    /**
     * 创建时间
     */
    public static final String JWT_CREATED = "created";

    /**
     * 用户权限
     */
    public static final String JWT_AUTHORITIES = "authorities";

    /**
     * 参数管理 cache key
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";

    /**
     * 字典管理 cache key
     */
    public static final String SYS_DICT_KEY = "sys_dict:";

    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";

	/**
	 * RMI 远程方法调用
	 */
	public static final String LOOKUP_RMI = "rmi://";

	/**
	 * 资源映射路径 前缀
	 */
	public static final String REDIS_LOCK_KEY = "redis_lock:";

    /**
     * 支付宝配置
     */
    public static String appId = "2021002139679881";
    public static String privatekey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCr3JT7jYCwyw4mGA4zWG2OLAhRb/GKji1FDKtFM4X2iGpW9Dv/JGqE9bbxGYSSEa+h4BkavxUtgSBadMfkfnIXpgH03R29IH16WyaDkuAfmemPeIzkH/TOKlkxBv+/h2QZ87S3a6l0sciYHmgYW/Zecl0JDrq8VBJRprDdJF4HpmRh8gB7y6fCtQrHPLp6/JvL2GfLO4xB8KCv51S1Rp2yjqNm5gjD0OiD8aXdxtxqya3EGWU/dQFvKRsfyWKl1vkBWSJSok4ZI97D0msGwtTWlasCMdtXIpjOIdGcKCoRsT0coZmbgMV+7omahH4MXrtyrEoiqSZ1iVo9dWiL1tuzAgMBAAECggEADH7cQjH2omQRIknrdmY+iPDAphMqj7VoqzWRmlV1rwgaGzpkxldCe2pWI8+EKQ6qI23kxWIRSx6xWIJXKlDbQMbsK36MM/0RwnywHy7lpsaNCcZtEAUWyoqfs4XbwHQ6nfxvLkrgpkBq4kyLqwG8tv8/rnHot9qw/kjNYTbMs2eRqhE4qy2oIbPrhAm8K9QAoTsS3beQP49DPWo7nWQJMJNReyDcQVeDgV4gdS0qOyYKWqGRZrof6RJz6K9e56GoxvQ100zkyvFOEY3UTTcljqmOJeOArqqysinWnO9jIVCRQYr6b/+jZp9b/Jeji+3y4HhdbPfPF9G9pcdnuuPIwQKBgQD8y6ea0Zz23h6dPtL42LTB3vU5vDzH70pvnol62Kpygbxb6eCqifcTtmPEy02eD3oO8iM2DoqRIhFrxWLOlhdl7/I2mqIf5TA8Cx7zppw/A6iBfXo195NYCRG+DakQ7dW9iF/31CesSYwrJLOFuJlnj9isWWMAaaT94uzoViVA4QKBgQCuCkoJBXGdo9ia/I2iLKrJy5gDaX+1fPUEYsnWOopNATGVomUxaIznuHXEGRog2ELOi7GFnm7WNQERVxvC6N/y4W0ca4LjeurS+WQ6xXO/JhY35JToroPYA2iuWcrLF/JaxYJ6qwfl/pj5g23JO8hmgZI9EC2zT0Wvff0qEpVrEwKBgQCPys/VUnH0QjgrvXaHscxvkoDujFIOb+BpSUZuKBwb8gvQRGJU3xE5lz98yx+lTqxhH/5DW1YaY8SBBs/DLsC0bR3bTW32sokTPkgm05iAh3Yr4dHILMEVDGOZNW/7fy1bF91uvLCsYVFnoQK0h2JK9BmNP3L+4xjEiXW0WnvqQQKBgBdinowTxS5vY51/rfBKnDA9QRHETTqvraSHOaOlfgvWyzjV907qQ3SnXnuY+9/J70AdmR7hKPdza89OqxZHgD/8dlLJR28VhxQOGp+jBGh8z6N2/WM+f8y4uIok2pDriM8VlvCwpoEK8rckJ85QUB8l7eZylBFx52UrQqcylA0tAoGBAIcYSPhwc6gQROmRv7vzev16RTOMUqg5Y79wd2ylu8SnTfaU1RDhuJ6XUBFO3djnbt87UHKMLREPEJZziYveb6IHx8FA+pdyPqncwpBjj3/lEe/WdmVjjS9QirkiV/0w55NLBLIlSEOTJSV4TL4gfFyTRPKCbDYGEedM5In3+wSt";
    public static String alipaypublickey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlLg7YkRi0U1tGDorUOykr+TmNsSR1A8CWxYVZVhpsYFZAUXD9eDwCZouv0ujWvMWP1e38yXH7eUxHNP9dyVlB0BelTN4BECrd8pm+hqalIKaalPG50UNVHSErJvtw5vDoEPspGvIJPRXrFoz2pKE0EcAliOFT5Pt6nNz8wcCKMyTyCaDZnkg74AVk6BDfbe/pUsVmta4Tfe2UJJQA9aj22ZyIPvH8IYhcfOS34qu3TdQTR1m8hDUjKiNMUpgqSDE2MypHeT8TsbaDagrHWJxDJVc9D1x1etcNZLAK5ZA4G/0wt1rmz+tjCs9QiLwY8Ei8CgVDXMib5AyehrbqrvM0wIDAQAB";


    public static final String MESSAGE_FLAG = "ACTIVITY";
}
