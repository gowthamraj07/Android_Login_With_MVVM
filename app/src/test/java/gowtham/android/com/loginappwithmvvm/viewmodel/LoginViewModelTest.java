package gowtham.android.com.loginappwithmvvm.viewmodel;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import static org.junit.Assert.*;

public class LoginViewModelTest {

    public static final String ANY_USER_ID = "any value";
    public static final String EMPTY_USER_ID = "";
    public static final String EMPTY_PASSWORD = "";
    public static final String ANY_PASSWORD = "any password";
    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    private LoginViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        viewModel = new LoginViewModel();
    }

    @Test
    public void setErrorMessagesToFalseWhenInitializing() {
        viewModel.initialize();

        assertNotNull(viewModel.userIdError);
        assertNotNull(viewModel.userIdError.getValue());
        assertFalse(viewModel.userIdError.getValue());
        assertNotNull(viewModel.passwordError);
        assertNotNull(viewModel.passwordError.getValue());
        assertFalse(viewModel.passwordError.getValue());
    }

    @Test
    public void setUserIdErrorToTrueWhenUserIdIsInvalid() {
        viewModel.signIn(EMPTY_USER_ID,EMPTY_PASSWORD);

        assertNotNull(viewModel.userIdError);
        assertNotNull(viewModel.userIdError.getValue());
        assertTrue(viewModel.userIdError.getValue());
        assertNotNull(viewModel.validationStatus);
        assertNotNull(viewModel.validationStatus.getValue());
        assertFalse(viewModel.validationStatus.getValue());
    }

    @Test
    public void setPasswordErrorToTrueWhenPasswordIsInvalid() {
        viewModel.signIn(EMPTY_USER_ID, EMPTY_PASSWORD);

        assertNotNull(viewModel.passwordError);
        assertNotNull(viewModel.passwordError.getValue());
        assertTrue(viewModel.passwordError.getValue());
        assertNotNull(viewModel.validationStatus);
        assertNotNull(viewModel.validationStatus.getValue());
        assertFalse(viewModel.validationStatus.getValue());
    }

    @Test
    public void hideUserIdErrorWhenUserIdHasSomeValues() {
        viewModel.signIn(ANY_USER_ID,EMPTY_PASSWORD);

        assertNotNull(viewModel.userIdError);
        assertNotNull(viewModel.userIdError.getValue());
        assertFalse(viewModel.userIdError.getValue());
        assertNotNull(viewModel.validationStatus);
        assertNotNull(viewModel.validationStatus.getValue());
        assertFalse(viewModel.validationStatus.getValue());
    }

    @Test
    public void hidePasswordErrorWhenPasswordHasSomeValues() {
        viewModel.signIn(EMPTY_USER_ID, ANY_PASSWORD);

        assertNotNull(viewModel.passwordError);
        assertNotNull(viewModel.passwordError.getValue());
        assertFalse(viewModel.passwordError.getValue());
        assertNotNull(viewModel.validationStatus);
        assertNotNull(viewModel.validationStatus.getValue());
        assertFalse(viewModel.validationStatus.getValue());
    }

    @Test
    public void setValidationStatusToTrueIfTheCredentialsAreValid() {
        viewModel.signIn(LoginViewModel.USERID, LoginViewModel.PASSWORD);

        assertNotNull(viewModel.userIdError);
        assertNotNull(viewModel.userIdError.getValue());
        assertFalse(viewModel.userIdError.getValue());
        assertNotNull(viewModel.passwordError);
        assertNotNull(viewModel.passwordError.getValue());
        assertFalse(viewModel.passwordError.getValue());
        assertNotNull(viewModel.validationStatus);
        assertNotNull(viewModel.validationStatus.getValue());
        assertTrue(viewModel.validationStatus.getValue());
    }

    @Test
    public void setValidationStatusToFalseIfTheCredentialsAreNotValid() {
        viewModel.signIn(ANY_USER_ID, ANY_PASSWORD);

        assertNotNull(viewModel.userIdError);
        assertNotNull(viewModel.userIdError.getValue());
        assertFalse(viewModel.userIdError.getValue());
        assertNotNull(viewModel.passwordError);
        assertNotNull(viewModel.passwordError.getValue());
        assertFalse(viewModel.passwordError.getValue());
        assertNotNull(viewModel.validationStatus);
        assertNotNull(viewModel.validationStatus.getValue());
        assertFalse(viewModel.validationStatus.getValue());
    }
}