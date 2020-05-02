Feature: Login / Sign Up / Forgot Password Test Set for Funimate

  Scenario: Driver create for Funimate
    Given Set Capability Key "platformName" Value "android"
    Given Set Capability Key "platformVersion" Value "9"
    Given Set Capability Key "deviceName" Value "GM9PRO"
    Given Set Capability Key "udid" Value "e1684800127"
    Given Set Capability Key "appPackage" Value "com.avcrbt.funimate"
    Given Set Capability Key "appActivity" Value "com.avcrbt.funimate.activity.StartActivity"
    Given Set Capability Key "systemPort" Value "8201"
    Given Set Capability Key "appVersion" Value "8.0.1.4"
    When Create Driver ID "127.0.0.1" Port "4723" with Test capability

  Scenario: Sign Up with Invalid Username for Funimate
    Given At "Funimate" Click "create account"
    Given At "Funimate" Click "Sign up with Email"
    When At "Funimate" SetText "Sign up Username" Type "fbf"
    When At "Funimate" SetText "Sign up Email" Type "Random Email"
    When At "Funimate" SetText "Sign up Password" Type "123456"
    Given At "Funimate" Click "Allow us to show Funimate"
    Given At "Funimate" Click "Sign Up OK"
    Then At "Funimate" Check "Sign Up Invalid Username"

  Scenario: Sign Up with Invalid Email for Funimate
    Given At "Funimate" Click "create account"
    Given At "Funimate" Click "Sign up with Email"
    When At "Funimate" SetText "Sign up Username" Type "Random Username"
    When At "Funimate" SetText "Sign up Email" Type "test@gmail"
    When At "Funimate" SetText "Sign up Password" Type "123456"
    Given At "Funimate" Click "Allow us to show Funimate"
    Given At "Funimate" Click "Sign Up OK"
    Then At "Funimate" Check "Sign Up Invalid Email"

  Scenario: Sign Up with Invalid Password for Funimate
    Given At "Funimate" Click "create account"
    Given At "Funimate" Click "Sign up with Email"
    When At "Funimate" SetText "Sign up Username" Type "Random Username"
    When At "Funimate" SetText "Sign up Email" Type "Random Email"
    When At "Funimate" SetText "Sign up Password" Type "1234"
    Given At "Funimate" Click "Allow us to show Funimate"
    Given At "Funimate" Click "Sign Up OK"
    Then At "Funimate" Check "Sign Up Invalid Password"

  Scenario: Sign Up for Funimate
    Given At "Funimate" Click "create account"
    Given At "Funimate" Click "Sign up with Email"
    When At "Funimate" SetText "Sign up Username" Type "Random Username"
    When At "Funimate" SetText "Sign up Email" Type "Random Email"
    When At "Funimate" SetText "Sign up Password" Type "123456"
    Given At "Funimate" Click "Allow us to show Funimate"
    Given At "Funimate" Click "Sign Up OK"
    Then At "Funimate" Check "Sign Up"

  Scenario: Login with Invalid Password for Funimate
    Given At "Funimate" Click "login"
    When At "Funimate" SetText "Login Username" Type "test1test1"
    When At "Funimate" SetText "Login Password" Type "123456asd"
    Given At "Funimate" Click "Login OK"
    Then At "Funimate" Check "Login Invalid Password"

  Scenario: Login for Funimate
    Given At "Funimate" Click "login"
    When At "Funimate" SetText "Login Username" Type "test1test1"
    When At "Funimate" SetText "Login Password" Type "123456"
    Given At "Funimate" Click "Login OK"
    Then At "Funimate" Check "Login"

  Scenario: Forgot for Funimate
    Given At "Funimate" Click "login"
    Given At "Funimate" Click "Forgot"
    When At "Funimate" SetText "Forgot Username or Mail" Type "test1test1"
    Given At "Funimate" Click "reset password"
    Then At "Funimate" Check "Forgot"

  Scenario: Finish Test for Funimate
    Given Finish Test