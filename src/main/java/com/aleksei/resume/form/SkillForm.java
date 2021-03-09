package com.aleksei.resume.form;

import com.aleksei.resume.entity.Skill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SkillForm implements Serializable {

    private static final long serialVersionUID = 6759196304127998224L;
    private List<Skill> items = new ArrayList<>();
}
