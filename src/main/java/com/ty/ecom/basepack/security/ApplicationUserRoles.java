package com.ty.ecom.basepack.security;

import java.util.Set;

import com.google.common.collect.Sets;


public enum ApplicationUserRoles {

	STUDENT(Sets.newHashSet()),
	ADMIN(Sets.newHashSet(ApplicationUserPermission.STUDENT_READ, ApplicationUserPermission.STUDENT_WRITE, ApplicationUserPermission.COURSE_READ, ApplicationUserPermission.COURSE_WRITE)),
	ADMINTRAINEE(Sets.newHashSet(ApplicationUserPermission.STUDENT_READ, 
			 ApplicationUserPermission.COURSE_READ));
	private final Set<ApplicationUserPermission> permissions;

	private ApplicationUserRoles(Set<ApplicationUserPermission> permissions) {
		this.permissions = permissions;
	}

	public Set<ApplicationUserPermission> getPermissions() {
		return permissions;
	}

}
