[![](https://androidweekly.net/issues/issue-455/badge)](https://androidweekly.net/issues/issue-455) 
[![CircleCI](https://circleci.com/gh/GabrielBrasileiro/mvvm-redux.svg?style=svg)](https://app.circleci.com/pipelines/github/GabrielBrasileiro/mvvm-redux?branch=master)
[![](https://jitpack.io/v/GabrielBrasileiro/mvvm-redux.svg)](https://jitpack.io/#GabrielBrasileiro/mvvm-redux)

# MVVM Redux

Is an Android Library based in redux to help android developers apply with a simple way the reducer in your respective ViewModel.

# Simplicity

MVVM Redux provides all you need to make your ViewModel uncoupled of view. With ViewModel extensions you can insert all you need in your constructor pragmatically. 

When you need to change your feature it will be simple. 

Read about our implementation in doc and you can use for your context the listener extensions.

The limit is your imagination. :)

# Documentation

* [BaseViewModel](https://github.com/GabrielBrasileiro/mvvm-redux/wiki/1.-BaseViewModel)
* [StateViewModel](https://github.com/GabrielBrasileiro/mvvm-redux/wiki/2.-StateViewModel)
* [EventViewModel](https://github.com/GabrielBrasileiro/mvvm-redux/wiki/3.-EventViewModel)
* [ReducerScope](https://github.com/GabrielBrasileiro/mvvm-redux/wiki/4.-ReducerScope)
* [Reducer](https://github.com/GabrielBrasileiro/mvvm-redux/wiki/4.1.-Reducer)
* [EventView](https://github.com/GabrielBrasileiro/mvvm-redux/wiki/5.1.-EventView)
* [StateView](https://github.com/GabrielBrasileiro/mvvm-redux/wiki/6.1.-StateView)
* [State](https://github.com/GabrielBrasileiro/mvvm-redux/wiki/6.-State)
* [Event](https://github.com/GabrielBrasileiro/mvvm-redux/wiki/5.-Event)
* [StateEvent](https://github.com/GabrielBrasileiro/mvvm-redux/wiki/6.2.-StateEvent)
* [Listener Extensions](https://github.com/GabrielBrasileiro/mvvm-redux/wiki/7.-Listener-Extensions)
* [ViewModel Extensions](https://github.com/GabrielBrasileiro/mvvm-redux/wiki/8.-ViewModel-extensions)
* [Unit Tests](https://github.com/GabrielBrasileiro/mvvm-redux/wiki/9.-Unit-Tests)

# Installation

Insert in project gradle:

```groovy
allprojects {
    repositories {
        google()
        mavenCentral()
        // Insert repository reference here
        maven { url 'https://jitpack.io' }
    }
}
```

Insert in module gradle:
```groovy
ext {
    mvvm_redux_version = '1.0.3'
}

dependencies {
    // MVVM Redux core features
    implementation "com.github.gabrielbrasileiro.mvvm-redux:core:$mvvm_redux_version"
    
    // MVVM Redux extension features
    implementation "com.github.gabrielbrasileiro.mvvm-redux:ext:$mvvm_redux_version"
    
    // MVVM Redux view model extensions features
    implementation "com.github.gabrielbrasileiro.mvvm-redux:viewmodel:$mvvm_redux_version"
}
```

Inspired by [Roxie](https://github.com/ww-tech/roxie) and [Jay Rambhia Article](https://jayrambhia.com/blog/android-redux-intro)
