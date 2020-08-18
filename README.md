# Loggy
Simple login app using SharedPreferences

## Content
Small and simple app with Splashscreen used to load SharedPreferences and lead to Login Activity or Main Activity if the mail and password preferences are set or not.

If they are not set, at the Login Activity the user will be prompted if wanted to save data. If so, he or she will be directed to the Main Activity with the posibility to go back to Login Activity with the data already set.

If not saved, as the user go back to the login activity, it won't be any data already set. This can be usefull for user validation (not implemented).

If preferences are set, starting the app will lead the user to the Main Activity directly from the Splash Screen.

---

This is exercise from Udemy's Android Programming Course, section 5: SharedPreferences. The splash screen has been made with a layered-list drawable and set in the Splash Activity with it's style.
