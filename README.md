# KMMViewModelSample

### A simple way to create shared view models between android and iOS using KMM

PlatformViewModel creates a platform-specific abstraction to use the native android ViewModel class and viewModelScope property. 

StateFlowWrapper is a wrapper for kotlin flow to enable Swift code to collect values for any change.

#### Build Android

On Android, the shared module is seen as a traditional module and the build is trivial (open project in Android Studio and run)

#### Build iOS

To build an iOS app using KMM we need to build the shared module first. 
On the project folder run `./gradlew createSwiftpackage` to build a shared module as Swift package. 

#### Example App

This repository includes a stupid example app that counts clicks and shows the current time updating every second.

| Android | iOS |
| ------- | --- |
| ![Android](https://user-images.githubusercontent.com/26679466/188282674-4c096b11-9c2f-4e69-ba68-7eb1f732d9e9.png) | ![iOS](https://user-images.githubusercontent.com/26679466/188282618-802b8f92-041e-4ef6-8f82-a8f7e4893490.png) |

