package cn.ruletest.login.rule;

import java.util.Map;

import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Failed;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.annotation.Success;
import org.jeasy.rules.api.Facts;

import cn.ruletest.login.entity.User;

@Rule(name = "check password", description = "validate password")
public class PasswordChecking {

	@Condition
	public boolean checkPassword(@Fact("login") User user) {
		System.out.println("checkPassword : " + System.currentTimeMillis());
		return false;
	}

	@Success
	public void success(Facts facts) {

		Map<String, Boolean> result = facts.get("result");
		result.put("password checking", true);
	}

	@Failed
	public void failed(Facts facts) {
		Map<String, Boolean> result = facts.get("result");
		result.put("password checking", false);
	}
}
