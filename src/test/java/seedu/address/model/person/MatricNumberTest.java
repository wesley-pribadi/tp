package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class MatricNumberTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new MatricNumber(null));
    }

    @Test
    public void constructor_invalidAddress_throwsIllegalArgumentException() {
        String invalidAddress = "";
        assertThrows(IllegalArgumentException.class, () -> new MatricNumber(invalidAddress));
    }

    @Test
    public void isValidMatricNumber() {
        // null address
        assertThrows(NullPointerException.class, () -> MatricNumber.isValidMatricNumber(null));

        // invalid addresses
        assertFalse(MatricNumber.isValidMatricNumber("")); // empty string
        assertFalse(MatricNumber.isValidMatricNumber(" ")); // spaces only

        // valid addresses
        assertTrue(MatricNumber.isValidMatricNumber("Blk 456, Den Road, #01-355"));
        assertTrue(MatricNumber.isValidMatricNumber("-")); // one character
        assertTrue(MatricNumber.isValidMatricNumber("Leng Inc; 1234 Market St; San Francisco CA 2349879; USA")); // long address
    }

    @Test
    public void equals() {
        MatricNumber matricNumber = new MatricNumber("Valid Address");

        // same values -> returns true
        assertTrue(matricNumber.equals(new MatricNumber("Valid Address")));

        // same object -> returns true
        assertTrue(matricNumber.equals(matricNumber));

        // null -> returns false
        assertFalse(matricNumber.equals(null));

        // different types -> returns false
        assertFalse(matricNumber.equals(5.0f));

        // different values -> returns false
        assertFalse(matricNumber.equals(new MatricNumber("Other Valid Address")));
    }
}
