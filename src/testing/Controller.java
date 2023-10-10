package testing;

public class Controller {
    
    protected KeyChecker checker_;
    protected LockCtrl lockCtrl_;
    protected LightCtrl lightCtrl_;
    protected PhotoObsrv sensor_;
    protected AlarmCtrl alarmCtrl_;
    public static final long maxNumOfAttempts_ = 3;
    public static final long attemptPeriod_ = 600000; // msec [=10min]
    protected long numOfAttempts_ = 0;


public Controller(
    KeyChecker kc, LockCtrl lkc, LightCtrl lic,
    PhotoObsrv sns, AlarmCtrl ac
) {
    checker_ = kc;
    lockCtrl_ = lkc;
    alarmCtrl_ = ac;
    lightCtrl_ = lic;
    sensor_ = sns;
}

public void enterKey(String key_code) { // included return type myself
    Key user_key = new Key(key_code)
if (checker_.checkKey(user_key)) {
    lockCtrl_.setArmed(false);
    if (!sensor_.isDaylight()) { lightCtrl_.setLit(true); }
    numOfAttempts_ = 0;
} else {
// we need to check the attempt period as well, but ...
if (++numOfAttempts_ >= maxNumOfAttempts_) {
    alarmCtrl_.soundAlarm();
    numOfAttempts_ = 0; // reset for the next user
}
}
}
}