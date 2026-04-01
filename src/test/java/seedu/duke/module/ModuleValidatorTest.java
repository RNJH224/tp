package seedu.duke.module;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModuleValidatorTest {

    /*
     *  isValidModuleCode(String code)
     *
     *  Specification (black-box view):
     *  Returns true  if code matches: [A-Z]{2,3} + [0-9]{4} + [A-Z]?
     *  Returns false for anything else (null, blank, wrong format).
     *
     *  Equivalence Partitions:
     *  VALID   [V1] 2-letter prefix + 4 digits            e.g. CS2113
     *  VALID   [V2] 3-letter prefix + 4 digits            e.g. CDE2501
     *  VALID   [V3] 2/3-letter prefix + 4 digits + letter e.g. CS2040C
     *  INVALID [I1] null input
     *  INVALID [I2] blank / whitespace-only
     *  INVALID [I3] empty string                (boundary: length 0)
     *  INVALID [I4] 1-letter prefix             (boundary below [V1])
     *  INVALID [I5] 4-letter prefix             (boundary above [V2])
     *  INVALID [I6] only 3 digits               (boundary below 4-digit rule)
     *  INVALID [I7] 5 digits                    (boundary above 4-digit rule)
     *  INVALID [I8] lowercase letters
     *  INVALID [I9] 2 trailing letters          (boundary above optional-letter rule)
     *  INVALID [I10] digit embedded in prefix
     */

    @Test
    public void isValidModuleCode_twoLetterPrefix_returnsTrue() {
        assertTrue(ModuleValidator.isValidModuleCode("CS2113"));
    }

    @Test
    public void isValidModuleCode_threeLetterPrefix_returnsTrue() {
        assertTrue(ModuleValidator.isValidModuleCode("CDE2501"));
    }

    @Test
    public void isValidModuleCode_withTrailingLetter_returnsTrue() {
        assertTrue(ModuleValidator.isValidModuleCode("CS2040C"));
    }

    @Test
    public void isValidModuleCode_nullInput_returnsFalse() {
        assertFalse(ModuleValidator.isValidModuleCode(null));
    }

    @Test
    public void isValidModuleCode_blankInput_returnsFalse() {
        assertFalse(ModuleValidator.isValidModuleCode("   "));
    }

    @Test
    public void isValidModuleCode_emptyString_returnsFalse() {
        assertFalse(ModuleValidator.isValidModuleCode(""));
    }

    @Test
    public void isValidModuleCode_oneLetterPrefix_returnsFalse() {
        assertFalse(ModuleValidator.isValidModuleCode("C2113"));
    }

    @Test
    public void isValidModuleCode_fourLetterPrefix_returnsFalse() {
        assertFalse(ModuleValidator.isValidModuleCode("ABCD2113"));
    }

    @Test
    public void isValidModuleCode_onlyThreeDigits_returnsFalse() {
        assertFalse(ModuleValidator.isValidModuleCode("CS211"));
    }

    @Test
    public void isValidModuleCode_fiveDigits_returnsFalse() {
        assertFalse(ModuleValidator.isValidModuleCode("CS21130"));
    }

    @Test
    public void isValidModuleCode_lowercaseInput_returnsFalse() {
        assertFalse(ModuleValidator.isValidModuleCode("cs2113"));
    }

    @Test
    public void isValidModuleCode_twoTrailingLetters_returnsFalse() {
        assertFalse(ModuleValidator.isValidModuleCode("CS2113AB"));
    }

    @Test
    public void isValidModuleCode_digitInPrefix_returnsFalse() {
        assertFalse(ModuleValidator.isValidModuleCode("C1S2113"));
    }


    @Test
    public void validateModuleCode_validCode_doesNotThrow() {
        assertDoesNotThrow(() -> ModuleValidator.validateModuleCode("CS2113"));
    }

    @Test
    public void validateModuleCode_nullCode_throwsWithEmptyMessage() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> ModuleValidator.validateModuleCode(null));
        assertEquals("Module code cannot be empty.", ex.getMessage());
    }

    @Test
    public void validateModuleCode_blankCode_throwsWithEmptyMessage() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> ModuleValidator.validateModuleCode("  "));
        assertEquals("Module code cannot be empty.", ex.getMessage());
    }

    @Test
    public void validateModuleCode_invalidFormat_messageContainsBadCode() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> ModuleValidator.validateModuleCode("BADCODE"));
        assertTrue(ex.getMessage().contains("BADCODE"));
    }

    @Test
    public void validateModuleCode_invalidFormat_messageContainsFormatHint() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> ModuleValidator.validateModuleCode("BADCODE"));
        assertTrue(ex.getMessage().length() > "BADCODE".length(),
                "Error message should contain more than just the rejected code");
    }

    @Test
    public void validateMc_positiveValue_doesNotThrow() {
        assertDoesNotThrow(() -> ModuleValidator.validateMc(4));
    }

    @Test
    public void validateMc_lowerBoundary_doesNotThrow() {
        assertDoesNotThrow(() -> ModuleValidator.validateMc(1));
    }

    @Test
    public void validateMc_upperBoundary_doesNotThrow() {
        assertDoesNotThrow(() -> ModuleValidator.validateMc(12));
    }
    @Test
    public void validateMc_nullValue_throwsWithMcFlagHint() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> ModuleValidator.validateMc(null));
        assertTrue(ex.getMessage().contains("/mc"));
    }

    @Test
    public void validateMc_zeroValue_throwsWithPositiveIntegerMessage() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> ModuleValidator.validateMc(0));
        assertTrue(ex.getMessage().contains("positive integer"));
    }

    @Test
    public void validateMc_negativeValue_throwsWithPositiveIntegerMessage() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> ModuleValidator.validateMc(-4));
        assertTrue(ex.getMessage().contains("positive integer"));
    }

    @Test
    public void validateInternalMc_nullSupplied_doesNotThrow() {
        assertDoesNotThrow(() -> ModuleValidator.validateInternalMc(null, 4, "CS2113"));
    }

    @Test
    public void validateInternalMc_matchingMc_doesNotThrow() {
        assertDoesNotThrow(() -> ModuleValidator.validateInternalMc(4, 4, "CS2113"));
    }

    @Test
    public void validateInternalMc_bothNull_doesNotThrow() {
        assertDoesNotThrow(() -> ModuleValidator.validateInternalMc(null, null, "CS2113"));
    }

    @Test
    public void validateInternalMc_mismatchedMc_throwsWithAllDetails() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> ModuleValidator.validateInternalMc(2, 4, "CS2113"));
        assertTrue(ex.getMessage().contains("CS2113"));
        assertTrue(ex.getMessage().contains("4"));
        assertTrue(ex.getMessage().contains("2"));
    }
}
