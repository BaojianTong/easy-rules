package cn.ruletest.login.rule;

import java.util.Map;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Failed;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.annotation.Success;
import org.jeasy.rules.api.Facts;

import cn.ruletest.login.entity.User;

@Rule(name = "login permission checking", description = "for checking login permission")
public class LoginPermissionChecking {
	
	@Condition
	public boolean checkLoginPermission(@Fact("login") User user) {
		return false;
	}

	@Success
	public void success(Facts facts ) {
		Map<String, Boolean> result = facts.get("result") ; 
		result.put("login permission", true) ; 
	}
	@Failed
	public void failed(Facts facts ) {
		Map<String, Boolean> result = facts.get("result") ; 
		result.put("login permission", false) ; 
	}

}
