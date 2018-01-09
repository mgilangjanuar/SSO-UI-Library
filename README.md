SSO UI Library
==============

A library for SSO (Single Sign On) Universitas Indonesia with Java language. This will validate a user through [https://sso.ui.ac.id](https://sso.ui.ac.id) and get student details.

## Install

### Gradle
 - *Step 1. Add the JitPack repository to your build file*
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Add that in your root _build.gradle_ at the end of repositories.
 - *Step 2. Add the dependency*
```
	dependencies {
	        compile 'com.github.mgilangjanuar:SSO-UI-Library:-SNAPSHOT'
	}
```

### Maven
 - *Step 1. Add the JitPack repository to your build file*
```
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```
 - *Step 2. Add the dependency*
```
	<dependency>
	    <groupId>com.github.mgilangjanuar</groupId>
	    <artifactId>SSO-UI-Library</artifactId>
	    <version>-SNAPSHOT</version>
	</dependency>
```

## Example Usage

```
...
import com.mgilangjanuar.dev.ssoui.SSOAuthentication;
import com.mgilangjanuar.dev.ssoui.listener.AuthListener;


SSOAuthentication.login('username', 'password', new AuthListener() {

    @Override
    public void onError(String message) {
        // do something with error message
        Log.e("error", message);
    }

    @Override
    public void onLogin(UserModel model) {
        // get username
        Log.d("user", model.getUsername());

        // get full name
        Log.d("user", model.getName());

        // get student ID
        Log.d("user", model.getStudentId());

        // get role
        Log.d("user", model.getRole());

        // get faculty name
        Log.d("user", model.getFaculty());

        // get SIAK status
        Log.d("user", String.valueOf(model.isActive()));
    }
});
```

View other sample with login activity in [sample package](https://github.com/mgilangjanuar/SSO-UI-Library/tree/master/sample) (you need to clone and run that with Android Studio).
