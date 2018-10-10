package gowtham.android.com.loginappwithmvvm.viewmodel;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import static org.junit.Assert.*;

public class LoginViewModelTest {

    private static final String ANY_USER_ID = "any value";
    private static final String EMPTY_USER_ID = "";
    private static final String EMPTY_PASSWORD = "";
    private static final String ANY_PASSWORD = "any password";

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

        assertHideUserIdError();
        assertHidePasswordError();
    }

    @Test
    public void setUserIdErrorToTrueWhenUserIdIsInvalid() {
        viewModel.signIn(EMPTY_USER_ID,EMPTY_PASSWORD);

        assertNotNull(viewModel.userIdError);
        assertNotNull(viewModel.userIdError.getValue());
        assertTrue(viewModel.userIdError.getValue());
    }

    @Test
    public void setPasswordErrorToTrueWhenPasswordIsInvalid() {
        viewModel.signIn(EMPTY_USER_ID, EMPTY_PASSWORD);

        assertNotNull(viewModel.passwordError);
        assertNotNull(viewModel.passwordError.getValue());
        assertTrue(viewModel.passwordError.getValue());
    }

    @Test
    public void hideUserIdErrorWhenUserIdHasSomeValues() {
        viewModel.signIn(ANY_USER_ID,EMPTY_PASSWORD);

        assertHideUserIdError();
    }

    @Test
    public void hidePasswordErrorWhenPasswordHasSomeValues() {
        viewModel.signIn(EMPTY_USER_ID, ANY_PASSWORD);

        assertHidePasswordError();
    }

    @Test
    public void setValidationStatusToTrueIfTheCredentialsAreValid() {
        viewModel.signIn(LoginViewModel.USERID, LoginViewModel.PASSWORD);

        assertHideUserIdError();
        assertHidePasswordError();
        assertNotNull(viewModel.validationStatus);
        assertNotNull(viewModel.validationStatus.getValue());
        assertTrue(viewModel.validationStatus.getValue());
    }

    @Test
    public void setValidationStatusToFalseIfTheCredentialsAreNotValid() {
        viewModel.signIn(ANY_USER_ID, ANY_PASSWORD);

        assertHideUserIdError();
        assertHidePasswordError();
        assertNotNull(viewModel.validationStatus);
        assertNotNull(viewModel.validationStatus.getValue());
        assertFalse(viewModel.validationStatus.getValue());
    }

    private void assertHidePasswordError() {
        assertNotNull(viewModel.passwordError);
        assertNotNull(viewModel.passwordError.getValue());
        assertFalse(viewModel.passwordError.getValue());
    }

    private void assertHideUserIdError() {
        assertNotNull(viewModel.userIdError);
        assertNotNull(viewModel.userIdError.getValue());
        assertFalse(viewModel.userIdError.getValue());
    }
}