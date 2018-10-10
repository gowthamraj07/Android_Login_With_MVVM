package gowtham.android.com.loginappwithmvvm.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    public static final String USERID = "userid";
    public static final String PASSWORD = "password";
    public MutableLiveData<Boolean> userIdError = new MutableLiveData<>();
    public MutableLiveData<Boolean> passwordError = new MutableLiveData<>();
    public MutableLiveData<Boolean> validationStatus = new MutableLiveData<>();

    public void initialize() {
        userIdError.setValue(false);
        passwordError.setValue(false);
    }

    public void signIn(String userId, String password) {
        userIdError.setValue(true);
        passwordError.setValue(true);
        validationStatus.setValue(false);

        boolean isValidUserId = userId != null && !userId.isEmpty();
        if(isValidUserId) {
            userIdError.setValue(false);
        }

        boolean isValidPassword = password != null && !password.isEmpty();
        if(isValidPassword) {
            passwordError.setValue(false);
        }

        if (!isValidUserId || !isValidPassword) {
            return;
        }

        if (!USERID.equals(userId) || !PASSWORD.equals(password)) {
            return;
        }

        validationStatus.setValue(true);
    }
}
