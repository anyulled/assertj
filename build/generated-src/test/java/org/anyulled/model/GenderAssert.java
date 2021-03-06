package org.anyulled.model;

import org.assertj.core.api.AbstractAssert;

/**
 * {@link Gender} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GenderAssert extends AbstractAssert<GenderAssert, Gender> {

  /**
   * Creates a new <code>{@link GenderAssert}</code> to make assertions on actual Gender.
   * @param actual the Gender we want to make assertions on.
   */
  public GenderAssert(Gender actual) {
    super(actual, GenderAssert.class);
  }

  /**
   * An entry point for GenderAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGender)</code> and get specific assertion with code completion.
   * @param actual the Gender we want to make assertions on.
   * @return a new <code>{@link GenderAssert}</code>
   */
  public static GenderAssert assertThat(Gender actual) {
    return new GenderAssert(actual);
  }

}
