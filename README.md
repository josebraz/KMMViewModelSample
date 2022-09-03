# KMMViewModelSample

### A simple way to create shared view models between android and iOS using KMM

PlatformViewModel create a platform especific abstraction to use native android ViewModel class and viewModelScope propertie. 

StateFlowWrapper is a wrapper for kotlin flow to enable Swift code collect values for any change.

#### Build Android

On android, shared module is seen as a traditional module and the build is trivial (open project in Android Studio and run)

#### Build iOS

To build iOS app using KMM we need to build shared module first. 
On project folder run `./gradlew createSwiftpackage` to build shared module as swift package. 

#### Example App

This repository include a stupid example app that count click and show the current time updating every second.

| Android | iOS |
| ------- | --- |
| ![Android](https://user-images.githubusercontent.com/26679466/188282674-4c096b11-9c2f-4e69-ba68-7eb1f732d9e9.png) | ![iOS](https://user-images.githubusercontent.com/26679466/188282618-802b8f92-041e-4ef6-8f82-a8f7e4893490.png) |

