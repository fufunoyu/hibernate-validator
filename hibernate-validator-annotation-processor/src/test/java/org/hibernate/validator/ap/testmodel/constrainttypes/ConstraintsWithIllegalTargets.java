// $Id: ConstraintsWithIllegalTargets.java 19033 Aug 1, 2010 5:44:13 PM gunnar.morling $
/*
* JBoss, Home of Professional Open Source
* Copyright 2009, Red Hat Middleware LLC, and individual contributors
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.hibernate.validator.ap.testmodel.constrainttypes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * @author Gunnar Morling
 */
public interface ConstraintsWithIllegalTargets {


	/**
	 * Compilation error expected due to none supported target type being given.
	 */
	@Constraint(validatedBy = { })
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ LOCAL_VARIABLE })
	public @interface ConstraintWithWrongTarget {

	}

	/**
	 * Compilation error expected as no supported target type is given.
	 */
	@Constraint(validatedBy = { })
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ })
	public @interface ConstraintWithEmptyTarget {

	}

	/**
	 * No compilation error expected, as not specifying @Target allows this constraint for all element types.
	 */
	@Constraint(validatedBy = { })
	@Retention(RetentionPolicy.RUNTIME)
	public @interface ConstraintWithDefaultTarget {

	}

	/**
	 * No compilation error expected, as supported target type FIELD is given.
	 */
	@Constraint(validatedBy = { })
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ FIELD })
	public @interface ConstraintWithAllowedTargetField {

	}

	/**
	 * No compilation error expected, as supported target type METHOD is given.
	 */
	@Constraint(validatedBy = { })
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ METHOD })
	public @interface ConstraintWithAllowedTargetMethod {

	}

	/**
	 * No compilation error expected, as supported target type TYPE is given.
	 */
	@Constraint(validatedBy = { })
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ TYPE })
	public @interface ConstraintWithAllowedTargetType {

	}

	/**
	 * No compilation error expected, as supported target type ANNOTATION_TYPE is given.
	 */
	@Constraint(validatedBy = { })
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ANNOTATION_TYPE })
	public @interface ConstraintWithAllowedTargetAnnotationType {

	}

}