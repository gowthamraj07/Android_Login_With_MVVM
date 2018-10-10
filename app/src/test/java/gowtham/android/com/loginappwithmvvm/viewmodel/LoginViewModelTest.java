package gowtham.android.com.loginappwithmvvm.viewmodel;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import static org.junit.Assert.*;

public class LoginViewModelTest {

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Test
    public void setErrorMessagesToFalseWhenInitializing() {
        LoginViewModel viewModel = new LoginViewModel();

        viewModel.initialize();

        assertNotNull(viewModel.userIdError);
        assertNotNull(viewModel.userIdError.getValue());
        assertFalse(viewModel.userIdError.getValue());
        assertNotNull(viewModel.passwordError);
        assertNotNull(viewModel.passwordError.getValue());
        assertFalse(viewModel.passwordError.getValue());
    }
}