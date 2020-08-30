package com.example.demo.login.domain.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class SignupForm {
    //入力必須、メールアドレス形式
    @NotBlank(message = "{require_check}")
    @Email(message = "{email_check}")
    private String userId;

    //必須入力、長さ4から100桁まで、半角英数字のみ
    @NotBlank(message = "{require_check}")
    @Length(min = 4, max = 100, message = "{length_check}")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "{pattern_check}")
    private String password;

    //必須入力
    @NotBlank(message = "{require_check}")
    public String userName;

    //必須入力
    @NotNull(message = "{require_check}")
    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date birthday;

    //値が20から100まで
    @Min(value = 20, message = "{min_check}")
    @Max(value = 100, message = "{max_check}")
    private int age;

    //falseのみ可能
    @AssertFalse(message = "{false_check")
    private boolean marriage;
}
