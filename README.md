# Test Automation Task

Bu projede Pixery tarafından verilen task, BDD yaklaşımı ile senaryolar oluşturulmuş olup Page Object Model kullanılarak koşulması sağlanmıştır. Test projesinin başlatılması için `src/test/java/bsturk/Base/BaseTest.java` dosyasını junit.Cucumber ile çalıştırılmalıdır. 

## Proje Özellikleri
* Mobile App testi başlatılması için gerekli cihaz bilgileri parametre feature içine senaryo olarak yazılmıştır. (İlk senaryo cihaz ayarı olduğundan log kaydında koşulan senaryo sayısına dahil değildir.)

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
    
* Teste başlanması için Appium Desktop yüklü olmalıdır. Ve appium üzerinden server başlatılmalıdır. Başlatılan server bilgileri parametre olarak senaryoda güncellenmelidir.
* Projenin log kaydı tutulmaktadır. Log kaydı error, info ve benzeri başlıklar için ayrı ayrı tutulmaktadır. Log kayıtları `Logs/` altında zamana göre tutulmaktadır.
* Test raporu log kaydında info olarak kaydedildi.
* Test sırasında hata ile karşılaşıldığı zamanda ekran görüntüsü kaydetmektedir. Ekran görüntüleri `ScreenshotFile/` altında zamana ve hata ile karşılaşılan senaryo adına göre tutulmaktadır.

## Pixery Task İsterleri
1. Mobil test aracı olarak Appium kullanılmalıdır.
2. Yazılım dili olarak bir kısıtlama yoktur.
3. BDD yaklaşımı kullanılması gerekmektedir.
4. Test senaryolarının ve proje yapısının sürdürülebilir ve çoğaltılabilir olması gerekmektedir.
5. Test annotations (Before,Test,After gibi), ve ayrıntılı log & assertion yapıları kullanılmalıdır.
6. Projenizi Github hesabınız vasıtasıyla paylaşabilirsiniz.

## Test Log Çıktısı

     1- Pixery's Funimate test set begins.
     2- Platform Name: android is getting ready to run.
     3- Driver created for Funimate Tests

     4- Starting test scenarios in Funimate Tests
        S.1- Scenario Start: Sign Up with Invalid Username for Funimate Test in Funimate
             1. Step: Clicking the 'create account' button
             2. Step: Clicking the 'Email' button
             3. Step: The given item is writing to Username
             4. Step: The given item is writing to Email
             5. Step: The given item is writing to Password
             6. Step: Clicking the 'AllowUsToShow' button
             7. Step: Clicking the '✔' button
             8. Step: Checking the invalid Username message.
        S.1- Scenario Finish: Sign Up with Invalid Username for Funimate STATUS= FAILED

        S.2- Scenario Start: Sign Up with Invalid Email for Funimate Test in Funimate
             1. Step: Clicking the 'create account' button
             2. Step: Clicking the 'Email' button
             3. Step: The given item is writing to Username
             4. Step: The given item is writing to Email
             5. Step: The given item is writing to Password
             6. Step: Clicking the 'AllowUsToShow' button
             7. Step: Clicking the '✔' button
             8. Step: Checking the invalid Email message.
        S.2- Scenario Finish: Sign Up with Invalid Email for Funimate STATUS= PASSED

        S.3- Scenario Start: Sign Up with Invalid Password for Funimate Test in Funimate
             1. Step: Clicking the 'create account' button
             2. Step: Clicking the 'Email' button
             3. Step: The given item is writing to Username
             4. Step: The given item is writing to Email
             5. Step: The given item is writing to Password
             6. Step: Clicking the 'AllowUsToShow' button
             7. Step: Clicking the '✔' button
             8. Step: Checking the invalid Password message.
        S.3- Scenario Finish: Sign Up with Invalid Password for Funimate STATUS= PASSED

        S.4- Scenario Start: Sign Up for Funimate Test in Funimate
             1. Step: Clicking the 'create account' button
             2. Step: Clicking the 'Email' button
             3. Step: The given item is writing to Username
             4. Step: The given item is writing to Email
             5. Step: The given item is writing to Password
             6. Step: Clicking the 'AllowUsToShow' button
             7. Step: Clicking the '✔' button
             8. Step: Checking 'MainActivity' visit
        S.4- Scenario Finish: Sign Up for Funimate STATUS= PASSED

        S.5- Scenario Start: Login with Invalid Password for Funimate Test in Funimate
             1. Step: Clicking the 'login' button
             2. Step: The given item is writing to Username
             3. Step: The given item is writing to Password
             4. Step: Clicking the '✔' button
             5. Step: Checking the invalid Password message.
        S.5- Scenario Finish: Login with Invalid Password for Funimate STATUS= PASSED

        S.6- Scenario Start: Login for Funimate Test in Funimate
             1. Step: Clicking the 'login' button
             2. Step: The given item is writing to Username
             3. Step: The given item is writing to Password
             4. Step: Clicking the '✔' button
             5. Step: Checking 'MainActivity' visit
        S.6- Scenario Finish: Login for Funimate STATUS= PASSED

        S.7- Scenario Start: Forgot for Funimate Test in Funimate
             1. Step: Clicking the 'login' button
             2. Step: Clicking the 'Forgot' button
             3. Step: The given item is writing to usernameOrMail
             4. Step: Clicking the 'reset password' button
             5. Step: Checking the message of 'reset password' button
        S.7- Scenario Finish: Forgot for Funimate STATUS= PASSED

     5- Test Name: Funimate 	Complete Time:136701
        PlatformName: android 	APP Version:8.0.1.4
        Number of scenarios run= 7
            Pass: 6		Fail: 1


