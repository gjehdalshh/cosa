package com.spring.cosa.user.exception;

import javax.validation.GroupSequence;

import com.spring.cosa.user.exception.ValidationGroups.DefaultGroup;
import com.spring.cosa.user.exception.ValidationGroups.EmailCheckGroup;
import com.spring.cosa.user.exception.ValidationGroups.NotEmptyGroup;
import com.spring.cosa.user.exception.ValidationGroups.NotNullGroup;
import com.spring.cosa.user.exception.ValidationGroups.PatternCheckGroup;
import com.spring.cosa.user.exception.ValidationGroups.SizeCheckGroup;

@GroupSequence({DefaultGroup.class, NotNullGroup.class, NotEmptyGroup.class, EmailCheckGroup.class,
PatternCheckGroup.class, SizeCheckGroup.class})
public interface ValidationSequence {

}
