#Fake Weather App
<img src ="https://github.com/douglasalipio/fake_weather/blob/main/fake_weather.gif"  width="360"/>&nbsp;&nbsp;
<img src ="https://github.com/douglasalipio/fake_weather/blob/main/Screenshot_20221127_144247.png" width="360" />&nbsp;&nbsp;

## Relevant feature developed

- [x] Display weather information
- [x] Load weather information data
- [x] Load weather icon

## Project architecture

The App was developed based on clean architecture concept. It is separated by package layers such as
domain, presentation, and data.

* Presentation - MVVM pattern to communicate with User Interface
* Domain - Usecase pattern to handle business logic
* Data - Repository pattern to handle remote data


## Testing
<img src ="https://github.com/douglasalipio/fake_weather/blob/main/coverage_image.png"/>

Test suite cover some unit tests for ViewModel, UseCase and Repository. 

## Relevant 3rd party libraries

* Livedata
* Viewmodel
* Mockk
* Junit
* Circleimageview
* Navigation
* Koin
