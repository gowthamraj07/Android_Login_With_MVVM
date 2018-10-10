package gowtham.android.com.loginappwithmvvm.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    public MutableLiveData<Boolean> userIdError = new MutableLiveData<>();
    public MutableLiveData<Boolean> passwordError = new MutableLiveData<>();

    public void initialize() {
        userIdError.setValue(false);
        passwordError.setValue(false);
    }
}
