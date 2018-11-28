# CRYPTOBYTE! :moneybag:

## DESCRIPTION

This is a Digital Currency Application displaying market price listing based on trade volume and market capitalization.

## IMPORTANT TERMS TO TAKE NOTE. :smiley:


- **What is "Market Capitalization" and how is it calculated?**

***Market Capitalization*** is one way to rank the relative size of a cryptocurrency. It's calculated by multiplying the Price by the Circulating Supply.

Market Cap = Price X Circulating Supply.

- **What is "Circulating Supply"**

***Circulating Supply*** is the best approximation of the number of coins that are circulating in the market and in the general public's hands.

## Author

Collins Kariuki

## PRE-REQUISITES.

A couple of things to get you started:

1. Ensure you have [Java](https://java.com/en/download/) installed

A simple way to install Java is using [sdkman](https://sdkman.io/).

Simply follow the instructions to have _sdkman_ installed and install java:

```bash
sdk install java
```

2. [Gradle](https://gradle.org/)

Gradle is used as the build tool and can be installed with sdkman:

```bash
sdk install gradle
```

3. [Android SDK](https://developer.android.com/studio/)

Android SDK used to provide all the necessary developer tools to build, test, and debug apps for Android in Windows, Mac or Linux.

4. [Android Build Tools](https://developer.android.com/studio/releases/build-tools)

Android SDK build tools used to debug, build, run and test an Android application.



## TECHNOLOGIES USED:

1. **[Java](https://java.com/en/download/)**

**source language.**

2. **[Gradle](https://gradle.org/)**

**For dependency management and running tasks.**

3. **[Android SDK](https://developer.android.com/studio/)**

**For providing all the necessary developer tools to build, test, and debug Android applications on Windows, Mac or Linux.**

4. **[Android Build Tools](https://developer.android.com/studio/releases/build-tools)**

**For debugging, building, running and testing an Android applications.**

5. **[Coin Market Cap](https://coinmarketcap.com/api/documentation/v1/)**

**Coin Market Cap** is a platform which provides fast, reliable and unified data APIs to cryptocurrency markets.

**Coin Market API** was used to get price listings on cryptocurrencies based on trade volume and market capitalization.

For more info about the API check out the API Section below.

6. **[FireBase](https://firebase.google.com/)**

- **Was used to authenticate users and register users and ensure user is logged in to run the application**

- FireBase is a NoSQL **cloud database**. Data is synced across all clients in realtime, and remains available when your app goes offline. The Firebase Realtime Database is a cloud-hosted database. Data is stored as JSON and synchronized in realtime to every connected client.



Android Butterknife is a view binding tool that uses annotations to generate boilerplate code for us.

## LIBRARIES USED TO NOTE.

1. **[GSON](https://github.com/google/gson)**

- **GSON was used in the API to convert Java Objects into JSON and back**

- Gson is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a **JSON string** to an **equivalent** **Java object**. Gson can work with arbitrary Java objects including pre-existing objects that you do not have source code of.

2. **[okHttp 3](https://github.com/square/okhttp)**

- OkHttp is a third party library used for sending and receiving HTTP-based network requests.

3. **[Picasso](https://github.com/square/okhttp)**

- Picasso was used to display cryptocurrency logos.

- **Picasso** is an image library for **Android**.It caters to image loading and processing. It simplifies the process of displaying images from external locations


**[ButterKnife](http://jakewharton.github.io/butterknife/)**

Android Butterknife is a view binding tool that uses annotations to generate boilerplate code for us.

## COIN MARKET CAP API

Coin Market API Provides crypto market data endpoints market price listing based on trade volume and market capitalization.

For CryptoByte Gson components were used to parse JSON into Java objects.

Gson is an open source Java library to serialize and deserialize Java objects to JSON.

The benefit you get with GSON is that object mapping can save the time spent writing code.

Click here to Check out :point_right: **[Coin Market API](https://coinmarketcap.com/api/)**

### API DESCRIPTION

**Ticker**

This endpoint displays ticker data for a specific cryptocurrency. Use the "id" field from the Listings endpoint in the URL.

**Global Data**

This endpoint displays the global data found at the top of coinmarketcap.com.

**Limits**

API Endpoints are update every 5 minutes.

**Mics**

All 'last_updated' fields are [unix timestamps](https://en.wikipedia.org/wiki/Unix_time)


## **SETUP/INSTALLATION!**


1. You will need Internet connection.

2. You need to get into the Coin-Base-BlockChain-Android Repository.

Link:-> ```https://github.com/zecollokaris/CryptoByte-Blockchain-Android```

3. From there you can access CryptoByte.

4. **Clone** the project.

5. **get into project folder** (cd into project).

6. If you have all the **Pre-requisites**

7. Open your Android Studio Editor and run the Application.


## Support & Contact

- Mobile number: (+254) 798731203

- Email Address: collo.kariss@gmail.com

- github-username: zecollokaris

## LICENSE

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.
