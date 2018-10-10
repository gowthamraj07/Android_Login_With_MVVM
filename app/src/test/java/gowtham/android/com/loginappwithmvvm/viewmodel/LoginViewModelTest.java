package gowtham.android.com.loginappwithmvvm.viewmodel;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import static org.junit.Assert.*;

public class LoginViewModelTest {

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
        viewModel.signIn("","");

        assertNotNull(viewModel.userIdError);
        assertNotNull(viewModel.userIdError.getValue());
        assertTrue(viewModel.userIdError.getValue());
        assertNotNull(viewModel.validationStatus);
        assertNotNull(viewModel.validationStatus.getValue());
        assertFalse(viewModel.validationStatus.getValue());
    }

    @Test
    public void setPasswordErrorToTrueWhenPasswordIsInvalid() {
        viewModel.signIn("","");

        assertNotNull(viewModel.passwordError);
        assertNotNull(viewModel.passwordError.getValue());
        assertTrue(viewModel.passwordError.getValue());
        assertNotNull(viewModel.validationStatus);
        assertNotNull(viewModel.validationStatus.getValue());
        assertFalse(viewModel.validationStatus.getValue());
    }
}