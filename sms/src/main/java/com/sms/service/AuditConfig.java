package com.sms.service;

import org.springframework.data.domain.AuditorAware;

public class AuditConfig {

	public AuditAwareImpl auditorAware() {
		return new AuditAwareImpl();
		
	}
}
