package com.example.demo.login.domain.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class SignupForm {
    //入力必須、メールアドレス形式
    //@NotBlank(message = "{require_check}")
    //@Email(message = "{email_check}")
    @NotBlank(groups = ValidGroup1.class)
    @Email(groups = ValidGroup2.class)
    private String userId;

    //必須入力、長さ4から100桁まで、半角英数字のみ
    //@NotBlank(message = "{require_check}")
    @NotBlank(groups = ValidGroup1.class)
    //@Length(min = 4, max = 100, message = "{length_check}")
    @Length(min=4, max=100, groups = ValidGroup2.class)

    //@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "{pattern_check}")
    @Pattern(regexp = "^[a-zA-Z0-9]+$",groups = ValidGroup3.class)
    private String password;

    //必須入力
    //@NotBlank(message = "{require_check}")
    @NotBlank(groups = ValidGroup1.class)
    public String userName;

    //必須入力
    //@NotNull(message = "{require_check}")
    @NotNull(groups = ValidGroup1.class)
    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date birthday;

    //値が20から100まで
    @Min(value = 20,groups = ValidGroup2.class)
    @Max(value = 100, groups = ValidGroup2.class)
    private int age;

    //falseのみ可能
    @AssertFalse(groups = ValidGroup2.class)
    private boolean marriage;
}
