package org.reactivestreams.tck;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Annotations {
  private Annotations() {}

  /**
   * Used to mark tests for specification rules which were currently impossible to be implemented.
   * For example tests like "Publisher SHOULD consider Subscription as ..." - is inherently hard to specifically test.
   */
  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.SOURCE)
  static @interface NotVerified {
  }

  /**
   * Used to mark stochastic tests which MAY yield false positives (pass) can violate the tested rule in some specific scenario.
   */
  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.SOURCE)
  static @interface Stochastic {
  }

  /**
   * Used to mark tests that MUST pass in all (even very restricted types of) Publishers / Subscribers.
   */
  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.SOURCE)
  static @interface Required {
  }

  /**
   * Used to mark how many subscribers will be used on the publisher under test.
   * If an implementation declares it does not support enough subscribers as needed by such test, it will be SKIPPed instead of FAILed.
   */
  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.SOURCE)
  static @interface Subscribers {
    long value() default 1;
  }

  /**
   * Used to mark tests which may be skipped / not implemented by certain implementations.
   * These tests can be skipped by returning null from the given factory method.
   */
  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.SOURCE)
  static @interface Additional {
    /** Description of situation when it's OK to not pass this test */
    String value() default "";

    /** Name of the method to be implemented (returning <em>not</em> {@code null}) if this test should be run. */
    String implement() default "";
  }

}
