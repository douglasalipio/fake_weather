## Fake Weather App

<img src ="https://github.com/douglasalipio/fake_weather/blob/main/fake_weather.gif"  width="360"/>&nbsp;&nbsp;
<img src ="https://github.com/douglasalipio/fake_weather/blob/main/Screenshot_20221127_144247.png" width="360" />&nbsp;&nbsp;

## Relevant feature developed

- [x] Display weather information
- [x] Load weather information data from remote API (https://cdn.faire.com/static/mobile-take-home/{location_id}.json)
- [x] Load weather icon from URL (https://cdn.faire.com/static/mobile-take-home/icons/{weather_state_abbr}.png)
- [x] Handle Loading view state
- [x] Display error message

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
