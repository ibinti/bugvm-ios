# BugVM iOS App

### Git Clone

```
git clone https://github.com/ibinti/bugvm-ios
cd bugvm-ios
```

System requirements: Minimum iOS 7, macOS 10.12, Xcode 9 and JDK 8


### Launch the app to the iPhone Simulator

```
./gradlew -q sim
```

### Launch the app to the iPad Simulator

```
./gradlew -q pad
```

### Install the app to the connected iPhone or iPad

```
./gradlew -q dev
```

### Package the app for the App Store distribution

```
./gradlew -q dist
```