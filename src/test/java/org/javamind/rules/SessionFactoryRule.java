package org.javamind.rules;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class SessionFactoryRule implements MethodRule{

	@Override
	public Statement apply(Statement base, FrameworkMethod method, Object target) {
		// TODO Auto-generated method stub
		return new Statement() {
			
			@Override
			public void evaluate() throws Throwable {
				// TODO Auto-generated method stub
				
			}
		};
	}

}
