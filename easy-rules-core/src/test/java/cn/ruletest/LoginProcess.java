package cn.ruletest;

import java.util.HashMap;
import java.util.Map;

import org.jeasy.rules.api.Fact;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Model;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

import cn.ruletest.login.entity.User;
import cn.ruletest.login.rule.LoginPermissionChecking;
import cn.ruletest.login.rule.PasswordChecking;

public class LoginProcess {

	public static void main(String[] args) {

		Map<String, Boolean> result = new HashMap<String, Boolean>();
		RulesEngine ruleEngine = new DefaultRulesEngine();
		Rules rules = new Rules(new LoginPermissionChecking(), new PasswordChecking());

		Facts facts = new Facts();
		facts.add(new Fact("login", new User("tong", "pwd")));
		facts.put("result", result);
		ruleEngine.fire(rules, facts, Model.All);
		result.forEach((key, value) -> System.out.println("key : " + key + "--- value : " + value ));

	}

}
