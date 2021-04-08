package org.anyulled.model;

/**
 * Entry point for assertions of different data types. Each method in this class is a static factory for the
 * type-specific assertion objects.
 */
public class Assertions {

  /**
   * Creates a new instance of <code>{@link org.anyulled.exceptions.MyPatientExceptionAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.anyulled.exceptions.MyPatientExceptionAssert assertThat(org.anyulled.exceptions.MyPatientException actual) {
    return new org.anyulled.exceptions.MyPatientExceptionAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.anyulled.model.GenderAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.anyulled.model.GenderAssert assertThat(org.anyulled.model.Gender actual) {
    return new org.anyulled.model.GenderAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.anyulled.model.PatientAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.anyulled.model.PatientAssert assertThat(org.anyulled.model.Patient actual) {
    return new org.anyulled.model.PatientAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.anyulled.service.PatientServiceAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.anyulled.service.PatientServiceAssert assertThat(org.anyulled.service.PatientService actual) {
    return new org.anyulled.service.PatientServiceAssert(actual);
  }

  /**
   * Creates a new <code>{@link Assertions}</code>.
   */
  protected Assertions() {
    // empty
  }
}
